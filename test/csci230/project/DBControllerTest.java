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
	}

	/**
	 * Test method for {@link csci230.project.DBController#getUsernameBySavedSchool(java.lang.String)}.
	 */
	@Test
	public void testGetUsernameBySavedSchool() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#removeSchool(csci230.project.University)}.
	 */
	@Test
	public void testRemoveSchool() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#addUser(csci230.project.User)}.
	 */
	@Test
	public void testAddUser() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#deleteSavedSchool(csci230.project.University)}.
	 */
	@Test
	public void testDeleteSavedSchool() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#editUser(csci230.project.User)}.
	 */
	@Test
	public void testEditUser() {
		User newUser = new User("IMAD", "RAHAL", "luser@csbsju.edu", "PASSWORD", 'a', 'Y');
		dbCon.editUser(newUser);
		ArrayList<User> allUsers = uc.viewUsers();
		for(User i:allUsers) {
			if(i.getUserName().equals("luser@csbsju.edu")) {
				if(i.getLastName().equals("RAHAL") && i.getPassword().equals("PASSWORD") && i.getType() == 'a' && i.getStatus() == 'Y') {
					assertTrue("edited User first name should equal IMAD. actual result" + i.getFirstName(), i.getFirstName().equals("IMAD"));
				}
			}
		}
		User oldUser = new User("Lynn", "User", "luser@csbsju.edu", "user", 'u', 'N');
		dbCon.editUser(oldUser);
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#editUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testEditUser_InvalidUsername() {
		User newUser = new User("IMAD", "RAHAL", "luser", "PASSWORD", 'a', 'Y');
		dbCon.editUser(newUser);
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#editUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testEditUser_InvalidType() {
		User newUser = new User("IMAD", "RAHAL", "luser@csbsju.edu", "PASSWORD", 'Z', 'Y');
	    dbCon.editUser(newUser);
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#editUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testEditUser_InvalidStatus() {
		User newUser = new User("IMAD", "RAHAL", "luser@csbsju.edu", "PASSWORD", 'a', 'p');
		dbCon.editUser(newUser);
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
		dbCon.getLoggedOnUser();
		assertTrue("Logged on user is John User " + dbCon.getLoggedOnUser().getFirstName(), dbCon.getLoggedOnUser().getFirstName().equals("John"));
	}
	
	/**
	 * Test method for {@link csci230.project.DBController#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers() {
		dbCon.getAllUsers();
		assertTrue("expected output is the username of the first User of all the users from the database " + dbCon.getAllUsers().get(0).getUserName(), dbCon.getAllUsers().get(0).getUserName().equals("abreyen001@csbsju.edu"));
	}

	/**
	 * Test method for {@link csci230.project.DBController#logOut()}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testLogOut() {
		dbCon.logOut();
		dbCon.getLoggedOnUser();
	}

}
