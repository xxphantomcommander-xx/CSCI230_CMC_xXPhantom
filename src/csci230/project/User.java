package csci230.project;
/**
 * this class will act as a super class for both non-admin and admin users
 * @author: xXPhantomCommander$Xx
 * @version: 3/19/19
 */

public class User {
  //first name of user
  private String firstName;
  //last name of user
  private String lastName;
  //username of user
  private String userName;
  //password of user
  private String password;
  //type of user (admin or non-admin)
  private char type;
  //status of user (active or deactivated)
  private char status;
/**
 * constructor
 * @param firstName
 * @param lastName
 * @param userName
 * @param password
 * @param type
 * @param status
 */
  public User(java.lang.String firstName, java.lang.String lastName, java.lang.String userName,
			java.lang.String password, char type, char status) {
		if(type == 'u' || type == 'a') {
			if(status == 'Y' || status == 'N') {
				if(userName.contains("@") && userName.contains(".")) {
					this.firstName = firstName;
					this.lastName = lastName;
					this.userName = userName;
					this.password = password;
					this.type = type;
					this.status = status;
				}
				else {
					throw new IllegalArgumentException("Invalid Username");
				}
			}
			else {
				throw new IllegalArgumentException("Invalid status");
			}
		}
		else {
			throw new IllegalArgumentException("Invalid type");
		}
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
	return lastName;
    
  }
  
  /**
   *get username
   *@return userName
   */
  public String getUserName() {
	return userName;
    
  }
  
  /**
   *get password
   *@return password
   */
  public String getPassword() {
	return password;
    
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
   *set first name to parameter
   *@param firstName
   */
  public void setFirstName(String firstName) {
	  this.firstName = firstName;
  }
  
  /**
   *set last name to parameter
   *@param lastName
   */
  public void setLastName(String lastName) {
	  this.lastName = lastName;
  }
  
  /**
   *set username to parameter by email
   *@param userName
   */
  public void setuserName(String userName) {
	  this.userName = userName;
  }
  
  /**
   *set password to parameter
   *@param password
   */
  public void setPassword(String newPassword) {
	  this.password = newPassword;
  }
  
  /**
   *set type of profile
   */
  public void setType(char type) {
	  this.type = type;
  }
  
  /**
   *set status of profile
   */
  public void setStatus(char status) {
	  this.status = status;
  }   


}
