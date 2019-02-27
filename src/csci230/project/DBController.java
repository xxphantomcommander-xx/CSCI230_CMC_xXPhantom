package csci230.project;

import java.util.List;

/**
 * This class accesses the raw information from the database
 * can remove and save new users and schools to database
 * @author zheinen001
 * @version 2/24/19
 */
public class DBController {
	private static final University University = null;
	private static final User User = null;
	/*
	 * saves the a new school to the database
	 * @param school
	 */
	public void saveUniversities()
	{
		
	}
	/*
	 * gets a university from the database
	 * @param schoolName
	 */
	public University getUniversity(String schoolName)
	{
		return University;
	}
	/*
	 * gets a user from the database
	 * @param userName
	 */
	public User getUser(String userName)
	{
		return User;
	}
	/*
	 * searches for schools based on the given criteria
	 * @param sch
	 * @param st
	 * @param l
	 * @param c
	 * @param nStu
	 * @param perctF
	 * @param sv
	 * @param sm
	 * @param e
	 * @param perctFin
	 * @param nApp
	 * @param perctA
	 * @param perctE
	 * @param as
	 * @param ss
	 * @param q
	 * @param emp)
	 */
	public void searchSchools(String sch, String st, String l, String c, int nStu, int perctF, int sv, int sm, int e, int perctFin, int nApp, int perctA, int perctE, int as, int ss, int q, String emp)
	{
		
	}
	/*
	 * gets alist of saved schools for
	 * a specific user from the databaase
	 * @param nonAdminUser
	 */
	public List<University> getSavedSchoolList(String nonAdminUser)
	{
		return null;
	}
	/*
	 * removes a school from the database
	 * @param uniName
	 */
	public void removeSchool()
	{
	
	}
	/*
	 * sets a new school to the saved list of schools
	 * for the user
	 * @param schoolName
	 */
	public University setSavedUniversity(String schooName)
	{
		return null;
		
	}
	/*
	 * gets the password for a user when they try to log in
	 */
	public String getPassword()
	{
		return null;
		
	}
	/*
	 * checks to see if a user is logged in
	 * @returns if the user is logged in
	 */
	public boolean isLoggedIn()
	{
		return false;
		
	}
	/*
	 * logs the user into the CMC system and sets
	 * the user info to the system
	 */
	public void logon()
	{
		
	}
	/*
	 * saves a new user to the database
	 * @param user
	 */
	public void saveUser(User user)
	{
		
	}
	/*
	 * selects a new school of the week
	 * @param school
	 */
	public void selectNewSchoolOfTheWeek(University school)
	{
		
	}
	/*
	 * checks to see if there is a school of the week saved
	 */
	public boolean schoolOfTheWeekSaved()
	{
		return false;
	}
	/*
	 * saves the new school of the week
	 * @param school
	 */
	public void saveNewSchoolOfTheWeek(University school)
	{
		
	}
	/*
	 * shows all of the details for a speciifed school
	 * @param school
	 */
	public String showUniversityDetails(University school)
	{
		return "";
	}
	/*
	 * checks to see if a user exists when trying to
	 * send a new email by password
	 * @param user
	 */
	public boolean isUser(User user)
	{
		return false;
	}
	/*
	 * finds the school image for a specified school
	 * @param school
	 */
	public void findSchoolImage(University school)
	{
		
	}
	/*
	 * recommends schools based off of another school
	 * @param school
	 */
	public List<University> recommendSchool(University school)
	{
		return null;
	}
	/*
	 * allows the user to view all universities from the 
	 * database
	 */
	public void viewUniversities()
	{
		
	}
	/*
	 * checks to see if the name of the school
	 * actually exists in the database
	 * @param school
	 */
	public boolean checkSchool(University school)
	{
		return false;
	}
	/*
	 * adds a new school to the database
	 * @param sch
	 * @param st
	 * @param l
	 * @param c
	 * @param nStu
	 * @param perctF
	 * @param sv
	 * @param sm
	 * @param e
	 * @param perctFin
	 * @param nApp
	 * @param perctA
	 * @param perctE
	 * @param as
	 * @param ss
	 * @param q
	 * @param emp
	 * @return university
	 */
	public void addUniversity(String sch, String st, String l, String c, int nStu, int perctF, int sv, int sm, int e, int perctFin, int nApp, int perctA, int perctE, int as, int ss, int q, String emp)
	{
	
	}
}
