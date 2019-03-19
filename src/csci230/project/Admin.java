package csci230.project;

/**
 * This is a subclass of User Contains info about Admins
 * 
 * @author xXPhantomCommander$Xx
 * @version 3/19/19
 */
class Admin extends User {


	/**
	 * constructor
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param type
	 * @param status
	 */
	public Admin(java.lang.String firstName, java.lang.String lastName, java.lang.String userName,
			java.lang.String password, char type, char status) {
		super(firstName, lastName, userName, password, type, status); //IDK IF WE NEED THIS
		
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
	
	

	
}
