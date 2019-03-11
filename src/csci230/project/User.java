package csci230.project;
/**
 * this class will act as a super class for both non-admin and admin users
 * @author: Gavin Wollenberg
 * @version: 3/10/19
 */

abstract class User {
  //first name of user
  protected String firstName;
  //last name of user
  protected String lastName;
  //username of user
  protected String userName;
  //password of user
  protected String password;
  //type of user (admin or non-admin)
  protected char type;
  //status of user (active or deactivated)
  protected char status;

  public User() {
	// TODO Auto-generated constructor stub
		super(); //IDK IF WE NEED THIS
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.status = status;
}
/**
   *get first name
   *@return firstName
   */
  public String getFirstName() {
	return firstName;
    
  }
  
  /**
   *get last name
   *@return lastName
   */
  public String getLastName() {
	return firstName;
    
  }
  
  /**
   *get username
   *@return userName
   */
  public String getUserName() {
	return firstName;
    
  }
  
  /**
   *get password
   *@return password
   */
  public String getPassword() {
	return firstName;
    
  }
  
  /**
   *get type of profile
   *@return firstName
   */
  public char getType() {
	return type;
    
  }
  
  /**
   *get status of profile
   *@return status
   */
  public char getStatus() {
	return status;
    
  }
  

  
  /**
   *logon user
   */
  public void logon() {
    
  }
  
  /**
   *log user out
   */
  public void logout() {
    
  }
  
  /**
   *set first name to parameter
   *@param firstName
   */
  public void setFirstName(String firstName) {
    
  }
  
  /**
   *set last name to parameter
   *@param lastName
   */
  public void setLastName(String firstName) {
    
  }
  
  /**
   *set username to parameter by email
   *@param userName
   */
  public void setuserName(String userName) {
    
  }
  
  /**
   *set password to parameter
   *@param password
   */
  public void setPassword(String newPassword) {
    
  }
  
  /**
   *set type of profile
   */
  public void setType() {
    
  }
  
  /**
   *set status of profile
   */
  public void setStatus() {
    
  }   
  
  /**
   *create new user
   *@param firstName
   *@param LastName
   *@param userName
   *@param password
   *@param type
   *@param status
   */
  public void createUser(String firstName, String lastName, String userName, String password, boolean type, boolean status) {
	  
  }
  /**
   *find another user by username
   *@param userName
   *@return String
   */
  public String findByUserName(String userName) {
	return "";
	  //Fix should return user but creates errors for now
  }

  /**
   *show details of user 
   *@param user
   *@return String 
   */
  public String showDetails(User user) {
	return firstName;
	  
  }
}



















