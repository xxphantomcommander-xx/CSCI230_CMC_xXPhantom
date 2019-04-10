
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
	DBController dbCon;
	User john;
//	User lynn;
//	User andrew;
//	User zach;
//	User noreen;
	
	@Before
	  public void setUp() throws Exception {
		uc = new UserController();
		uc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		john = new User("John", "User", "juser@csbsju.edu", "user", 'u', 'Y');
//		lynn = new User("Lynn", "User", "luser@csbsju.edu", "user", 'u', 'N');
//		andrew = new User("Andrew", "Breyen", "abreyen001@csbsju.edu", "myPassword", 'u', 'Y');
//		noreen = new User("Noreen", "Admin", "nadmin@csbsju.edu", "admin", 'a', 'Y');
//		zach = new User("Zach", "Heinen", "ZHEINEN001@csbsju.edu", "zaciscool", 'a', 'Y');
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
		uc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		uc.logOut();
		assertTrue("Successful logOut. isLoggedInShould should be false " + uc.isLoggedIn(), uc.isLoggedIn() == false);
		uc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLogOut_NobodyLoggedIn() {
		uc.logOut();
		uc.logOut();
	}

	/**
	 * Test method for {@link csci230.project.UserController#addUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test
	public void testAddUser() {
		uc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
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
		uc.viewMyProfile();
		assertTrue("expected output zach got" + uc.viewMyProfile(), uc.viewMyProfile().equals(uc.getLoggedOnUser()));
	}
	

	/**
	 * Test method for {@link csci230.project.UserController#isLoggedIn()}.
	 */
	@Test
	public void testIsLoggedIn() {
		uc.logOn("juser@csbsju.edu", "user");
		uc.isLoggedIn();
		assertTrue("expected output true" + uc.isLoggedIn(), uc.isLoggedIn() == true);
		uc.logOut();
	}

	/**
	 * Test method for {@link csci230.project.UserController#isAdminLoggedIn()}.
	 */
	@Test
	public void testIsAdminLoggedIn() {
		uc.isAdminLoggedIn();
		assertTrue("expected output true" + uc.isAdminLoggedIn(), uc.isAdminLoggedIn() == true);
	}

	/**
	 * Test method for {@link csci230.project.UserController#viewUsers()}.
	 */
	@Test
	public void testViewUsers() {
		uc.viewUsers();
		assertTrue("expected output is the username of the first User of all the users from the database " + uc.viewUsers().get(0).getUserName(), uc.viewUsers().get(0).getUserName().equals("abreyen001@csbsju.edu"));
		
	}

	/**
	 * Test method for {@link csci230.project.UserController#editMyProfile(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testEditMyProfile() {
		uc.logOn("juser@csbsju.edu", "user");
		uc.editMyProfile("Johnny", "User", "user", "john");
		ArrayList<User> allUsers = uc.viewUsers();
		for(User i:allUsers) {
			if(i.getUserName().equals("juser@csbsju.edu")) {
				if(i.getFirstName().equals("Johnny") && i.getPassword().equals("john") && i.getUserName().equals("juser@csbsju.edu")) {
					assertTrue("edited User first name should equal Johnny. actual result" + i.getFirstName(), i.getFirstName().equals("Johnny"));
				}
			}
		}
		uc.editMyProfile("John", "User", "john", "user");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditMyProfile_WrongOldPassword() {
		uc.editMyProfile("John", "User", "john", "user");
	}

	/**
	 * Test method for {@link csci230.project.UserController#getLoggedOnUser()}.
	 */
	@Test
	public void testGetLoggedOnUser() {
		uc.getLoggedOnUser();
		assertTrue("expected output: " + uc.getLoggedOnUser().getUserName(), uc.getLoggedOnUser().getUserName().equals("ZHEINEN001@csbsju.edu"));	
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#editUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetLoggedOnUser_NoOneLoggedIn() {
		uc.logOut();
		uc.getLoggedOnUser();
	}

	/**
	 * Test method for {@link csci230.project.UserController#showUserDetails(csci230.project.User)}.
	 */
	@Test
	public void testShowUserDetails() {
		uc.showUserDetails(john);
		ArrayList<String> list = new ArrayList<String>();
		list.add("John");
		list.add("User");
		list.add("juser@csbsju.edu");
		list.add("user");
		list.add("u");
		list.add("Y");
		assertTrue("expected output for user name is and ArrayList of strings with User john's info" + uc.showUserDetails(john), uc.showUserDetails(john).equals(list));
	}
	

	/**
	 * Test method for {@link csci230.project.UserController#editUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test
	public void testEditUser() {
		uc.editUser("IMAD", "RAHAL", "luser@csbsju.edu", "PASSWORD", 'a', 'Y');
		ArrayList<User> allUsers = uc.viewUsers();
		for(User i:allUsers) {
			if(i.getUserName().equals("luser@csbsju.edu")) {
				if(i.getLastName().equals("RAHAL") && i.getPassword().equals("PASSWORD") && i.getType() == 'a' && i.getStatus() == 'Y') {
					assertTrue("edited User first name should equal IMAD. actual result" + i.getFirstName(), i.getFirstName().equals("IMAD"));
				}
			}
		}
		uc.editUser("Lynn", "User", "luser@csbsju.edu", "user", 'u', 'N');
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#editUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testEditUser_InvalidUsername() {
		uc.editUser("IMAD", "RAHAL", "luser", "PASSWORD", 'a', 'Y');
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#editUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testEditUser_InvalidType() {
		uc.editUser("IMAD", "RAHAL", "luser@csbsju.edu", "PASSWORD", 'Z', 'Y');
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#editUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testEditUser_InvalidStatus() {
		uc.editUser("IMAD", "RAHAL", "luser@csbsju.edu", "PASSWORD", 'a', 'p');
	}

	/**
	 * Test method for {@link csci230.project.UserController#viewSavedSchools()}.
	 */
	@Test
	public void testViewSavedSchools() {
		ArrayList<University> saved = uc.viewSavedSchools();
		assertTrue("First Saved school expected Tufts got " + saved.get(0).getSchoolName(), saved.get(0).getSchoolName().equals("TUFTS"));
	}
	
	@Test
	public void testViewSavedSchools_NoSavedSchools() {
		uc.logOut();
		uc.logOn("juser@csbsju.edu", "user");
		ArrayList<University> saved = uc.viewSavedSchools();
		assertTrue("School list should be empty", saved.size() == 0);
		uc.logOut();
	}

	/**
	 * Test method for {@link csci230.project.UserController#removeSavedSchool(csci230.project.University)}.
	 */
	@Test
	public void testRemoveSavedSchool() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		uc.saveUniversity(u);
		uc.removeSavedSchool(u);
		for (University i: uc.viewSavedSchools()) {
			if (!i.getSchoolName().equals("ADELPHI"))
			assertTrue("expected to remove Adelphi", !i.getSchoolName().equals("ADELPHI"));
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRemoveSavedSchool_SchoolNotSaved() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		uc.removeSavedSchool(u);
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#saveUniversity(csci230.project.University)}.
	 */
	@Test
	public void testSaveUniversity() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		uc.saveUniversity(u);
		assertTrue("expected Adelphi got " + uc.viewSavedSchools().get(0).getSchoolName(), uc.viewSavedSchools().get(0).getSchoolName().equals("ADELPHI"));
		uc.removeSavedSchool(u);
		
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
		uc.saveUniversity(u);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSaveUniversity_SchoolAlreadySaved() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("ENGINEERING");
		al2.add("LIBERAL-ARTS");
		al2.add("SCIENCE");
		al2.add("");
		al2.add("");
		University u = new University("TUFTS", "MASSACHUSETTS", "SUBURBAN", "PRIVATE", 15000, 50, 600, 600, 31060, 45, 11500, 35, 35, 4, 3, 3, al2, 0, 0, 0);
		uc.saveUniversity(u);
		uc.saveUniversity(u);
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#deleteUser(java.lang.String)}.
	 */
	@Test
	public void testDeleteUser() {
		uc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		uc.deleteUser("juser@csbsju.edu");
		boolean found = false;
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
	 * Test method for {@link csci230.project.UserController#resetPasswordByEmail(java.lang.String)}.
	 */
	@Test
	public void testResetPasswordByEmail() {
		uc.logOut();
		uc.logOn("andrew.breyen+rpt@gmail.com", "myPassword");
		User u = uc.getLoggedOnUser();
		String oldPass = u.getPassword();
		uc.resetPasswordByEmail(u.getUserName());
		assertFalse("Password should have changed" ,oldPass.equals(u.getPassword()));
		uc.logOut();
	}

	/**
	 * Test method for {@link csci230.project.UserController#deactivateUser(java.lang.String)}.
	 */
	@Test
	public void testDeactivateUser() {
		uc.deactivateUser("abreyen001@csbsju.edu");
		for(User i:uc.viewUsers()) {
			if(i.getUserName().equals("abreyen001@csbsju.edu")) {
				assertTrue("expected output: 'N' actual output: " + i.getStatus(), i.getStatus() == 'N');
			}
		}
		uc.activateUser("abreyen001@csbsju.edu");
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#deactivateUser(java.lang.String)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testDeactivateUser_AlreadyDeactivated() {
		uc.deactivateUser("luser@csbsju.edu");
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#deactivateUser(java.lang.String)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testDeactivateUser_UserNotInDatabase() {
		uc.deactivateUser("notAUser@csbsju.edu");
	}

	/**
	 * Test method for {@link csci230.project.UserController#activateUser(java.lang.String)}.
	 */
	@Test
	public void testActivateUser() {
		uc.activateUser("luser@csbsju.edu");
		for(User i:uc.viewUsers()) {
			if(i.getUserName().equals("luser@csbsju.edu")) {
				assertTrue("expected output: 'Y' actual output: " + i.getStatus(), i.getStatus() == 'Y');
			}
		}
		uc.deactivateUser("luser@csbsju.edu");
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#activateUser(java.lang.String)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testActivateUser_AlreadyActivated() {
		uc.activateUser("abreyen001@csbsju.edu");
	}
	
	/**
	 * Test method for {@link csci230.project.UserController#activateUser(java.lang.String)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testActivateUser_UserNotInDatabase() {
		uc.activateUser("notAUser@csbsju.edu");
	}

}
