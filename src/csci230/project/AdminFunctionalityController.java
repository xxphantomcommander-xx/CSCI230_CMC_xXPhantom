package csci230.project;

import java.util.ArrayList;

/**
 * This class contains all the functionalities of Admins
 * @author zheinen001 and samyoung3
 * @version 2/25/19
 */
public class AdminFunctionalityController {
	
	UniversityController univC;
	UserController userC;
	public AdminFunctionalityController() {
		super();
		// TODO Auto-generated constructor stub
		univC = new UniversityController();
		userC = new UserController();
	}
	/**
	 * Logs the admin into the system
	 * @param userName
	 * @param password
	 */
	public void logOn(String userName, String password)
	{
		
	}
	/**
	 * Logs the user out of the system
	 * @param userName
	 * @param password
	 */
	public void logOff() 
	{
		
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
	 * @param userName
	 * @param password
	 * @param type
	 * @param status
	 */
	public void addUser(String first, String last, String userName, String password, String type, String status)
	{
		
	}
	/**
	 * Edits a user in the database
	 * @param first
	 * @param last
	 * @param userName
	 * @param password
	 * @param type
	 * @param status
	 */
	public void editUser(String first, String last, String userName, String password, String type, String status)
	{
		
	}
	/**
	 * Allows the admin to view all universities 
	 */
	public ArrayList<String> viewUniversities()
	{
		return univC.viewUniversities();
	}
	/**
	 * Allows the admin to view all users
	 */
	public void viewUsers()
	{
		
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
	public void showUserDetails(User user)
	{
		
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
	public void addUniversity(String school, String state, String location, String control, int numStudents, int prctFemale, int SATVerbal, int SATMath, double expenses, double prctFinancialAid, int numApplicants, int prctAccepted, int prctEnrolled, int academicScale, int socialScale, int qualOfLife, String emphases)
	{
		
	}
}
