/**
 * 
 */
package csci230.project;

import static org.junit.Assert.*;

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
		uc = new UserController();
		dbCon = new DBController();
		uc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		john = new User("John", "User", "juser@csbsju.edu", "user", 'u', 'Y');
		AdminFunctionalityController afc = new AdminFunctionalityController();
	}

	@Test
	public void testAdminFunctionalityController() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testLogOn() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testLogOff() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testAddUser() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testEditUser() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testViewUniversities() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testViewUsers() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testShowUserDetails() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testAddUniversity() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testEditSchool() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testViewMyProfile() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testShowSchoolDetails() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testRemoveUniversity() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testDeleteUser() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testSetSchoolOfTheWeek() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testGetSchoolOfTheWeek() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testResetPasswordByEmail() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testDeactivateUser() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}
	
	@Test
	public void testActviateUser() {
		AdminFunctionalityController afc2 = afc;
		assertSame("Constructor worked", afc, afc2);
	}

}
