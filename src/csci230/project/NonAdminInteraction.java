package csci230.project;

import java.util.List;

/**
 * This class is how Non-Admins interact with the system
 * @author zheinen001
 * @version 2/25/19
 */
public class NonAdminInteraction {
	
	
	/**
	 * creates an object
	 */
	public NonAdminInteraction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Logs the user onto the system
	 * @param userName
	 * @param password
	 */
	public void logOn(String userName, String password) {
	
	}
	
	/**
	 * Logs the User out
	 */
	public void logOut() {
		
	}
	
	/**
	 * Resets the user password
	 * @param userName
	 * @param newPassword
	 */
	public void resetPassword(String userName, String newPassword) {
		
	}
	
	/**
	 * Shows the details of the user
	 */
	public void viewMyProfile() {
		
	}
	
	/**
	 * Displays the school's details
	 * @param school
	 */
	public void showSchoolDetails(University school) {
		
	}
	
	/**
	 * Sets the user as the user logged in???? DO WE NEED THIS?
	 * @param user
	 */
	public void setUser(User user) {
		
	}
	
	/**
	 * This edits the User's info in the database
	 * @param first
	 * @param last
	 * @param oldPassword
	 * @param newPassword
	 */
	public void editProfile(String first, String last,
			String oldPassword, String newpassword) {
		
	}
	
	/**
	 * Displays the Universitie's names
	 */
	public void viewUniversities() {
		
	}
	
	/**
	 * sends email to user with new password
	 * @param userName
	 */
	public void resetPasswordByEmail(String userName) {
		
	}
	
	/**
	 * Searches for schools that most match the search
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
	 * @param nApp
	 * @param prcta
	 * @param prcte
	 * @param as
	 * @param ss
	 * @param q
	 * @param emp
	 */
	public void searchSchools(String sch, String st, String l, String c, int nStu,
			int prctf, int sv, int sm, int e, int prctfin, int nApp, int prcta, 
			int prcte, int as, int ss, int q, String emp) {
		NonAdminFunctionalityController NaFC = new NonAdminFunctionalityController();
		NaFC.searchSchools(sch, st, l, c, nStu, prctf, sv, sm, e, prctfin, nApp, prcta, prcte, as, ss, q, emp);
		
	}
	
	/**
	 * Displays saved schools
	 */
	public void viewSavedSchools() {
		
	}
	
	/**
	 * removes saved schools
	 * @param school
	 */
	public void removeSavedSchool(University school) {
		
	}
	
	/**
	 * Displays the search history of the user
	 * @param user
	 */
	public void viewHistory(String user){
		
	}
	
	/**
	 * Sorts the saved schools by state
	 * @param savedSchool
	 */
	public void sortByState(List<University> savedSchool) {
		
	}
	
	/**
	 * Sorts the saved schools by Size
	 * @param savedSchool
	 */
	public void sortBySize(List<University> savedSchool) {
		
	}
	
	/**
	 * Sorts the saved schools by name
	 * @param savedSchool
	 */
	public void sortByName(List<University> savedSchool) {
		
	}
	
	/**
	 * lists 5 recommended Universities
	 * @param school
	 */
	public List<University> recommendSchools(University school){
		return null;
	}
}
