package csci230.project;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class controls how User objects interact
 * with the system
 * @author xXPhantomCommander$Xx
 * @version 3/19/19
 */

public class UserController {
	// boolean to check if the non-admin is logged in
	private boolean isLoggedIn = false;
	// boolean to check if the admin is logged in
	private boolean isAdminLoggedIn = false;
	// an instance of the DBController
	private DBController dbCon;
	// an instance of the UniversityController
	private UniversityController univC;
	
	/**
	 * constructor
	 */
	public UserController() {
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
							return;
						}
						else
						{
							//user type IS admin
							isAdminLoggedIn = true;
							dbCon.loadUniversities();
							dbCon.loadUsers(username);						
							return;
						}
					}
					else
					{
						throw new UnsupportedOperationException("deactivated User");
					}
				}
				else
				{
					throw new UnsupportedOperationException("invalid password");
				}
			}
			else if(i == users.length -1){
				//usernameIS incorrect
				throw new UnsupportedOperationException("invalid username");
			}

		}
		System.out.println("Username or Password is incorrect");
	}
	
	
	
	/**
	 * logs out
	 */
	public void logOut() {
		dbCon.logOut();
		isLoggedIn = false;
		isAdminLoggedIn = false;
		univC.clearHistory();
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
		if(username.contains("@") && username.contains(".")) {
			if(type == 'u' || type == 'a') {
				if(status == 'Y' || status == 'N') {
					User newUser = new User(first, last, username, password, type, status);
					dbCon.addUser(newUser);
				}
				else {
					throw new IllegalArgumentException("Invalid status");
				}
			}
			else {
				throw new IllegalArgumentException("Invalid type");
			}
		}
		else {
			throw new IllegalArgumentException("Invalid Username");
		}
	}
	
	/**
	 * views profile
	 * @return logged on user
	 */
	public User viewMyProfile() {
		return dbCon.getLoggedOnUser();
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
				  return dbCon.getAllUsers();
		  
	  }
	  
	  
	  /**
	   * edits profile
	 * @param first first name to change
	 * @param last last name to change
	 * @param oldPassword old password
	 * @param newPassword new password to change
	 */
	public void editMyProfile(String first, String last, String oldPassword, String newPassword) {
		  
		  if(dbCon.getLoggedOnUser().getPassword().equals(oldPassword)) {  
			  dbCon.getLoggedOnUser().setFirstName(first);
			  dbCon.getLoggedOnUser().setLastName(last);
			  dbCon.getLoggedOnUser().setPassword(newPassword);
			  dbCon.editUser(dbCon.getLoggedOnUser());
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
		  return dbCon.getLoggedOnUser();
	  }
	
	/**
	 * Gets all the details about a specific user
	 * and returns them in an arraylist of strings ready to be printed.
	 * @param user that the user wants to view details about
	 * @return arraylist of strings to be printed for the user
	 */
	public ArrayList<String> showUserDetails(User user){
		if(user != null) {
		ArrayList<String> details = new ArrayList<String>();
		details.add(user.getFirstName());
		details.add(user.getLastName());
		details.add(user.getUserName());
		details.add(user.getPassword());
		details.add(String.valueOf(user.getType()));
		details.add(String.valueOf(user.getStatus()));
		return details;
		}
		else {
			throw new UnsupportedOperationException("user is null");
		}
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
		if(username.contains("@") && username.contains(".")) {
			if(type == 'u' || type == 'a') {
				if(status == 'Y' || status == 'N') {
					User newUser = new User(first, last, username, password, type, status);
					dbCon.editUser(newUser);
				}
				else {
					throw new IllegalArgumentException("Invalid status");
				}
			}
			else {
				throw new IllegalArgumentException("Invalid type");
			}
		}
		else {
			throw new IllegalArgumentException("Invalid Username");
		}
	}
	
	/**
	 * able to view the your saved school's list
	 * @return list of Saved Schools connected to a user
	 */
	public ArrayList<University> viewSavedSchools() {
		return dbCon.getSavedSchoolList();
	}
	
	/**
	 * Remove a school from the saved university list
	 * @param uniName
	 */
	public void removeSavedSchool(University school) {
		dbCon.deleteSavedSchool(school);
	}
	
	
	/**
	 * saves university to the user
	 * @param school
	 */
	public void saveUniversity(University school) {
		dbCon.saveUniversities(school);
	}
	
	/**
	 * deletes a user from the database
	 * @param username
	 */
	public void deleteUser(String username) {
		dbCon.deleteUser(username);
	}
	
	/**
	 * sends email to user with new password
	 * @param userName
	 */
	public void resetPasswordByEmail(String userName) {
		String to = userName;
		String from = "CMCPhantomCommanders";
		String host = "localHost";
		Properties properties=new Properties();  
		properties.setProperty("mail.smtp.host", host);
		Session session=Session.getDefaultInstance(properties);  
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Your Password has been reset: CMC");
			String abc = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijklmnpqrstuvwxyz123456789!@#$%^&*";
			String newPass = "";
			for(int i = 0; i < 8; i++) {
				int n = (int)(abc.length() * Math.random());	// an instance of the DBController
				newPass = newPass + abc.charAt(n);
			}
			for(User i : viewUsers()) {
				if(userName.equals(i.getUserName())) {
					editUser(i.getFirstName(), i.getLastName(), i.getUserName(), newPass, i.getType(), i.getStatus());
				}
			}
			message.setText("Dear User,\n\n Your CMC Password has been reset to: \n" + newPass+"\n\nPlease log in with this new password and change it.\n\nThanks,\nxXPhantomCommander$Xx");
			
			Transport.send(message);
			}catch(MessagingException mex) {
				mex.printStackTrace();}
	}
	
    /**
     * deactivates a user
	 * @param String userName
	 */
	public void deactivateUser(String userName) {
		  ArrayList<User> useList = dbCon.getAllUsers();
		  boolean activated = false;
		  boolean exists = false;
		  for(User i : useList)
		  {
			  if (userName.equals(i.getUserName()))
			  {
				  exists = true;
				  	if (i.getStatus() == 'Y')
				  	{
				  		activated = true;
				  		editUser(i.getFirstName(), i.getLastName(), i.getUserName(), i.getPassword(), i.getType(), 'N');
				  	}
			  }

		  }
			if(activated == false) {
				throw new IllegalArgumentException("User already deactivated");
			}
			if(exists == false) {
				throw new IllegalArgumentException("User doesn't exist");
			}
		  
	  }
	
    /**
     * activates a user
	 * @param String userName
	 */
	public void activateUser(String userName) {
		  ArrayList<User> useList = dbCon.getAllUsers();
		  boolean deactivated = false;
		  boolean exists = false;
		  for(User i : useList)
		  {
			  if (userName.equals(i.getUserName()))
			  {
				  exists = true;
				  	if (i.getStatus() == 'N')
				  	{
				  		deactivated = true;
				  		editUser(i.getFirstName(), i.getLastName(), i.getUserName(), i.getPassword(), i.getType(), 'Y');
				  	}
			  }

		  }
			if(deactivated == false) {
				throw new IllegalArgumentException("User already activated");
			}
			if(exists == false) {
				throw new IllegalArgumentException("User doesn't exist");
			}
		  
	  }
}
