package csci230.project;

import dblibrary.project.csci230.*;
import java.util.ArrayList;

/**
 * This class accesses the raw information from the database
 * can remove and save new users and schools to database
 * @author xXPhantomCommander$Xx
 * @version 3/19/19
 */
public class DBController {
	// a variable to set who the logged on user is
	private User loggedOnUser;
	// an arraylist of users
	private ArrayList<User> allUsers = new ArrayList<User>();
	

	
	private UniversityDBLibrary univDBlib;
	
	
	/**
	 * Constructor for the database controller
	 */
	public DBController() {
		univDBlib = new UniversityDBLibrary("xxphanto", "csci230");
	}
	
	/**
	 * saves schools to the user's saved universities
	 * @param userName
	 * @param schoolName
	 */
	public void saveUniversities(University school)
	{
		univDBlib.user_saveSchool(loggedOnUser.getUserName(), school.getSchoolName().toUpperCase());
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

	/*
	 * gets a list of saved schools for
	 * a specific user from the database
	 * @return an arrayList of universities saved by the user
	 */
	public ArrayList<University> getSavedSchoolList()
	{
		ArrayList<University> savedUnivs = new ArrayList<University>();
		String [][] usersSavedUnivs = univDBlib.user_getUsernamesWithSavedSchools();
		ArrayList<String> al = new ArrayList<String>();
		al.add("");
		al.add("");
		al.add("");
		al.add("");
		al.add("");
		User loggedOnUser2 = getLoggedOnUser();
		for(int i = 0; i < usersSavedUnivs.length; i++) {
			
			if(usersSavedUnivs[i][0].equals(loggedOnUser2.getUserName())) {
				ArrayList<University> temp = new ArrayList<University>();
				NonAdminFunctionalityController nai = new NonAdminFunctionalityController();
				temp = nai.searchSchools(usersSavedUnivs[i][1], "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, al);
				savedUnivs.add(temp.get(0));
				
			}
			else {
				throw new IllegalArgumentException("Logged on user doesn't have any save schools");
			}
		}
		return savedUnivs;
	}
	
	/**
	 * gets the username with a school parameter
	 * @param SchoolName
	 * @return username
	 */
	public ArrayList<String> getUsernameBySavedSchool(String SchoolName){
		ArrayList<String> usernames = new ArrayList<String>();
		String [][] usersSavedUnivs = univDBlib.user_getUsernamesWithSavedSchools();
		
		for(int i = 0; i < usersSavedUnivs.length; i++) {
			
			if(usersSavedUnivs[i][1].equals(SchoolName)) {
				usernames.add(usersSavedUnivs[i][0]);
			}
			else
			{
				throw new IllegalArgumentException("School name not found");
			}
		}
		return usernames;
	}
	
	/*
	 * removes a school from the database
	 * @param uniName
	 */
	public void removeSchool(University univ)
	{
		boolean removed = false;
		ArrayList<University> univs = loadUniversities();
		for (University i : univs) {
			if (i.equals(univ)) {
				for (String j:univ.getEmp()) {
					removeUnivEmph(univ.getSchoolName().toUpperCase(), j.toUpperCase());
				}

				univDBlib.university_deleteUniversity(univ.getSchoolName().toUpperCase());
				removed = true;
				loadUniversities();
			}
		}
		if (removed = false) {
			throw new IllegalArgumentException("Cannot remove a school that doesn't exist in database");
		}
	}
	
	/**
	 * adds a user to the database
	 * @param status
	 */
	public void addUser(User newUser)
	{
		ArrayList<User> users = loadUsers(loggedOnUser.getUserName());
		for (User i : users) {
			if (i.getUserName().equals(newUser.getUserName())) {
				throw new IllegalArgumentException("User already exists");
			}
		}
		univDBlib.user_addUser(newUser.getFirstName(), newUser.getLastName(), newUser.getUserName(), newUser.getPassword(), newUser.getType());
	}
	
	/**
	 * adds university to database
	 * @param school
	 */
	public void addUniversity(University univ)
	{
	ArrayList<University> univs = loadUniversities();
	for (University i : univs) {
		if (i.getSchoolName().equals(univ.getSchoolName())) {
			throw new IllegalArgumentException("University already exists");
		}
	}
	univDBlib.university_addUniversity(univ.getSchoolName().toUpperCase(), univ.getState().toUpperCase(), univ.getLocation().toUpperCase(), univ.getControl().toUpperCase(), univ.getNumOfStudents(), 
			univ.getPerFem(), univ.getSatVerbal(), univ.getSatMath(), univ.getExpenses(), univ.getFinancialAid(), univ.getNumOfApps(), univ.getPerAdmitted(), 
			univ.getPerEnrolled(), univ.getAcademicScale(), univ.getSocialScale(), univ.getQualOfLife());
	ArrayList<String> emp = new ArrayList<String>();
	emp = univ.getEmp();
	for(String i:emp) {
		addUnivEmph(univ.getSchoolName(), i.toUpperCase());
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
	univDBlib.university_editUniversity(univ.getSchoolName().toUpperCase(), univ.getState().toUpperCase(), univ.getLocation().toUpperCase(), univ.getControl().toUpperCase(), univ.getNumOfStudents(), 
			univ.getPerFem(), univ.getSatVerbal(), univ.getSatMath(), univ.getExpenses(), univ.getFinancialAid(), univ.getNumOfApps(), univ.getPerAdmitted(), 
			univ.getPerEnrolled(), univ.getAcademicScale(), univ.getSocialScale(), univ.getQualOfLife());
	loadUniversities();
	}
	
	/**
	 * removes emphasis from a university
	 * @param school
	 * @param emphasis
	 */
	private void removeUnivEmph(String school, String emphasis) {
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
		//ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < userString.length; i++)
		{
			
			//User u = new User(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
			
			if ("u".equals(userString[i][4]))
			{

				User temp = new User(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				this.allUsers.add(temp);
				if(username.equals(userString[i][2])) {
					loggedOnUser = this.allUsers.get(i);
				}
			}
			else
			{
				User temp2 = new User(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				this.allUsers.add(temp2);
				if(username.equals(userString[i][2])) {
					loggedOnUser = this.allUsers.get(i);
				}
			}
	
		}
		return this.allUsers;
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
					Integer.parseInt(univData[i][12]), Integer.parseInt(univData[i][13]), Integer.parseInt(univData[i][14]), Integer.parseInt(univData[i][15]), loadEmp(univData[i][0]), 0, 0, 0);
			univ.add(temp);
		}

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
	
	/**
	 * gets all users from the database and puts them in an arraylist of users
	 * @return arraylist of all users
	 */
	public ArrayList<User> getAllUsers()
	{
		String [][] userString = getUsers();
		this.allUsers.clear();
		for (int i = 0; i < userString.length; i++)
		{
				User temp = new User(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				this.allUsers.add(temp);	
		}
		return this.allUsers;
	}
	
	/**
	 * logs out user
	 */
	public void logOut()
	{
		loggedOnUser = null;
	}
}
