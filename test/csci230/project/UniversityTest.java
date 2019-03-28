//
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
public class UniversityTest {
	University u;
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al3 = new ArrayList<String>();
	ArrayList<String> al2 = new ArrayList<String>();

	
	  @Before
	  public void setUp() throws Exception {
			al2.add("BIOLOGY");
			al2.add("BUSINESS-ADMINISTRATION");
			al2.add("");
			al2.add("");
			al2.add("");
			al.add("BIOLOGY");
			al.add("");
			al.add("");
			al.add("");
			al.add("");
			al3.add("BIOLOGY");
			al3.add("CHEMISTRY");
			al3.add("");
			al3.add("");
			al3.add("");
	   u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
	  }
	/**
	 * Test method for {@link csci230.project.University#University(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, int, int, int, int, int, int, int, int, java.util.ArrayList, int, int, double)}.
	 */
	@Test
	public void testUniversity() {

   University u2 = new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 425, 30000, 40, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
   assertTrue(u2.getSchoolName().equals("UNIVERSITY"));
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidState(){
		 new University("UNIVERSITY", "STATE", "URBAN", "STATE", 10000, 60, 400, 425, 30000, 40, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidLocation(){
		 new University("UNIVERSITY", "MINNESOTA", "KEITHURBAN", "STATE", 10000, 60, 400, 425, 30000, 40, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidControl(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "CONTROL", 10000, 60, 400, 425, 30000, 40, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidNumOfStudents(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", -20, 60, 400, 425, 30000, 40, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidPerFem(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, -60, 400, 425, 30000, 40, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidSatVerbal(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 100, 425, 30000, 40, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidSatMath(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 125, 30000, 40, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidExpenses(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 425, -30000, 40, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidFinancailAid(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 425, 30000, 110, 5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidNumOfApps(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 425, 30000, 40, -5000, 60, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidPerAdmitted(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 425, 30000, 40, 5000, 160, 50, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidPerEnrolled(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 425, 30000, 40, 5000, 60, 150, 3, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidAcadmeicScale(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 425, 30000, 40, 5000, 60, 50, 6, 4, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidSocialScale(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 425, 30000, 40, 5000, 60, 50, 3, 6, 3, al, 0, 0, 0);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUniversity_InvalidQualOfLife(){
		 new University("UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 60, 400, 425, 30000, 40, 5000, 60, 50, 3, 4, 6, al, 0, 0, 0);
	 }
	 

	/**
	 * Test method for {@link csci230.project.University#getSchoolName()}.
	 */
	@Test
	public void testGetSchoolName() {
		assertTrue("getSchoolName() expected ADELPHI got " + u.getSchoolName(), u.getSchoolName().equals("ADELPHI"));
	}

	/**
	 * Test method for {@link csci230.project.University#setSchoolName(java.lang.String)}.
	 */
	@Test
	public void testSetSchoolName() {
		String expected = "COLLEGE";
		u.setSchoolName("COLLEGE");
		assertTrue("setSchoolName() expected COLLEGE got " + u.getSchoolName(), u.getSchoolName().equals(expected));
	}

	/**
	 * Test method for {@link csci230.project.University#getState()}.
	 */
	@Test
	public void testGetState() {
		assertTrue("getState() expected NEW YORK got " + u.getState(), u.getState().equals("NEW YORK"));
	}

	/**
	 * Test method for {@link csci230.project.University#setState(java.lang.String)}.
	 */
	@Test
	public void testSetState() {
		String expected = "WISCONSIN";
		u.setState("WISCONSIN");
		assertTrue("setState() expected WISCONSIN got " + u.getState(), u.getState().equals(expected));
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetState_InvalidState(){
		 u.setState("STATE");
	 }
	

	/**
	 * Test method for {@link csci230.project.University#getLocation()}.
	 */
	@Test
	public void testGetLocation() {
		assertTrue("getLocation() expected -1 got " + u.getLocation(), u.getLocation().equals("-1"));
	}

	/**
	 * Test method for {@link csci230.project.University#setLocation(java.lang.String)}.
	 */
	@Test
	public void testSetLocation() {
		String expected = "SUBURBAN";
		u.setLocation("SUBURBAN");
		assertTrue("setLocation() expected SUBURBAN got " + u.getLocation(), u.getLocation().equals(expected));
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetLocation_InvalidLocation(){
		 u.setLocation("KEITHURBAN");
	 }

	/**
	 * Test method for {@link csci230.project.University#getControl()}.
	 */
	@Test
	public void testGetControl() {
		assertTrue("getContol() expected PRIVATE got " + u.getControl(), u.getControl().equals("PRIVATE"));
	}

	/**
	 * Test method for {@link csci230.project.University#setContol(java.lang.String)}.
	 */
	@Test
	public void testSetControl() {
		String expected = "STATE";
		u.setControl("STATE");
		assertTrue("setControl() expected STATE got " + u.getControl(), u.getControl().equals(expected));
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetControl_InvalidControl(){
		 u.setControl("FEDERAL");
	 }

	/**
	 * Test method for {@link csci230.project.University#getNumOfStudents()}.
	 */
	@Test
	public void testGetNumOfStudents() {
		assertTrue("getNumOfStudents() expected 15000 got " + u.getNumOfStudents(), u.getNumOfStudents() == 15000);
	}

	/**
	 * Test method for {@link csci230.project.University#setNumOfStudents(int)}.
	 */
	@Test
	public void testSetNumOfStudents() {
		int expected = 10000;
		u.setNumOfStudents(10000);
		assertTrue("setNumOfStudents() expected 10000 got " + u.getNumOfStudents(), u.getNumOfStudents() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetNumOfStudents_InvalidNumOfStudents(){
		 u.setNumOfStudents(-10);
	 }

	/**
	 * Test method for {@link csci230.project.University#getPerFem()}.
	 */
	@Test
	public void testGetPerFem() {
		assertTrue("getPerFem() expected 70 got " + u.getPerFem(), u.getPerFem() == 70);
	}

	/**
	 * Test method for {@link csci230.project.University#setPerFem(int)}.
	 */
	@Test
	public void testSetPerFem() {
		int expected = 50;
		u.setPerFem(50);
		assertTrue("setPerFem() expected 50 got " + u.getPerFem(), u.getPerFem() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetPerFem_InvalidPerFem(){
		 u.setPerFem(110);
	 }

	/**
	 * Test method for {@link csci230.project.University#getSatVerbal()}.
	 */
	@Test
	public void testGetSatVerbal() {
		assertTrue("getSatVerbal() expected 500 got " + u.getSatVerbal(), u.getSatVerbal() == 500);
	}

	/**
	 * Test method for {@link csci230.project.University#setSatVerbal(int)}.
	 */
	@Test
	public void testSetSatVerbal() {
		int expected = 450;
		u.setSatVerbal(450);
		assertTrue("setSatVerbal() expected 450 got " + u.getSatVerbal(), u.getSatVerbal() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetSatVerbal_InvalidSatVerbal(){
		 u.setSatVerbal(1000);
	 }

	/**
	 * Test method for {@link csci230.project.University#getSatMath()}.
	 */
	@Test
	public void testGetSatMath() {
		assertTrue("getSatMath() expected 475 got " + u.getSatMath(), u.getSatMath() == 475);
	}

	/**
	 * Test method for {@link csci230.project.University#setSatMath(int)}.
	 */
	@Test
	public void testSetSatMath() {
		int expected = 450;
		u.setSatMath(450);
		assertTrue("setSatMath() expected 450 got " + u.getSatMath(), u.getSatMath() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetSatMath_InvalidSatMath(){
		 u.setSatMath(1000);
	 }

	/**
	 * Test method for {@link csci230.project.University#getExpenses()}.
	 */
	@Test
	public void testGetExpenses() {
		assertTrue("getExpenses() expected 37437 got " + u.getExpenses(), u.getExpenses() == 37437);
	}

	/**
	 * Test method for {@link csci230.project.University#setExpenses(int)}.
	 */
	@Test
	public void testSetExpenses() {
		int expected = 25000;
		u.setExpenses(25000);
		assertTrue("setExpenses() expected 25000 got " + u.getExpenses(), u.getExpenses() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetExpenses_InvalidExpenses(){
		 u.setExpenses(-1000);
	 }

	/**
	 * Test method for {@link csci230.project.University#getFinancialAid()}.
	 */
	@Test
	public void testGetFinancialAid() {
		assertTrue("getFinancialAid() expected 60 got " + u.getFinancialAid(), u.getFinancialAid() == 60);
	}

	/**
	 * Test method for {@link csci230.project.University#setFinancialAid(int)}.
	 */
	@Test
	public void testSetFinancialAid() {
		int expected = 50;
		u.setFinancialAid(50);
		assertTrue("setFinancialAid() expected 50 got " + u.getFinancialAid(), u.getFinancialAid() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetFinancialAid_InvalidFinancialAid(){
		 u.setFinancialAid(120);
	 }

	/**
	 * Test method for {@link csci230.project.University#getNumOfApps()}.
	 */
	@Test
	public void testGetNumOfApps() {
		assertTrue("getNumOfApps() expected 5500 got " + u.getNumOfApps(), u.getNumOfApps() == 5500);
	}

	/**
	 * Test method for {@link csci230.project.University#setNumOfApps(int)}.
	 */
	@Test
	public void testSetNumOfApps() {
		int expected = 6000;
		u.setNumOfApps(6000);
		assertTrue("setNumOfApps() expected 6000 got " + u.getNumOfApps(), u.getNumOfApps() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetNumOfApps_InvalidNumOfApps(){
		 u.setNumOfApps(-10);
	 }

	/**
	 * Test method for {@link csci230.project.University#getPerAdmitted()}.
	 */
	@Test
	public void testGetPerAdmitted() {
		assertTrue("getPerAdmitted() expected 70 got " + u.getPerAdmitted(), u.getPerAdmitted() == 70);
	}

	/**
	 * Test method for {@link csci230.project.University#setPerAdmitted(int)}.
	 */
	@Test
	public void testSetPerAdmitted() {
		int expected = 50;
		u.setPerAdmitted(50);
		assertTrue("setPerAdmitted() expected 50 got " + u.getPerAdmitted(), u.getPerAdmitted() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetPerAdmitted_InvalidPerAdmitted(){
		 u.setPerAdmitted(130);
	 }

	/**
	 * Test method for {@link csci230.project.University#getPerEnrolled()}.
	 */
	@Test
	public void testGetPerEnrolled() {
		assertTrue("getPerEnrolled() expected 40 got " + u.getPerEnrolled(), u.getPerEnrolled() == 40);
	}

	/**
	 * Test method for {@link csci230.project.University#setPerEnrolled(int)}.
	 */
	@Test
	public void testSetPerEnrolled() {
		int expected = 60;
		u.setPerEnrolled(60);
		assertTrue("setPerEnrolled() expected 60 got " + u.getPerEnrolled(), u.getPerEnrolled() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetPErEnrolled_InvalidPerEnrolled(){
		 u.setPerEnrolled(105);
	 }

	/**
	 * Test method for {@link csci230.project.University#getAcademicScale()}.
	 */
	@Test
	public void testGetAcademicScale() {
		assertTrue("getAcademicScale() expected 2 got " + u.getAcademicScale(), u.getAcademicScale() == 2);
	}

	/**
	 * Test method for {@link csci230.project.University#setAcademicScale(int)}.
	 */
	@Test
	public void testSetAcademicScale() {
		int expected = 4;
		u.setAcademicScale(4);
		assertTrue("setAcademicScale() expected 4 got " + u.getAcademicScale(), u.getAcademicScale() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetAcademicScale_InvalidAcademicScale(){
		 u.setAcademicScale(6);
	 }

	/**
	 * Test method for {@link csci230.project.University#getSocialScale()}.
	 */
	@Test
	public void testGetSocialScale() {
		assertTrue("getSocialScale() expected 2 got " + u.getSocialScale(), u.getSocialScale() == 2);
	}

	/**
	 * Test method for {@link csci230.project.University#setSocialScale(int)}.
	 */
	@Test
	public void testSetSocialScale() {
		int expected = 3;
		u.setSocialScale(3);
		assertTrue("setSocialScale() expected 3 got " + u.getSocialScale(), u.getSocialScale() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetSocialScale_InvalidSocialScale(){
		 u.setSocialScale(6);
	 }

	/**
	 * Test method for {@link csci230.project.University#getQualOfLife()}.
	 */
	@Test
	public void testGetQualOfLife() {
		assertTrue("getQualOfLife() expected 2 got " + u.getQualOfLife(), u.getQualOfLife() == 2);
	}

	/**
	 * Test method for {@link csci230.project.University#setQualOfLife(int)}.
	 */
	@Test
	public void testSetQualOfLife() {
		int expected = 4;
		u.setQualOfLife(4);
		assertTrue("setQualOfLife() expected 4 got " + u.getQualOfLife(), u.getQualOfLife() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetQualOfLife_InvalidQualOfLife(){
		 u.setQualOfLife(6);
	 }

	/**
	 * Test method for {@link csci230.project.University#getEmp()}.
	 */
	@Test
	public void testGetEmp() {
		assertTrue("getEmp() expected al2 got " + u.getEmp(), u.getEmp() == al2);
	}

	/**
	 * Test method for {@link csci230.project.University#setEmphasis(java.util.ArrayList)}.
	 */
	@Test
	public void testSetEmphasis() {
		ArrayList<String> expected = al3;
		u.setEmphasis(al3);
		assertTrue("setEmphasis() expected al3 got " + u.getEmp(), u.getEmp() == expected);
	}

	/**
	 * Test method for {@link csci230.project.University#getCount()}.
	 */
	@Test
	public void testGetCount() {
		assertTrue("getCount() expected 0 got " + u.getCount(), u.getCount() == 0);
	}

	/**
	 * Test method for {@link csci230.project.University#setCount(int)}.
	 */
	@Test
	public void testSetCount() {
		int expected = 8;
		u.setCount(8);
		assertTrue("setCount() expected 8 got " + u.getCount(), u.getCount() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetCount_InvalidCount(){
		 u.setCount(-2);
	 }


	/**
	 * Test method for {@link csci230.project.University#getDistance()}.
	 */
	@Test
	public void testGetDistance() {
		assertTrue("getDistance() expected 0 got " + u.getDistance(), u.getDistance() == 0);
	}

	/**
	 * Test method for {@link csci230.project.University#setDistance(double)}.
	 */
	@Test
	public void testSetDistance() {
		double expected = 8.152324;
		u.setDistance(8.152324);
		assertTrue("setCount() expected 8.152324 got " + u.getDistance(), u.getDistance() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetDistance_InvalidDistance(){
		 u.setDistance(-2);
	 }

	/**
	 * Test method for {@link csci230.project.University#getSup()}.
	 */
	@Test
	public void testGetSup() {
		assertTrue("getSup() expected 0 got " + u.getSup(), u.getSup() == 0);
	}

	/**
	 * Test method for {@link csci230.project.University#setSup(double)}.
	 */
	@Test
	public void testSetSup() {
		double expected = 8.152324;
		u.setSup(8.152324);
		assertTrue("setSup() expected 8.152324 got " + u.getSup(), u.getSup() == expected);
	}
	
	 @Test(expected=IllegalArgumentException.class)
	 public void testSetSup_InvalidSup(){
		 u.setSup(-2);
	 }

}
