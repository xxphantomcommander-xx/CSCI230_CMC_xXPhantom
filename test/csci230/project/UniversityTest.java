/**
 * 
 */
package csci230.project;

import java.util.ArrayList;

/**
 * @author zheinen001
 *
 */
public class UniversityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*********** University Test **************\n");
		
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("Computer Science");
		emp.add("BIology");
		emp.add("");
		emp.add("");
		emp.add("");
		University zach3 = new University("Zach3", "NEW YORK", "Small-city", "Private", 43234, 80, 600, 550, 45000, 70, 11000, 65, 90, 5, 5, 5, emp, 0, 0, 0);
		System.out.println("University Zach3 created");
		System.out.println();
		
		System.out.println("get SchoolName. Expected output: ZACH3");
		System.out.println(zach3.getSchoolName());
		System.out.println();
		
		System.out.println("get State. Expected output: NEW YORK");
		System.out.println(zach3.getState());
		System.out.println();
		
		System.out.println("get Location. Expected output: SMALL-CITY");
		System.out.println(zach3.getLocation());
		System.out.println();
		
		System.out.println("get Control. Expected output: PRIVATE");
		System.out.println(zach3.getControl());
		System.out.println();
		
		System.out.println("get Number of Students. Expected output: 43234");
		System.out.println(zach3.getNumOfStudents());
		System.out.println();
		
		System.out.println("get Percent Female. Expected output: 80");
		System.out.println(zach3.getPerFem());
		System.out.println();
		
		System.out.println("get SAT Verbal. Expected output: 600");
		System.out.println(zach3.getSatVerbal());
		System.out.println();
		
		System.out.println("get SAT Math. Expected output: 550");
		System.out.println(zach3.getSatMath());
		System.out.println();
		
		System.out.println("get Expenses. Expected output: 45000");
		System.out.println(zach3.getExpenses());
		System.out.println();
		
		System.out.println("get Percent Financial Aid. Expected output: 70");
		System.out.println(zach3.getFinancialAid());
		System.out.println();
		
		System.out.println("get Number of Applicants. Expected output: 11000");
		System.out.println(zach3.getNumOfApps());
		System.out.println();
		
		System.out.println("get Percent Admitted. Expected output: 65");
		System.out.println(zach3.getPerAdmitted());
		System.out.println();
		
		System.out.println("get Percent Enrolled. Expected output: 90");
		System.out.println(zach3.getPerEnrolled());
		System.out.println();
		
		System.out.println("get Social Scale. Expected output: 5");
		System.out.println(zach3.getSocialScale());
		System.out.println();
		
		System.out.println("get Academic Scale. Expected output: 5");
		System.out.println(zach3.getAcademicScale());
		System.out.println();
		
		System.out.println("get Quality of Life Scale. Expected output: 5");
		System.out.println(zach3.getQualOfLife());
		System.out.println();
		
		System.out.println("get Percent Female. Expected output: COMPUTER SCIENCE BIOLOGY");
		for(String i:zach3.getEmp()) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("get Count. Expected output: 0");
		System.out.println(zach3.getCount());
		System.out.println();
		
		System.out.println("get Distance. Expected output: 0.0");
		System.out.println(zach3.getDistance());
		System.out.println();
		
		System.out.println("get Sup. Expected output: 0.0");
		System.out.println(zach3.getSup());
		System.out.println();
		
		System.out.println("**************** Testing Setters *********************\n\n");
		
		System.out.println("set SchoolName. Expected output: TEST");
		zach3.setSchoolName("test");
		System.out.println(zach3.getSchoolName());
		System.out.println();
		
		System.out.println("set State. Expected output: FLORIDA");
		zach3.setState("florida");
		System.out.println(zach3.getState());
		System.out.println();
		
		System.out.println("set Location. Expected output: URBAN");
		zach3.setLocation("Urban");
		System.out.println(zach3.getLocation());
		System.out.println();
		
		System.out.println("set Control. Expected output: PUBLIC");
		zach3.setContol("pulbic");
		System.out.println(zach3.getControl());
		System.out.println();
		
		System.out.println("set Number of Students. Expected output: 10000");
		zach3.setNumOfStudents(10000);
		System.out.println(zach3.getNumOfStudents());
		System.out.println();
		
		System.out.println("set Percent Female. Expected output: 50");
		zach3.setPerFem(50);
		System.out.println(zach3.getPerFem());
		System.out.println();
		
		System.out.println("set SAT Verbal. Expected output: 550");
		zach3.setSatVerbal(550);
		System.out.println(zach3.getSatVerbal());
		System.out.println();
		
		System.out.println("set SAT Math. Expected output: 600");
		zach3.setSatMath(600);
		System.out.println(zach3.getSatMath());
		System.out.println();
		
		System.out.println("set Expenses. Expected output: 20000");
		zach3.setExpenses(20000);
		System.out.println(zach3.getExpenses());
		System.out.println();
		
		System.out.println("set Percent Financial Aid. Expected output: 50");
		zach3.setFinancialAid(50);
		System.out.println(zach3.getFinancialAid());
		System.out.println();
		
		System.out.println("set Number of Applicants. Expected output: 6000");
		zach3.setNumOfApps(6000);
		System.out.println(zach3.getNumOfApps());
		System.out.println();
		
		System.out.println("set Percent Admitted. Expected output: 80");
		zach3.setPerAdmitted(80);
		System.out.println(zach3.getPerAdmitted());
		System.out.println();
		
		System.out.println("set Percent Enrolled. Expected output: 60");
		zach3.setPerEnrolled(60);
		System.out.println(zach3.getPerEnrolled());
		System.out.println();
		
		System.out.println("set Social Scale. Expected output: 3");
		zach3.setSocialScale(3);
		System.out.println(zach3.getSocialScale());
		System.out.println();
		
		System.out.println("set Academic Scale. Expected output: 3");
		zach3.setAcademicScale(3);
		System.out.println(zach3.getAcademicScale());
		System.out.println();
		
		System.out.println("set Quality of Life Scale. Expected output: 3");
		zach3.setQualOfLife(3);
		System.out.println(zach3.getQualOfLife());
		System.out.println();
		
		System.out.println("set Percent Female. Expected output: THEOLOGY ENGINEERING");
		ArrayList<String> newEmp = new ArrayList<String>();
		newEmp.add("THEOLOGY");
		newEmp.add("ENGINEERING");
		newEmp.add("");
		newEmp.add("");
		newEmp.add("");
		zach3.setEmphasis(newEmp);
		for(String i:zach3.getEmp()) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("set Count. Expected output: 5");
		zach3.setCount(5);
		System.out.println(zach3.getCount());
		System.out.println();
		
		System.out.println("set Distance. Expected output: 5.5");
		zach3.setDistance(5.5);
		System.out.println(zach3.getDistance());
		System.out.println();
		
		System.out.println("set Sup. Expected output: 19.56");
		zach3.setSup(19.56);
		System.out.println(zach3.getSup());
		System.out.println();
	}

}
