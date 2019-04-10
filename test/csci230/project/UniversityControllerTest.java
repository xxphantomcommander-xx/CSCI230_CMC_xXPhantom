//yup
package csci230.project;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import org.junit.Before;


public class UniversityControllerTest {
	UniversityController univC;
	DBController dbCon;
	UserController uc;
	University u;
	ArrayList<University> allUnivs;
	ArrayList<String> al2;
	
	
	@Before
	  public void setUp() throws Exception {
		uc = new UserController();
		univC = new UniversityController();
		dbCon = new DBController();
		al2 = new ArrayList<String>();
		
		uc.logOn("juser@csbsju.edu", "user");
		/*
		 * tests view universities
		 */
		allUnivs = dbCon.loadUniversities();
		/*
		 * university used for testing set and get school of the week
		 */
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
	  }
	
	@Test
	public void testUniversityController() {
		UniversityController newUc = univC;
		assertSame("Constructor failed", univC, newUc);
	}

//	@Test
//	public void testSearchSchools() {
//		ArrayList<String> emp = new ArrayList<String>();
//		ArrayList<University> results = univC.searchSchools("", "California","Urban", "", -1, -1, -1, -1, 500, 650, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
//		for (University i: results){
//			
//		}
//	}
	
	@Test
	public void testSearchBySchool_NullForBoth() {
		ArrayList<University> result = univC.searchBySchool(null, null);
		assertTrue("Expected output null got" + result.get(0), result.get(0) == null);
	}
	
	@Test
	public void testSearchBySchool_ValidNameAndList() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCHESTER", "MASSACHUSETTS", "URBAN","PRIVATE", 10000, 20, 550, 650, 30973, 70, 4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40, 11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400, 15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, emp4, 0, 0, 0));
		
		ArrayList<University> result = univC.searchBySchool(example, "WORCHESTER");
		for (University i: result)
		{
			if (i.getSchoolName().equals("WORCHESTER"))
			{
				assertTrue("Expected output Worchester got" + i.getSchoolName(), "WORCHESTER".equals(i.getSchoolName()));
			}
		}

		
	}
	
	@Test
	public void testSearchBySchool_IvalidNameInList2() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("FINE-ARTS");
		emp1.add("LIBERAL-ARTS");
		emp1.add("MUSIC");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("ENGINEERING");
		emp2.add("HUMANITIES");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("ADMINISTRATIVE SCIENCE");
		emp3.add("AGRICULTURE");
		emp3.add("ARTS-AND-SCIENCES");
		emp3.add("DENTISTRY");
		emp3.add("EDUCATION");
		emp3.add("ENGINEERING");
		emp3.add("LAW");
		emp3.add("MEDICINE");
		emp3.add("OPTOMETRY");
		emp3.add("PHARMACY");
		emp3.add("SOCIAL-WORK");
		emp3.add("VETERINARY-MEDICINE");
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("ENGINEERING");
		emp4.add("LAW");
		emp4.add("LIBERAL-ARTS");
		emp4.add("MEDICAL");
		ArrayList<String> emp5 = new ArrayList<String>();
		emp5.add("ARCHITECTURE");
		emp5.add("ART:DESIGN");
		emp5.add("ARTS-AND-SCIENCES");
		emp5.add("ELECTRICAL-ENGINEERING");
		ArrayList<University> example2 = new ArrayList<University>();
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70, 30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500, 35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90, 65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60, 11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50, 60, 3, 1, 2, emp5, 0, 0, 0));
	}
	
	@Test
	public void testSearchBySchool_InvalidNameInList() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCHESTER", "MASSACHUSETTS", "URBAN","PRIVATE", 10000, 20, 550, 650, 30973, 70, 4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40, 11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400, 15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, emp4, 0, 0, 0));
		
		ArrayList<University> result = univC.searchBySchool(example, "ZACH2");

		assertTrue("Expected output null got " + result.get(0).getSchoolName(), result.get(0).getSchoolName() == null);
		
	}
	
	@Test
	public void testSearchBySchool_InvalidName() {
		fail("Not yet implemented");
	}

	@Test
	public void testTopRecommended() {
		ArrayList<University> r = univC.topRecommended(u);
		assertTrue("Top Recomended, results should be HOFSTRA, was "+r.get(1).getSchoolName(), r.get(1).getSchoolName().equals("HOFSTRA"));
	}

	@Test
	public void testTopRecommended2() {
		ArrayList<University> r = univC.topRecommended2(u);
		assertTrue("Top Recomended 2, result 1 should be HOFSTRA, was" +r.get(1).getSchoolName(), r.get(1).getSchoolName().equals("HOFSTRA"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTopRecommended_invalidUniversity() {
		u = new University("ADELPHInotAUniversity", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		ArrayList<University> r = univC.topRecommended(u);
		assertTrue("Top Recomended, results should be HOFSTRA, was "+r.get(1).getSchoolName(), r.get(1).getSchoolName().equals("HOFSTRA"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTopRecommended2_invalidUniversity() {
		u = new University("ADELPHInotAUniversity", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		ArrayList<University> r = univC.topRecommended2(u);
		assertTrue("Top Recomended 2, result 1 should be HOFSTRA, was" +r.get(1).getSchoolName(), r.get(1).getSchoolName().equals("HOFSTRA"));
	}
	
	@Test
	public void testShowUniversityDetails() {
		ArrayList<String> univDetails = univC.showUniversityDetails(u);
		assertTrue("School name should be ADELPHI, was "+univDetails.get(0), univDetails.get(0).equals("ADELPHI"));
	}

	@Test
	public void testEditSchool_SuccessfulState() {

		univC.editSchool("ADELPHI", "CALIFORNIA", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected California got " + u.getState(), u.getState().equals("CALIFORNIA"));
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulState() {
		univC.editSchool("ADELPHI", "NOTASTATE", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}

	@Test
	public void testEditSchool_SuccessfulLocation() {
		univC.editSchool("ADELPHI", "NEW YORK", "URBAN", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected Urban got " + u.getLocation(), u.getLocation().equals("URBAN"));
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulLocation() {
		univC.editSchool("ADELPHI", "NEW YORK", "NOTALOCATION", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulControl() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "STATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected State got " + u.getControl(), u.getControl().equals("STATE"));
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulControl() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "NOTACONTROL", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulNumStudents() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 20000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 20000 got " + u.getNumOfStudents(), u.getNumOfStudents() == 20000);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulNumStudents() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", -500, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulPerFem() {
		ArrayList<String> al2 = new ArrayList<String>();
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 50, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 50 got " + u.getPerFem(), u.getPerFem() == 50);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulPerFem() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, -20, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulSatVerbal() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 600, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 600 got " + u.getSatVerbal(), u.getSatVerbal() == 600);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulSatVerbal() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, -500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulSatMath() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 675, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 675 got " + u.getSatMath(), u.getSatMath() == 675);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulSatMath() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 2, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulExpences() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 17437, 60, 5500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 17437 got " + u.getExpenses(), u.getExpenses() == 17437);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulExpences() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, -10000, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulFinancialAid() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 20, 5500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 20 got " + u.getFinancialAid(), u.getFinancialAid() == 20);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulFinancialAid() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, -10, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulNumOfApps() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 7500, 70, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 7500 got " + u.getNumOfApps(), u.getNumOfApps() == 7500);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulNumOfApps() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, -5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulPerAdmitted() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 40, 40, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 40 got " + u.getPerAdmitted(), u.getPerAdmitted() == 40);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulPerAdmitted() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, -70, 40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulPerEnrolled() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 40, 60, 2, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 60 got " + u.getPerEnrolled(), u.getPerEnrolled() == 60);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulPerEnrolled() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, -40, 2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulAcademicScale() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 4, 2, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 4 got " + u.getAcademicScale(), u.getAcademicScale() == 4);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulAcademicScale() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, -2, 2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulSocialScale() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 4, 2, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 4 got " + u.getSocialScale(), u.getSocialScale() == 4);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulSocialScale() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, -2, 2, al2);
	}
	
	@Test
	public void testEditSchool_SuccessfulQualOfLife() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 4, al2);
		
		allUnivs = dbCon.loadUniversities();
		
		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
					u = i;
			}
		}
		
		assertTrue("expected 4 got " + u.getQualOfLife(), u.getQualOfLife() == 4);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulQualOFLife() {
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, -2, al2);
	}
	
	@Test
	public void testViewUniversities() {
		ArrayList<University> allUnivs2 = univC.viewUniversities();
		assertTrue("expected ADELPHI got "+allUnivs2.get(2).getSchoolName(),(allUnivs2.get(2).getSchoolName()).equals(allUnivs.get(2).getSchoolName()));
	}

	@Test
	public void testAddUniversity() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		University test = new University("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3, emp, 0, 0, 0);
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3, emp);
		for(University i:univC.viewUniversities()) {
			if(i.getSchoolName().equals("TEST1")) {
				assertTrue("school added", i.getSchoolName().equals("TEST1"));	
			}
		}
		univC.removeUniversity(test);
	}

	@Test
	public void testRemoveUniversity() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		University test = new University("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3, emp, 0, 0, 0);
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3, emp);
		for(University i:univC.viewUniversities()) {
			if(i.getSchoolName().equals("TEST1")) {
				assertTrue("school added", i.getSchoolName().equals("TEST1"));	
			}
		}
		univC.removeUniversity(test);
		for(University i:univC.viewUniversities()) {
			if(i.getSchoolName().equals("TEST1")) {
				assertFalse("school found!", i.getSchoolName().equals("TEST1"));	
			}
		}
	}

	@Test
	public void testRandomSchool() {
		University rand = univC.randomSchool();
		ArrayList<University> temp = dbCon.loadUniversities(); 
		for(University i: temp) {
			if(i.equals(rand)) {
				assertTrue(i.getSchoolName()+ " = " + rand.getSchoolName(),i.getSchoolName().equals(rand.getSchoolName()));
			}
		}
		
	}
	@Test
	public void testSetSchoolOfTheWeek() {
		String expected = u.getSchoolName();
		univC.setSchoolOfTheWeek(expected);
		assertTrue("Expected Adelphi got " + univC.getSchoolOfTheWeek().getSchoolName(), univC.getSchoolOfTheWeek().getSchoolName().equals(expected));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetSchoolOfTheWeek_InvalidName() {
		String expected = "NotASchool";
		univC.setSchoolOfTheWeek(expected);
	}

	@Test
	public void testGetSchoolOfTheWeek() {
		String expected = u.getSchoolName();
		univC.setSchoolOfTheWeek(expected);
		
		assertTrue("expected Adelphi got " + univC.getSchoolOfTheWeek().getSchoolName(), univC.getSchoolOfTheWeek().getSchoolName().equals(u.getSchoolName()));
	}

	@Test
	public void testViewHistory() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.searchSchools("ADELPHI", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		univC.searchSchools("TUFTS", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		univC.searchSchools("GOTHENBURG UNIVERSITY", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		assertTrue("Expected TUFTS, was"+univC.viewHistory().get(1).getSchoolName(),(univC.viewHistory().get(1).getSchoolName()).equals("TUFTS"));
	}

	@Test
	public void testClearHistory() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.searchSchools("ADELPHI", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		univC.searchSchools("TUFTS", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		univC.searchSchools("GOTHENBURG UNIVERSITY", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		assertTrue("Expected TUFTS, was"+univC.viewHistory().get(1).getSchoolName(),(univC.viewHistory().get(1).getSchoolName()).equals("TUFTS"));
		
		univC.clearHistory();
		
		assertTrue("Expected isEmpty, was"+univC.viewHistory(),(univC.viewHistory().isEmpty()));
	}

	@Test
	public void testSuperRecommend() {
		ArrayList<University> r = univC.superRecommend(u);
		assertTrue("Top Recomended, results should be HOFSTRA, was "+r.get(1).getSchoolName(), r.get(1).getSchoolName().equals("HOFSTRA"));
	}

}
