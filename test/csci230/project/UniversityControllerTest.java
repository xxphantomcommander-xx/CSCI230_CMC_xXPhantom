
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
		u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2,
				2, al2, 0, 0, 0);
	}

	@Test
	public void testUniversityController() {
		UniversityController newUc = univC;
		assertSame("Constructor failed", univC, newUc);
	}

	// @Test
	// public void testSearchSchools() {
	// ArrayList<String> emp = new ArrayList<String>();
	// ArrayList<University> results = univC.searchSchools("", "California","Urban",
	// "", -1, -1, -1, -1, 500, 650, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
	// -1, -1, -1, -1, -1, -1, emp);
	// for (University i: results){
	//
	// }
	// }

	@Test
	public void testSearchBySchool_NullForBoth() {
		ArrayList<University> result = univC.searchBySchool(null, "");
		assertTrue("expected: null. actual:" + result, result == null);
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		boolean found = false;
		ArrayList<University> result = univC.searchBySchool(example, "ZACH2");
		for (University i : result) {
			if (i.getSchoolName().equals("ZACH2")) {
				assertTrue("Expected output ZACH2 got" + i.getSchoolName(),
						"ZACH2".equals(i.getSchoolName()));
				found = true;
			}
		}
		if(!found) {
			assertTrue(false);
		}

	}

	@Test
	public void testSearchBySchool_InvalidNameInList2() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		
		ArrayList<University> result = univC.searchBySchool(example2, "ZACH2");
		boolean works = true;
		for (University i : result) {
			if (i.getSchoolName().equals("ZACH2")) {
				works = false;
			}
		}
		if (works == true)
		{
			assertTrue("Expected output is true got" + univC.searchBySchool(example2, "ZACH2"),
					result.isEmpty());
		}
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));

		ArrayList<University> result = univC.searchBySchool(example, "ZACH3");

		assertTrue("Expected output true got" + result.isEmpty(), result.isEmpty());
	}
	
	@Test
	public void testSearchBySchool_NullNameInList() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));

		ArrayList<University> result = univC.searchBySchool(example, "");

		assertTrue("Expected output for the 2nd school in the list got" + result.get(1).getSchoolName(), result.get(1).getSchoolName() == "YALE");
	}
	
	@Test
	public void testSearchBySchool_NullList() {
		ArrayList<University> result = univC.searchBySchool(null, "ADELPHI");
		assertTrue("expected: null. actual:"  + result,
				result == null);
	}

	@Test
	public void testSearchByState_StateNullTempNull() {
		ArrayList<University> matchingSchools = univC.searchByState(null, "");
		assertTrue("expected: null. actual:" + matchingSchools, matchingSchools == null);

	}

	@Test
	public void testSearchByState_StateMatches() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByState(example, "MASSACHUSETTS");
		assertTrue("expected: WORCESTER. actual: " + matchingSchools.get(0).getSchoolName(),
				matchingSchools.get(0).getSchoolName().equals("WORCESTER"));

	}

	@Test
	public void testSearchByState_StateDoesntMatch() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByState(example2, "MINNESOTA");
		assertTrue("expected: null. actual: " + matchingSchools.isEmpty(), matchingSchools.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchByState_StateNotNullTempNull() {
		univC.searchByState(null, "TUVALU");
	}

	@Test
	public void testSearchByState_StateDoesntMatchTempNotNull() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByState(example, "HAWAII");
		assertTrue("expected: null. actual: " + matchingSchools.isEmpty(), matchingSchools.isEmpty());

	}

	@Test
	public void testSearchByState_StateIsNullTempIsNotNull() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByState(example2, "");
		assertTrue("expected: OBERLIN. actual: " + matchingSchools.get(0).getSchoolName(),
				matchingSchools.get(0).getSchoolName().equals("OBERLIN"));
	}

	@Test
	public void testSearchByState_StateMatchesMultiple() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByState(example2, "OHIO");
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			assertTrue("expected: OHIO STATE. actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("OHIO STATE"));
		}
		else {
			assertTrue("expected: OBRELIN. actual: " + matchingSchools.get(0).getSchoolName(), false);
		}
	}

	@Test
	public void testSearchByLocation_LocationNullTempNull() {
		ArrayList<University> matchingSchools = univC.searchByLocation(null, "");
		assertTrue("expected: null actual: " + matchingSchools, matchingSchools == null);
	}

	@Test
	public void testSearchByLocation_LocationMatches() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByLocation(example, "URBAN");
		assertTrue("expected: WORCESTER actual: " + matchingSchools.get(0).getSchoolName(),
				matchingSchools.get(0).getSchoolName().equals("WORCESTER"));
	}

	@Test
	public void testSearchByLocation_LocationDoesntMatch() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByLocation(example2, "SMALL-CITY");
		assertTrue("expected: null actual: " + matchingSchools.isEmpty(), matchingSchools.isEmpty());
	}

	@Test
	public void testSearchByLocation_InvalidLocationTempNull() {
		ArrayList<University> matchingSchools = univC.searchByLocation(null, "Rural");
		assertTrue("expected: null. actual:" + matchingSchools,  matchingSchools == null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchByLocation_InvalidLocationTempNotNull() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByLocation(example, "Rural");
	}

	@Test
	public void testSearchByLocation_LocationNullTempNotNull() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByLocation(example2, "");
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(4).getSchoolName(),
					matchingSchools.get(4).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: OBERLIN. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}

	@Test
	public void testSearchByLocation_LocationMatchesMultiple() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByLocation(example2, "URBAN");
		if (matchingSchools.get(0).getSchoolName().equals("NOTRE DAME")) {
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: NOTRE DAME. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}

	@Test
	public void testSearchByControl_ControlNullTempNull() {
		ArrayList<University> matchingSchools = univC.searchByControl(null, "");
		assertTrue("expected: null actual: " + matchingSchools, matchingSchools == null);
	}

	@Test
	public void testSearchByControl_ControlMatches() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByControl(example, "PRIVATE");
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("ZACH2"));
		}
		else {
			assertTrue("expected: WORCESTER. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}

	@Test
	public void testSearchByControl_ControlDoesntMatchTempNotNull() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByControl(example, "STATE");
		assertTrue("expected: true. actual: " + matchingSchools.isEmpty(), matchingSchools.isEmpty());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchByControl_InvalidControlTempNull() {
		univC.searchByControl(null, "PETEOWNED");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchByControl_InvalidControlTempNotNull() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByControl(example, "STEIGHT");

	}

	@Test
	public void testSearchByControl_ControlNullTempNotNull() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByControl(example2, "");
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(4).getSchoolName(),
					matchingSchools.get(4).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: OBERLIN. actual: " + matchingSchools.get(0).getSchoolName(),
				false);
		}
	}

	@Test
	public void testSearchByControl_ControlMatchesMultiple() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByControl(example2, "STATE");
		if (matchingSchools.get(0).getSchoolName().equals("OHIO STATE")) {
			assertTrue("expected: PENN STATE. actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("PENN STATE"));
		}
		else {
			assertTrue("expected: OHIO STATE. actual: " + matchingSchools.get(0).getSchoolName(),
				false);
		}
	}

	@Test
	public void testSearchByNumStudents_TempNullLowNullHighNull() {
		ArrayList<University> matchingSchools = univC.searchByNumOfStudents(null, -1, -1);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}

	@Test
	public void testSearchByNumStudents_MultipleMatches() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByNumOfStudents(example, 5000, 30000);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("ZACH2"));
		}
		else {
			assertTrue("expected: WORCESTER. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchByNumStudents_invalidNumStudents() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByNumOfStudents(example2, -100, -100);
	}
	
	@Test
	public void testSearchByNumStudents_TempNullNumZero() {
		ArrayList<University> matchingSchools = univC.searchByNumOfStudents(null, 0, 0);
		assertTrue("expected: null actual: " + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByNumStudents_LowAndHighEqual1() {
		ArrayList<University> matchingSchools = univC.searchByNumOfStudents(null, 1, 1);
		assertTrue("expected: null actual: " + matchingSchools, matchingSchools == null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByNumStudents_InvalidNumStu() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByNumOfStudents(example2, -2, -2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByNumStudents_NStuLowBiggerThanHigh() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByNumOfStudents(example2, 5000, 1);
	}
	
	@Test
	public void testSearchByNumStudents_TempNotNullNStuLowAndHighNull() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByNumOfStudents(example, -1, -1);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("ZACH2"));
		}
		else {
			assertTrue("expected: WORCESTER. actual: " + matchingSchools.get(0).getSchoolName(),
				false);
		}
	}
	
	@Test
	public void testSearchByNumStudents_TempNotNullNstuLowNullHighNotNull() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByNumOfStudents(example2, -1, 30000);
		ArrayList<University> matchingSchools = univC.searchByNumOfStudents(example2, -1, 30000);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: OBERLIN. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test
	public void testSearchByNumStudents_TempNotNullNStuLow30000High30000() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByNumOfStudents(example, 30000, 30000);
		assertTrue("expected: ZACH2. actual: " + matchingSchools.get(0).getSchoolName(),
				matchingSchools.get(0).getSchoolName().equals("ZACH2"));
	}
	
	@Test
	public void testSearchByPercentFemale_TempNullLowNullHighNull() {
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(null, -1, -1);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	
	
	@Test
	public void testSearchByPercentFemale_TempNotNullPrctLow30prctHigh60() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(example, 30, 60);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(2).getSchoolName(),
					matchingSchools.get(2).getSchoolName().equals("ZACH2"));
		}
		else {
			assertTrue("expected: WORCESTER. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFemale_PrctFemNegative() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercentFemale(example2, -10, -10);
	}
	
	@Test
	public void testSearchByPercentFemale_TempNullLowZeroHighZero() {
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(null, 0, 0);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentFemale_TempNotNullLowOneHighOne() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(example, 1, 1);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFemale_PrctFemNegative2() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercentFemale(example2, -10, -10);
	}
	
	@Test
	public void testSearchByPercentFemale_TempNullLowHighNotNull() {
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(null, 99, 99);	
			assertTrue("expected: ZACH2. actual: " + matchingSchools,
					matchingSchools == null);	
	}
	
	@Test
	public void testSearchByPercentFemale_TempNotNullLow100High100() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(example, 100, 100);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFemale_PrctFemNegativeInvalid101() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercentFemale(example2, 101, 101);
	}
	
	@Test
	public void testSearchByPercentFemale_TempNotNullPrctLow40prctHigh60() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(example, 30, 60);
		if (matchingSchools.get(0).getSchoolName().equals("YALE")) {
			
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(2).getSchoolName(),
					matchingSchools.get(2).getSchoolName().equals("ZACH2"));
		}
		else {
			assertTrue("expected: YALE. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test
	public void testSearchByPercentFemale_TempNotNullPrctLowNeg1prctHigh60() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(example2, -1, 60);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(4).getSchoolName(),
					matchingSchools.get(4).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: OBERLIN. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFemale_TempNotNullPrctLowNeg2prctHigh60() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByPercentFemale(example, -2, 60);
	}
	
	@Test
	public void testSearchByPercentFemale_TempNotNullPrctLow40prctHigh40() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(example2, -1, 60);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(4).getSchoolName(),
					matchingSchools.get(4).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: OBERLIN. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFemale_TempNotNullPrctLow65prctHigh30() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByPercentFemale(example, 65, 30);
	}
	
	@Test
	public void testSearchByPercentFinAid_TempNullLowNullHighNull() {
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(null, -1, -1);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentFinAid_TempNotNullFinAidLow30FinAidHigh60() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFinAid(example, 30, 60);
		assertTrue("expected: YALE. actual: " + matchingSchools.get(0).getSchoolName(),
				matchingSchools.get(0).getSchoolName().equals("YALE"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFinAid_TempNotNullFinAidLowNeg10FinAidHighNeg10() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercentFinAid(example2, -10, -10);
	}
	
	@Test
	public void testSearchByPercentFinAid_TempNullLowZeroHighZero() {
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(null, 0, 0);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentFinAid_TempNotNullFinAidLow1FinAidHigh1() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFinAid(example, 1, 1);
		assertTrue("expected: YALE. actual: " + matchingSchools.isEmpty(),
				matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFinAid_TempNotNullFinAidLowNeg2FinAidHighNeg2() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercentFinAid(example2, -2, -2);
	}
	
	@Test
	public void testSearchByPercentFinAid_TempNullLow99High99() {
		ArrayList<University> matchingSchools = univC.searchByPercentFemale(null, 99, 99);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentFinAid_TempNotNullFinAidLow100FinAidHigh100() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFinAid(example, 1, 1);
		assertTrue("expected: YALE. actual: " + matchingSchools.isEmpty(),
				matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFinAid_TempNotNullFinAidLow101FinAidHigh101() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercentFinAid(example2, 101, 101);
	}
	
	@Test
	public void testSearchByPercentFinAid_TempNotNullFinAidLow40FinAidHigh70() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFinAid(example, 40, 70);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(2).getSchoolName(),
					matchingSchools.get(2).getSchoolName().equals("ZACH2"));
		}
		else {
			assertTrue("expected: WORCESTER. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test
	public void testSearchByPercentFinAid_TempNotNullFinAidLowNullFinAidHigh60() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFinAid(example2, -1, 60);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			
			assertTrue("expected: PENN STATE. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("PENN STATE"));
		}
		else {
			assertTrue("expected: OBERLIN. actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFinAid_TempNotNullFinAidLowNeg2FinAidHigh60() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByPercentFinAid(example, -2, 60);
	}
	
	
	@Test
	public void testSearchByPercentFinAid_TempNotNullFinAidLow30FinAidHigh30() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFinAid(example2, 30, 30);
			assertTrue("expected: OHIO STATE. actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("OHIO STATE"));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentFinAid_TempNotNullFinAidLow65FinAidHigh30() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercentFinAid(example, 400, 600);
		assertTrue("expected: OHIO STATE. actual: " + matchingSchools.get(0).getSchoolName(),
				matchingSchools.get(0).getSchoolName().equals("OHIO STATE"));
	}
	
	@Test
	public void testSearchBySATVerbal_TempNullLowNullHighNull() {
		ArrayList<University> matchingSchools = univC.searchBySATVerbal(null, -1, -1);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchBySATVerbal_TempNotNullLow400High600() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATVerbal(example, 400, 600);	
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			assertTrue("expected: ZACH2 actual: " + matchingSchools.get(2).getSchoolName(),
					matchingSchools.get(2).getSchoolName().equals("ZACH2"));
		}
		else {
			assertTrue("expected: WORCESTER actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATVerbal_TempNotNullLowNeg10HighNeg10() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchBySATVerbal(example2, -10, -10);
	}
	
	@Test
	public void testSearchBySATVerbal_TempNullLow0High0() {
		ArrayList<University> matchingSchools = univC.searchBySATVerbal(null, 0, 0);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATVerbal_TempNotNullLow1High1() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchBySATVerbal(example, 1, 1);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATVerbal_TempNotNullLowNeg2HighNeg2() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchBySATVerbal(example2, -2, -2);
	}
	
	@Test
	public void testSearchBySATVerbal_TempNullLow799High799() {
		ArrayList<University> matchingSchools = univC.searchBySATVerbal(null, 799, 799);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchBySATVerbal_TempNotNullLow800High800() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATVerbal(example, 800, 800);	

			assertTrue("expected: true actual: " + matchingSchools.isEmpty(),
					matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATVerbal_TempNotNullLow801High801() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchBySATVerbal(example2, 801, 801);
	}
	
	
	
	@Test
	public void testSearchBySATVerbal_TempNotNullLow650High675() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATVerbal(example, 650, 675);	


			assertTrue("expected: YALE actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("YALE"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATVerbal_TempNotNullLowNullHigh675() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATVerbal(example2, -1, 675);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			assertTrue("expected: PRATT actual: " + matchingSchools.get(4).getSchoolName(),
					matchingSchools.get(4).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: OBERLIN actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATVerbal_TempNotNulllLowNeg2High600() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchBySATVerbal(example, -2, 600);	
	}
	
	@Test
	public void testSearchBySATVerbal_TempNotNullLow570High570() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATVerbal(example2, 570, 570);
			assertTrue("expected: NOTRE DAME actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("NOTRE DAME"));
	}
	
	@Test
	public void testSearchBySATMath_TempNullLowNullHighNull() {
		ArrayList<University> matchingSchools = univC.searchBySATMath(null, -1, -1);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchBySATMath_TempNotNullLow400High600() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATMath(example, 400, 600);	
	
			assertTrue("expected: YANKTOWN COLLEGE actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("YANKTOWN COLLEGE"));

	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATMath_TempNotNullLowNeg10HighNeg10() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchBySATMath(example2, -10, -10);
	}
	
	@Test
	public void testSearchBySATMath_TempNullLow0High0() {
		ArrayList<University> matchingSchools = univC.searchBySATMath(null, 0, 0);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATMath_TempNotNullLow1High1() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchBySATMath(example, 1, 1);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATMath_TempNotNullLowNeg2HighNeg2() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchBySATMath(example2, -2, -2);
	}
	
	@Test
	public void testSearchBySATMath_TempNullLow799High799() {
		ArrayList<University> matchingSchools = univC.searchBySATMath(null, 799, 799);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchBySATMath_TempNotNullLow800High800() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATMath(example, 800, 800);	
			assertTrue("expected: true actual: " + matchingSchools.isEmpty(),
					matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchBySATMath_TempNotNullLow801High801() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchBySATMath(example2, 801, 801);	
	}
	
	@Test
	public void testSearchBySATMath_TempNotNullLow650High675() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATMath(example, 800, 800);	
			assertTrue("expected: true actual: " + matchingSchools.isEmpty(),
					matchingSchools.isEmpty());
	}
	
	@Test
	public void testSearchBySATMath_TempNotNullLowNeg1High675() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATMath(example2, -1, 675);	
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			assertTrue("expected: PRATT actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: OBERLIN actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	public void testSearchBySATMath_TempNotNullLowNeg2High600() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchBySATMath(example, -2, 600);	
	}
	
	@Test
	public void testSearchBySATMath_TempNotNullLow640High640() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySATMath(example2, 640, 640);	
			assertTrue("expected: NOTRE DAME actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("NOTRE DAME"));
	}
	
	@Test
	public void testSearchByPercentAdmitted_TempNullLowNullHighNull() {
		ArrayList<University> matchingSchools = univC.searchByPercAdmitted(null, -1, -1);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentAdmitted_TempNullLowHighNull() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercAdmitted(example, 30, 60);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			assertTrue("expected: ZACH2 actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("ZACH2"));
		}
		else {
			assertTrue("expected: WORCESTER actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentAdmitted_TempNullLowNeg10HighNeg10() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercAdmitted(example2, -10, -10);
	}
	
	@Test
	public void testSearchByPercentAdmitted_TempNullLow0High0() {
		ArrayList<University> matchingSchools = univC.searchByPercAdmitted(null, 0, 0);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentAdmitted_TempNullLow1High1() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercAdmitted(example, 1, 1);
			assertTrue("expected: true actual: " + matchingSchools.isEmpty(),
					matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentAdmitted_TempNullLowNeg2HighNeg2() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercAdmitted(example2, -2, -2);
	}
	
	@Test
	public void testSearchByPercentAdmitted_TempNullLow99High99() {
		ArrayList<University> matchingSchools = univC.searchByPercAdmitted(null, 99, 99);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentAdmitted_TempNullLow100High100() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercAdmitted(example, 100, 100);
			assertTrue("expected: true actual: " + matchingSchools.isEmpty(),
					matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentAdmitted_TempNullLow101High101() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercAdmitted(example2, 101, 101);
	}
	
	@Test
	public void testSearchByPercentAdmitted_TempNullLow40High70() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercAdmitted(example, 40, 70);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			assertTrue("expected: ZACH2 actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("ZACH2"));
		}
		else {
			assertTrue("expected: WORCESTER actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test
	public void testSearchByPercentAdmitted_TempNullLowNeg1High60() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercAdmitted(example2, -1, 60);
		if (matchingSchools.get(0).getSchoolName().equals("NOTRE DAME")) {
			assertTrue("expected: PRATT actual: " + matchingSchools.get(2).getSchoolName(),
					matchingSchools.get(2).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: NOTRE DAME actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentAdmitted_TempNullLowNeg2High60() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByPercAdmitted(example, -2, 60);
	}
	
	@Test
	public void testSearchByPercentAdmitted_TempNullLow90High90() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercAdmitted(example2, 90, 90);
			assertTrue("expected: OHIO STATE actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("OHIO STATE"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentAdmitted_TempNullLow65High30() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByPercAdmitted(example, 65, 30);
	}
	
	@Test
	public void testSearchByPercentEnrolled_TempNullLowNullHighNull() {
		ArrayList<University> matchingSchools = univC.searchByPercEnrolled(null, -1, -1);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentEnrolled_TempNullLow30High60() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercEnrolled(example, 30, 60);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			assertTrue("expected: YALE actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("YALE"));
		}
		else {
			assertTrue("expected: WORCESTER actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentEnrolled_TempNullLowNeg10HighNeg10() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercEnrolled(example2, -10, -10);
	}
	
	@Test
	public void testSearchByPercentEnrolled_TempNullLow0High0() {
		ArrayList<University> matchingSchools = univC.searchByPercEnrolled(null, 0, 0);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentEnrolled_TempNullLow1High1() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercEnrolled(example, 1, 1);

			assertTrue("expected: true actual: " + matchingSchools.isEmpty(),
					matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentEnrolled_TempNullLowNeg2HighNeg2() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercEnrolled(example2, -2, -2);
	}
	
	@Test
	public void testSearchByPercentEnrolled_TempNullLow99High99() {
		ArrayList<University> matchingSchools = univC.searchByPercEnrolled(null, 99, 99);
		assertTrue("expected: null actual:"  + matchingSchools, matchingSchools == null);
	}
	
	@Test
	public void testSearchByPercentEnrolled_TempNullLow100High100() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercEnrolled(example, 100, 100);

			assertTrue("expected: true actual: " + matchingSchools.isEmpty(),
					matchingSchools.isEmpty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentEnrolled_TempNullLow101High101() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByPercEnrolled(example2, 101, 101);
	}
	
	@Test
	public void testSearchByPercentEnrolled_TempNullLowNeg1High60() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercEnrolled(example2, -1, 60);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			assertTrue("expected: PRATT actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("PRATT"));
		}
		else {
			assertTrue("expected: OBERLIN actual: " + matchingSchools.get(0).getSchoolName(),
					false);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentEnrolled_TempNullLowNeg2High60() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByPercEnrolled(example, -2, 60);
	}
	
	@Test
	public void testSearchByPercentEnrolled_TempNullLow65High65() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByPercEnrolled(example2, 65, 65);
			assertTrue("expected: OHIO STATE actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("OHIO STATE"));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSearchByPercentEnrolled_TempNullLow65High30() {
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
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByPercEnrolled(example, 65, 30);
	}
	
	@Test
	public void testSearchByExpenses_TempNullQLowNegQHighNeg() {
		ArrayList<University> matchingSchools = univC.searchByExpenses(null, -1, -1);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	
	@Test
	public void testSearchByExpenses_TempNotNullQLow5000QHigh33014() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByExpenses(example, 5000, 33014);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("ZACH2"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchByExpenses_TempNotNullQLowNegQHighNeg() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByExpenses(example2, -10, -10);
	}
	
	@Test
	public void testSearchByExpences_TempNotNullQLow1QHigh1() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByExpenses(example, 1, 1);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools.isEmpty());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchByExpenses_TempNotNullQLowGreaterThanHigh() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByExpenses(example, 5000, 1);
	}
	
	
	@Test
	public void testSearchByExpenses_TempNotNullQLow5000High33014_2() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByExpenses(example2, 5000, 33014);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("PRATT"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testSearchByExpenses_TempNotNullQLowNeg1QHighNeg1() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByExpenses(example, -1, -1);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("ZACH2"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testSearchByExpences_TempNotNullQLow0QHigh0() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByExpenses(example2, 0, 0);
		assertTrue("expected: empty actual: " + matchingSchools,
				matchingSchools.isEmpty());
	}
	
	@Test
	public void testSearchByExpenses_TempNotNullQLow33014High33014() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByExpenses(example, 33014, 33014);
			assertTrue("expected: YALE. actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("YALE"));
	
	}
	
	@Test
	public void testSearchByExpenses_TempNullQLow5000QHigh33014() {
		ArrayList<University> matchingSchools = univC.searchByNumOfApps(null, 5000, 33014);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	
	@Test
	public void testSearchByNumOfApps_TempNullQLowNegQHighNeg() {
		ArrayList<University> matchingSchools = univC.searchByNumOfApps(null, -1, -1);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	
	@Test
	public void testSearchByNumOfApps_TempNotNullQLow4000QHigh11500() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByNumOfApps(example, 4000, 11500);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("ZACH2"));
		}
		else
		{
			assertTrue(false);
		}
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testSearchNumOfApps_TempNotNullQLowNegQHighNeg() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByNumOfApps(example2, -10, -10);
	}
	
	@Test
	public void testSearchByNumOfApps_TempNotNullQLow1QHigh1() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByNumOfApps(example, 1, 1);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools.isEmpty());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchByNumOfApps_TempNotNullQLowGreaterThanHigh() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByNumOfApps(example, 4000, 1);
	}
	
	@Test
	public void testSearchByNumOfApps_TempNotNullQLow4000High11500_2() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByNumOfApps(example2, 4000, 11500);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("PRATT"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testSearchByNumOfApps_TempNotNullQLowNeg1QHighNeg1() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByNumOfApps(example, -1, -1);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(3).getSchoolName(),
					matchingSchools.get(3).getSchoolName().equals("ZACH2"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testSearchByNumOfApps_TempNotNullQLow0QHigh0() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByNumOfApps(example2, 0, 0);
		assertTrue("expected: empty actual: " + matchingSchools,
				matchingSchools.isEmpty());
	}
	
	@Test
	public void testSearchByNumOfApps_TempNotNullQLow11500High11500() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByNumOfApps(example, 11500, 11500);
			assertTrue("expected: YALE. actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("YALE"));
	
	}
	
	@Test
	public void testSearchByNumOfApps_TempNullQLow4000QHigh11500() {
		ArrayList<University> matchingSchools = univC.searchByNumOfApps(null, 4000, 11500);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	
	@Test
	public void testSearchByAcademicScale_TempNullQLowNegQHighNeg() {
		ArrayList<University> matchingSchools = univC.searchByAcademicScale(null, -1, -1);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	
	
	@Test
	public void testSearchByAcademicScale_TempNotNullQLow3QHigh4() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByAcademicScale(example, 3, 4);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: ZACH2. actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("ZACH2"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchAcademicScale_TempNotNullQLowNegQHighNeg() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByAcademicScale(example2, -10, -10);
	}
	
	
	@Test
	public void testSearchByAcademicScale_TempNotNullQLow3QHigh3() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByAcademicScale(example, 3, 3);
		assertTrue("expected: empty actual: " + matchingSchools,
				matchingSchools.isEmpty());
	}
	
	@Test
	public void testSearchByAcademicScale_TempNullQLow4QHigh4() {
		ArrayList<University> matchingSchools = univC.searchByAcademicScale(null, 4, 4);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	
	@Test
	public void testSearchByAcademicScale_TempNotNullQLow5QHigh5() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByAcademicScale(example, 5, 5);
		assertTrue("expected: YALE. actual: " + matchingSchools.get(0).getSchoolName(),
				matchingSchools.get(0).getSchoolName().equals("YALE"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSearchByAcademicScale_TempNotNullQLowHighQHighHigh() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByAcademicScale(example2, 6, 6);
	}
	
	
	@Test
	public void testSearchByAcademicScale_TempNotNullQLow1High4() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByAcademicScale(example2, 1, 4);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(2).getSchoolName(),
					matchingSchools.get(2).getSchoolName().equals("PRATT"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchByAcademicScale_TempNotNullQLowNegQHigh4() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByAcademicScale(example, -2, 4);
	}
	
	@Test
	public void testSearchByAcademicScale_TempNotNullQLow4QHigh4() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByAcademicScale(example2, 4, 4);
			assertTrue("expected: OHIO STATE. actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("OHIO STATE"));
		}
	
	
	@Test
	public void testSearchBySocialScale_TempNullQLowNegQHighNeg() {
		ArrayList<University> matchingSchools = univC.searchBySocialLife(null, -1, -1);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	

	
	@Test
	public void testSearchBySocialScale_TempNotNullQLow3QHigh4() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySocialLife(example, 3, 4);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: YALE. actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("YALE"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchSocialScale_TempNotNullQLowNegQHighNeg() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchBySocialLife(example2, -10, -10);
	}
	
	@Test
	public void testSearchBySocialScale_TempNotNullQLow1QHigh1() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySocialLife(example, 1, 1);
		assertTrue("expected: empty list actual: " + matchingSchools,
				matchingSchools.isEmpty());
	}
	
	@Test
	public void testSearchBySocialScale_TempNullQLow4QHigh4() {
		ArrayList<University> matchingSchools = univC.searchBySocialLife(null, 4, 4);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	
	@Test
	public void testSearchBySocialScale_TempNotNullQLow5QHigh5() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySocialLife(example, 5, 5);
		assertTrue("expected: ZACH2. actual: " + matchingSchools.get(0).getSchoolName(),
				matchingSchools.get(0).getSchoolName().equals("ZACH2"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchBySocialScale_TempNotNullQLowHighQHighHigh() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchBySocialLife(example2, 6, 6);
	}
	
	@Test
	public void testSearchBySocialScale_TempNotNullQLow1QHigh4() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySocialLife(example, 1, 4);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(2).getSchoolName(),
					matchingSchools.get(2).getSchoolName().equals("YANKTOWN COLLEGE"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchBySocialScale_TempNotNullQLowNegQHigh4() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchBySocialLife(example, -2, 4);
	}
	
	
	@Test
	public void testSearchBySocialScale_TempNotNullQLow4QHigh4() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchBySocialLife(example2, 4, 4);
			assertTrue("expected: PENN STATE. actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("PENN STATE"));
		}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchBySocialScale_TempNotNullQLowGreaterThanHigh() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchBySocialLife(example, 5, 3);
	}
	
	@Test
	public void testSearchByQualOfLife_TempNullQLowNegQHighNeg() {
		ArrayList<University> matchingSchools = univC.searchByQualityOfLife(null, -1, -1);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	
	@Test
	public void testSearchByQualOfLife_TempNotNullQLow3QHigh4() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByQualityOfLife(example, 3, 4);
		if (matchingSchools.get(0).getSchoolName().equals("WORCESTER")) {
			
			assertTrue("expected: YALE. actual: " + matchingSchools.get(1).getSchoolName(),
					matchingSchools.get(1).getSchoolName().equals("YALE"));
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchByQualOfLife_TempNotNullQLowNegQHighNeg() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByQualityOfLife(example2, -10, -10);
	}
	
	@Test
	public void testSearchByQualOfLife_TempNullQLow4QHigh4() {
		ArrayList<University> matchingSchools = univC.searchByQualityOfLife(null, 4, 4);
		assertTrue("expected: null actual: " + matchingSchools,
				matchingSchools == null);	
	}
	
	@Test
	public void testSearchByQualOfLife_TempNotNullQLow1QHigh1() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByQualityOfLife(example, 1, 1);
		assertTrue("expected: empty list actual: " + matchingSchools,
				matchingSchools.isEmpty());
	}
	
	
	@Test
	public void testSearchByQualOfLife_TempNotNullQLow5QHigh5() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByQualityOfLife(example, 5, 5);
		assertTrue("expected: ZACH2. actual: " + matchingSchools.get(0).getSchoolName(),
				matchingSchools.get(0).getSchoolName().equals("ZACH2"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchByQualOfLife_TempNotNullQLowHighQHighHigh() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		univC.searchByQualityOfLife(example2, 6, 6);
	}
	
	@Test
	public void testSearchByQualOfLife_TempNotNullQLow1QHigh4() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByQualityOfLife(example2, 1, 4);
		if (matchingSchools.get(0).getSchoolName().equals("OBERLIN")) {
			
			assertTrue("expected: PRATT. actual: " + matchingSchools.get(4).getSchoolName(),
					matchingSchools.get(4).getSchoolName().equals("PRATT"));
		}
		else
		{
			assertTrue(false);
		}
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSearchByQualOfLife_TempNotNullQLowNegQHigh4() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByQualityOfLife(example, -2, 4);
	}
	
	@Test
	public void testSearchByQualOfLife_TempNotNullQLow4QHigh4() {
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
		example2.add(new University("OBERLIN", "OHIO", "SUBURBAN", "PRIVATE", 10000, 50, 550, 550, 25369, 50, 4000, 70,
				30, 3, 3, 2, emp1, 0, 0, 0));
		example2.add(new University("NOTRE DAME", "INDIANA", "URBAN", "PRIVATE", 35000, 29, 570, 640, 15650, 50, 8500,
				35, 60, 5, 3, 3, emp2, 0, 0, 0));
		example2.add(new University("OHIO STATE", "OHIO", "URBAN", "STATE", 40000, 45, 450, 500, 20840, 30, 17000, 90,
				65, 4, 4, 3, emp3, 0, 0, 0));
		example2.add(new University("PENN STATE", "PENNSYLVANIA", "URBAN", "STATE", 40000, 40, 620, 680, 39604, 60,
				11500, 40, 50, 5, 4, 4, emp4, 0, 0, 0));
		example2.add(new University("PRATT", "NEW YORK", "URBAN", "PRIVATE", 10000, 40, 425, 475, 17879, 80, 4000, 50,
				60, 3, 1, 2, emp5, 0, 0, 0));
		ArrayList<University> matchingSchools = univC.searchByQualityOfLife(example2, 4, 4);
			assertTrue("expected: PENN STATE. actual: " + matchingSchools.get(0).getSchoolName(),
					matchingSchools.get(0).getSchoolName().equals("PENN STATE"));
		}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchByQualOfLife_TempNotNullQLowGreaterThanHigh() {
		ArrayList<String> emp1 = new ArrayList<String>();
		emp1.add("ENGINEERING");
		ArrayList<String> emp2 = new ArrayList<String>();
		emp2.add("BIOLOGY");
		emp2.add("ENGLISH");
		emp2.add("HISTORY");
		emp2.add("LIBERAL-ARTS");
		ArrayList<String> emp3 = new ArrayList<String>();
		emp3.add("BUSINESS-ADMINISTRATION");
		emp3.add("SOCIAL-SCIENCE");//
		ArrayList<String> emp4 = new ArrayList<String>();
		emp4.add("BIOLOGY");
		emp4.add("COMPUTER SCIENCE");
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70,
				4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40,
				11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400,
				15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000,
				40, 80, 4, 5, 5, emp4, 0, 0, 0));
		univC.searchByQualityOfLife(example, 5, 3);
	}
	/*
	 * End of search tests
	 */
	
	@Test
	public void testTopRecommended() {
		ArrayList<University> r = univC.topRecommended(u);
		assertTrue("Top Recomended, results should be HOFSTRA, was " + r.get(1).getSchoolName(),
				r.get(1).getSchoolName().equals("HOFSTRA"));
	}

	@Test
	public void testTopRecommended2() {
		ArrayList<University> r = univC.topRecommended2(u);
		assertTrue("Top Recomended 2, result 1 should be HOFSTRA, was" + r.get(1).getSchoolName(),
				r.get(1).getSchoolName().equals("HOFSTRA"));
	}

	@Test
	public void testShowUniversityDetails() {
		ArrayList<String> univDetails = univC.showUniversityDetails(u);
		assertTrue("School name should be ADELPHI, was " + univDetails.get(0), univDetails.get(0).equals("ADELPHI"));
	}

	@Test
	public void testEditSchool_SuccessfulState() {

		univC.editSchool("ADELPHI", "CALIFORNIA", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2,
				2, al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected California got " + u.getState(), u.getState().equals("CALIFORNIA"));
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulState() {
		univC.editSchool("ADELPHI", "NOTASTATE", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulLocation() {
		univC.editSchool("ADELPHI", "NEW YORK", "URBAN", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2,
				2, al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected Urban got " + u.getLocation(), u.getLocation().equals("URBAN"));
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulLocation() {
		univC.editSchool("ADELPHI", "NEW YORK", "NOTALOCATION", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40,
				2, 2, 2, al2);
	}

	@Test
	public void testEditSchool_SuccessfulControl() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "STATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected State got " + u.getControl(), u.getControl().equals("STATE"));
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulControl() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "NOTACONTROL", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2,
				2, al2);
	}

	@Test
	public void testEditSchool_SuccessfulNumStudents() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 20000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 20000 got " + u.getNumOfStudents(), u.getNumOfStudents() == 20000);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulNumStudents() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", -500, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulPerFem() {
		ArrayList<String> al2 = new ArrayList<String>();
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 50, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 50 got " + u.getPerFem(), u.getPerFem() == 50);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulPerFem() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, -20, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulSatVerbal() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 600, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 600 got " + u.getSatVerbal(), u.getSatVerbal() == 600);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulSatVerbal() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, -500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulSatMath() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 675, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 675 got " + u.getSatMath(), u.getSatMath() == 675);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulSatMath() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 2, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulExpences() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 17437, 60, 5500, 70, 40, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 17437 got " + u.getExpenses(), u.getExpenses() == 17437);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulExpences() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, -10000, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulFinancialAid() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 20, 5500, 70, 40, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 20 got " + u.getFinancialAid(), u.getFinancialAid() == 20);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulFinancialAid() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, -10, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulNumOfApps() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 7500, 70, 40, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 7500 got " + u.getNumOfApps(), u.getNumOfApps() == 7500);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulNumOfApps() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, -5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulPerAdmitted() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 40, 40, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 40 got " + u.getPerAdmitted(), u.getPerAdmitted() == 40);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulPerAdmitted() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, -70, 40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulPerEnrolled() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 40, 60, 2, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 60 got " + u.getPerEnrolled(), u.getPerEnrolled() == 60);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulPerEnrolled() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, -40, 2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulAcademicScale() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 4, 2, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 4 got " + u.getAcademicScale(), u.getAcademicScale() == 4);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulAcademicScale() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, -2, 2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulSocialScale() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 4, 2,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 4 got " + u.getSocialScale(), u.getSocialScale() == 4);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulSocialScale() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, -2, 2,
				al2);
	}

	@Test
	public void testEditSchool_SuccessfulQualOfLife() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 4,
				al2);

		allUnivs = dbCon.loadUniversities();

		for (University i : allUnivs) {
			if (i.getSchoolName().equals("ADELPHI")) {
				u = i;
			}
		}

		assertTrue("expected 4 got " + u.getQualOfLife(), u.getQualOfLife() == 4);
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2,
				al2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchool_UnsuccessfulQualOFLife() {
		univC.editSchool("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, -2,
				al2);

	}

	@Test
	public void testViewUniversities() {
		ArrayList<University> allUnivs2 = univC.viewUniversities();
		assertTrue("expected ADELPHI got " + allUnivs2.get(2).getSchoolName(),
				(allUnivs2.get(2).getSchoolName()).equals(allUnivs.get(2).getSchoolName()));
	}

	@Test
	public void testAddUniversity() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		University test = new University("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50,
				80, 3, 3, 3, emp, 0, 0, 0);
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3,
				emp);
		for (University i : univC.viewUniversities()) {
			if (i.getSchoolName().equals("TEST1")) {
				assertTrue("school added", i.getSchoolName().equals("TEST1"));
			}
		}
		univC.removeUniversity(test);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidState() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "NOTASTATE", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3,
				3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidLocation() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "NOTALOCATION", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80,
				3, 3, 3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidControl() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "NOTACONTROL", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3,
				3, 3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidNumOfStudents() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", -50, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3,
				emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidPerFem() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 150, -1, -1, 16403, 20, 5500, 50, 80, 3, 3,
				3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidSATVerbal() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -50, -1, 16403, 20, 5500, 50, 80, 3, 3,
				3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidSATMath() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -50, 16403, 20, 5500, 50, 80, 3, 3,
				3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidExpenses() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, -50, 20, 5500, 50, 80, 3, 3, 3,
				emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidFinancialAid() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, -50, 5500, 50, 80, 3, 3,
				3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidNumOfApps() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, -50, 50, 80, 3, 3, 3,
				emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidPerAdmitted() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 150, 80, 3, 3,
				3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidPerEnrolled() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 150, 3, 3,
				3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidAcademicScale() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, -50, 3,
				3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidSocialScale() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, -50,
				3, emp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversity_InvalidQualOfLife() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3,
				-50, emp);
	}

	@Test
	public void testRemoveUniversity() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		University test = new University("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50,
				80, 3, 3, 3, emp, 0, 0, 0);
		univC.addUniversity("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3,
				emp);
		for (University i : univC.viewUniversities()) {
			if (i.getSchoolName().equals("TEST1")) {
				assertTrue("school added", i.getSchoolName().equals("TEST1"));
			}
		}
		univC.removeUniversity(test);
		for (University i : univC.viewUniversities()) {
			if (i.getSchoolName().equals("TEST1")) {
				assertFalse("school found!", i.getSchoolName().equals("TEST1"));
			}
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveSchool_SchoolDoesNotExist() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		University test = new University("TEST1", "FOREIGN", "URBAN", "PRIVATE", 10000, 40, -1, -1, 16403, 20, 5500, 50,
				80, 3, 3, 3, emp, 0, 0, 0);
		univC.removeUniversity(test);
	}

	@Test
	public void testRandomSchool() {
		University rand = univC.randomSchool();
		ArrayList<University> temp = dbCon.loadUniversities();
		for (University i : temp) {
			if (i.equals(rand)) {
				assertTrue(i.getSchoolName() + " = " + rand.getSchoolName(),
						i.getSchoolName().equals(rand.getSchoolName()));
			}
		}

	}

	@Test
	public void testSetSchoolOfTheWeek() {
		String expected = u.getSchoolName();
		univC.setSchoolOfTheWeek(expected);
		assertTrue("Expected Adelphi got " + univC.getSchoolOfTheWeek().getSchoolName(),
				univC.getSchoolOfTheWeek().getSchoolName().equals(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetSchoolOfTheWeek_InvalidName() {
		String expected = "NotASchool";
		univC.setSchoolOfTheWeek(expected);
	}

	@Test
	public void testGetSchoolOfTheWeek() {
		String expected = u.getSchoolName();
		univC.setSchoolOfTheWeek(expected);

		assertTrue("expected Adelphi got " + univC.getSchoolOfTheWeek().getSchoolName(),
				univC.getSchoolOfTheWeek().getSchoolName().equals(u.getSchoolName()));
	}

	@Test
	public void testViewHistory() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.searchSchools("ADELPHI", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, emp);
		univC.searchSchools("TUFTS", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, emp);
		univC.searchSchools("GOTHENBURG UNIVERSITY", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		assertTrue("Expected TUFTS, was" + univC.viewHistory().get(1).getSchoolName(),
				(univC.viewHistory().get(1).getSchoolName()).equals("TUFTS"));
	}

	@Test
	public void testClearHistory() {
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.searchSchools("ADELPHI", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, emp);
		univC.searchSchools("TUFTS", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, emp);
		univC.searchSchools("GOTHENBURG UNIVERSITY", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		assertTrue("Expected TUFTS, was" + univC.viewHistory().get(1).getSchoolName(),
				(univC.viewHistory().get(1).getSchoolName()).equals("TUFTS"));

		univC.clearHistory();

		assertTrue("Expected isEmpty, was" + univC.viewHistory(), (univC.viewHistory().isEmpty()));
	}

	@Test
	public void testSuperRecommend() {
		ArrayList<University> r = univC.superRecommend(u);
		assertTrue("Top Recomended, results should be HOFSTRA, was " + r.get(1).getSchoolName(),
				r.get(1).getSchoolName().equals("HOFSTRA"));
	}

}
