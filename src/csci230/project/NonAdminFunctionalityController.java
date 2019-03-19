package csci230.project;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all the functionalities of Non-Admins
 * @author xXPhantomCommander$Xx
 * @version 3/19/19
 */
public class NonAdminFunctionalityController {
	//Controller that controls all universities
	private UniversityController univC;
	
	//Controller that controls all users
	private UserController userC;
	
	/**
	 * Constructor method
	 */
	public NonAdminFunctionalityController() {
		univC = new UniversityController();
		userC = new UserController();
	}

	/**
	 * Logs on the user into the system
	 * @param username
	 * @param password
	 */
	public void logOn(String username, String password) {
		userC.logOn(username, password);
	}
	
	/**
	 * Logs the user out of the program
	 */
	public void logout() {
		userC.logOut();
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
	 * @return University objects that match the search parameters
	 */
	public ArrayList<University> searchSchools(String sch, String st, String l, String c, 
			int nStuLow, int nStuHigh, int prctfLow, int prctfHigh, int svLow, int svHigh, int smLow, int smHigh, int eLow, int eHigh, int prctfinLow, int prctfinHigh, int nApLow, int nApHigh,
			int prctaLow, int prctaHigh, int prcteLow, int prcteHigh, int asLow, int asHigh, int ssLow, int ssHigh, int qLow, int qHigh, ArrayList<String> emp) {
		return this.univC.searchSchools(sch, st, l, c, nStuLow, nStuHigh, prctfLow, prctfHigh, svLow, svHigh, smLow, smHigh, eLow, eHigh, prctfinLow, prctfinHigh, nApLow, nApHigh,
				prctaLow, prctaHigh, prcteLow, prcteHigh, asLow, asHigh, ssLow, ssHigh, qLow, qHigh, emp);
	}
	
	/**
	 * able to view the your saved school's list
	 * @return list of Saved Schools connected to a user
	 */
	public ArrayList<University> viewSavedSchools() {
		return userC.viewSavedSchools();
	}
	
	/**
	 * shows a list of all the universities
	 * @return All university objects
	 */
	public ArrayList<University> viewUniversities(){
		ArrayList<University> univ = new ArrayList<University>();
		univ = univC.viewUniversities();
		return univ;
	}
	
	/**
	 * Remove a school from the saved university list
	 * @param school
	 */
	public void removeSavedSchool(University school) {
		userC.removeSavedSchool(school);
	}
	
	/**
	 * saves university to the user
	 * @param school
	 */
	public void saveUniversity(University school) {
		userC.saveUniversity(school);
	}
	
	/**
	 * Lets the user change their first name, last name, and password
	 * @param first
	 * @param last
	 * @param oldPassword
	 * @param newPassword
	 */
	public void editProfile(String first, String last, String oldPassword, String newPassword) {
		userC.editMyProfile(first, last, oldPassword, newPassword);
	}
	
	/**
	 * lets the user view their profile
	 * @return User object of the user that is currently logged in
	 */
	public User viewMyProfile() {
		User temp = userC.viewMyProfile();
		return temp;
		
	}
	
	/**
	 * generates a random school for non admin to view
	 * @return Random university
	 */
	public University viewRandomSchool() {
		return null;
		
	}

	/**
	 * Resets the password by email if forgotten password
	 * @param username
	 */
	public void resetPasswordByEmail(String username) {
		userC.resetPasswordByEmail(username);
	}
	
	/**
	 * returns the list of recommended schools based on the current school
	 * @param school
	 */
	public ArrayList<University> recommendSchools(University school){
		return univC.topRecommended(school);
		
	}
	
	/**
	 * lists out the saved schools sorted by the state alphabetically
	 * @param savedSchools
	 */
	public void sortByPerEnrolled(List<University> savedSchools) {
		userC.sortByPerEnrolled(savedSchools);
	}
	
	/**
	 * lists out the saved schools sorted by the size
	 * @param savedSchools
	 */
	public void sortBySize(ArrayList<University> savedSchools) {
		userC.sortBySize(savedSchools);
	}
	
	/**
	 * lists out the saved schools sorted by the name alphabetically
	 * @param savedSchools
	 */
	public void sortByExpense (ArrayList<University> savedSchools) {
		userC.sortByExpense(savedSchools);
	}
	
	/**
	 * Displays the school's details
	 * @param school
	 * @return School details
	 */
	public ArrayList<String> showSchoolDetails(University school) {
		
		return univC.showUniversityDetails(school);
	}
	
	/**
	 * generates a random school from the list of universities
	 * @return random University
	 */
	public University randomSchool()
	{
		return univC.randomSchool();
	}
	
	/**
	 * Displays the search history of the user
	 * @param user
	 */
	public ArrayList<University> viewHistory(){
		return univC.viewHistory();
	}
	
	/**
	 * able to view the your saved school's list
	 * @return list of Saved Schools connected to a user
	 */
	public ArrayList<University> viewSortedSavedSchools() {
		return userC.viewSortedSavedSchools();
	}
}
