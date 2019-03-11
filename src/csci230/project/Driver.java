package csci230.project;

import java.io.*;
import java.util.*;


public class Driver {

	
	public static void main(String[] args){
		//System.out.println("Creating Instances...");
		NonAdminInteraction nai = new NonAdminInteraction();
		AdminInteraction ai = new AdminInteraction();
		UserController uc = new UserController();
		
		//uc.loadUsers("juser");
		System.out.println(uc.viewUsers());
	
		System.out.println("*** 1 ***");
		System.out.println("Logging in with valid user credentials");
		nai.logOn("juser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with invalid user credentials");
		nai.logOn("juser", "incorrectPassword");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with deactivated user credentials");
		nai.logOn("luser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with valid admin credentials");
		nai.logOn("nadmin", "admin");
		System.out.println("IsLoggedIn status: "+uc.isAdminLoggedIn());
		
		System.out.println("");
		
		System.out.println("*** 2 ***");
		System.out.println("View Profile");
		
		System.out.println("");
		
		System.out.println("Edit Profile");
		
		System.out.println("");
		System.out.println("*** 3 ***");
		System.out.println("Search for schools by a combination of state and number of students");
		System.out.println("View Results");
		
		System.out.println("");
		System.out.println("*** 4 ***");
		System.out.println("Find top 5 recommended schools for a given school");
		
		System.out.println("");
		System.out.println("*** 5 ***");
		System.out.println("View list of universities");
		
		System.out.println("");
		System.out.println("*** 6 ***");
		System.out.println("View list of users");
		
		
		
			
    }
	
}
