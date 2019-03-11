package csci230.project;

import java.util.List;

/**
 * This class contains all the info about Non-Admins
 * @author zheinen001
 * @version 2/24/19
 */
public class NonAdmin extends User{
	
	public NonAdmin(java.lang.String firstName, java.lang.String lastName, java.lang.String userName,
			java.lang.String password, char type, char status) {
		super(firstName, lastName, userName, password, type, status); //IDK IF WE NEED THIS
	
	}
	/**
	 * This method allows the NonAdmin User
	 * to view the details of their profile
	 */
	public void viewMyProfile(User user)
	{
		String first = user.getFirstName();
		String last = user.getLastName();
		String username = user.getUserName();
		String password = user.getPassword();
		char type = user.getType();
		char status = user.getStatus();
		System.out.println("first name = " + first + "\n" + "last name = " + last + "\n" + "userName = " 
		+ username + "\n" + "password = " + password + "\n" + "type = " + type + "\n" + "status = " + status 
		+ "\n");
	}
	
	/**
	 * Allows the NonAdmin to change the name
	 * or password of their profile
	 * @param first
	 * @param last
	 * @param newPassword
	 */
	public void editUser(String first, String last, String newPassword)
	{
		
	}
	/**
	 * Allows the NonAdmin to sort their saved schools
	 * by state
	 * @param savedSchools
	 */
	public void sortByState(List<University> savedSchools)
	{
		
	}
	/**
	 * Allows the NonAdmin to sort their saved schools
	 * by size
	 * @param savedSchools
	 */
	public void sortBySize(List<University> savedSchools)
	{
		
	}
	/**
	 * Allows the NonAdmin to sort their saved schools
	 * by name
	 * @param savedSchools
	 */
	public void sortByName(List<University> savedSchools)
	{
		
	}
	/**
	 * Gets the list of saved schools by the NonAdmin
	 */
	public List<University> getSavedSchools()
	{
		return null;
		
	}
}
