package csci230.project;

import java.util.ArrayList;

/**
 * This class is how Admins interact with the system
 * @author zheinen001
 * @version 3/10/19
 */
public class AdminInteraction {
	

	//admin func controller
	AdminFunctionalityController aFC;
	public AdminInteraction() {
		super();
		// TODO Auto-generated constructor stub
		aFC = new AdminFunctionalityController();
	}

	/**
	 * adds User to the database
	 * @param first
	 * @param last
	 * @param username
	 * @param password
	 * @param type
	 * @param status
	 */
	public void addUser(String first, String last,
			String username, String password, char type,
			char status) {
		aFC.addUser(first, last, username, password, type, status);
	}
	
	/**
	 * Logs the user onto the system
	 * @param username
	 * @param password
	 */
	public void logOn(String username, String password) {
		aFC.logOn(username, password);
	}
	
	/**
	 * Logs the User out
	 */
	public void logOut() {
		aFC.logOff();
	}
	
//	/**
//	 * Resets the user password
//	 * @param userName
//	 * @param newPassword
//	 */
//	public void resetPassword(String userName, String newPassword) {
//		aFC.resetPassword(userName, newPassword);
//	}
	
	/**
	 * Adds the school to the database
	 * @param school
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param prctFemale
	 * @param SATVerbal
	 * @param SATMath
	 * @param expenses
	 * @param prctFinancialAid
	 * @param numApplicants
	 * @param prctAccepted
	 * @param prctEnrolled
	 * @param academicScale
	 * @param socialScale
	 * @param qualOfLife
	 * @param emphases
	 */
	public void addSchool(String school, String state, String location, String control, int numStudents, int prctFemale, int SATVerbal, int SATMath, int expenses, int prctFinancialAid, int numApplicants, int prctAccepted, int prctEnrolled, int academicScale, int socialScale, int qualOfLife, ArrayList<String> emphases) {
		aFC.addUniversity(school, state, location, control, numStudents, prctFemale, SATVerbal, SATMath, expenses, prctFinancialAid, numApplicants, prctAccepted, prctEnrolled, academicScale, socialScale, qualOfLife, emphases);
	}
	
	/**
	 * Shows the details of the user
	 * @param user
	 */
	public void showUserDetails(User user) {
		
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
	 * Displays all the User's names and info
	 */
	public ArrayList<User> viewUsers() {
		ArrayList<User> temp = new ArrayList<User>();
		temp = aFC.viewUsers();
		return temp;
//		for(User i:temp) {
//			System.out.println(i.getFirstName() + " " + i.getLastName() + " " + i.getUserName() + " " + i.getPassword() + " " + i.getType() + " " + i.getStatus() + "\n");
//		}
	}
	
	/**
	 * This edits the User's info in the database
	 * @param User
	 */
	public void editUser(User user) {
		
	}
	
	/**
	 * Showcases the school of the week entered by the Admin
	 * @param schoolName
	 */
	public void editSchoolOfTheWeek(String schoolName) {
		
	}
	
	/**
	 * Displays the Universitie's names
	 */
	public void viewUniversities() {
//		ArrayList<String> univName = new ArrayList<String>();
//		univName = aFC.viewUniversities();
		aFC.viewUniversities();
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
	 * views profile
	 */
	public void viewMyProfile() {
//		User temp;
//		temp = aFC.viewMyProfile();
		aFC.viewMyProfile();
		//System.out.println(temp.getFirstName() + "\n" + temp.getLastName() + "\n" + temp.getUserName() + "\n" + temp.getPassword() + "\n" + temp.getType());
		
	}
	public ArrayList<University> searchSchools(String sch, String st, String l, String c, 
			int nStuLow, int nStuHigh, int prctfLow, int prctfHigh, int svLow, int svHigh, int smLow, int smHigh, int eLow, int eHigh, int prctfinLow, int prctfinHigh, int nApLow, int nApHigh,
			int prctaLow, int prctaHigh, int prcteLow, int prcteHigh, int asLow, int asHigh, int ssLow, int ssHigh, int qLow, int qHigh, ArrayList<String> emp)
	{
		return aFC.searchSchools(sch, st, l, c, nStuLow, nStuHigh, prctfLow, prctfHigh, svLow, svHigh, smLow, smHigh, eLow, eHigh, prctfinLow, prctfinHigh, nApLow, nApHigh,
				prctaLow, prctaHigh, prcteLow, prcteHigh, asLow, asHigh, ssLow, ssHigh, qLow, qHigh, emp);
	}
}

