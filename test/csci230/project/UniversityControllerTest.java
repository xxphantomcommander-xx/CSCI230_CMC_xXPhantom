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
		University i = new University("test", "foreign")
		univC.addUniversity(school, state, location, control, numStudents, perFem, satVerbal, satMath, expenses, financialAid, numOfApps, perAdmitted, perEnrolled, academicScale, socialScale, qualOfLife, emphasis);
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
