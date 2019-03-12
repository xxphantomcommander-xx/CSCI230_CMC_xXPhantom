package csci230.project;


public class Driver {

	
	public static void main(String[] args){
		System.out.println("Creating Instances as needed...");
		NonAdminInteraction nai = new NonAdminInteraction();
		AdminInteraction ai = new AdminInteraction();
		UserController uc = new UserController();
		UniversityController univc = new UniversityController();
		
		
		System.out.println();
		
		System.out.println("******** 1 ********");
		
		System.out.println("Logging in with valid user credentials");
		uc.logOn("juser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with invalid user credentials");
		//TODO Print error message
		uc.logOn("juser", "incorrectPassword");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with deactivated user credentials");
		//TODO Print error message: deactivated, not wrong password
		uc.logOn("luser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with valid admin credentials");
		uc.logOn("nadmin", "admin");
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
		
		System.out.println("******** 3 COMPLETE ********\n\n");
		
		
		
		
		
		
		
		System.out.println("");
		
		System.out.println("******** 4 ********");
		
		System.out.println("Find top 5 recommended schools for a given school");
		
		System.out.println("******** 4 COMPLETE ********\n\n");
		
		
		
		
		
		
		
		
		
		System.out.println("******** 5 ********");
		
		System.out.println("View list of universities");
		uc.viewUniversities();
		
		System.out.println("******** 5 COMPLETE ********\n\n");
		
		
		
		
		
		
		
		System.out.println("");
		
		System.out.println("******** 6 ********");
		
		System.out.println("View list of users");
		uc.viewUsers();
		
		System.out.println("******** 6 COMPLETE ********");
		
		
		
		
			
    }
	
}
