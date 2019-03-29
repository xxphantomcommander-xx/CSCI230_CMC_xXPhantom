package csci230.project;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * This class controls how Universities object interact 
 * with the system
 * @author xXPhantomCommander$Xx
 * @version 3/19/19
 */
public class UniversityController {
	// creates an instance of a DBController
	private DBController dbCon;
	// Arraylist of all universities
	private ArrayList<University> allUnivs;
	// University that is the school of the week
	private University schoolOfTheWeek;
	// ArrayList of universities that contains the top result of all searches
	private ArrayList<University> history = new ArrayList<University>();
	/**
	 * Constructor for University controller
	 */
	public UniversityController() {
		dbCon = new DBController();
		allUnivs = dbCon.loadUniversities();

		
	}
	
	/**
	 * searches for schools using parameters
	 * @param sch
	 * @param st
	 * @param l
	 * @param c
	 * @param nStuLow
	 * @param nStuHigh
	 * @param prctfLow
	 * @param prctfHigh
	 * @param svLow
	 * @param svHigh
	 * @param smLow
	 * @param smHigh
	 * @param eLow
	 * @param eHigh
	 * @param prctfinLow
	 * @param prctfinHigh
	 * @param nApLow
	 * @param nApHigh
	 * @param prctaLow
	 * @param prctaHigh
	 * @param prcteLow
	 * @param prcteHigh
	 * @param asLow
	 * @param asHigh
	 * @param ssLow
	 * @param ssHigh
	 * @param qLow
	 * @param qHigh
	 * @param emp
	 */
	public ArrayList<University> searchSchools(String schoolName, String state, String location, String control, 
			int nStuLow, int nStuHigh, int prctfLow, int prctfHigh, int svLow, int svHigh, int smLow, int smHigh, int eLow, int eHigh, int prctfinLow, int prctfinHigh, int nApLow, int nApHigh,
			int prctaLow, int prctaHigh, int prcteLow, int prcteHigh, int asLow, int asHigh, int ssLow, int ssHigh, int qLow, int qHigh, ArrayList<String> emp) {
		if (state.equals("ALABAMA") || state.equals("ALASKA") || state.equals("ARIZONA") || state.equals("ARKANSAS") || state.equals("CALIFORNIA") || state.equals("COLORADO") || state.equals("CONNECTICUT") || state.equals("DELAWARE") || state.equals("FLORIDA") || state.equals("GEORGIA") || state.equals("HAWAII") || state.equals("IDAHO") || state.equals("ILLINOIS") || state.equals("INDIANA") || state.equals("IOWA") || state.equals("KANSAS") || state.equals("KENTUCKY") || state.equals("LOUISIANA") || state.equals("MAINE") || state.equals("MARYLAND") || state.equals("MASSACHUSETTS") || state.equals("MICHIGAN") || state.equals("MINNESOTA") || state.equals("MISSISSIPPI") || state.equals("MISSOURI") || state.equals("MONTANA") || state.equals("NEBRASKA") || state.equals("NEVADA") || state.equals("NEW HAMPSHIRE") || state.equals("NEW JERSEY") || state.equals("NEW MEXICO") || state.equals("NEW YORK") || state.equals("NORTH CAROLINA") || state.equals("NORTH DAKOTA") || state.equals("OHIO") || state.equals("OKLAHOMA") || state.equals("OREGON") || state.equals("PENNSYLVANIA") || state.equals("RHODEISLAND") || state.equals("RHODE ISLAND") || state.equals("SOUTH CAROLINA") || state.equals("SOUTH DAKOTA") || state.equals("TENNESSEE") || state.equals("TEXAS") || state.equals("UTAH") || state.equals("VERMONT") || state.equals("VIRGINIA") || state.equals("WASHINGTON") || state.equals("WEST VIRGINIA") || state.equals("WISCONSIN") || state.equals("WYOMING") || state.equals("FOREIGN") || state.equals("DISTRICT OF COLUMBIA")){
			if(location.equals("-1") || location.equals("SMALL-CITY") || location.equals("SUBURBAN") || location.equals("URBAN")) {
				if(control.equals("CITY") || control.equals("PRIVATE") || control.equals("STATE")) {
					if(0 <= nStuLow) {
					if(0 <= nStuHigh && nStuHigh > nStuLow) {
						if(0 <= prctfLow && prctfLow <= 100) {
						if(0 <= prctfHigh && prctfLow <= 100 && prctfHigh > prctfLow) {
							if(200 <= svLow && svLow <= 800) {
							if(200 <= svHigh && svHigh <= 800 && svHigh > svLow) {
								if(200 <= smLow && smLow <= 800) {
								if(200 <= smHigh && smHigh <= 800 && smHigh > smLow) {
									if(0 <= eLow) {
									if(0 <= eHigh && eHigh > eLow) {
										if(0 <= prctfinLow && prctfinLow >= 100) {
										if(0 <= prctfinHigh && prctfinHigh >= 100 && prctfinHigh > prctfinLow) {
											if(nApLow >= 0) {
											if(nApHigh >= 0 && nApHigh > nApLow) {
												if(0 <= prctaLow && prctaLow <= 100) {
												if(0 <= prctaHigh && prctaHigh <= 100 && prctaHigh > prctaLow) {
													if(0 <= prcteLow && prcteLow <= 100) {
													if(0 <= prcteHigh && prcteHigh <= 100 && prcteHigh > prcteLow) {
														if(0 <= asLow && asLow <= 5) {
														if(0 <= asHigh && asHigh <= 5 && asHigh > asLow) {
															if(0 <= ssLow && ssLow <= 5) {
															if(0 <= ssHigh && ssHigh <= 5 && ssHigh > ssLow) {
																if(0 <= qLow && qLow <= 5) {
																if(0 <= qLow && qLow <= 5 && qHigh > qLow) {
																	
																	ArrayList<University> searchList = new ArrayList<University>();
																	ArrayList<University> results = new ArrayList<University>();
																	searchList = allUnivs;
																	results = searchByEmphasis(searchByQualityOfLife(searchBySocialLife(searchByAcademicScale(searchByPercEnrolled(searchByPercAdmitted(searchByNumOfApps
																			(searchByPercentFinAid(searchByExpenses(searchBySATMath(searchBySATVerbal(searchByPercentFemale(searchByNumOfStudents(searchByControl(searchByState(searchBySchool(searchList, schoolName), state),  control),nStuLow, nStuHigh)
																			, prctfLow, prctfHigh), svLow, svHigh), smLow, smHigh), eLow, eHigh), prctfinLow, prctfinHigh), nApLow, nApHigh), prctaLow, prctaHigh), prcteLow, prcteHigh),
																			asLow, asHigh), ssLow, ssHigh), qLow, qHigh), emp);
																	history.add(results.get(0));
																	return results;
																}
																else {
																	throw new IllegalArgumentException("Invalid qualOfLife");
																}
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
																	throw new IllegalArgumentException("Invalid socialScale");
																}
															}
														else {
															throw new IllegalArgumentException("Invalid academicScale");
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
																throw new IllegalArgumentException("Invalid perEnrolled");
															}
															}
												else {
													throw new IllegalArgumentException("Invalid perAdmmited");
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
															throw new IllegalArgumentException("Invalid numOfApps");
														}
															}
										else {
											throw new IllegalArgumentException("Invalid financialAid");
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
														throw new IllegalArgumentException("Invalid expenses");
													}
															}
								else {
									throw new IllegalArgumentException("Invalid satMath");
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
													throw new IllegalArgumentException("Invalid satVerbal");
												}
															}
						else {
							throw new IllegalArgumentException("Invalid perFem");
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
												throw new IllegalArgumentException("Invalid numOfStudents");
											}
															}
				else {
					throw new IllegalArgumentException("Invalid control");
				}
			}

															}
			else {
				throw new IllegalArgumentException("Invalid location");
			}
		return allUnivs;
	}

	
	/**
	 * Searches based on the school name
	 * @param temp
	 * @param sch
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchBySchool(ArrayList<University> temp, String sch)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		String schoolName = sch.toUpperCase();
		if(sch.equals(null))
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				String name = i.getSchoolName();
				if(name.contains(schoolName)) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
		}
	}
	/**
	 * Searches based on the state
	 * @param temp
	 * @param st
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByState(ArrayList<University> temp, String st)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		String state = st.toUpperCase();
		if(st.equals(null))
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				String name = i.getState();
				if(name.contains(state)) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
		}
	}
	
	/**
	 * Searches based on the control
	 * @param temp
	 * @param c
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByControl(ArrayList<University> temp, String c)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		String control = c.toUpperCase();
		if(c.equals(null))
		{
			return temp;
		}
		else{
			
			for(University i: temp)
			{
				String name = i.getControl();
				if(name.contains(control)) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
		}
	
	}
	
	/**
	 * Searches based on the number of students
	 * @param temp
	 * @param nStuLow
	 * @param nStuHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByNumOfStudents(ArrayList<University> temp, int nStuLow, int nStuHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(nStuLow == -1 && nStuHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getNumOfStudents();
				if(v >= nStuLow && v <= nStuHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
			
		}
	}
	/**
	 * Searches based on the percent female
	 * @param temp
	 * @param prctfLow
	 * @param prctfHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByPercentFemale(ArrayList<University> temp, int prctfLow, int prctfHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(prctfLow == -1 && prctfHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getPerFem();
				if(v >= prctfLow && v <= prctfHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
		}
	}
	/**
	 * Searches based on the SAT verbal
	 * @param temp
	 * @param svLow
	 * @param svHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchBySATVerbal(ArrayList<University> temp, int svLow, int svHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(svLow == -1 && svHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getSatVerbal();
				if(v >= svLow && v <= svHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
			
		}
	}
	/**
	 * Searches based on the SAT math
	 * @param temp
	 * @param smLow
	 * @param smHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchBySATMath(ArrayList<University> temp, int smLow, int smHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(smLow == -1 && smHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getSatMath();
				if(v >= smLow && v <= smHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	/**
	 * Searches based on the Expenses
	 * @param temp
	 * @param eLow
	 * @param eHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByExpenses(ArrayList<University> temp, int eLow, int eHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(eLow == -1 && eHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getExpenses();
				if(v >= eLow && v <= eHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	/**
	 * Searches based on the percent financial aid
	 * @param temp
	 * @param prctfinLow
	 * @param prctfinHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByPercentFinAid(ArrayList<University> temp, int prctfinLow, int prctfinHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(prctfinLow == -1 && prctfinHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getFinancialAid();
				if(v >= prctfinLow && v <= prctfinHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	/**
	 * Searches based on the number of applicants
	 * @param temp
	 * @param nApLow
	 * @param nApHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByNumOfApps(ArrayList<University> temp, int nApLow, int nApHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(nApLow == -1 && nApHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getNumOfApps();
				if(v >= nApLow && v <= nApHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	/**
	 * Searches based on the percent admitted
	 * @param temp
	 * @param prctaLow
	 * @param prctaHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByPercAdmitted(ArrayList<University> temp, int prctaLow, int prctaHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(prctaLow == -1 && prctaHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getPerAdmitted();
				if(v >= prctaLow && v <= prctaHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	/**
	 * Searches based on the percent enrolled
	 * @param temp
	 * @param prcteLow
	 * @param prcteHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByPercEnrolled(ArrayList<University> temp, int prcteLow, int prcteHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(prcteLow == -1 && prcteHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getPerEnrolled();
				if(v >= prcteLow && v <= prcteHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	/**
	 * Searches based on the academic scale
	 * @param temp
	 * @param asLow
	 * @param asHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByAcademicScale(ArrayList<University> temp, int asLow, int asHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(asLow == -1 && asHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getAcademicScale();
				if(v >= asLow && v <= asHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	/**
	 * Searches based on the social scale
	 * @param temp
	 * @param ssLow
	 * @param ssHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchBySocialLife(ArrayList<University> temp, int ssLow, int ssHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(ssLow == -1 && ssHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getSocialScale();
				if(v >= ssLow && v <= ssHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	/**
	 * Searches based on the quality of life
	 * @param temp
	 * @param qLow
	 * @param qHigh
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByQualityOfLife(ArrayList<University> temp, int qLow, int qHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(qLow == -1 && qHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getQualOfLife();
				if(v >= qLow && v <= qHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	/**
	 * Searches based on the emphasis
	 * @param temp
	 * @param emp
	 * @return ArrayList of all universities matching search criteria
	 */
	private ArrayList<University> searchByEmphasis(ArrayList<University> temp, ArrayList<String> emp)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		ArrayList<String> capEmp = new ArrayList<String>();
		for(String i:emp) {
			capEmp.add(i.toUpperCase());
		}
		
		if(emp.get(0).equals("") && emp.get(1).equals("") && emp.get(2).equals("") && emp.get(3).equals("") && emp.get(4).equals(""))
		{
			
			return temp;
		}
		else{
			for(University i: temp) {
				ArrayList<String> v = capEmp;
				for(String u:i.getEmp()) {
					if(u.equals(v.get(0)) || u.equals(v.get(1)) || u.equals(v.get(2)) || u.equals(v.get(3)) || u.equals(v.get(4)) ) {
						matchedSchools.add(i);
					}
				}
			}
			return matchedSchools;
		}
	}
	/*
	 * Gets the top recommended schools using a count system
	 * @param univ the given school to compare to
	 * @return an arrayList of 5 universities
	 */
	public ArrayList<University> topRecommended(University univ)
	{
		if(univ != null && allUnivs.contains(univ))
		{
		ArrayList<University> recommend = new ArrayList<University>();
		for (University i: allUnivs)
		{
			int count = 0;
			if (univ.getState().equals("-1"))
			{
				
			}
			else if (i.getState().equals(univ.getState()))
			{
				count++;
			}
			
			if (univ.getLocation().equals("-1"))
			{
				
			}
			else if (i.getLocation().equals(univ.getLocation()))
			{
				count++;
			}
			
			if (univ.getControl().equals("-1"))
			{
				
			}
			else if (i.getControl().equals(univ.getControl()))
			{
				count++;
			}
			
			if (univ.getNumOfStudents() == -1)
			{
				
			}
			else if(univ.getNumOfStudents() == i.getNumOfStudents())
			{
				count += 2;
			}
			else if (i.getNumOfStudents() - univ.getNumOfStudents() <= 5000 && i.getNumOfStudents() - univ.getNumOfStudents() >= -5000)
			{
				count++;
			}
			
			if (univ.getPerFem() == -1)
			{
				
			}
			else if (univ.getPerFem() == i.getPerFem()) {
				count += 2;
			}
			else if (i.getPerFem() - univ.getPerFem() <= 5 && i.getPerFem() - univ.getPerFem() >= -5)
			{
				count++;
			}
			
			if (univ.getSatVerbal() == -1)
			{
				
			}
			else if (univ.getSatVerbal() == i.getSatVerbal()) {
				count += 2;
			}
			else if (i.getSatVerbal() - univ.getSatVerbal() <= 25 && i.getSatVerbal() - univ.getSatVerbal() >= -25)
			{
				count++;
			}
			
			if (univ.getSatMath() == -1)
			{
				
			}
			else if (univ.getSatMath() == i.getSatMath()) {
				count += 2;
			}
			else if (i.getSatMath() - univ.getSatMath() <= 25 && i.getSatMath() - univ.getSatMath() >= -25)
			{
				count++;
			}
			
			if (univ.getExpenses() == -1)
			{
				
			}
			else if (univ.getExpenses() == i.getExpenses()) {
				count += 2;
			}
			else if (i.getExpenses() - univ.getExpenses() <= 2500 && i.getExpenses() - univ.getExpenses() >= -2500)
			{
				count++;
			}
			
			if (univ.getFinancialAid() == -1)
			{
				
			}
			else if (univ.getFinancialAid() == i.getFinancialAid()) {
				count += 2;
			}
			else if (i.getFinancialAid() - univ.getFinancialAid() <= 5 && i.getFinancialAid() - univ.getFinancialAid() >= -5)
			{
				count++;
			}
			
			if (univ.getNumOfApps() == -1)
			{
				
			}
			else if (univ.getNumOfApps() == i.getNumOfApps()) {
				count += 2;
			}
			else if (i.getNumOfApps() - univ.getNumOfApps() <= 500 && i.getNumOfApps() - univ.getNumOfApps() >= -500)
			{
				count++;
			}
			
			if (univ.getPerAdmitted() == -1)
			{
				
			}
			else if (univ.getPerAdmitted() == i.getPerAdmitted()) {
				count += 2;
			}
			else if (i.getPerAdmitted() - univ.getPerAdmitted() <= 5 && i.getPerAdmitted() - univ.getPerAdmitted() >= -5)
			{
				count++;
			}
			
			if (univ.getPerEnrolled() == -1)
			{
				
			}
			else if (univ.getPerEnrolled() == i.getPerEnrolled()) {
				count += 2;
			}
			else if (i.getPerEnrolled() - univ.getPerEnrolled() <= 5 && i.getPerEnrolled() - univ.getPerEnrolled() >= -5)
			{
				count++;
			}
			
			if (univ.getAcademicScale() == -1)
			{
				
			}
			else if (univ.getAcademicScale() == i.getAcademicScale()) {
				count += 2;
			}
			else if (i.getAcademicScale() - univ.getAcademicScale() <= 1 && i.getAcademicScale() - univ.getAcademicScale() >= -1)
			{
				count++;
			}
			
			if (univ.getSocialScale() == -1)
			{
				
			}
			else if (univ.getSocialScale() == i.getSocialScale()) {
				count += 2;
			}
			else if (i.getSocialScale() == univ.getSocialScale())
			{
				count++;
			}
			
			if (univ.getQualOfLife() == -1)
			{
				
			}
			else if (univ.getQualOfLife() == i.getQualOfLife()) {
				count += 2;
			}
			else if (i.getQualOfLife() == univ.getQualOfLife())
			{
				count++;
			}
			
			
			i.setCount(count);
		}

		for (University i : allUnivs)
		{
			recommend.add(i);
		}
		

		ArrayList<University> sortedSchools = mergeSort(recommend);

		return sortedSchools;
		}
		else {
			throw new IllegalArgumentException("University passed is not a valid university");
		}
		

	}
	
	/**
	 * merge sort for the counts of universities
	 * @param whole
	 * @return the arraylist of universities sorted by their count
	 */
	private ArrayList<University> mergeSort(ArrayList<University> whole)
	{
		ArrayList<University> left = new ArrayList<University>();
		ArrayList<University> right = new ArrayList<University>();
		int center;
		
		if (whole.size() == 1)
		{
			return whole;
		}
		else 
		{
			center = whole.size()/2;
			for (int i = 0; i < center ; i++)
			{
				left.add(whole.get(i));
			}
			for (int i = center; i < whole.size(); i++)
			{
				right.add(whole.get(i));
			}
			left = mergeSort(left);
			right = mergeSort(right);
			merge(left, right, whole);
		}
		return whole;
	}
	
	/**
	 * helper method for mergeSort
	 * @param left
	 * @param right
	 * @param whole
	 */
	private void merge(ArrayList<University> left, ArrayList<University> right, ArrayList<University> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
 
        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).getCount() > (right.get(rightIndex).getCount()))) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        ArrayList<University> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
	/*
	 * Gets the top recommended schools using distance formula
	 * @param univ the given university to compare to
	 * @return an arrayList of 5 universities
	 */
	public ArrayList<University> topRecommended2(University univ)
	{
		if(univ != null && allUnivs.contains(univ)) {
		
		double maxStudents = 0;
		double minStudents = 0;
		double maxPrctFem = 0;
		double minPrctFem = 0;
		double maxVerbal = 0;
		double minVerbal = 0;
		double maxMath = 0;
		double minMath = 0;
		double maxExp = 0;
		double minExp = 0;
		double maxFinance = 0;
		double minFinance = 0;
		double maxApps = 0;
		double minApps = 0;
		double maxAdmitted = 0;
		double minAdmitted = 0;
		double maxEnrolled = 0;
		double minEnrolled = 0;
		double maxAcademics = 0;
		double minAcademics = 0;
		double maxSocial = 0;
		double minSocial = 0;
		double maxQual = 0;
		double minQual = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		int count9 = 0;
		int count10 = 0;
		int count11 = 0;
		int count12 = 0;
		// The following calculates the min and max for each category of university
		// number of students
		for (University i: allUnivs)
		{
			if (count1 == 0)
			{
				maxStudents = i.getNumOfStudents();
				minStudents = i.getNumOfStudents();
				count1++;
			}
			else
			{
				if (i.getNumOfStudents() > maxStudents)
				{
					maxStudents = i.getNumOfStudents();
				}
				else if (i.getNumOfStudents() < minStudents)
				{
					if(i.getNumOfStudents() == -1)
					{
						
					}
					else
					{
						minStudents = i.getNumOfStudents();
					}
					
				}
			}
		
		// percent female
			if (count2 == 0)
			{
				maxPrctFem = i.getPerFem();
				minPrctFem = i.getPerFem();
				count2++;
			}
			else
			{
				if (i.getPerFem() > maxPrctFem)
				{
					maxPrctFem = i.getPerFem();
				}
				else if (i.getPerFem() < minPrctFem)
				{
					if(i.getPerFem() == -1)
					{
						
					}
					else
					{
						minPrctFem = i.getPerFem();
					}
				}
			}
		
		// SAT Verbal
			if (count3 == 0 && i.getSatVerbal() != -1)
			{
				maxVerbal = i.getSatVerbal();
				minVerbal = 1000;
				count3++;
			}
			else
			{
				if (i.getSatVerbal() > maxVerbal)
				{
					maxVerbal = i.getSatVerbal();
				}
				else if (i.getSatVerbal() < minVerbal)
				{
					if(i.getSatVerbal() == -1)
					{
						
					}
					else
					{
						minVerbal = i.getSatVerbal();
					}
				}
			}
		
		//SAT Math
			if (count4 == 0 && i.getSatMath() != -1)
			{
				maxMath = i.getSatMath();
				minMath = 1000;
				count4++;
			}
			else
			{
				if (i.getSatMath() > maxMath)
				{
					maxMath = i.getSatMath();
				}
				else if (i.getSatMath() < minMath)
				{
					if(i.getSatMath() == -1)
					{
						
					}
					else
					{
						minMath = i.getSatMath();
					}
				}
			}
		
		//Expenses
			if (count5 == 0)
			{
				maxExp = i.getExpenses();
				minExp = i.getExpenses();
				count5++;
			}
			else
			{
				if (i.getExpenses() > maxExp)
				{
					maxExp = i.getExpenses();
				}
				else if (i.getExpenses() < minExp)
				{
					if(i.getExpenses() == -1)
					{
						
					}
					else
					{
						minExp = i.getExpenses();
					}
				}
			}
	
		//Percent Financial Aid

			if (count6 == 0)
			{
				maxFinance = i.getFinancialAid();
				minFinance = i.getFinancialAid();
				count6++;
			}
			else
			{
				if (i.getFinancialAid() > maxFinance)
				{
					maxFinance = i.getFinancialAid();
				}
				else if (i.getFinancialAid() < minFinance)
				{
					if(i.getFinancialAid() == -1)
					{
						
					}
					else
					{
						minFinance = i.getFinancialAid();
					}
				}
			}
		
		// Number of applicants
			if (count7 == 0)
			{
				maxApps = i.getNumOfApps();
				minApps = i.getNumOfApps();
				count7++;
			}
			else
			{
				if (i.getNumOfApps() > maxApps)
				{
					maxApps = i.getNumOfApps();
				}
				else if (i.getNumOfApps() < minApps)
				{
					if(i.getNumOfApps() == -1)
					{
						
					}
					else
					{
						minApps = i.getNumOfApps();
					}
				}
			}
		
		// Percent admitted
			if (count8 == 0)
			{
				maxAdmitted = i.getPerAdmitted();
				minAdmitted = i.getPerAdmitted();
				count8++;
			}
			else
			{
				if (i.getPerAdmitted() > maxAdmitted)
				{
					maxAdmitted = i.getPerAdmitted();
				}
				else if (i.getPerAdmitted() < minAdmitted)
				{
					if(i.getPerAdmitted() == -1)
					{
						
					}
					else
					{
						minAdmitted = i.getPerAdmitted();
					}
				}
			}
		
		//Percent enrolled
			if (count9 == 0)
			{
				maxEnrolled = i.getPerEnrolled();
				minEnrolled = i.getPerEnrolled();
				count9++;
			}
			else
			{
				if (i.getPerEnrolled() > maxEnrolled)
				{
					maxEnrolled = i.getPerEnrolled();
				}
				else if (i.getPerEnrolled() < minEnrolled)
				{
					if(i.getPerEnrolled() == -1)
					{
						
					}
					else
					{
						minEnrolled = i.getPerEnrolled();
					}
				}
			}
		
		// Academics Scale
			if (count10 == 0)
			{
				maxAcademics = i.getAcademicScale();
				minAcademics = i.getAcademicScale();
				count10++;
			}
			else
			{
				if (i.getAcademicScale() > maxAcademics)
				{
					maxAcademics = i.getAcademicScale();
				}
				else if (i.getAcademicScale() < minAcademics)
				{
					if(i.getAcademicScale() == -1)
					{
						
					}
					else
					{
						minAcademics = i.getAcademicScale();
					}
				}
			}
		
		// Social Scale
			if (count11 == 0)
			{
				maxSocial = i.getSocialScale();
				minSocial = i.getSocialScale();
				count11++;
			}
			else
			{
				if (i.getSocialScale() > maxSocial)
				{
					maxSocial = i.getSocialScale();
				}
				else if (i.getSocialScale() < minSocial)
				{
					if(i.getSocialScale() == -1)
					{
						
					}
					else
					{
						minSocial = i.getSocialScale();
					}
				}
			}
		
		// Quality of life scale
			if (count12 == 0)
			{
				maxQual = i.getQualOfLife();
				minQual = i.getQualOfLife();
				count12++;
			}
			else
			{
				if (i.getQualOfLife() > maxQual)
				{
					maxQual = i.getQualOfLife();
				}
				else if (i.getQualOfLife() < minQual)
				{
					if(i.getQualOfLife() == -1)
					{
						
					}
					else
					{
						minQual = i.getQualOfLife();
					}
				}
			}
		}
		
		
		
		//calculates the distance for all universities
		for (University i : allUnivs)
		{
			double distance = 0;
			if (!univ.getState().equals(i.getState()))
			{
				distance += 1;
			}
			if (!univ.getLocation().equals(i.getLocation()))
			{
				distance += 1;
			}
			if (!univ.getControl().equals(i.getControl()))
			{
				distance += 1;
			}
			
			if(i.getNumOfStudents() != -1)
			{
				distance += Math.abs(univ.getNumOfStudents() - i.getNumOfStudents()) / (maxStudents - minStudents);
			}
			if(i.getPerFem() != -1)
			{
				distance += Math.abs(univ.getPerFem() - i.getPerFem()) / (maxPrctFem - minPrctFem);
			}
			if(i.getSatVerbal() != -1)
			{
				distance += Math.abs(univ.getSatVerbal() - i.getSatVerbal()) / (maxVerbal - minVerbal);
			}
			if(i.getSatMath() != -1)
			{
				distance += Math.abs(univ.getSatMath() - i.getSatMath()) / (maxMath - minMath);
			}
			if(i.getExpenses() != -1)
			{
				distance += Math.abs(univ.getExpenses() - i.getExpenses()) / (maxExp - minExp);
			}
			if(i.getFinancialAid() != -1)
			{
				distance += Math.abs(univ.getFinancialAid() - i.getFinancialAid()) / (maxFinance - minFinance);
			}
			if(i.getNumOfApps() != -1)
			{
				distance += Math.abs(univ.getNumOfApps() - i.getNumOfApps()) / (maxApps - minApps);
			}
			if(i.getPerAdmitted() != -1)
			{
				distance += Math.abs(univ.getPerAdmitted() - i.getPerAdmitted()) / (maxAdmitted - minAdmitted);
			}
			if(i.getPerEnrolled() != -1)
			{
				distance += Math.abs(univ.getPerEnrolled() - i.getPerEnrolled()) / (maxEnrolled - minEnrolled);
			}
			if(i.getAcademicScale() != -1)
			{
				distance += Math.abs(univ.getAcademicScale() - i.getAcademicScale()) / (maxAcademics - minAcademics);
			}
			if(i.getSocialScale() != -1)
			{
				distance += Math.abs(univ.getSocialScale() - i.getSocialScale()) / (maxSocial - minSocial);
			}
			if(i.getQualOfLife() != -1)
			{
				distance += Math.abs(univ.getQualOfLife() - i.getQualOfLife()) / (maxQual - minQual);
			}
			
			i.setDistance(distance);

		}
		ArrayList<University> sortedSchools = mergeSort2(allUnivs);
		return sortedSchools;
	}
		else {
			throw new IllegalArgumentException("University passed is not a valid university");
		}
	}
	
	/**
	 * merge sorts based on the distance value of the universities
	 * @param whole
	 * @return Arraylist of universities sorted by distance
	 */
	private ArrayList<University> mergeSort2(ArrayList<University> whole)
	{
		ArrayList<University> left = new ArrayList<University>();
		ArrayList<University> right = new ArrayList<University>();
		int center;
		
		if (whole.size() == 1)
		{
			return whole;
		}
		else 
		{
			center = whole.size()/2;
			for (int i = 0; i < center ; i++)
			{
				left.add(whole.get(i));
			}
			for (int i = center; i < whole.size(); i++)
			{
				right.add(whole.get(i));
			}
			left = mergeSort2(left);
			right = mergeSort2(right);
			merge2(left, right, whole);
		}
		return whole;
	}
	
	/**
	 * helper method for mergeSort2
	 * @param left
	 * @param right
	 * @param whole
	 */
	private void merge2(ArrayList<University> left, ArrayList<University> right, ArrayList<University> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
 
        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).getDistance() < (right.get(rightIndex).getDistance()))) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        ArrayList<University> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
	
	/**
	 * 
	 * Shows University Details
	 * @param String of school searched
	 * @return String of results
	 */
	public ArrayList<String> showUniversityDetails(University univ) {
		if (univ != null && viewUniversities().contains(univ)) {
			ArrayList<String> details = new ArrayList<String>();
			details.add(univ.getSchoolName());
			details.add(univ.getState());
			details.add(univ.getLocation());
			details.add(univ.getControl());
			details.add(String.valueOf(univ.getNumOfStudents()));
			details.add(String.valueOf(univ.getPerFem()));
			details.add(String.valueOf(univ.getSatVerbal()));
			details.add(String.valueOf(univ.getSatMath()));
			details.add(String.valueOf(univ.getExpenses()));
			details.add(String.valueOf(univ.getFinancialAid()));
			details.add(String.valueOf(univ.getNumOfApps()));
			details.add(String.valueOf(univ.getPerAdmitted()));
			details.add(String.valueOf(univ.getPerEnrolled()));
			details.add(String.valueOf(univ.getAcademicScale()));
			details.add(String.valueOf(univ.getSocialScale()));
			details.add(String.valueOf(univ.getQualOfLife()));
			for(String i:univ.getEmp()) {
				details.add(i);
			}
			return details;
		}
		else {
			throw new IllegalArgumentException("University passed is not a valid university");
		}
	}

	/**
	 * edits the school using parameters
	 * @param sch
	 * @param st
	 * @param l
	 * @param c
	 * @param nStuLow
	 * @param nStuHigh
	 * @param prctfLow
	 * @param prctfHigh
	 * @param svLow
	 * @param svHigh
	 * @param smLow
	 * @param smHigh
	 * @param eLow
	 * @param eHigh
	 * @param prctfinLow
	 * @param prctfinHigh
	 * @param nApLow
	 * @param nApHigh
	 * @param prctaLow
	 * @param prctaHigh
	 * @param prcteLow
	 * @param prcteHigh
	 * @param asLow
	 * @param asHigh
	 * @param ssLow
	 * @param ssHigh
	 * @param qLow
	 * @param qHigh
	 * @param emp
	 * @return University Objects of universities that match the search parameters
	 */
	public void editSchool(String school, String state, String location, String control, 
			int numStudents, int perFem, int satVerbal, int satMath,
			int expenses, int financialAid, int numOfApps, int perAdmitted, 
			int perEnrolled, int academicScale, int socialScale, 
			int qualOfLife, ArrayList<String> emphasis) {
		if (state.equals("ALABAMA") || state.equals("ALASKA") || state.equals("ARIZONA") || state.equals("ARKANSAS") || state.equals("CALIFORNIA") || state.equals("COLORADO") || state.equals("CONNECTICUT") || state.equals("DELAWARE") || state.equals("FLORIDA") || state.equals("GEORGIA") || state.equals("HAWAII") || state.equals("IDAHO") || state.equals("ILLINOIS") || state.equals("INDIANA") || state.equals("IOWA") || state.equals("KANSAS") || state.equals("KENTUCKY") || state.equals("LOUISIANA") || state.equals("MAINE") || state.equals("MARYLAND") || state.equals("MASSACHUSETTS") || state.equals("MICHIGAN") || state.equals("MINNESOTA") || state.equals("MISSISSIPPI") || state.equals("MISSOURI") || state.equals("MONTANA") || state.equals("NEBRASKA") || state.equals("NEVADA") || state.equals("NEW HAMPSHIRE") || state.equals("NEW JERSEY") || state.equals("NEW MEXICO") || state.equals("NEW YORK") || state.equals("NORTH CAROLINA") || state.equals("NORTH DAKOTA") || state.equals("OHIO") || state.equals("OKLAHOMA") || state.equals("OREGON") || state.equals("PENNSYLVANIA") || state.equals("RHODEISLAND") || state.equals("RHODE ISLAND") || state.equals("SOUTH CAROLINA") || state.equals("SOUTH DAKOTA") || state.equals("TENNESSEE") || state.equals("TEXAS") || state.equals("UTAH") || state.equals("VERMONT") || state.equals("VIRGINIA") || state.equals("WASHINGTON") || state.equals("WEST VIRGINIA") || state.equals("WISCONSIN") || state.equals("WYOMING") || state.equals("FOREIGN") || state.equals("DISTRICT OF COLUMBIA")){
			if(location.equals("-1") || location.equals("SMALL-CITY") || location.equals("SUBURBAN") || location.equals("URBAN")) {
				if(control.equals("CITY") || control.equals("PRIVATE") || control.equals("STATE")) {
					if(0 < numStudents || numStudents == -1) {
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
																	University newUniv = new University(school, state, location, 																	control, numStudents, perFem, satVerbal, satMath, expenses, 																	financialAid, numOfApps, perAdmitted, perEnrolled, 																	academicScale, socialScale, qualOfLife, emphasis, 0, 0, 0);
																	this.dbCon.editUniversity(newUniv);
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
	 * get all universities
	 * @return ArrayList<University> os all universities
	 */
	public ArrayList<University> viewUniversities() {
		return dbCon.loadUniversities();
	}
	
	
	/**
	 * Creates a new university and adds it to the database
	 * @param school
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param prctFemale
	 * @param SATVerbal
	 * @param SATMath
	 * @param expenses
	 * @param prctFinancialAid
	 * @param numApplicants
	 * @param prctAccepted
	 * @param prctEnrolled
	 * @param academicScale
	 * @param socialScale
	 * @param qualOfLife
	 * @param emphasis
	 */
	public void addUniversity(String school, String state, String location, String control, 
			int numStudents, int perFem, int satVerbal, int satMath,
			int expenses, int financialAid, int numOfApps, int perAdmitted, 
			int perEnrolled, int academicScale, int socialScale, 
			int qualOfLife, ArrayList<String> emphasis)
	{
		if (state.equals("ALABAMA") || state.equals("ALASKA") || state.equals("ARIZONA") || state.equals("ARKANSAS") || state.equals("CALIFORNIA") || state.equals("COLORADO") || state.equals("CONNECTICUT") || state.equals("DELAWARE") || state.equals("FLORIDA") || state.equals("GEORGIA") || state.equals("HAWAII") || state.equals("IDAHO") || state.equals("ILLINOIS") || state.equals("INDIANA") || state.equals("IOWA") || state.equals("KANSAS") || state.equals("KENTUCKY") || state.equals("LOUISIANA") || state.equals("MAINE") || state.equals("MARYLAND") || state.equals("MASSACHUSETTS") || state.equals("MICHIGAN") || state.equals("MINNESOTA") || state.equals("MISSISSIPPI") || state.equals("MISSOURI") || state.equals("MONTANA") || state.equals("NEBRASKA") || state.equals("NEVADA") || state.equals("NEW HAMPSHIRE") || state.equals("NEW JERSEY") || state.equals("NEW MEXICO") || state.equals("NEW YORK") || state.equals("NORTH CAROLINA") || state.equals("NORTH DAKOTA") || state.equals("OHIO") || state.equals("OKLAHOMA") || state.equals("OREGON") || state.equals("PENNSYLVANIA") || state.equals("RHODEISLAND") || state.equals("RHODE ISLAND") || state.equals("SOUTH CAROLINA") || state.equals("SOUTH DAKOTA") || state.equals("TENNESSEE") || state.equals("TEXAS") || state.equals("UTAH") || state.equals("VERMONT") || state.equals("VIRGINIA") || state.equals("WASHINGTON") || state.equals("WEST VIRGINIA") || state.equals("WISCONSIN") || state.equals("WYOMING") || state.equals("FOREIGN") || state.equals("DISTRICT OF COLUMBIA")){
			if(location.equals("-1") || location.equals("SMALL-CITY") || location.equals("SUBURBAN") || location.equals("URBAN")) {
				if(control.equals("CITY") || control.equals("PRIVATE") || control.equals("STATE")) {
					if(0 < numStudents || numStudents == -1) {
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
																	University newUniv = new University(school, state, location, 																	control, numStudents, perFem, satVerbal, satMath, expenses, 																	financialAid, numOfApps, perAdmitted, perEnrolled, 																	academicScale, socialScale, qualOfLife, emphasis, 0, 0, 0);
																	dbCon.addUniversity(newUniv);
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
	 * removes a university from the list of schools on the database
	 * @param univ
	 */
	public void removeUniversity(University univ) {
		if(univ != null && allUnivs.contains(univ))
		{
		dbCon.removeSchool(univ);
		}
		else {
			throw new IllegalArgumentException("University passed is not a valid university");
		}
	}
	
	/**
	 * generates a random school from the list of universities
	 * @return random University
	 */
	public University randomSchool()
	{
		ArrayList<University> randList = dbCon.loadUniversities();
		int x;
		x = (int) Math.floor(Math.random() * randList.size());
		return randList.get(x);
	}
	
	/**
	 * allows an admin to change the school of the week
	 * @return school of the week
	 */
	public void setSchoolOfTheWeek(String schoolName)
	{
		ArrayList<University> schoolList = dbCon.loadUniversities();
		for(University i : schoolList)
		{
			if(schoolName.equals(i.getSchoolName()))
			{
				schoolOfTheWeek= i;
			}
			else
			{
				throw new IllegalArgumentException("School not found");
			}
		}
		for(String x:dbCon.getUsernameBySavedSchool(schoolName)) {
			String to = x;
			String from = "CMCPhantomCommanders";
			String host = "localHost";
			Properties properties=new Properties();  
			properties.setProperty("mail.smtp.host", host);
			Session session=Session.getDefaultInstance(properties);  
		
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("New School Of The Week: CMC");
				message.setText("Dear User,\n\n The school of the week is in your saved school list!!!\n The school of the week is: " + schoolOfTheWeek.getSchoolName() + "\n\nThanks,\nxXPhantomCommander$Xx");
			
				Transport.send(message);
				}catch(MessagingException mex) {
					mex.printStackTrace();}
		}
	}
	
	/**
	 * gets the school of the week
	 * @return school of the week
	 */
	public University getSchoolOfTheWeek()
	{
		return schoolOfTheWeek;
	}
	
	/**
	 * Displays the search history of the user
	 * @param user
	 */
	public ArrayList<University> viewHistory(){
		return history;
	}
	
	/**
	 * clears the history of viewed schools
	 */
	public void clearHistory() {
		history.clear();
	}
	
	/**
	 * uses toprecommend and toprecommend2 to make a more accurate recommendation system
	 * @param univ
	 * @return top 5 recommended schools
	 */
	public ArrayList<University> superRecommend(University univ){
		if (univ != null && allUnivs.contains(univ)) {
		ArrayList<University> tc = new ArrayList<University>();
		tc = topRecommended(univ);
		topRecommended2(univ);
		for(University i:tc) {
			double n = i.getCount();
			double j = i.getDistance();
			double z = n-j;
			i.setSup(z);
		}
		ArrayList<University> sortedSchools = mergeSort3(allUnivs);
		return sortedSchools;
		}
		else {
			throw new IllegalArgumentException("University passed is not a valid university");
		}
	}
	
	/**
	 * merge sorts the arraylist of universities based on the Sup value universities
	 * @param whole
	 * @return a sorted arraylist based on Sup
	 */
	private ArrayList<University> mergeSort3(ArrayList<University> whole)
	{
		ArrayList<University> left = new ArrayList<University>();
		ArrayList<University> right = new ArrayList<University>();
		int center;
		
		if (whole.size() == 1)
		{
			return whole;
		}
		else 
		{
			center = whole.size()/2;
			for (int i = 0; i < center ; i++)
			{
				left.add(whole.get(i));
			}
			for (int i = center; i < whole.size(); i++)
			{
				right.add(whole.get(i));
			}
			left = mergeSort3(left);
			right = mergeSort3(right);
			merge3(left, right, whole);
		}
		return whole;
	}

	
	/**
	 * helper method for mergeSort3
	 * @param left
	 * @param right
	 * @param whole
	 */
	private void merge3(ArrayList<University> left, ArrayList<University> right, ArrayList<University> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
 
        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).getSup() > (right.get(rightIndex).getSup()))) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        ArrayList<University> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
}
