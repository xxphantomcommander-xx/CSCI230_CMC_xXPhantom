package csci230.project;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is how Non-Admins interact with the system
 * @author zheinen001
 * @version 3/10/19
 */
public class NonAdminInteraction {
	
	NonAdminFunctionalityController nAFC;
	/**
	 * creates an object
	 */
	public NonAdminInteraction() {

		nAFC = new NonAdminFunctionalityController();
	}

	/**
	 * Logs the user onto the system
	 * @param userName
	 * @param password
	 */
	public void logOn(String username, String password) {
		nAFC.logOn(username, password);
	}
	
	/**
	 * Logs the User out
	 */
	public void logOut() {
		nAFC.logout();
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
	public User viewMyProfile() {
		User temp;
		temp = nAFC.viewMyProfile();
		return temp;
		//System.out.println(temp.getFirstName() + "\n" + temp.getLastName() + "\n" + temp.getUserName() + "\n" + temp.getPassword() + "\n" + temp.getType());
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
	public void editProfile(String first, String last,String oldPassword, String newPassword) {
		nAFC.editProfile(first, last, oldPassword, newPassword);
	}
	
	/**
	 * Displays the Universitie's names
	 */
	public ArrayList<University> viewUniversities() {
		ArrayList<University> univName = new ArrayList<University>();
		univName = nAFC.viewUniversities();
		return univName;
//		for(String i:univName) {
//			System.out.println(i + "\n");
//		}
	}
	
	/**
	 * sends email to user with new password
	 * @param userName
	 */
	public void resetPasswordByEmail(String userName) {
		
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
		 return this.nAFC.searchSchools(sch, st, l, c, nStuLow, nStuHigh, prctfLow, prctfHigh, svLow, svHigh, smLow, smHigh, eLow, eHigh, prctfinLow, prctfinHigh, nApLow, nApHigh,
				prctaLow, prctaHigh, prcteLow, prcteHigh, asLow, asHigh, ssLow, ssHigh, qLow, qHigh, emp);
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
