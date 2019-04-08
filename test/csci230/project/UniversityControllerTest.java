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

	@Test
	public void testSearchSchools() {
		ArrayList<String> emp = new ArrayList<String>();
		ArrayList<University> results = univC.searchSchools("", "California","Urban", "", -1, -1, -1, -1, 500, 650, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emp);
		for (University i: results){
			
		}
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
		fail("Not yet implemented");
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
