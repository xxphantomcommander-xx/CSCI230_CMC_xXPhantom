package csci230.project;

import dblibrary.project.csci230.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class accesses the raw information from the database
 * can remove and save new users and schools to database
 * @author zheinen001
 * @version 3/10/19
 */
public class DBController {
	private User loggedOnUser;
	private UniversityController univC;
	private UserController userC;
	

	
	private UniversityDBLibrary univDBlib;
	
	
	/**
	 * Constructor for the database controller
	 */
	public DBController() {
		univDBlib = new UniversityDBLibrary("xxphanto", "csci230");
		//univC = new UniversityController();
		//userC = new UserController();
	}
	
	/**
	 * saves schools to the user's saved universities
	 * @param userName
	 * @param schoolName
	 */
	public void saveUniversities(University school)
	{
		univDBlib.user_saveSchool(loggedOnUser.getUserName(), school.getSchoolName());
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
	 * @return an arrayList of universities saved by the user
	 */
	public ArrayList<University> getSavedSchoolList()
	{
		ArrayList<University> savedUnivs = new ArrayList<University>();
		String [][] usersSavedUnivs = univDBlib.user_getUsernamesWithSavedSchools();
		ArrayList<String> al = new ArrayList<String>();
		User loggedOnUser2 = getLoggedOnUser();
		for(int i = 0; i < usersSavedUnivs.length; i++) {
			
			if(usersSavedUnivs[i][0].equals(loggedOnUser2.getUserName())) {
				University temp = univC.searchSchools(usersSavedUnivs[i][1], "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, al).get(0);
				savedUnivs.add(temp);
			}
		}
		return savedUnivs;
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
	 * @param status
	 */
	public void addUser(User newUser)
	{
		univDBlib.user_addUser(newUser.getFirstName(), newUser.getLastName(), newUser.getUserName(), newUser.getPassword(), newUser.getType());
	}
	
	/**
	 * adds university to database
	 * @param school
	 */
	public void addUniversity(University univ)
	{
	univDBlib.university_addUniversity(univ.getSchoolName(), univ.getState(), univ.getLocation(), univ.getControl(), univ.getNumOfStudents(), 
			univ.getPerFem(), univ.getSatVerbal(), univ.getSatMath(), univ.getExpenses(), univ.getFinancialAid(), univ.getNumOfApps(), univ.getPerAdmitted(), 
			univ.getPerEnrolled(), univ.getAcademicScale(), univ.getSocialScale(), univ.getQualOfLife());
	ArrayList<String> emp = new ArrayList<String>();
	emp = univ.getEmp();
	for(String i:emp) {
		addUnivEmph(univ.getSchoolName(), i);
	}
	loadUniversities();
	
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
	private void addUnivEmph(String school, String emphasis) {
		univDBlib.university_addUniversityEmphasis(school, emphasis);
	}
	
	/**
	 * edits university based on school name to database
	 * @param school
	 */
	public void editUniversity(University univ)
	{
	univDBlib.university_editUniversity(univ.getSchoolName(), univ.getState(), univ.getLocation(), univ.getControl(), univ.getNumOfStudents(), 
			univ.getPerFem(), univ.getSatVerbal(), univ.getSatMath(), univ.getExpenses(), univ.getFinancialAid(), univ.getNumOfApps(), univ.getPerAdmitted(), 
			univ.getPerEnrolled(), univ.getAcademicScale(), univ.getSocialScale(), univ.getQualOfLife());
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
	public void deleteSavedSchool(University school) {
		univDBlib.user_removeSchool(loggedOnUser.getUserName(), school.getSchoolName());
	}
	
	/**
	 * edits the user in the database
	 * @param User
	 */
	public void editUser(User newUser)
	{
		univDBlib.user_editUser(newUser.getUserName(), newUser.getFirstName(), newUser.getLastName(), newUser.getPassword(), newUser.getType(), newUser.getStatus());
	}
	
	/**
	 * create an arraylist of users from the 2d String array
	 * @param username
	 */
	public ArrayList<User> loadUsers(String username)
	{
		String [][] userString = getUsers();
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < userString.length; i++)
		{
			
			//User u = new User(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
			
			if ("u".equals(userString[i][4]))
			{

				NonAdmin temp = new NonAdmin(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				users.add(temp);
				if(username.equals(userString[i][2])) {
					loggedOnUser = temp;
				}
			}
			else
			{
				Admin temp = new Admin(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				users.add(temp);
				if(username.equals(userString[i][2])) {
					loggedOnUser = temp;
				}
			}
	
		}

		return users;
	}
	
	/**
	 * Loads the university into an arraylist
	 * @return An array list of universities
	 */
	public ArrayList<University> loadUniversities() {
		String [][] univData;
	
		ArrayList<University> univ = new ArrayList<University>();
		univData = getUniversities();
	
		/**
		 * Create list of Universities and Store their info into them.
		 */
		for(int i = 0; i < univData.length; i++) {
			
			University temp = new University(univData[i][0], univData[i][1], univData[i][2],univData[i][3], Integer.parseInt(univData[i][4]), Integer.parseInt(univData[i][5]), Integer.parseInt(univData[i][6]),
					Integer.parseInt(univData[i][7]), Integer.parseInt(univData[i][8]), Integer.parseInt(univData[i][9]), Integer.parseInt(univData[i][10]), Integer.parseInt(univData[i][11]),
					Integer.parseInt(univData[i][12]), Integer.parseInt(univData[i][13]), Integer.parseInt(univData[i][14]), Integer.parseInt(univData[i][15]), loadEmp(univData[i][0]), 0);
			univ.add(temp);
			//hey
		}

		
		//System.out.println(univEmp[0][1]);
		return univ;
		
	}
	
	/**
	 * gets all the emps into a single arraylist of strings
	 * @param univName
	 * @return list of emps
	 */
	private ArrayList<String> loadEmp(String univName){
		String [][] univEmp;
		univEmp = getEmphasis();
		ArrayList<String> emp = new ArrayList<String>();
		for(int i = 0; i < univEmp.length; i++) {
			

			
				if(univEmp[i][0].equals(univName)) {
					emp.add(univEmp[i][1]);
			}
				
		}
		return emp;
	}
	
	  /**
	   * gets currently logged on user
	 * @return currently logged on user
	 */
	public User getLoggedOnUser() {
		  return loggedOnUser;
	  
}
}
