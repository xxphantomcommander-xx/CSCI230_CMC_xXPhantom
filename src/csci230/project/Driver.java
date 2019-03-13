package csci230.project;

import java.util.ArrayList;

/**
 * @author abreyen001
 * @version 3/12/18
 */
public class Driver {

	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("Creating Instances as needed...");
		NonAdminInteraction nai = new NonAdminInteraction();
		AdminInteraction ai = new AdminInteraction();
		UserController uc = new UserController();
		UniversityController univc = new UniversityController();
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0);
		
		
		System.out.println();
		
		System.out.println("******** 1 ********");
		
		System.out.println("Logging in with valid user credentials");
		uc.logOn("juser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with invalid user credentials");
		//TODO Print error message
		System.out.println("1: Incorrect Password");
		uc.logOn("juser", "incorrectPassword");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		System.out.println();
		System.out.println("2: Incorrect Username");
		uc.logOn("jNotAUser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with deactivated user credentials");
		//TODO Print error message: deactivated, not wrong password
		uc.logOn("luser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with valid admin credentials");
		uc.logOn("nadmin", "admin");
		System.out.println(uc.getLoggedOnUser().getUserName());
		System.out.println("IsAdminLoggedIn status: "+uc.isAdminLoggedIn());
		
		System.out.println("******** 1 COMPLETE ********\n\n");
		
		
		
		
		
		
		
		
		System.out.println("******** 2 ********");
		
		System.out.println("View My Profile");
		//This prints the user details for Noreen, as she was the last logged in user. She was successfully logged on in Driver part 1. 
		uc.viewMyProfile(uc.getLoggedOnUser());
	
		
		System.out.println("");
		//If you want to change Noreen back to the default, you will need to change her password in line 39 and the old password (parameter 3 in line 58.)
		System.out.println("Edit Profile");
		System.out.println("!!! CHANGE USER HAS BEEN DEACTIVATED FOR TESTING PURPOSES! !!!\nUncomment lines 66-69 in Driver.java to reactivate change user.");
		//uc.editMyProfile("Noreen", "Admin", "newAdmin", "admin");
		//System.out.println("Updated Profile Details:");
		//uc.viewMyProfile(uc.getLoggedOnUser());
		//System.out.println("");
		
		System.out.println("******** 2 COMPLETE ********\n\n");
		
		
		
		
		
		
		
		System.out.println("******** 3 ********");
		
		
		System.out.println("Search for schools by a combination of state and number of students");
		System.out.println("View Results");
		univc.loadUniversities();
		univc.searchSchools("", "New York", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, al);
		//System.out.println("******** 3 COMPLETE ********\n\n");
		
		
		
		
		
		
		
		System.out.println("");
		
		System.out.println("******** 4 ********");
		
		System.out.println("Find top 5 recommended schools for a given school");
		
		univc.topRecommended(u);
		
		//System.out.println("******** 4 COMPLETE ********\n\n");
		
		
		
		
		
		
		
		
		
		System.out.println("******** 5 ********");
		
		System.out.println("View list of universities");
		//System.out.println("!!!! VIEW LIST OF UNIVERSITIES HAS BEEN DEACTIVATED FOR TESTING PURPOSES !!!! \nTo reactivate, uncomment line 111 in Driver.java");
		//uc.viewUniversities();
		
		System.out.println("******** 5 COMPLETE ********\n\n");
		
		
		
		
		
		
		
		System.out.println("");
		
		System.out.println("******** 6 ********");
		
		System.out.println("View list of users");
		uc.viewUsers();
		
		System.out.println("******** 6 COMPLETE ********");
		
		
		
		
			
    }
	
}
