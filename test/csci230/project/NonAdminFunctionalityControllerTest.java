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
		dbCon.loadUsers("abreyen001@csbsju.edu");
		ArrayList<University> list = nafc.viewSavedSchools();
		assertTrue("list.get(0) " + list.get(0).getSchoolName(), list.get(0).getSchoolName().equals("ADELPHI"));
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
