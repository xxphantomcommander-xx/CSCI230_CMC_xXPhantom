package csci230.project;

/**
 * This is a subclass of User Contains info about Admins
 * 
 * @author zheinen001
 * @version 2/26/19
 */
class Admin extends User {
	// first name of user
	protected String firstName;
	// last name of user
	protected String lastName;
	// username of user
	protected String userName;
	// password of user
	protected String password;
	// type of user (admin or non-admin)
	protected boolean type;
	// status of user (active or deactivated)
	protected boolean status;

	public Admin(java.lang.String firstName, java.lang.String lastName, java.lang.String userName,
			java.lang.String password, boolean type, boolean status) {
		super();// IDK IF WE NEED THIS
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.status = status;
	}

	/**
	 * used to check is user is logged in or not
	 * 
	 * @return boolean
	 */
	public boolean isLoggedon() {
		return true;
	}

	/**
	 * logon user
	 */
	public void logon() {

	}

	/**
	 * log user out
	 */
	public void logout() {

	}

	/**
	 * @param userName
	 * @return userName
	 */
	public String findByUserName(String userName) {
		return "";
	}

	/**
	 * shows user details
	 * 
	 * @param user
	 * @return user details
	 */
	public String showUserDetails(User user) {
		return "";
	}
	
	/**
	 * gets the first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * sets the first name
	 * @param first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * gets the last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets the last name
	 * @param last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * gets the userName
	 * @return user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * sets the User name
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * gets the password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * sets the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * gets the Type of user
	 * @return type
	 */
	public boolean isType() {
		return type;
	}

	/**
	 * sets the type of User
	 * @param type
	 */
	public void setType(boolean type) {
		this.type = type;
	}

	/**
	 * gets the status
	 * @return status of user
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * sets the status of the user
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
}
