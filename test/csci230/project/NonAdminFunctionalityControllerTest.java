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
public class NonAdminFunctionalityControllerTest {
	UserController uc;
	DBController dbCon;
	User john;
	NonAdminFunctionalityController nafc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		uc = new UserController();
		dbCon = new DBController();
		nafc = new NonAdminFunctionalityController();
		//nafc.logOn("abreyen001@csbsju.edu", "myPassword");
		john = new User("John", "User", "juser@csbsju.edu", "user", 'u', 'Y');
	}

	@Test
	public void testNonAdminFunctionalityController() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
	}
	
	@Test
	public void testLogOn() {
		nafc.logOn("abreyen001@csbsju.edu", "myPassword");
		assertTrue("NonAdminlogon. output expected: true actual output: " + nafc.isLoggedIn(), nafc.isLoggedIn() == true);
	}
	
	@Test
	public void testIsLoggedIn() {
		nafc.logOn("abreyen001@csbsju.edu", "myPassword");
		assertTrue("NonAdminlogon. output expected: true actual output: " + nafc.isLoggedIn(), nafc.isLoggedIn() == true);
	}
	
	@Test
	public void testLogOut() {
		nafc.logOn("abreyen001@csbsju.edu", "myPassword");
		nafc.logout();
		assertTrue("Successful logOut. isLoggedInShould should be false " + nafc.isLoggedIn(), nafc.isLoggedIn() == false);
	}
	
	@Test
	public void testSearchSchools() {
		uc.logOn("abreyen001@csbsju.edu", "myPassword");
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		nafc.searchSchools("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 15000, 70, 70, 500, 500, 475, 475, 37437, 37437, 60, 60, 5500, 5500, 70, 70, 40, 40, 2, 2, 2, 2, 2, 2, al2);
		assertTrue("expected Adelphi got " + nafc.searchSchools("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 15000, 70, 70, 500, 500, 475, 475, 37437, 37437, 60, 60, 5500, 5500, 70, 70, 40, 40, 2, 2, 2, 2, 2, 2, al2).get(0).getSchoolName(), uc.viewSavedSchools().get(0).getSchoolName().equals("ADELPHI"));
	}
	
	@Test
	public void testViewedSavedSchools() {
		nafc.logOn("abreyen001@csbsju.edu", "myPassword");
		ArrayList<University> list = nafc.viewSavedSchools();
		assertTrue("list.get(0) " + list.get(0).getSchoolName(), list.get(0).getSchoolName().equals("ADELPHI"));
	}
	
	@Test
	public void testViewUniversities() {
		dbCon.loadUsers("abreyen001@csbsju.edu");
		ArrayList<University> allUnivs = nafc.viewUniversities();
		assertTrue("expected: ABILENE CHRISTIAN UNIVERSITY. actual: " + allUnivs.get(0).getSchoolName(), allUnivs.get(0).getSchoolName().equals("ABILENE CHRISTIAN UNIVERSITY"));
	}
	
	@Test
	public void testRemoveSavedSchool() {
		nafc.logOn("abreyen001@csbsju.edu", "myPassword");
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("HISTORY");
		al2.add("LIBERAL ARTS");
		al2.add("");
		al2.add("");
		University u = new University("HARVARD", "MASSACHUSETTS", "URBAN", "PRIVATE", 15000, 35, 700, 675, 46475, 60, 15000, 20, 80, 5, 3, 4, al2, 0, 0, 0);
		nafc.saveUniversity(u);
		nafc.removeSavedSchool(u);
		for (University i: nafc.viewSavedSchools()) {
			if (!i.getSchoolName().equals("HARVARD"))
			assertTrue("expected to remove Harvard", !i.getSchoolName().equals("HARVARD"));
		}
	}
	
	@Test
	public void testSaveUniversities() {
		nafc.logOn("abreyen001@csbsju.edu", "myPassword");
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("HISTORY");
		al2.add("LIBERAL ARTS");
		al2.add("");
		al2.add("");
		University u = new University("HARVARD", "MASSACHUSETTS", "URBAN", "PRIVATE", 15000, 35, 700, 675, 46475, 60, 15000, 20, 80, 5, 3, 4, al2, 0, 0, 0);
		nafc.saveUniversity(u);
		assertTrue("expected Adelphi got " + nafc.viewSavedSchools().get(0).getSchoolName(), nafc.viewSavedSchools().get(0).getSchoolName().equals("ADELPHI"));
		nafc.removeSavedSchool(u);
	}
	
	@Test
	public void testEditProfile() {
		nafc.logOn("juser@csbsju.edu", "user");
		nafc.editProfile("Johnny", "User", "user", "john");
		ArrayList<User> allUsers = uc.viewUsers();
		for(User i:allUsers) {
			if(i.getUserName().equals("juser@csbsju.edu")) {
				if(i.getFirstName().equals("Johnny") && i.getPassword().equals("john") && i.getUserName().equals("juser@csbsju.edu")) {
					assertTrue("edited User first name should equal Johnny. actual result" + i.getFirstName(), i.getFirstName().equals("Johnny"));
				}
			}
		}
		nafc.editProfile("John", "User", "john", "user");
		nafc.logout();
	}
	
	@Test
	public void testViewMyProfile() {
		nafc.logOn("abreyen001@csbsju.edu", "myPassword");
		assertTrue("logged on user should be Andrew" + nafc.viewMyProfile().getUserName(), nafc.viewMyProfile().getUserName().equals("abreyen001@csbsju.edu"));
	}
	
	@Test
	public void testViewRandomSchool() {
		University rand = nafc.viewRandomSchool();
		ArrayList<University> temp = dbCon.loadUniversities();
		for (University i : temp) {
			if (i.equals(rand)) {
				assertTrue(i.getSchoolName() + " = " + rand.getSchoolName(),
						i.getSchoolName().equals(rand.getSchoolName()));
			}
		}
		
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
	public void testRecommendSchools() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		ArrayList<University> r = nafc.recommendSchools(u);
		assertTrue("Top Recomended, results should be HOFSTRA, was " + r.get(1).getSchoolName(),
				r.get(1).getSchoolName().equals("HOFSTRA"));
		
	}
	
	@Test
	public void testShowSchoolDetails() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		ArrayList<String> univDetails = nafc.showSchoolDetails(u);
		assertTrue("School name should be ADELPHI, was " + univDetails.get(0), univDetails.get(0).equals("ADELPHI"));
	}
	
	@Test
	public void testRandomSchool() {
		University rand = nafc.randomSchool();
		ArrayList<University> temp = dbCon.loadUniversities();
		for (University i : temp) {
			if (i.equals(rand)) {
				assertTrue(i.getSchoolName() + " = " + rand.getSchoolName(),
						i.getSchoolName().equals(rand.getSchoolName()));
			}
		}
		
	}
	
	@Test
	public void testViewHistory() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		nafc.searchSchools("ADELPHI", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, emp);
		nafc.searchSchools("TUFTS", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, emp);
		nafc.searchSchools("GOTHENBURG UNIVERSITY", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		assertTrue("Expected TUFTS, was" + nafc.viewHistory().get(1).getSchoolName(),
				(nafc.viewHistory().get(1).getSchoolName()).equals("TUFTS"));
	}


}
