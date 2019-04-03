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
		boolean saved = false;
		boolean exists = false;
		ArrayList<University> univs = loadUniversities();
		for (University i : univs) {
			if (i.getSchoolName().equals(school.getSchoolName())) {
				exists = true;
				ArrayList<University>  savedSchools = getSavedSchoolList();
				for(University j : savedSchools) {
					if(!j.getSchoolName().equals(school.getSchoolName())) {
						univDBlib.user_saveSchool(loggedOnUser.getUserName(), school.getSchoolName().toUpperCase());
						saved = true;
					}
				}
			}
		}
		if(saved == false) {
			throw new IllegalArgumentException("School already saved");
		}
		if(exists == false) {
			throw new IllegalArgumentException("School not in database");
		}
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
		boolean gotSaved = false;
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
				gotSaved = true;
				
			}
		}
		if (gotSaved == false) {
			throw new IllegalArgumentException("Logged on user doesn't have any save schools");
		}
		return savedUnivs;
	}
	
	/**
	 * gets the username with a school parameter
	 * @param SchoolName
	 * @return username
	 */
	public ArrayList<String> getUsernameBySavedSchool(String SchoolName){
		boolean gotUsername = false;
		ArrayList<String> usernames = new ArrayList<String>();
		String [][] usersSavedUnivs = univDBlib.user_getUsernamesWithSavedSchools();
		
		for(int i = 0; i < usersSavedUnivs.length; i++) {
			
			if(usersSavedUnivs[i][1].equals(SchoolName)) {
				usernames.add(usersSavedUnivs[i][0]);
				gotUsername = true;
			}
		}
		if(gotUsername == false)
		{
			throw new IllegalArgumentException("School name not found");
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
		if (removed == false) {
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
		boolean added = false;
		ArrayList<University> univs = loadUniversities();
		for (University i : univs) {
			if (i.getSchoolName().equals(school)) {
				univDBlib.university_addUniversityEmphasis(school, emphasis);
				added = true;
			}
		}
		if (added == false) {
			throw new IllegalArgumentException("School does not exist");
		}
	}
	/**
	 * edits university based on school name to database
	 * @param school
	 */
	public void editUniversity(University univ)
	{
		boolean edited = false;
		ArrayList<University> univs = loadUniversities();
		for (University i : univs) {
			if (i.getSchoolName().equals(univ.getSchoolName())) {
				univDBlib.university_editUniversity(univ.getSchoolName().toUpperCase(), univ.getState().toUpperCase(), univ.getLocation().toUpperCase(), univ.getControl().toUpperCase(), univ.getNumOfStudents(), 
						univ.getPerFem(), univ.getSatVerbal(), univ.getSatMath(), univ.getExpenses(), univ.getFinancialAid(), univ.getNumOfApps(), univ.getPerAdmitted(), 
						univ.getPerEnrolled(), univ.getAcademicScale(), univ.getSocialScale(), univ.getQualOfLife());
						loadUniversities();
						edited = true;
			}
		}
		if (edited == false)
		{
			throw new IllegalArgumentException("University does not exist");
		}
	}
	
	/**
	 * removes emphasis from a university
	 * @param school
	 * @param emphasis
	 */
	private void removeUnivEmph(String school, String emphasis) {
		boolean removed = false;
		ArrayList<University> univs = loadUniversities();
		for (University i : univs) {
			if (i.getSchoolName().equals(school)) {
				univDBlib.university_removeUniversityEmphasis(school, emphasis);
				removed = true;
			}
		}
		if (removed == false)
		{
			throw new IllegalArgumentException("University does not exist");
		}
		
	}
	
	/**
	 * deletes a user from the database
	 * @param username
	 */
	public void deleteUser(String username) {
		boolean deleted = false;
		ArrayList<User> users = loadUsers(loggedOnUser.getUserName());
		for (User i : users) {
			if (i.getUserName().equals(username)) {
				univDBlib.user_deleteUser(username);
				deleted = true;
			}
		}
		if (deleted == false) {
			throw new IllegalArgumentException("User does not exist");
		}
	}
	
	/**
	 * delete saved school from user
	 * @param username
	 * @param school
	 */
	public void deleteSavedSchool(University school) {
		boolean deleted = false;
		ArrayList<University> savedUnivs = getSavedSchoolList();
		for (University i : savedUnivs) {
			if (i.getSchoolName().equals(school.getSchoolName())) {
				univDBlib.user_removeSchool(loggedOnUser.getUserName(), school.getSchoolName());
				deleted = true;
			}
		}
		if (deleted == false) {
			throw new IllegalArgumentException("School not saved by the user");
		}
	}
	
	/**
	 * edits the user in the database
	 * @param User
	 */
	public void editUser(User newUser)
	{
		boolean edited = false;
		ArrayList<User> users = loadUsers(loggedOnUser.getUserName());
		for (User i : users) {
			if (i.getUserName().equals(newUser.getUserName())) {
				univDBlib.user_editUser(newUser.getUserName(), newUser.getFirstName(), newUser.getLastName(), newUser.getPassword(), newUser.getType(), newUser.getStatus());
				edited = true;
			}
		}
		if (edited == false) {
			throw new IllegalArgumentException("User does not exist");
		}
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
		boolean loaded = false;
		ArrayList<University> univs = loadUniversities();
		String [][] univEmp;
		univEmp = getEmphasis();
		ArrayList<String> emp = new ArrayList<String>();
		for (University i : univs) {
			if (i.getSchoolName().equals(univName)) {
				for(int j = 0; j < univEmp.length; j++) {
					if(univEmp[j][0].equals(univName)) {
						emp.add(univEmp[j][1]);
					}	
				}
				loaded = true;
			}
		}
		if (loaded == false)
		{
			throw new IllegalArgumentException("School does not exist");
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
