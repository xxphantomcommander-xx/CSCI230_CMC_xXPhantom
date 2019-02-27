package csci230.project;

import java.util.List;

/**
 * This class contains all the functionalities of Non-Admins
 * @author zheinen001
 * @version 2/25/19
 */
public class NonAdminFunctionalityController {
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
	 * This searches a specific school based on the users input
	 * @param sch
	 * @param st
	 * @param l
	 * @param c
	 * @param nStu
	 * @param prctf
	 * @param sv
	 * @param sm
	 * @param e
	 * @param prctfin
	 * @param nAp
	 * @param prcta
	 * @param prcte
	 * @param as
	 * @param ss
	 * @param q
	 * @param emp
	 */
	public void searchSchools(String sch, String st, String l, String c, 
			int nStu, int prctf, int sv, int sm, int e, int prctfin, int nAp, 
			int prcta, int prcte, int as, int ss, int q, String emp) {
		
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
