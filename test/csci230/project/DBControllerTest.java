/**
 * 
 */
package csci230.project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author zheinen001
 *
 */
public class DBControllerTest {
	DBController dbCon;
	UserController uc;
	User u;
	University univ;
	ArrayList<String> al2;
	@Before
	  public void setUp() throws Exception {
		 dbCon = new DBController();
		 uc = new UserController();
		 u = new User("John", "User", "juser@csbsju.edu", "user", 'u', 'Y');
		 dbCon.loadUsers("juser@csbsju.edu");
		 al2 = new ArrayList<String>();
			al2.add("BIOLOGY");
			al2.add("BUSINESS-ADMINISTRATION");
			al2.add("");
			al2.add("");
			al2.add("");
			univ = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2,
					2, al2, 0, 0, 0);
	  }
	
	/**
	 * Test method for {@link csci230.project.DBController#DBController()}.
	 */
	@Test
	public void testDBController() {
		DBController newDBCon = dbCon;
		assertSame(dbCon, newDBCon);
	}

	/**
	 * Test method for {@link csci230.project.DBController#saveUniversities(csci230.project.University)}.
	 */
	@Test
	public void testSaveUniversities() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		dbCon.saveUniversities(u);
		assertTrue("expected Adelphi got " + dbCon.getSavedSchoolList().get(0).getSchoolName(), dbCon.getSavedSchoolList().get(0).getSchoolName().equals("ADELPHI"));
		dbCon.deleteSavedSchool(u);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSaveUniversity_InvalidSchool() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("NOTAUNIV", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		dbCon.saveUniversities(u);
	}

	/**
	 * Test method for {@link csci230.project.DBController#getUsers()}.
	 */
	@Test
	public void testGetUsers() {
		String [][] list = dbCon.getUsers();
		assertTrue("list [0][0] expected got " + list [0][0], list [0][0].equals("Andrew"));
	}

	/**
	 * Test method for {@link csci230.project.DBController#getSavedSchoolList()}.
	 */
	@Test
	public void testGetSavedSchoolList() {
		dbCon.loadUsers("abreyen001@csbsju.edu");
		ArrayList<University> list = dbCon.getSavedSchoolList();
		assertTrue("list.get(0) " + list.get(0).getSchoolName(), list.get(0).getSchoolName().equals("ADELPHI"));
		dbCon.loadUsers("juser@csbsju.edu");
	}

	/**
	 * Test method for {@link csci230.project.DBController#getUsernameBySavedSchool(java.lang.String)}.
	 */
	@Test
	public void testGetUsernameBySavedSchool() {
		ArrayList<String> list = dbCon.getUsernameBySavedSchool("ADELPHI");
		assertTrue("list.get(0) should equal " + list.get(0), list.get(0).equals("abreyen001@csbsju.edu"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetUsernameBySavedSchool_NoUserHasSchoolSaved() {
		dbCon.getUsernameBySavedSchool("AUBURN");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetUsernameBySavedSchool_NoSuchSchoolExists() {
		dbCon.getUsernameBySavedSchool("AUBORN");
	}

	/**
	 * Test method for {@link csci230.project.DBController#removeSchool(csci230.project.University)}.
	 */
	@Test
	public void testRemoveSchool() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		University test = new University("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50,
				80, 3, 3, 3, emp, 0, 0, 0);
		dbCon.addUniversity(test);
		for (University i : dbCon.loadUniversities()) {
			if (i.getSchoolName().equals("TEST1")) {
				assertTrue("school added", i.getSchoolName().equals("TEST1"));
			}
		}
		dbCon.removeSchool(test);
		for (University i : dbCon.loadUniversities()) {
			if (i.getSchoolName().equals("TEST1")) {
				assertFalse("school found!", i.getSchoolName().equals("TEST1"));
			}
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveSchool_SchoolDoesNotExist() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		University test = new University("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50,
				80, 3, 3, 3, emp, 0, 0, 0);
		dbCon.removeSchool(test);
	}

	/**
	 * Test method for {@link csci230.project.DBController#addUser(csci230.project.User)}.
	 */
	@Test
	public void testAddUser() {
		User zac = new User("Zac", "Heinen", "someEmail@gmail.com", "password", 'a', 'Y');
		dbCon.addUser(zac);
		boolean found = false;
		ArrayList<User> allUsers = dbCon.loadUsers("juser@csbsju.edu");
		for(User i:allUsers) {
			if(i.getUserName().equals("someEmail@gmail.com")) {
				found = true;
				assertTrue("expected output someEmail@gmail.com got" + i.getUserName(),i.getUserName().equals("someEmail@gmail.com"));
			}
		}
		if(!found) {
			assertFalse(true);
		}
		dbCon.deleteUser("someEmail@gmail.com");
	}

	/**
	 * Test method for {@link csci230.project.DBController#addUniversity(csci230.project.University)}.
	 */
	@Test
	public void testAddUniversity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#getUniversities()}.
	 */
	@Test
	public void testGetUniversities() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#getEmphasis()}.
	 */
	@Test
	public void testGetEmphasis() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#editUniversity(csci230.project.University)}.
	 */
	@Test
	public void testEditUniversity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#deleteUser(java.lang.String)}.
	 */
	@Test
	public void testDeleteUser() {
		User zac = new User("Zac", "Heinen", "someEmail@gmail.com", "password", 'a', 'Y');
		dbCon.addUser(zac);
		dbCon.deleteUser("someEmail@gmail.com");
		boolean found = false;
		ArrayList<User> allUsers = dbCon.loadUsers("juser@csbsju.edu");
		for(User i:allUsers) {
			if(i.getUserName().equals("someEmail@gmail.com")) {
				found = true;
				assertTrue("expected output someEmail@gmail.com got" + i.getUserName(),i.getUserName().equals("someEmail@gmail.com"));
			}
		}
		if(!found) {
			assertFalse(true);
		}
	}

	/**
	 * Test method for {@link csci230.project.DBController#editUser(csci230.project.User)}.
	 */
	@Test
	public void testEditUser() {
		boolean found = false;
		User newUser = new User("IMAD", "RAHAL", "luser@csbsju.edu", "PASSWORD", 'a', 'Y');
		dbCon.editUser(newUser);
		ArrayList<User> allUsers = uc.viewUsers();
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
		uc.addUser("John", "User", "juser@csbsju.edu", "user", 'u', 'Y');
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDeleteUser_UserNotFound() {
		uc.deleteUser("someEmail@gmail.com");
	}
	

	/**
	 * Test method for {@link csci230.project.DBController#deleteSavedSchool(csci230.project.University)}.
	 */
	@Test
	public void testDeleteSavedSchool() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		dbCon.saveUniversities(u);
		dbCon.deleteSavedSchool(u);
		for (University i: dbCon.getSavedSchoolList()) {
			if (!i.getSchoolName().equals("ADELPHI"))
			assertTrue("expected to remove Adelphi", !i.getSchoolName().equals("ADELPHI"));
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testDeleteSavedSchool_SchoolNotSaved() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		dbCon.deleteSavedSchool(u);
	}

	/**
	 * Test method for {@link csci230.project.DBController#loadUsers(java.lang.String)}.
	 */
	@Test
	public void testLoadUsers_FoundNonAdminSuccessfulLoad() {
		ArrayList<User> allUsers = dbCon.loadUsers("abreyen001@csbsju.edu");
		ArrayList<User> allUsers2 = dbCon.getAllUsers();
		
		User loggedOnUser = dbCon.getLoggedOnUser();
		if(loggedOnUser.getUserName().equals("abreyen001@csbsju.edu")) {
			assertTrue("expected: " + allUsers2.get(0).getUserName() + "actual: " + allUsers.get(0).getUserName(), allUsers2.get(0).getUserName().equals(allUsers.get(0).getUserName()));
		}
	}
	
	/**
	 * Test method for {@link csci230.project.DBController#loadUsers(java.lang.String)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testLoadUsers_Invaliduser() {
		dbCon.loadUsers("InvalidUser@csbsju.edu");
	
	}
	
	/**
	 * Test method for {@link csci230.project.DBController#loadUsers(java.lang.String)}.
	 */
	@Test
	public void testLoadUsers_FoundAdminSuccessfulLoad() {
		ArrayList<User> allUsers = dbCon.loadUsers("ZHEINEN001@csbsju.edu");
		ArrayList<User> allUsers2 = dbCon.getAllUsers();
		
		User loggedOnUser = dbCon.getLoggedOnUser();
		if(loggedOnUser.getUserName().equals("ZHEINEN001@csbsju.edu")) {
			assertTrue("expected: " + allUsers2.get(0).getUserName() + "actual: " + allUsers.get(0).getUserName(), allUsers2.get(0).getUserName().equals(allUsers.get(0).getUserName()));
		}
	}

	/**
	 * Test method for {@link csci230.project.DBController#loadUniversities()}.
	 */
	@Test
	public void testLoadUniversities() {
		ArrayList<University> allUnivs = dbCon.loadUniversities();
		assertTrue("expected: ABILENE CHRISTIAN UNIVERSITY. actual: " + allUnivs.get(0).getSchoolName(), allUnivs.get(0).getSchoolName().equals("ABILENE CHRISTIAN UNIVERSITY"));
	}

	/**
	 * Test method for {@link csci230.project.DBController#getLoggedOnUser()}.
	 */
	@Test
	public void testGetLoggedOnUser() {
		fail("Not yet implemented");
	}
//
	/**
	 * Test method for {@link csci230.project.DBController#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#logOut()}.
	 */
	@Test
	public void testLogOut() {
		fail("Not yet implemented");
	}

}
