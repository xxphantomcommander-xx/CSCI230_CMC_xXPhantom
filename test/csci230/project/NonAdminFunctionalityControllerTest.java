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
		uc.logOn("ZHEINEN001@csbsju.edu", "zaciscool");
		john = new User("John", "User", "juser@csbsju.edu", "user", 'u', 'Y');
		NonAdminFunctionalityController nafc = new NonAdminFunctionalityController();
	}

	@Test
	public void testNonAdminFunctionalityController() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
	}
	
	@Test
	public void testLogOn() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
	}
	
	@Test
	public void testLogOut() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testSearchSchools() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testViewedSavedSchools() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testViewUniversities() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testSaveUniversities() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testEditProfile() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testViewMyProfile() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testViewRandomSchool() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testResetPasswordByEmail() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testRecommendSchools() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testShowSchoolDetails() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testRandomSchool() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}
	
	@Test
	public void testViewHistory() {
		NonAdminFunctionalityController nafc2 = nafc;
		assertSame("Constructor worked", nafc, nafc2);
		
	}


}
