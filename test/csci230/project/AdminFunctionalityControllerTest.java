/**
 * 
 */
package csci230.project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author pgathje001
 *
 */
public class AdminFunctionalityControllerTest {
	UserController uc;
	DBController dbCon;
	User john;
	AdminFunctionalityController afc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		afc = new AdminFunctionalityController();
		uc = new UserController();
		dbCon = new DBController();
		//afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		john = new User("John", "User", "juser@csbsju.edu", "user", 'u', 'Y');

	}

	@Test
	public void testAdminFunctionalityController() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testLogOn() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		assertTrue("Adminlogon. output expected: true actual output: " + afc.getIsAdminLoggedIn(),afc.getIsAdminLoggedIn());
	}
	
	@Test
	public void testGetIsAdminLoggedIn() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		assertTrue("Adminlogon. output expected: true actual output: " + afc.getIsAdminLoggedIn(),afc.getIsAdminLoggedIn());
	}
	
	@Test
	public void testLogOff() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		afc.logOff();
		assertTrue("Successful logOut. isLoggedInShould should be false " + afc.getIsAdminLoggedIn(), afc.getIsAdminLoggedIn() == false);
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
	}
	
	@Test
	public void testAddUser() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		afc.addUser("Pete", "Gathje", "pgathje001@csbsju.edu", "user", 'u', 'N');
		boolean found = false;
		ArrayList<User> allUsers = afc.viewUsers();
		for(User i:allUsers) {
			if(i.getUserName().equals("pgathje001@csbsju.edu")) {
				found = true;
				assertTrue("expected output someEmail@gmail.com got" + i.getUserName(),i.getUserName().equals("pgathje001@csbsju.edu"));
			}
		}
		if(!found) {
			assertFalse(true);
		}
		afc.deleteUser("pgathje001@csbsju.edu");
		
	}
	
	@Test
	public void testEditUser() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		ArrayList<String>al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		afc.editSchool("ADELPHI", "CALIFORNIA", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2,
				2, al2);
		ArrayList<University> allUnivs = afc.viewUniversities();
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}
		assertTrue("expected California got " + u.getState(), u.getState().equals("CALIFORNIA"));
		afc.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}
	
	@Test
	public void testViewUniversities() {
		ArrayList<University> allUnivs2 = afc.viewUniversities();
		assertTrue("expected ADELPHI got " + allUnivs2.get(2).getSchoolName(),
				(allUnivs2.get(2).getSchoolName()).equals(afc.viewUniversities().get(2).getSchoolName()));
	}
	
	@Test
	public void testViewUsers() {
		afc.viewUsers();
		assertTrue("expected output is the username of the first User of all the users from the database " + afc.viewUsers().get(0).getUserName(), afc.viewUsers().get(0).getUserName().equals("abreyen001@csbsju.edu"));
	}
	
	@Test
	public void testShowUserDetails() {
		afc.showUserDetails(john);
		ArrayList<String> list = new ArrayList<String>();
		list.add("John");
		list.add("User");
		list.add("juser@csbsju.edu");
		list.add("user");
		list.add("u");
		list.add("Y");
		assertTrue("expected output for user name is and ArrayList of strings with User john's info" + afc.showUserDetails(john), afc.showUserDetails(john).equals(list));
	}
	
	@Test
	public void testAddUniversity() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		University test = new University("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50,
				80, 3, 3, 3, emp, 0, 0, 0);
		afc.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3,
				emp);
		for (University i : afc.viewUniversities()) {
			if (i.getSchoolName().equals("TEST1")) {
				assertTrue("school added", i.getSchoolName().equals("TEST1"));
			}
		}
		afc.removeUniversity(test);
	}

	
	@Test
	public void testEditSchool() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		afc.editUser("IMAD", "RAHAL", "luser@csbsju.edu", "PASSWORD", 'a', 'Y');
		ArrayList<User> allUsers = afc.viewUsers();
		for(User i:allUsers) {
			if(i.getUserName().equals("luser@csbsju.edu")) {
				if(i.getLastName().equals("RAHAL") && i.getPassword().equals("PASSWORD") && i.getType() == 'a' && i.getStatus() == 'Y') {
					assertTrue("edited User first name should equal IMAD. actual result" + i.getFirstName(), i.getFirstName().equals("IMAD"));
				}
			}
		}
		afc.editUser("Lynn", "User", "luser@csbsju.edu", "user", 'u', 'N');
	}

	
	@Test
	public void testViewMyProfile() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		afc.viewMyProfile();
		assertTrue("expected output zach got" + afc.viewMyProfile().getUserName(), afc.viewMyProfile().getUserName().equals("ZHEINEN001@csbsju.edu"));
	}
	
	@Test
	public void testShowSchoolDetails() {
		ArrayList<String>al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		ArrayList<String> univDetails = afc.showSchoolDetails(u);
		assertTrue("School name should be ADELPHI, was " + univDetails.get(0), univDetails.get(0).equals("ADELPHI"));
	}
	
	@Test
	public void testRemoveUniversity() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		University test = new University("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50,
				80, 3, 3, 3, emp, 0, 0, 0);
		afc.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3,
				emp);
		for (University i : afc.viewUniversities()) {
			if (i.getSchoolName().equals("TEST1")) {
				assertTrue("school added", i.getSchoolName().equals("TEST1"));
			}
		}
		afc.removeUniversity(test);
		for (University i : afc.viewUniversities()) {
			if (i.getSchoolName().equals("TEST1")) {
				assertFalse("school found!", i.getSchoolName().equals("TEST1"));
			}
		}
	}
	
	@Test
	public void testDeleteUser() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		afc.deleteUser("juser@csbsju.edu");
		boolean found = false;
		ArrayList<User> allUsers = afc.viewUsers();
		for(User i:allUsers) {
			if(i.getUserName().equals("juser@csbsju.edu")) {
				found = true;
			}
		}
		if(found) {
			assertFalse(true);
		}
		else
		{
			assertTrue(true);
		}
		afc.addUser("John", "User", "juser@csbsju.edu", "user", 'u', 'Y');
	}
	
	@Test
	public void testSetSchoolOfTheWeek() {
		ArrayList<String>al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		String expected = u.getSchoolName();
		afc.setSchoolOfTheWeek(expected);
		assertTrue("Expected Adelphi got " + afc.getSchoolOfTheWeek().getSchoolName(),
				afc.getSchoolOfTheWeek().getSchoolName().equals(expected));
	}
	
	@Test
	public void testGetSchoolOfTheWeek() {
		ArrayList<String>al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		String expected = u.getSchoolName();
		afc.setSchoolOfTheWeek(expected);

		assertTrue("expected Adelphi got " + afc.getSchoolOfTheWeek().getSchoolName(),
				afc.getSchoolOfTheWeek().getSchoolName().equals(u.getSchoolName()));
	}
	
	@Test
	public void testResetPasswordByEmail() {
		uc.logOn("andrew.breyen+rpt@gmail.com", "pass");
		User u = uc.getLoggedOnUser();
		String oldPass = u.getPassword();
		uc.resetPasswordByEmail(u.getUserName());
		ArrayList<User> allUsers = dbCon.getAllUsers();

		for (User i : allUsers) {
			if (i.getUserName().equals("andrew.breyen+rpt@gmail.com")) {
				u = i;
			}
		}
		assertFalse("Password should have changed oldPass:"+oldPass+"u.getPass:"+u.getPassword() ,oldPass.equals(u.getPassword()));
		uc.editUser("ResetPass", "Word", "andrew.breyen+rpt@gmail.com", oldPass, 'u', 'Y');
		uc.logOut();
	}
	
	@Test
	public void testDeactivateUser() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		afc.deactivateUser("abreyen001@csbsju.edu");
		for(User i:afc.viewUsers()) {
			if(i.getUserName().equals("abreyen001@csbsju.edu")) {
				assertTrue("expected output: 'N' actual output: " + i.getStatus(), i.getStatus() == 'N');
			}
		}
		afc.activateUser("abreyen001@csbsju.edu");
	}
	
	@Test
	public void testActviateUser() {
		afc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		afc.activateUser("luser@csbsju.edu");
		for(User i:afc.viewUsers()) {
			if(i.getUserName().equals("luser@csbsju.edu")) {
				assertTrue("expected output: 'Y' actual output: " + i.getStatus(), i.getStatus() == 'Y');
			}
		}
		afc.deactivateUser("luser@csbsju.edu");
	}

}
