package csci230.project;

import java.util.ArrayList;
import java.util.List;

/**
 * This class controls how Users objects interact
 * with the system
 * @author andrewbreyen
 * @version 3/10/19
 */

public class UserController {
	private boolean isLoggedIn = false;
	private boolean isAdminLoggedIn = false;
	private DBController dbCon;
	private UniversityController univC;
	private ArrayList<User> users;
	private User loggedOn;
	
	/**
	 * constructor
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
		dbCon = new DBController();
		univC = new UniversityController();
	}
	
	/**
	 * logs on and loads data into the program
	 * @param username
	 */
	public void logOn(String username, String password) {
		String [][] users = dbCon.getUsers();
		for (int i = 0; i < users.length; i++)
		{
			if (username == users[i][2])
			{
				if (password == users[i][3]) 
				{
					if (users[i][5] == "Y")
					{
						if (users[i][4] == "u")
						{
							isLoggedIn = true;
							univC.loadUniversities();
							loadUsers(username);
						}
						else
						{
							isAdminLoggedIn = true;
							univC.loadUniversities();
							loadUsers(username);
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
	 * create an arraylist of users from the 2d String array
	 * @param username
	 */
	public void loadUsers(String username)
	{
		String [][] userString = dbCon.getUsers();
		
		for (int i = 0; i < userString.length; i++)
		{
			if (userString[i][4] == "u")
			{

				NonAdmin temp = new NonAdmin(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				users.add(temp);
				if(userString[i][2] == username) {
					loggedOn = temp;
				}
			}
			else
			{
				Admin temp = new Admin(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				users.add(temp);
				if(userString[i][2] == username) {
					loggedOn = temp;
				}
			}

		}
	}
	
	/**
	 * logs out
	 */
	public void logOut() {
		
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
	 * @return logged on user
	 */
	public User viewMyProfile() {
		  return loggedOn;
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
	  
	  /**
	   * returns an arraylist of users
	   * @return arraylist of users
	   */
	  public ArrayList<User> viewUsers(){
		  return users;
	  }
	  
	  
	  public void editMyProfile(String first, String last, String oldPassword, String newPassword) {
		  
		  if(oldPassword == loggedOn.getPassword()) {  
			  dbCon.editUser(loggedOn.getUserName(), first, last, newPassword, loggedOn.getType(), loggedOn.getStatus());
		  }
	  }
}
