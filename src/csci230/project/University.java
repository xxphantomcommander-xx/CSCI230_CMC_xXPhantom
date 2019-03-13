package csci230.project;

import java.util.ArrayList;

/**
 * This class contains all the info about Universities
 * @author zheinen001
 * @version 3/10/19
 */
public class University {
	//name of University
	String schoolName;
	//State of University
	String state;
	//Location of school(urban or rural)
	String location;
	// number of students in the university
	String control;
	// private vs city/state
	int numOfStudents;
	// percent female
	int perFem;
	// sat score for verbal
	int satVerbal;
	// sat score for math
	int satMath;
	// how much does this university cost
	int expenses;
	// Financial aid offered by the university
	int financialAid;
	// number of applicants to this university
	int numOfApps;
	// percent admitted to this university
	int perAdmitted;
	// percent of admitted that actually enrolled
	int perEnrolled;
	// academic scale of this university 0-10
	int academicScale;
	// social scale of this university 0-10
	int socialScale;
	// quality of life scale of this university 0-10
	int qualOfLife;
	// the emphasises of the University
	ArrayList<String> emphasis;
	// the recommend count of the University
	int count;
	/**
	 * creates a University
	 * @param schoolName
	 * @param state
	 * @param location
	 * @param control
	 * @param numOfStudents
	 * @param perFem
	 * @param satVerbal
	 * @param satMath
	 * @param expenses
	 * @param financialAid
	 * @param numOfApps
	 * @param perAdmitted
	 * @param perEnrolled
	 * @param academicScale
	 * @param socialScale
	 * @param qualOfLife
	 * @param count
	 */
	public University(String schoolName, String state, String location, String control, 
			int numOfStudents, int perFem, int satVerbal, int satMath,
			int expenses, int financialAid, int numOfApps, int perAdmitted, 
			int perEnrolled, int academicScale, int socialScale, 
			int qualOfLife, ArrayList<String> emphasis, int count) {
		this.schoolName = schoolName;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numOfStudents = numOfStudents;
		this.perFem = perFem;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.expenses = expenses;
		this.financialAid = financialAid;
		this.numOfApps = numOfApps;
		this.perAdmitted = perAdmitted;
		this.perEnrolled = perEnrolled;
		this.academicScale = academicScale;
		this.socialScale = socialScale;
		this.qualOfLife = qualOfLife;
		this.emphasis = emphasis;
		this.count = count;
	}
	
	/**
	 * gets school name
	 * @return school name
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * sets school name
	 * @param schoolName
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * gets state
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * set state
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * gets location
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * sets location
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * gets control
	 * @return control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * sets control
	 * @param control
	 */
	public void setContol(String control) {
		this.control = control;
	}

	/**
	 *  gets the number of students in the university
	 * @return number of students
	 */
	public int getNumOfStudents() {
		return numOfStudents;
	}

	/**
	 * sets the number of students in the university
	 * @param numOfStudents
	 */
	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	/**
	 * gets the percent female
	 * @return percent female
	 */
	public int getPerFem() {
		return perFem;
	}

	/**
	 * sets the percent female
	 * @param perFem
	 */
	public void setPerFem(int perFem) {
		this.perFem = perFem;
	}

	/**
	 * gets the SATVerbal
	 * @return SATVerbal
	 */
	public int getSatVerbal() {
		return satVerbal;
	}

	/**
	 * set the SATVerbal
	 * @param satVerbal
	 */
	public void setSatVerbal(int satVerbal) {
		this.satVerbal = satVerbal;
	}

	/**
	 * gets the SATMath
	 * @return SATMath
	 */
	public int getSatMath() {
		return satMath;
	}

	/**
	 * sets the SAT math
	 * @param satMath
	 */
	public void setSatMath(int satMath) {
		this.satMath = satMath;
	}

	/**
	 * gets the expenses
	 * @return expenses
	 */
	public int getExpenses() {
		return expenses;
	}

	/**
	 * sets the expenses of this university
	 * @param expenses
	 */
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}

	/**
	 * gets the Financial Aid
	 * @return Financial Aid
	 */
	public int getFinancialAid() {
		return financialAid;
	}

	/**
	 * sets the financial aid
	 * @param financialAid
	 */
	public void setFinancialAid(int financialAid) {
		this.financialAid = financialAid;
	}

	/**
	 * gets the number of applicants
	 * @return number of applicants
	 */
	public int getNumOfApps() {
		return numOfApps;
	}

	/**
	 * sets the number of applicants
	 * @param numOfApps
	 */
	public void setNumOfApps(int numOfApps) {
		this.numOfApps = numOfApps;
	}

	/**
	 * gets the percent admitted
	 * @return percent admitted
	 */
	public int getPerAdmitted() {
		return perAdmitted;
	}

	/**
	 * sets the percent admitted
	 * @param perAdmitted
	 */
	public void setPerAdmitted(int perAdmitted) {
		this.perAdmitted = perAdmitted;
	}

	/**
	 * gets the percent enrolled
	 * @return percent enrolled
	 */
	public int getPerEnrolled() {
		return perEnrolled;
	}

	/**
	 * sets the percent enrolled
	 * @param perEnrolled
	 */
	public void setPerEnrolled(int perEnrolled) {
		this.perEnrolled = perEnrolled;
	}

	/**
	 * gets the academic scale
	 * @return academic scale 1-10
	 */
	public int getAcademicScale() {
		return academicScale;
	}

	/**
	 * sets the academic scale
	 * @param academicScale
	 */
	public void setAcademicScale(int academicScale) {
		this.academicScale = academicScale;
	}

	/**
	 * gets the social scale 1-10
	 * @return social scale
	 */
	public int getSocialScale() {
		return socialScale;
	}

	/**
	 * sets the social scale
	 * @param socialScale
	 */
	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}

	/**
	 * gets the quality of life scale 1-10
	 * @return quality of life
	 */
	public int getQualOfLife() {
		return qualOfLife;
	}

	/**
	 * sets the quality of life
	 * @param qualOfLife
	 */
	public void setQualOfLife(int qualOfLife) {
		this.qualOfLife = qualOfLife;
	}
	
	
	/**
	 * gets emphases
	 * @return ArrayList<String> of emphases
	 */
	public ArrayList<String> getEmp(){
		return emphasis;
	}
	
	
	/**
	 * adds emphasis
	 * @param newEmp new emphasis
	 */
	public void setEmphasis(ArrayList<String> newEmp) {
		this.emphasis = newEmp;
	}
	
	/**
	 * gets emphases
	 * @return ArrayList<String> of emphases
	 */
	public int getCount(){
		return count;
	}
	
	
	/**
	 * adds emphasis
	 * @param newEmp new emphasis
	 */
	public void setCount(int newCount) {
		this.count = newCount;
	}

}
