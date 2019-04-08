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
		
	}

	@Test
	public void testSearchSchools() {
		fail("Not yet implemented");
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
		emp.add("Biology");
		emp.add("Computer Science");
		emp.add("");
		emp.add("");
		emp.add("");
		univC.addUniversity("test", "foreign", "urban", "private", 10000, 40, -1, -1, 16403, 20, 5500, 50, 80, 3, 3, 3, emp);
		for(University i:univC.viewUniversities()) {
			if(i.getSchoolName().equals("TEST")) {
				assertTrue("school added", i.getSchoolName().equals("TEST"));
			}
		}
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
