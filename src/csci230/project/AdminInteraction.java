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
	
	/**
	 * Constructor
	 */
	public AdminInteraction() {
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
	 * @return user details
	 */
	public ArrayList<String> showUserDetails(User user) {
		
		return aFC.showUserDetails(user);
	}
	
	/**
	 * Displays the school's details
	 * @param school
	 * @return school details
	 */
	public ArrayList<String> showSchoolDetails(University school) {
		return aFC.showSchoolDetails(school);
	}
	
	/**
	 * Displays all the User's names and info
	 * @return user objects
	 */
	public ArrayList<User> viewUsers() {
		return aFC.viewUsers();
	}
	
	/**
	 * This edits the User's info in the database
	 * @param first
	 * @param last
	 * @param username
	 * @param password
	 * @param type
	 * @param status
	 */
	public void editUser(String first, String last,
			String username, String password, char type,
			char status) {
		aFC.editUser(first, last, username, password, type, status);
	}
	
	/**
	 * edits the school using parameters
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
	public void editSchool(String school, String state, String location, String control, 
			int numStudents, int perFem, int satVerbal, int satMath,
			int expenses, int financialAid, int numOfApps, int perAdmitted, 
			int perEnrolled, int academicScale, int socialScale, 
			int qualOfLife, ArrayList<String> emphasis) {
		 this.aFC.editSchool(school, state, location, control, numStudents, perFem, satVerbal, satMath, expenses, financialAid, numOfApps, perAdmitted, perEnrolled, academicScale, socialScale, qualOfLife, emphasis);
	}
	
	/**
	 * Showcases the school of the week entered by the Admin
	 * @param schoolName
	 */
	public void editSchoolOfTheWeek(String schoolName) {
		//TODO finish this additional functionality
	}
	
	/**
	 * Displays the Universitie's names
	 * @return university objects
	 */
	public ArrayList<University> viewUniversities() {
		return aFC.viewUniversities();
		
	}
	
	/**
	 * sends email to user with new password
	 * @param userName
	 */
	public void resetPasswordByEmail(String userName) {
		//TODO finish this additional functionality
	}
	
	
	/**
	 * views profile
	 * @return User object
	 */
	public User viewMyProfile() {

		return aFC.viewMyProfile();
		//System.out.println(temp.getFirstName() + "\n" + temp.getLastName() + "\n" + temp.getUserName() + "\n" + temp.getPassword() + "\n" + temp.getType());
		
	}
	
	/**
	 * removes a university from the list of schools on the database
	 * @param univ
	 */
	public void removeUniversity(University univ) {
		aFC.removeUniversity(univ);
	}

}

