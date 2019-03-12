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
	private ArrayList<User> allUsers;
	private User loggedOnUser;
	
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
			if (username.equals(users[i][2]))
			{
				if (password.equals(users[i][3])) 
				{
					if ("Y".equals(users[i][5])) 
					{
						if ("u".equals(users[i][4]))
						{
							isLoggedIn = true;
							//univC.loadUniversities();
							loadUsers(username);
							return;
						}
						else
						{
							isAdminLoggedIn = true;
							//univC.loadUniversities();
							loadUsers(username);
							return;
						}
					}
					else
					{
						System.out.println("User status is inactive");
					}
				}
				else
				{
					isLoggedIn = false;
					return;
				}
			}
//			else
//			{
//				System.out.println("Username or password is incorrect");
//			}
		}
		
		System.out.println("Username or password is incorrect");
	}
	
	/**
	 * create an arraylist of users from the 2d String array
	 * @param username
	 */
	public ArrayList<User> loadUsers(String username)
	{
		String [][] userString = dbCon.getUsers();
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < userString.length; i++)
		{
			
			//User u = new User(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
			
			if ("u".equals(userString[i][4]))
			{

				NonAdmin temp = new NonAdmin(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				users.add(temp);
				if(username.equals(userString[i][2])) {
					loggedOnUser = temp;
				}
			}
			else
			{
				Admin temp = new Admin(userString[i][0], userString[i][1], userString[i][2], userString[i][3], userString[i][4].charAt(0), userString[i][5].charAt(0));
				users.add(temp);
				if(username.equals(userString[i][2])) {
					loggedOnUser = temp;
				}
			}
	
		}
		allUsers = users;
		return users;
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
	public void viewMyProfile(User user) {
		  String first = user.getFirstName();
		  String last = user.getLastName();
		  String username = user.getUserName();
		  String password = user.getPassword();
		  char type = user.getType();
		  char status = user.getStatus();
		  System.out.println("First Name: "+ first + "\t"+"Last Name: "+ last + "\t"+"Username: "+ username + "\t"+"Password: "+ password + "\t\t"+"Type: "+ type + "\t\t"+"Status: "+ status + "\t");
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
	  public void viewUsers(){
		  if(loggedOnUser.getType() == 'a') {
			  ArrayList<User> users = loadUsers(loggedOnUser.getUserName());
			  for(int i = 0;i < allUsers.size();i++) {
				  System.out.println(users.get(i).getUserName());
			  }
		  }
		  else {
			  System.out.println("Currently logged in user is not an admin");
		  }
		  
	  }
	  
	  
	  public void editMyProfile(String first, String last, String oldPassword, String newPassword) {
		  
		  if(loggedOnUser.getPassword().equals(oldPassword)) {  
			  loggedOnUser.setFirstName(first);
			  loggedOnUser.setLastName(last);
			  loggedOnUser.setPassword(newPassword);
			  dbCon.editUser(loggedOnUser.getUserName(), first, last, newPassword, loggedOnUser.getType(), loggedOnUser.getStatus());
		  }
		  else {
			  System.out.println("Incorrect Password. Nothing changed!");
		  }
	  }
	  
	  public User getLoggedOnUser() {
		  return loggedOnUser;
	  }
	  
	  public void viewUniversities(){
			if(getLoggedOnUser().getType() == 'a') {
				ArrayList<University> univNames = univC.loadUniversities();
				for (int i = 0 ; i < univC.getAllUnivs().size() ; i++)
				{
					System.out.println(univNames.get(i).getSchoolName());
				}
				
			  }
			  else {
				  System.out.println("Currently logged in user is not an admin");
			  }
			
			
		}
}
