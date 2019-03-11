package csci230.project;

import java.util.List;

/**
 * This class contains all the functionalities of Non-Admins
 * @author zheinen001
 * @version 2/25/19
 */
public class NonAdminFunctionalityController {
	private UniversityController univC;
	
	
	public NonAdminFunctionalityController() {
		super();
		// TODO Auto-generated constructor stub
		univC = new UniversityController();
	}

	/**
	 * Logs on the user into the system
	 * @param username
	 * @param password
	 */
	public void logOn(String username, String password) {
		
	}
	
	/**
	 * Logs the user out of the program
	 */
	public void logout() {
		
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
	public void searchSchools(String sch, String st, String l, String c, 
			int nStuLow, int nStuHigh, int prctfLow, int prctfHigh, int svLow, int svHigh, int smLow, int smHigh, int eLow, int eHigh, int prctfinLow, int prctfinHigh, int nApLow, int nApHigh,
			int prctaLow, int prctaHigh, int prcteLow, int prcteHigh, int asLow, int asHigh, int ssLow, int ssHigh, int qLow, int qHigh, String emp) {
		this.univC.searchSchools(sch, st, l, c, nStuLow, nStuHigh, prctfLow, prctfHigh, svLow, svHigh, smLow, smHigh, eLow, eHigh, prctfinLow, prctfinHigh, nApLow, nApHigh,
				prctaLow, prctaHigh, prcteLow, prcteHigh, asLow, asHigh, ssLow, ssHigh, qLow, qHigh, emp);
	}
	
	/**
	 * replaces the old password with a new one
	 * @param username
	 * @param newPassword
	 */
	public void resetPassword(String username, String newPassword) {
		
	}
	
	/**
	 * able to view the your saved school's list
	 */
	public void viewSavedSchools() {
		
	}
	
	/**
	 * Remove a school from the saved university list
	 * @param uniName
	 */
	public void removeSchool(University uniName) {
		
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
		
	}
	
	/**
	 * lets the user view their profile
	 */
	public void viewMyProfile() {
		
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
		
	}
	
	/**
	 * returns the list of recommended schools based on the current school
	 * @param school
	 */
	public List<University> recommendSchools(String school){
		return null;
		
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
}
