
package csci230.project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author zheinen001
 *
 */
public class UserControllerTest {
	UserController uc;
	
	@Before
	public void setUp() throws Exception{
		uc = new UserController();
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#UserController()}.
	 */
	@Test
	public void testUserController() {
		UserController newUc = uc;
		assertSame("Constructor failed", uc, newUc);
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#logOn(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogOn_AdminLogon() {
		uc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		assertTrue("Adminlogon. output expected: true actual output: " + this.uc.isAdminLoggedIn(),uc.isAdminLoggedIn());
	}
	
	@Test
	public void testLogOn_NonAdminLogon() {
		uc.logOn("abreyen001@csbsju.edu", "myPassword");
		assertTrue("NonAdminlogon. output expected: true actual output: " + this.uc.isLoggedIn(),uc.isLoggedIn());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testLogOn_IncorrectPassword() {
		uc.logOn("abreyen001@csbsju.edu", "notmyPassword");
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testLogOn_IncorrectUserName() {
		uc.logOn("notaUser@csbsju.edu", "myPassword");
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testLogOn_DeactivatedUser() {
		uc.logOn("luser", "user");
	}

	/**
	 * Test method for {@link csci230.project.UserController#logOut()}.
	 */
	@Test
	public void testLogOut() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#addUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test
	public void testAddUser() {
		uc.addUser("Zac", "Heinen", "someEmail@gmail.com", "password", 'a', 'Y');
		boolean found = false;
		ArrayList<User> allUsers = uc.viewUsers();
		for(User i:allUsers) {
			if(i.getUserName().equals("someEmail@gmail.com")) {
				found = true;
				assertTrue("expected output someEmail@gmail.com got" + i.getUserName(),i.getUserName().equals("someEmail@gmail.com"));
			}
		}
		if(!found) {
			assertFalse(true);
		}
		uc.deleteUser("someEmail@gmail.com");
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#addUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddUser_InvalidUsername() {
		uc.addUser("Zac", "Heinen", "badUsername", "password", 'a', 'Y');
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#addUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddUser_InvalidType() {
		uc.addUser("Zac", "Heinen", "someEmail@gmail.com", "password", 'g', 'Y');
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#addUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddUser_InvalidStatus() {
		uc.addUser("Zac", "Heinen", "someEmail@gmail.com", "password", 'a', 'Z');
	}

	/**
	 * Test method for {@link csci230.project.UserController#viewMyProfile()}.
	 */
	@Test
	public void testViewMyProfile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#isLoggedIn()}.
	 */
	@Test
	public void testIsLoggedIn() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#isAdminLoggedIn()}.
	 */
	@Test
	public void testIsAdminLoggedIn() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#viewUsers()}.
	 */
	@Test
	public void testViewUsers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#editMyProfile(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testEditMyProfile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#getLoggedOnUser()}.
	 */
	@Test
	public void testGetLoggedOnUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#showUserDetails(csci230.project.User)}.
	 */
	@Test
	public void testShowUserDetails() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#editUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test
	public void testEditUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#viewSavedSchools()}.
	 */
	@Test
	public void testViewSavedSchools() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#removeSavedSchool(csci230.project.University)}.
	 */
	@Test
	public void testRemoveSavedSchool() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#saveUniversity(csci230.project.University)}.
	 */
	@Test
	public void testSaveUniversity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#deleteUser(java.lang.String)}.
	 */
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#resetPasswordByEmail(java.lang.String)}.
	 */
	@Test
	public void testResetPasswordByEmail() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#sortByPerEnrolled(java.util.List)}.
	 */
	@Test
	public void testSortByPerEnrolled() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#sortBySize(java.util.List)}.
	 */
	@Test
	public void testSortBySize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#sortByExpense(java.util.List)}.
	 */
	@Test
	public void testSortByExpense() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#viewSortedSavedSchools()}.
	 */
	@Test
	public void testViewSortedSavedSchools() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#deactivateUser(java.lang.String)}.
	 */
	@Test
	public void testDeactivateUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csci230.project.UserController#activateUser(java.lang.String)}.
	 */
	@Test
	public void testActivateUser() {
		fail("Not yet implemented");
	}

}
