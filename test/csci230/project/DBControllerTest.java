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
	public void testEditUniversity_SuccessfulState() {
		University univ2 = new University("ADELPHI", "CALIFORNIA", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2,
				2, al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected California got " + univ2.getState(), univ2.getState().equals("CALIFORNIA"));
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulState() {
		University univ2 = new University("ADELPHI", "NOTASTATE", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulLocation() {
		University univ2 = new University("ADELPHI", "NEW YORK", "URBAN", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2,
				2, al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected Urban got " + univ2.getLocation(), univ2.getLocation().equals("URBAN"));
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulLocation() {
		University univ2 = new University("ADELPHI", "NEW YORK", "NOTALOCATION", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40,
				2, 2, 2, al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulControl() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "STATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected State got " + univ2.getControl(), univ2.getControl().equals("STATE"));
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulControl() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "NOTACONTROL", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2,
				2, al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulNumStudents() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 20000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 20000 got " + univ2.getNumOfStudents(), univ2.getNumOfStudents() == 20000);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulNumStudents() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", -500, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulPerFem() {
		ArrayList<String> al2 = new ArrayList<String>();
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 50, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 50 got " + univ2.getPerFem(), univ2.getPerFem() == 50);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulPerFem() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, -20, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulSatVerbal() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 600, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 600 got " + univ2.getSatVerbal(), univ2.getSatVerbal() == 600);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulSatVerbal() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, -500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulSatMath() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 675, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 675 got " + univ2.getSatMath(), univ2.getSatMath() == 675);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulSatMath() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 2, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulExpences() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 17437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 17437 got " + univ2.getExpenses(), univ2.getExpenses() == 17437);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulExpences() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, -10000, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulFinancialAid() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 20, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 20 got " + univ2.getFinancialAid(), univ2.getFinancialAid() == 20);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulFinancialAid() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, -10, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulNumOfApps() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 7500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 7500 got " + univ2.getNumOfApps(), univ2.getNumOfApps() == 7500);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulNumOfApps() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, -5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulPerAdmitted() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 40, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 40 got " + univ2.getPerAdmitted(), univ2.getPerAdmitted() == 40);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulPerAdmitted() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, -70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulPerEnrolled() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 40, 60, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 60 got " + univ2.getPerEnrolled(), univ2.getPerEnrolled() == 60);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulPerEnrolled() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, -40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulAcademicScale() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 4, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 4 got " + univ2.getAcademicScale(), univ2.getAcademicScale() == 4);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulAcademicScale() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, -2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulSocialScale() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 4, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 4 got " + univ2.getSocialScale(), univ2.getSocialScale() == 4);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulSocialScale() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, -2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
	}

	@Test
	public void testEditUniversity_SuccessfulQualOfLife() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 4,
				al2, 0, 0, 0);
		dbCon.editUniversity(univ2);

		ArrayList<University> allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				univ2 = i;
			}
		}

		assertTrue("expected 4 got " + univ2.getQualOfLife(), univ2.getQualOfLife() == 4);
		University oldUniv = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2, 0, 0, 0);
		dbCon.editUniversity(oldUniv);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversity_UnsuccessfulQualOFLife() {
		University univ2 = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, -2, al2, 0, 0, 0);
		dbCon.editUniversity(univ2);
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
