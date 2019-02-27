package csci230.project;
/*this class will act as a super class for both non-admin and admin users
 * 
 * @author: Gavin Wollenberg
 * @version: 2/25/19
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
  protected boolean type;
  //status of user (active or deactivated)
  protected boolean status;
  
  /**
   *get first name
   *@return firstName
   */
  public String getFirstName() {
    
  }
  
  /**
   *get last name
   *@return lastName
   */
  public String getLastName() {
    
  }
  
  /**
   *get username
   *@return userName
   */
  public String getUserName() {
    
  }
  
  /**
   *get password
   *@return password
   */
  public String getPassword() {
    
  }
  
  /**
   *get type of profile
   *@return firstName
   */
  public boolean getType() {
    
  }
  
  /**
   *get status of profile
   *@return status
   */
  public boolean getStatus() {
    
  }
  
  /**
   *used to check is user is logged in or not
   *@return boolean
   */
  public boolean isLoggedon() {
    
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
	  
  }

  /**
   *show details of user 
   *@param user
   *@return String 
   */
  public String (user User) {
	  
  }
}



















