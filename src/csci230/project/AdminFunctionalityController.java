package csci230.project;

import java.util.ArrayList;

/**
 * This class contains all the functionalities of Admins
 * @author zheinen001 and samyoung3
 * @version 3/10/19
 */
public class AdminFunctionalityController {
	
	UniversityController univC;
	UserController userC;
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
	}
	/**
	 * Logs the user out of the system
	 * @param userName
	 * @param password
	 */
	public void logOff() 
	{
		userC.logOut();
	}
	/**
	 * replaces the old password with a new one
	 * @param userName
	 * @param password
	 */
	public void resetPassword(String userName, String newPassword)
	{
		
	}
	/**
	 * Sets the given user as active and logged in
	 * @param user
	 */
	public void setUser(User user)
	{
		
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
	 */
	public ArrayList<University> viewUniversities()
	{
		return univC.viewUniversities();
	}
	/**
	 * Allows the admin to view all users
	 */
	public ArrayList<User> viewUsers()
	{
		return userC.viewUsers();
	}
	/**
	 * Edits the school of the week
	 */
	public void editSchoolOfTheWeek() 
	{
		
	}
	/**
	 * Shows the details of a specific user
	 * @param user
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
	 * shows the logged in User their profile
	 * @return user
	 */
	public void viewMyProfile() {
		userC.viewMyProfile();
	}
	
	public ArrayList<University> searchSchools(String sch, String st, String l, String c, 
			int nStuLow, int nStuHigh, int prctfLow, int prctfHigh, int svLow, int svHigh, int smLow, int smHigh, int eLow, int eHigh, int prctfinLow, int prctfinHigh, int nApLow, int nApHigh,
			int prctaLow, int prctaHigh, int prcteLow, int prcteHigh, int asLow, int asHigh, int ssLow, int ssHigh, int qLow, int qHigh, ArrayList<String> emp)
	{
		 return userC.searchSchools(sch, st, l, c, nStuLow, nStuHigh, prctfLow, prctfHigh, svLow, svHigh, smLow, smHigh, eLow, eHigh, prctfinLow, prctfinHigh, nApLow, nApHigh,
				prctaLow, prctaHigh, prcteLow, prcteHigh, asLow, asHigh, ssLow, ssHigh, qLow, qHigh, emp);
	}
	public ArrayList<String> showSchoolDetails(University school) {
		return univC.showUniversityDetails(school);
	}
}
