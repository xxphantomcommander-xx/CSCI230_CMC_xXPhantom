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
		dbCon = new DBController();
		univC = new UniversityController();
		loggedOnUser = dbCon.getLoggedOnUser();
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
				//username exists
				if (password.equals(users[i][3])) 
				{
					//password IS correct
					if ("Y".equals(users[i][5])) 
					{
						//user status IS active
						if ("u".equals(users[i][4]))
						{
							//user type IS user
							isLoggedIn = true;
							dbCon.loadUniversities();
							dbCon.loadUsers(username);
							loggedOnUser = dbCon.getLoggedOnUser();
							return;
						}
						else
						{
							//user type IS admin
							isAdminLoggedIn = true;
							dbCon.loadUniversities();
							dbCon.loadUsers(username);
							loggedOnUser = dbCon.getLoggedOnUser();
							return;
						}
					}
					else
					{
						//user status IS inactive
//						System.out.println("User status is inactive");
//						return;
					}
				}
				else
				{
					//password IS incorrect
					isLoggedIn = false;
					isAdminLoggedIn = false;
//					System.out.println("Password incorrect.");
//					return;
				}
			}
			
			else {
				//System.out.println(username +" Username incorrect.");
				//return;
			}
		}
		
	}
	
	
	
	/**
	 * logs out
	 */
	public void logOut() {
		loggedOnUser = null;
		return;
	}
	
	
	/**
	 * adds a user
	 * @param first name
	 * @param last name
	 * @param user name
	 * @param password
	 * @param type
	 * @param status
	 */
	public void addUser(String first, String last, String username, String password, char type, char status) {
		User newUser = new User(first, last, username, password, type, status);
		dbCon.addUser(newUser);
	}
	
	/**
	 * views profile
	 * @return logged on user
	 */
	public User viewMyProfile() {
		return loggedOnUser;
//		  String first = loggedOnUser.getFirstName();
//		  String last = loggedOnUser.getLastName();
//		  String username = loggedOnUser.getUserName();
//		  String password = loggedOnUser.getPassword();
//		  char type = loggedOnUser.getType();
//		  char status = loggedOnUser.getStatus();
		  //System.out.println("First Name: "+ first + "\t"+"Last Name: "+ last + "\t"+"Username: "+ username + "\t"+"Password: "+ password + "\t\t"+"Type: "+ type + "\t\t"+"Status: "+ status + "\t");
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
		  if(loggedOnUser.getType() == 'a') {
			  ArrayList<User> users = dbCon.loadUsers(loggedOnUser.getUserName());
				  return users;
			  
		  }
		  else {
			  System.out.println("Currently logged in user is not an admin");
			  return null;
		  }
		  
	  }
	  
	  
	  /**
	   * edits profile
	 * @param first first name to change
	 * @param last last name to change
	 * @param oldPassword old password
	 * @param newPassword new password to change
	 */
	public void editMyProfile(String first, String last, String oldPassword, String newPassword) {
		  
		  if(loggedOnUser.getPassword().equals(oldPassword)) {  
			  loggedOnUser.setFirstName(first);
			  loggedOnUser.setLastName(last);
			  loggedOnUser.setPassword(newPassword);
			  dbCon.editUser(loggedOnUser);
		  }
		  else {
			  System.out.println("Incorrect Password. Nothing changed!");
		  }
	  }
	  
	  /**
	   * gets currently logged on user
	 * @return currently logged on user
	 */
	public User getLoggedOnUser() {
		  return loggedOnUser;
	  }
	  
	  /**
	 * views universities
	 */
	public ArrayList<University> viewUniversities(){
		//THIS IS A MAJOR PROBLEM!!!	
		if(loggedOnUser.getType() == 'a') {
				ArrayList<University> univNames = dbCon.loadUniversities();
				return univNames;
//				for (int i = 0 ; i < univC.getAllUnivs().size() ; i++)
//				{
//					System.out.println(univNames.get(i).getSchoolName());
//				}
				
			  }
			  else {
				  return null;
			  }
			
			
		}
	
	public ArrayList<University> searchSchools(String sch, String st, String l, String c, 
			int nStuLow, int nStuHigh, int prctfLow, int prctfHigh, int svLow, int svHigh, int smLow, int smHigh, int eLow, int eHigh, int prctfinLow, int prctfinHigh, int nApLow, int nApHigh,
			int prctaLow, int prctaHigh, int prcteLow, int prcteHigh, int asLow, int asHigh, int ssLow, int ssHigh, int qLow, int qHigh, ArrayList<String> emp)
	{
		return univC.searchSchools(sch, st, l, c, nStuLow, nStuHigh, prctfLow, prctfHigh, svLow, svHigh, smLow, smHigh, eLow, eHigh, prctfinLow, prctfinHigh, nApLow, nApHigh,
				prctaLow, prctaHigh, prcteLow, prcteHigh, asLow, asHigh, ssLow, ssHigh, qLow, qHigh, emp);
	}
	
	/**
	 * Gets all the details about a specific user
	 * and returns them in an arraylist of strings ready to be printed.
	 * @param user that the user wants to view details about
	 * @return arraylist of strings to be printed for the user
	 */
	public ArrayList<String> showUserDetails(User user){
		ArrayList<String> details = new ArrayList<String>();
		details.add(user.getFirstName());
		details.add(user.getLastName());
		details.add(user.getUserName());
		details.add(user.getPassword());
		details.add(String.valueOf(user.getType()));
		details.add(String.valueOf(user.getStatus()));
		return details;
	}
	
	/**
	 * adds a user
	 * @param first name
	 * @param last name
	 * @param user name
	 * @param password
	 * @param type
	 * @param status
	 */
	public void editUser(String first, String last, String username, String password, char type, char status) {
		User newUser = new User(first, last, username, password, type, status);
		dbCon.editUser(newUser);
	}
}
