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
	@Before
	  public void setUp() throws Exception {
		 dbCon = new DBController();
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#getUsers()}.
	 */
	@Test
	public void testGetUsers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.DBController#getSavedSchoolList()}.
	 */
	@Test
	public void testGetSavedSchoolList() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		// log someone in
		dbCon.getLoggedOnUser();
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
		//log someone in
		dbCon.logOut();
		assertTrue("logged on user is null" + dbCon.getLoggedOnUser(), dbCon.getLoggedOnUser() == null);
	}

}
