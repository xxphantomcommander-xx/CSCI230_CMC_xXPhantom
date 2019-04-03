package csci230.project;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is how Non-Admins interact with the system
 * @author xXPhantomCommander$Xx
 * @version 3/19/19
 */
public class NonAdminInteraction {
	//Controller that controls all the functionalities of a nonadmin user
	NonAdminFunctionalityController nAFC;
	
	/**
	 * constructor
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
	 * Shows the details of the user
	 * @return User object of the user that is logged in
	 */
	public User viewMyProfile() {
		User temp;
		temp = nAFC.viewMyProfile();
		return temp;
	}	
	
	/**
	 * Displays the school's details
	 * @param school
	 * @return An array list of school details ready to be printed
	 */
	public ArrayList<String> showSchoolDetails(University school) {
		return nAFC.showSchoolDetails(school);
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
	 * @return University objects
	 */
	public ArrayList<University> viewUniversities() {
		ArrayList<University> univName = new ArrayList<University>();
		univName = nAFC.viewUniversities();
		return univName;
	}
	
	/**
	 * sends email to user with new password
	 * @param username
	 */
	public void resetPasswordByEmail(String username) {
		nAFC.resetPasswordByEmail(username);
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
	 * @return University Objects of universities that match the search parameters
	 */
	public ArrayList<University> searchSchools(String sch, String st, String l, String c, 
			int nStuLow, int nStuHigh, int prctfLow, int prctfHigh, int svLow, int svHigh, int smLow, int smHigh, int eLow, int eHigh, int prctfinLow, int prctfinHigh, int nApLow, int nApHigh,
			int prctaLow, int prctaHigh, int prcteLow, int prcteHigh, int asLow, int asHigh, int ssLow, int ssHigh, int qLow, int qHigh, ArrayList<String> emp) {
		 return this.nAFC.searchSchools(sch, st, l, c, nStuLow, nStuHigh, prctfLow, prctfHigh, svLow, svHigh, smLow, smHigh, eLow, eHigh, prctfinLow, prctfinHigh, nApLow, nApHigh,
				prctaLow, prctaHigh, prcteLow, prcteHigh, asLow, asHigh, ssLow, ssHigh, qLow, qHigh, emp);
	}
	
	/**
	 * Displays saved schools
	 * @return ArrayList of saved universities
	 */
	public ArrayList<University> viewSavedSchools() {
		return nAFC.viewSavedSchools();
	}
	
	/**
	 * removes saved schools
	 * @param school
	 */
	public void removeSavedSchool(University school) {
		nAFC.removeSavedSchool(school);
	}
	
	/**
	 * saves university to the user
	 * @param school
	 */
	public void saveUniversity(University school) {
		nAFC.saveUniversity(school);
	}
	
	/**
	 * Displays the search history of the user
	 * @param user
	 */
	public ArrayList<University> viewHistory(){
		return nAFC.viewHistory();
	}
	
	/**
	 * lists 5 recommended Universities
	 * @param school
	 * @return University objects of recommended schools
	 */
	public ArrayList<University> recommendSchools(University school){
		return nAFC.recommendSchools(school);
	}
	
	/**
	 * generates a random school from the list of universities
	 * @return random University
	 */
	public University randomSchool()
	{
		return nAFC.randomSchool();
	}
}
