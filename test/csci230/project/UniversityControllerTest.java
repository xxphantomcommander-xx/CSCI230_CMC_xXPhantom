//yup
package csci230.project;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import org.junit.Before;


public class UniversityControllerTest {
	UniversityController univC;
	DBController dbCon;
	
	
	@Before
	  public void setUp() throws Exception {
		univC = new UniversityController();
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
		AssertTrue("Expected output null got" + result.get(0), result.get(0) == null);
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
		ArrayList<University> allUnivs = new ArrayList<University>();
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
				AssertTrue("Expected output Worchester got" + i.getSchoolName(), "WORCHESTER".equals(i.getSchoolName());
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
		ArrayList<University> allUnivs = new ArrayList<University>();
		ArrayList<University> example = new ArrayList<University>();
		example.add(new University("WORCHESTER", "MASSACHUSETTS", "URBAN","PRIVATE", 10000, 20, 550, 650, 30973, 70, 4000, 50, 50, 4, 3, 4, emp1, 0, 0, 0));
		example.add(new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40, 11500, 20, 60, 5, 3, 4, emp2, 0, 0, 0));
		example.add(new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400, 15736, 95, 4000, 95, 90, 1, 2, 2, emp3, 0, 0, 0));
		example.add(new University("ZACH2", "MINNESOTA", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, emp4, 0, 0, 0));
		
		ArrayList<University> result = univC.searchBySchool(example, "ZACH2");

		AssertTrue("Expected output null got" + result.get(0), result.get(0) == null);


		
	}
	
	@Test
	public void testSearchBySchool_InvalidName() {
		
	}

	@Test
	public void testTopRecommended() {
		fail("Not yet implemented");
	}

	@Test
	public void testTopRecommended2() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowUniversityDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewUniversities() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testGetSchoolOfTheWeek() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewHistory() {
		fail("Not yet implemented");
	}

	@Test
	public void testClearHistory() {
		fail("Not yet implemented");
	}

	@Test
	public void testSuperRecommend() {
		fail("Not yet implemented");
	}

}
