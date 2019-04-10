package csci230.project;

import java.util.ArrayList;

/**
 * This class contains all the functionalities of Admins
 * @author xXPhantomCommander$Xx
 * @version 3/19/19
 */
public class AdminFunctionalityController {
	
	//controller for all universities
	UniversityController univC;
	
	//controller for all users
	UserController userC;
	private boolean isAdminLoggedIn = false;
	
	/**
	 * constructor method
	 */
	public AdminFunctionalityController() {
		univC = new UniversityController();
		userC = new UserController();
	}
	
	/**
	 * Logs the admin into the system
	 * @param username
	 * @param password
	 */
	public void logOn(String username, String password)
	{
		userC.logOn(username, password);
		isAdminLoggedIn = true;
	}
	
	public boolean getIsAdminLoggedIn()
	{
		return isAdminLoggedIn;
	}
	
	/**
	 * Logs the user out of the system
	 * @param userName
	 * @param password
	 */
	public void logOff() 
	{
		userC.logOut();
		isAdminLoggedIn = false;
	}

	/**
	 * Adds a new user to the database
	 * @param first
	 * @param last
	 * @param username
	 * @param password
	 * @param type
	 * @param status
	 */
	public void addUser(String first, String last, String username, String password, char type, char status)
	{
		userC.addUser(first, last, username, password, type, status);
	}
	
	/**
	 * Edits a user in the database
	 * @param first
	 * @param last
	 * @param username
	 * @param password
	 * @param type
	 * @param status
	 */
	public void editUser(String first, String last, String username, String password, char type, char status)
	{
		userC.editUser(first, last, username, password, type, status);
	}
	
	/**
	 * Allows the admin to view all universities
	 * @return an array list of universities 
	 */
	public ArrayList<University> viewUniversities()
	{
		return univC.viewUniversities();
	}
	
	/**
	 * Allows the admin to view all users
	 * @return an array list of users
	 */
	public ArrayList<User> viewUsers()
	{
		return userC.viewUsers();
	}
	
	/**
	 * Shows the details of a specific user
	 * @param user
	 * @return an array list string of user details
	 */
	public ArrayList<String> showUserDetails(User user)
	{
		return userC.showUserDetails(user);
	}
	
	/**
	 * Creates a new university and adds it to the database
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
	 * @param emphasis
	 */
	public void addUniversity(String school, String state, String location, String control, 
			int numStudents, int perFem, int satVerbal, int satMath,
			int expenses, int financialAid, int numOfApps, int perAdmitted, 
			int perEnrolled, int academicScale, int socialScale, 
			int qualOfLife, ArrayList<String> emphasis)
	{
		univC.addUniversity(school, state, location, control, numStudents, perFem, satVerbal, satMath, expenses, financialAid, numOfApps, perAdmitted, perEnrolled, academicScale, socialScale, qualOfLife, emphasis);
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
		 this.univC.editSchool(school, state, location, control, numStudents, perFem, satVerbal, satMath, expenses, financialAid, numOfApps, perAdmitted, perEnrolled, academicScale, socialScale, qualOfLife, emphasis);
	}
	/**
	 * shows the logged in User their profile
	 * @return user
	 */
	public User viewMyProfile() {
		return userC.viewMyProfile();
	}
	
	/**
	 * shows the school details
	 * @param school
	 * @return an array list of string school details
	 */
	public ArrayList<String> showSchoolDetails(University school) {
		return univC.showUniversityDetails(school);
	}
	
	/**
	 * removes a university from the list of schools on the database
	 * @param univ
	 */
	public void removeUniversity(University univ) {
		univC.removeUniversity(univ);
	}
	
	/**
	 * deletes a user from the database
	 * @param username
	 */
	public void deleteUser(String username) {
		userC.deleteUser(username);
	}
	
	/**
	 * sets the school of the week
	 * @param schoolName
	 */
	public void setSchoolOfTheWeek(String schoolName)
	{
		univC.setSchoolOfTheWeek(schoolName);
	}
	
	/**
	 * gets the school of the week
	 * @return school of the week
	 */
	public University getSchoolOfTheWeek()
	{
		return univC.getSchoolOfTheWeek();
	}
	
	/**
	 * sends email to user with new password
	 * @param userName
	 */
	public void resetPasswordByEmail(String userName) {
	userC.resetPasswordByEmail(userName);
	}
	
	/**
     * deactivates a user
	 * @param User user
	 */
	public void deactivateUser(String userName)
	{
		userC.deactivateUser(userName);
	}
	
	/**
     * activates a user
	 * @param User user
	 */
	public void activateUser(String userName)
	{
		userC.activateUser(userName);
	}
	

	
}
