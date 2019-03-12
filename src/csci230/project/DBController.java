package csci230.project;

import dblibrary.project.csci230.*;
import java.io.*;
import java.util.List;

/**
 * This class accesses the raw information from the database
 * can remove and save new users and schools to database
 * @author zheinen001
 * @version 3/10/19
 */
public class DBController {

	private UniversityDBLibrary univDBlib;
	
	
	/**
	 * Constructor for the database controller
	 */
	public DBController() {
		super();
		univDBlib = new UniversityDBLibrary("xxphanto", "csci230");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * saves schools to the user's saved universities
	 * @param userName
	 * @param schoolName
	 */
	public void saveUniversities(String userName, String schoolName)
	{
		univDBlib.user_saveSchool(userName, schoolName);
	}
	
	/*
	 * gets a user from the database
	 * @param userName
	 * @return 2d array of users
	 */
	public String [][] getUsers()
	{
		return univDBlib.user_getUsers();
	}

	/*e
	 * gets a list of saved schools for
	 * a specific user from the database
	 * @param userName
	 * @return 2d array of saved schools attached to the username along with a timestamp
	 */
	public String [][] getSavedSchoolList(String userName)
	{
		return univDBlib.user_getUsernamesWithSavedSchools();
	}
	
	/*
	 * removes a school from the database
	 * @param uniName
	 */
	public void removeSchool(String uniName)
	{
		univDBlib.university_deleteUniversity(uniName);
	}
	
	/**
	 * adds a user to the database
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param type
	 */
	public void addUser(String firstName, String lastName, String username, String password, char type)
	{
		univDBlib.user_addUser(firstName, lastName, username, password, type);
	}
	
	/**
	 * adds university to database
	 * @param school
	 * @param state
	 * @param location
	 * @param control
	 * @param numberOfStudents
	 * @param percentFemales
	 * @param SATVerbal
	 * @param SATMath
	 * @param expenses
	 * @param percentFinancialAid
	 * @param numberOfApplicants
	 * @param percentAdmitted
	 * @param percentEnrolled
	 * @param academicsScale
	 * @param socialScale
	 * @param qualityOfLifeScale
	 */
	public void addUniversity(String school, String state, String location, String control, int numberOfStudents, 
			int percentFemales, int SATVerbal, int SATMath, int expenses, int percentFinancialAid, int numberOfApplicants, 
			int percentAdmitted, int percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale)
	{
	univDBlib.university_addUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, 
			SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	}
	
	/**
	 * gets the 2d array of universities
	 * @return universities
	 */
	public String[][] getUniversities(){
		return univDBlib.university_getUniversities();
	}
	
	/**
	 * gets a 2d array of the emphasis connected to the university names
	 * @return Emphasis
	 */
	public String [][] getEmphasis(){
		return univDBlib.university_getNamesWithEmphases();
	}
	
	/**
	 * adds emphasis to a university
	 * @param school
	 * @param emphasis
	 */
	public void addUnivEmph(String school, String emphasis) {
		univDBlib.university_addUniversityEmphasis(school, emphasis);
	}
	
	/**
	 * edits university based on school name to database
	 * @param school
	 * @param state
	 * @param location
	 * @param control
	 * @param numberOfStudents
	 * @param percentFemales
	 * @param SATVerbal
	 * @param SATMath
	 * @param expenses
	 * @param percentFinancialAid
	 * @param numberOfApplicants
	 * @param percentAdmitted
	 * @param percentEnrolled
	 * @param academicsScale
	 * @param socialScale
	 * @param qualityOfLifeScale
	 */
	public void editUniversity(String school, String state, String location, String control, int numberOfStudents, 
			int percentFemales, int SATVerbal, int SATMath, int expenses, int percentFinancialAid, int numberOfApplicants, 
			int percentAdmitted, int percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale)
	{
	univDBlib.university_editUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, 
			SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	}
	
	/**
	 * removes emphasis from a university
	 * @param school
	 * @param emphasis
	 */
	public void removeUnivEmph(String school, String emphasis) {
		univDBlib.university_removeUniversityEmphasis(school, emphasis);
	}
	
	/**
	 * deletes a user from the database
	 * @param username
	 */
	public void deleteUser(String username) {
		univDBlib.user_deleteUser(username);
	}
	
	/**
	 * delete saved school from user
	 * @param username
	 * @param school
	 */
	public void deleteSavedSchool(String username, String school) {
		univDBlib.user_removeSchool(username, school);
	}
	
	/**
	 * edits the user in the database
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param type
	 * @param status
	 */
	public int editUser(String username, String firstName, String lastName, String password, char type, char status) {
		int editstatus = univDBlib.user_editUser(username, firstName, lastName, password, type, status);
		return editstatus;
	}
}
