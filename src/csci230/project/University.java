package csci230.project;

import java.util.ArrayList;

/**
 * This class contains all the info about Universities
 * @author xXPhantomCommander$Xx
 * @version 3/19/19
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
	// the recommend distance of the University
	double distance;
	//the super recommend
	double sup;
	/**
	 * constructor
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
	 * @param sup
	 */
	public University(String schoolName, String state, String location, String control, 
			int numOfStudents, int perFem, int satVerbal, int satMath,
			int expenses, int financialAid, int numOfApps, int perAdmitted, 
			int perEnrolled, int academicScale, int socialScale, 
			int qualOfLife, ArrayList<String> emphasis, int count, int distance, double sup) {
		if (state.equals("ALABAMA") || state.equals("ALASKA") || state.equals("ARIZONA") || state.equals("ARKANSAS") || state.equals("CALIFORNIA") || state.equals("COLORADO") || state.equals("CONNECTICUT") || state.equals("DELAWARE") || state.equals("FLORIDA") || state.equals("GEORGIA") || state.equals("HAWAII") || state.equals("IDAHO") || state.equals("ILLINOIS") || state.equals("INDIANA") || state.equals("IOWA") || state.equals("KANSAS") || state.equals("KENTUCKY") || state.equals("LOUISIANA") || state.equals("MAINE") || state.equals("MARYLAND") || state.equals("MASSACHUSETTS") || state.equals("MICHIGAN") || state.equals("MINNESOTA") || state.equals("MISSISSIPPI") || state.equals("MISSOURI") || state.equals("MONTANA") || state.equals("NEBRASKA") || state.equals("NEVADA") || state.equals("NEW HAMPSHIRE") || state.equals("NEW JERSEY") || state.equals("NEW MEXICO") || state.equals("NEW YORK") || state.equals("NORTH CAROLINA") || state.equals("NORTH DAKOTA") || state.equals("OHIO") || state.equals("OKLAHOMA") || state.equals("OREGON") || state.equals("PENNSYLVANIA") || state.equals("RHODEISLAND") || state.equals("RHODE ISLAND") || state.equals("SOUTH CAROLINA") || state.equals("SOUTH DAKOTA") || state.equals("TENNESSEE") || state.equals("TEXAS") || state.equals("UTAH") || state.equals("VERMONT") || state.equals("VIRGINIA") || state.equals("WASHINGTON") || state.equals("WEST VIRGINIA") || state.equals("WISCONSIN") || state.equals("WYOMING") || state.equals("FOREIGN") || state.equals("DISTRICT OF COLUMBIA")){
			if(location.equals("-1") || location.equals("SMALL-CITY") || location.equals("SUBURBAN") || location.equals("URBAN")) {
				if(control.equals("CITY") || control.equals("PRIVATE") || control.equals("STATE")) {
					if(0 < numOfStudents || numOfStudents == -1) {
						if(0 <= perFem && perFem <= 100 || perFem == -1) {
							if(200 <= satVerbal && satVerbal <= 800 || satVerbal == -1) {
								if(200 <= satMath && satMath <= 800 || satMath == -1) {
									if(expenses == -1 || expenses >= 0) {
										if(financialAid == -1 || financialAid >= 0 && financialAid <= 100) {
											if(numOfApps == -1 || numOfApps >= 0) {
												if(0 <= perAdmitted && perAdmitted <= 100 || perAdmitted == -1) {
													if(0 <= perEnrolled && perEnrolled <= 100 || perEnrolled == -1) {
														if(0 <= academicScale && academicScale <= 5 || academicScale == -1) {
															if(0 <= socialScale && socialScale <= 5 || socialScale == -1) {
																if(0 <= qualOfLife && qualOfLife <= 5 || qualOfLife == -1) {
																	this.schoolName = schoolName.toUpperCase();
																	this.state = state.toUpperCase();
																	this.location = location.toUpperCase();
																	this.control = control.toUpperCase();
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
																	for(int i = 0; i < emphasis.size(); i++) {
																		emphasis.set(i, emphasis.get(i).toUpperCase());
																	}
																	this.emphasis = emphasis;
																	this.count = count;
																	this.distance = distance;
																	this.sup = sup;
																}
																else {
																	throw new IllegalArgumentException("Invalid qualOfLife");
																}
															}
															else {
																throw new IllegalArgumentException("Invalid socialScale");
															}
															}
														else {
															throw new IllegalArgumentException("Invalid academicScale");
														}
															}
													else {
														throw new IllegalArgumentException("Invalid perEnrolled");
													}
															}
												else {
													throw new IllegalArgumentException("Invalid perAdmmited");
												}
															}
											else {
												throw new IllegalArgumentException("Invalid numOfApps");
											}
															}
										else {
											throw new IllegalArgumentException("Invalid financialAid");
										}
															}
									else {
										throw new IllegalArgumentException("Invalid expenses");
									}
															}
								else {
									throw new IllegalArgumentException("Invalid satMath");
								}
															}
							else {
								throw new IllegalArgumentException("Invalid satVerbal");
							}
															}
						else {
							throw new IllegalArgumentException("Invalid perFem");
						}
															}
					else {
						throw new IllegalArgumentException("Invalid numOfStudents");
					}
															}
				else {
					throw new IllegalArgumentException("Invalid control");
				}
															}
			else {
				throw new IllegalArgumentException("Invalid location");
			}
															}
		else {
			throw new IllegalArgumentException("Invalid state");
		}
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
			this.schoolName = schoolName.toUpperCase();
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
		if (state.equals("ALABAMA") || state.equals("ALASKA") || state.equals("ARIZONA") || state.equals("ARKANSAS") || state.equals("CALIFORNIA") || state.equals("COLORADO") || state.equals("CONNECTICUT") || state.equals("DELAWARE") || state.equals("FLORIDA") || state.equals("GEORGIA") || state.equals("HAWAII") || state.equals("IDAHO") || state.equals("ILLINOIS") || state.equals("INDIANA") || state.equals("IOWA") || state.equals("KANSAS") || state.equals("KENTUCKY") || state.equals("LOUSIANA") || state.equals("MAINE") || state.equals("MARYLAND") || state.equals("MASSACHUSETTS") || state.equals("MICHIGAN") || state.equals("MINNESOTA") || state.equals("MISSISSIPPI") || state.equals("MISSOURI") || state.equals("MONTANA") || state.equals("NEBRASKA") || state.equals("NEVADA") || state.equals("NEW HAMPSHIRE") || state.equals("NEW JERSEY") || state.equals("NEW MEXICO") || state.equals("NEW YORK") || state.equals("NORTH CAROLINA") || state.equals("NORTH DAKOTA") || state.equals("OHIO") || state.equals("OKLAHOMA") || state.equals("OREGON") || state.equals("PENNSYLVANNIA") || state.equals("RHODE ISLAND") || state.equals("SOUTH CAROLINA") || state.equals("SOUTH DAKOTA") || state.equals("TENNESSEE") || state.equals("TEXAS") || state.equals("UTAH") || state.equals("VERMONT") || state.equals("VIRGINIA") || state.equals("WASHINGTON") || state.equals("WEST VIRGINIA") || state.equals("WISCONSIN") || state.equals("WYOMING") || state.equals("FOREIGN")) {
			this.state = state.toUpperCase();
		}
		else {
			throw new IllegalArgumentException("Invalid state");
		}

	}

	/**
	 * gets location
	 * @return location
	 */
	public String getLocation() {
		return location.toUpperCase();
	}

	/**
	 * sets location
	 * @param location
	 */
	public void setLocation(String location) {
		if(location.equals("-1") || location.equals("SMALL-CITY") || location.equals("SUBURBAN") || location.equals("URBAN")) {
			this.location = location.toUpperCase();
		}
		else {
			throw new IllegalArgumentException("Invalid location");
		}
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
	public void setControl(String control) {
		if(control.equals("CITY") || control.equals("PRIVATE") || control.equals("STATE")) {
			this.control = control.toUpperCase();
		}
		else {
			throw new IllegalArgumentException("Invalid control");
		}
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
		if(0 < numOfStudents || numOfStudents == 1) {
			this.numOfStudents = numOfStudents;
		}
		else {
			throw new IllegalArgumentException("Invalid numOfStudents");
		}
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
		if(0 <= perFem && perFem <= 100 || perFem == 1) {
			this.perFem = perFem;
		}
		else {
			throw new IllegalArgumentException("Invalid perFem");
		}
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
		if(200 <= satVerbal && satVerbal <= 800 || satVerbal == -1) {
			this.satVerbal = satVerbal;
		}
		else {
			throw new IllegalArgumentException("Invalid satVerbal");
		}
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
		if(200 <= satMath && satMath <= 800 || satMath == -1) {
			this.satMath = satMath;
		}
		else {
			throw new IllegalArgumentException("Invalid satMath");
		}
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
		if(expenses == -1 || expenses >= 0) {
			this.expenses = expenses;
		}
		else {
			throw new IllegalArgumentException("Invalid satExpenses");
		}
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
		if(financialAid == -1 || financialAid >= 0 && financialAid <= 100) {
			this.financialAid = financialAid;
		}
		else {
			throw new IllegalArgumentException("Invalid financialAid");
		}
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
		if(numOfApps == -1 || numOfApps >= 0) {
			this.numOfApps = numOfApps;
		}
		else {
			throw new IllegalArgumentException("Invalid numOfApps");
		}
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
		if(0 <= perAdmitted && perAdmitted <= 100 || perAdmitted == 1) {
			this.perAdmitted = perAdmitted;
		}
		else {
			throw new IllegalArgumentException("Invalid perAdmitted");
		}
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
		if(0 <= perEnrolled && perEnrolled <= 100 || perEnrolled == 1) {
			this.perEnrolled = perEnrolled;
		}
		else {
			throw new IllegalArgumentException("Invalid perEnrolled");
		}
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
		if(0 <= academicScale && academicScale <= 5 || academicScale == 1) {
			this.academicScale = academicScale;
		}
		else {
			throw new IllegalArgumentException("Invalid academicScale");
		}
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
		if(0 <= socialScale && socialScale <= 5 || socialScale == 1) {
			this.socialScale = socialScale;
		}
		else {
			throw new IllegalArgumentException("Invalid socialScale");
		}
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
		if(0 <= qualOfLife && qualOfLife <= 5 || qualOfLife == 1) {
			this.qualOfLife = qualOfLife;
		}
		else {
			throw new IllegalArgumentException("Invalid qualOfLife");
		}
		
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
		for(int i = 0; i < newEmp.size(); i++) {
			newEmp.set(i, newEmp.get(i).toUpperCase());
		}
		this.emphasis = newEmp;
	}
	
	/**
	 * gets the count
	 * @return ArrayList<String> of counts
	 */
	public int getCount(){
		return count;
	}
	
	
	/**
	 * set the count
	 * @param newCount new count
	 */
	public void setCount(int newCount) {
		if(0 <= newCount) {
			this.count = newCount;
		}
		else {
			throw new IllegalArgumentException("Invalid count");
		}
	}
	
	/**
	 * gets the distance
	 * @return ArrayList<String> of distances
	 */
	public double getDistance(){
		return distance;
	}
	
	
	/**
	 * adds emphasis
	 * @param newEmp new emphasis
	 */
	public void setDistance(double newDistance) {
		if(0 <= newDistance) {
			this.distance = newDistance;
		}
		else {
			throw new IllegalArgumentException("Invalid distance");
		}
	}

	/**
	 * @return the sup
	 */
	public double getSup() {
		return sup;
	}

	/**
	 * @param sup the sup to set
	 */
	public void setSup(double sup) {
		this.sup = sup;
	}

}
