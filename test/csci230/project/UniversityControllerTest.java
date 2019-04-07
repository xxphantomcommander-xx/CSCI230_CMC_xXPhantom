//yup
package csci230.project;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import org.junit.Before;


public class UniversityControllerTest {
	UniversityController univC;
	
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
		ArrayList<University> results = univC.searchSchools(-1, "California","Urban", -1, -1, -1, -1, -1, 500, 650, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
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
		fail("Not yet implemented");
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
