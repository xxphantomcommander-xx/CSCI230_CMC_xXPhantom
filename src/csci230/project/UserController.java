package csci230.project;

import java.util.ArrayList;
import java.util.List;

/**
 * This class controls how Users objects interact
 * with the system
 * @author andrewbreyen
 * @version 2/27/19
 */

public class UserController {
	private boolean isLoggedIn = false;
	private boolean isAdminLoggedIn = false;
	private DBController dbCon;
	private UniversityController univC;
	private ArrayList<User> users;
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
		dbCon = new DBController();
		univC = new UniversityController();
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
		String [][] users = dbCon.getUsers();
		for (int i = 0; i < users.length; i++)
		{
			if (userName == users[i][2])
			{
				if (password == users[i][3]) 
				{
					if (users[i][5] == "Y")
					{
						if (users[i][4] == "u")
						{
							isLoggedIn = true;
							univC.loadUniversities();
						}
						else
						{
							isAdminLoggedIn = true;
							univC.loadUniversities();
						}
					}
					else
					{
						System.out.println("User status is inactive");
					}
				}
				else
				{
					System.out.println("Username or password is incorrect");
				}
			}
			else
			{
				System.out.println("Username or password is incorrect");
			}
		}
		
	}
	/**
	 * create a 2d list of users
	 */
	public void loadUsers()
	{
		String [][] userString = dbCon.getUsers();
		
		for (int i = 0; i < userString.length; i++)
		{
			if (userString[i][4] == "u")
			{
				NonAdmin temp = new NonAdmin(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				users.add(temp);
			}
			else
			{
				Admin temp = new Admin(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				users.add(temp);
			}

		}
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
	
	  /**
	   *used to check is user is logged in or not
	   *@return boolean
	   */
	  public boolean isLoggedIn() {
		return isLoggedIn;
	    
	  }
	  
	  /**
	   *used to check is user is logged in or not
	   *@return boolean
	   */
	  public boolean isAdminLoggedIn() {
		return isAdminLoggedIn;
	    
	  }
}
