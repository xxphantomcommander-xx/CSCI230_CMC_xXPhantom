package csci230.project;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all the functionalities of Non-Admins
 * @author zheinen001
 * @version 3/10/19
 */
public class NonAdminFunctionalityController {
	private UniversityController univC;
	private UserController userC;
	
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
	 */
	public ArrayList<University> viewUniversities(){
		ArrayList<University> univ = new ArrayList<University>();
		univ = univC.viewUniversities();
		return univ;
	}
	
	/**
	 * Remove a school from the saved university list
	 * @param uniName
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
	 * sets user as active
	 * @param user
	 */
	public void setUser(User user) {
		
	}
	
	/**
	 * Lets the user change their first, last and password
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
	 */
	public User viewMyProfile() {
		User temp = userC.viewMyProfile();
		return temp;
		
	}
	
	/**
	 * generates a random school for non admin to view
	 */
	public University viewRandomSchool() {
		return null;
		
	}
	
	/**
	 * returns the random university
	 * @param randomSchool
	 */
	public String returnUniversity(String randomSchool) {
		return "";
		
	}
	
	/**
	 * views more school info on the specific school
	 * @param school
	 */
	public void viewMoreSchoolInfo(String school) {
		
	}
	
	/**
	 * Returns the info to the user
	 */
	public String returnSchoolInfo() {
		return null;
		
	}
	
	/**
	 * displays the school image for the specific school
	 * @param school
	 */
	public void displaySchoolImage(String school) {
		
	}
	
	/**
	 * Resets the password by email if forgotten password
	 * @param username
	 */
	public void resetPasswordByEmail(String username) {
		//TODO finish this additional functionality
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
	public void sortByState(List<University> savedSchools) {
		
	}
	/**
	 * lists out the saved schools sorted by the size
	 * @param savedSchools
	 */
	public void sortBySize(List<University> savedSchools) {
		
	}
	/**
	 * lists out the saved schools sorted by the name alphabetically
	 * @param savedSchools
	 */
	public void sortByName(List<University> savedSchools) {
		
	}
	/**
	 * Displays the school's details
	 * @param school
	 */
	public ArrayList<String> showSchoolDetails(University school) {
		
		return univC.showUniversityDetails(school);
	}
}
