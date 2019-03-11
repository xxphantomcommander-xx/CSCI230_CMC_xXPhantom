package csci230.project;

import java.util.List;

/**
 * This class controls how Users objects interact
 * with the system
 * @author andrewbreyen
 * @version 2/27/19
 */

public class UserController {
	
	private DBController dbCon;
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
		dbCon = new DBController();
	}

	/**
	 * sets the first name
	 * @param newFirstName new First Name
	 */
	public void setFirstName(String newFirstName) {
		
	}
	
	/**
	 * sets the last name
	 * @param newLastName new Last Name
	 */
	public void setLastName(String newLastName) {
		
	}
	
	/**
	 * sets a new password
	 * @param newPassword the new password
	 */
	public void setPassword(String newPassword) {
		
	}
	
	/**
	 * logs on
	 * @param userName the username
	 */
	public void logOn(String userName, String password) {
		
	}
	
	/**
	 * logs out
	 */
	public void logOut() {
		
	}
	
	/**
	 * sets the user
	 * @param user the user
	 */
	public void setUser(User user) {
		
	}
	
	/**
	 * adds a user
	 * @param f first name
	 * @param l last name
	 * @param u user name
	 * @param p password
	 * @param t type
	 * @param s status
	 */
	public void addUser(String f, String l, String u, String p, String t, Boolean s) {
		
	}
	
	/**
	 * views profile
	 */
	public void viewMyProfile() {
		
	}
	
	/**
	 * shows user details
	 * @param user User
	 * @return String of user details
	 */
	public String showUserDetails(User user) {
		return null;
		
	}
	
	/**
	 * sorts by state
	 * @param savedSchools saved schools
	 */
	public void sortByState(List<University> savedSchools) {
		
	}
	
	/**
	 * sorts by size
	 * @param savedSchools saved schools
	 */
	public void sortBySize(List<University> savedSchools) {
		
	}
	
	/**
	 * sorts by name
	 * @param savedSchools saved schools
	 */
	public void sortByName(List<University> savedSchools) {
		
	}
}
