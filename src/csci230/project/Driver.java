package csci230.project;

import java.util.ArrayList;

/**
 * @author abreyen001
 * @version 3/12/18
 */
public class Driver {

	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException{
		System.out.println("Creating Instances as needed...");
		NonAdminInteraction nai = new NonAdminInteraction();
		AdminInteraction ai = new AdminInteraction();
		UserController uc = new UserController();
		//UniversityController univc = new UniversityController();
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();
		DBController dbCon = new DBController();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		//University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0);
		
		
		System.out.println();
		
		System.out.println("******** 1 ********");
		
		System.out.println("Logging in with valid user credentials");
		uc.logOn("juser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with invalid user credentials");
		//TODO Print error message
		System.out.println("Test 1: User with Incorrect Password");
		uc.logOn("juser", "incorrectPassword");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		System.out.println();
		
		System.out.println("Test 2: User with Incorrect Username, Correct Password");
		uc.logOn("jNotAUser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		System.out.println();
		
		System.out.println("Test 3: User with Incorrect Username and Incorrect Password");
		uc.logOn("jNotAUser", "incorrectPassword");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with deactivated user credentials");
		//TODO Print error message: deactivated, not wrong password
		uc.logOn("luser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with valid admin credentials");
		uc.logOn("nadmin", "admin");
		//System.out.println(uc.getLoggedOnUser().getUserName());
		System.out.println("IsAdminLoggedIn status: "+uc.isAdminLoggedIn());
		
		System.out.println("******** 1 COMPLETE ********\n\n");

		
		
		
		System.out.println("******** 2 ********");
		
		System.out.println("View My Profile");
		//This prints the user details for Noreen, as she was the last logged in user. She was successfully logged on in Driver part 1. 
		System.out.println("First Name: "+ uc.viewMyProfile().getFirstName() + "\t"+"Last Name: "+ uc.viewMyProfile().getLastName() + "\t"+"Username: "+ uc.viewMyProfile().getUserName() + "\t"+"Password: "+ uc.viewMyProfile().getPassword() + "\t\t"+"Type: "+ uc.viewMyProfile().getType() + "\t\t"+"Status: "+ uc.viewMyProfile().getStatus() + "\t");
		
		System.out.println("");
		//If you want to change Noreen back to the default, you will need to change her password in line 39 and the old password (parameter 3 in line 58.)
		System.out.println("Edit Profile");
		//System.out.println("!!! CHANGE USER HAS BEEN DEACTIVATED FOR TESTING PURPOSES! !!!\nUncomment lines 66-69 in Driver.java to reactivate change user.");
		uc.editMyProfile("Noreen", "Admin", "newAdmin", "admin");
		System.out.println("Updated Profile Details:");
		System.out.println("First Name: "+ uc.viewMyProfile().getFirstName() + "\t"+"Last Name: "+ uc.viewMyProfile().getLastName() + "\t"+"Username: "+ uc.viewMyProfile().getUserName() + "\t"+"Password: "+ uc.viewMyProfile().getPassword() + "\t\t"+"Type: "+ uc.viewMyProfile().getType() + "\t\t"+"Status: "+ uc.viewMyProfile().getStatus() + "\t");
		System.out.println("");
		
		System.out.println("******** 2 COMPLETE ********\n\n");
		
		
		
		System.out.println("******** 3 ********");
		
		
		System.out.println("Search for schools by a combination of state and number of students");
		System.out.println("View Results");
		ai.logOut();
		uc.logOn("juser", "user");
		dbCon.loadUniversities();
		//name, **state**, location, control, **numOfStudents(low)**, **numOfStudents(high)**, prctFem(low), prctFem(high), SATVerbal(low), SATVerbal(high), SATMath(low), SATMath(high), expenses(low), expenses(high), prctFinAid(low), prctFinAid(low), prctFinAid(high), numOfApps(low), numOfApps(high), prctAdmitted(low), prctAdmitted(high) prctEnrolled(low), prctEnrolled(high), academicsScale(low), academicsScale(high), socialScale(low), socialScale(high), qualOfLife(low), qualOfLife(high), array list of emphasis
		// Searches for New York schools with a size of 15000-35000. Excludes schools that do not meet criteria.
		al.add("");
		al.add("");
		al.add("");
		al.add("");
		al.add("");
		ArrayList<University> results = nai.searchSchools("", "Minnesota", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, al);
		for(University i: results) {
		System.out.println(i.getSchoolName());
	}
		System.out.println("******** 3 COMPLETE ********\n\n");
		
		
		
//		System.out.println("******** 4 ********");
//		
//		System.out.println("Find top 5 recommended schools for a given school");
//		
//		univc.topRecommended(u);
//		
//
//		
//		
//		
//		
//		
//		
//		
//
//		System.out.println("******** 4 COMPLETE ********\n\n");

		
				
		
		System.out.println("******** 5 ********");
		
		System.out.println("View list of universities");
		//System.out.println("!!!! VIEW LIST OF UNIVERSITIES HAS BEEN DEACTIVATED FOR TESTING PURPOSES !!!! \nTo reactivate, uncomment line 111 in Driver.java");
		for(University i : nai.viewUniversities())
		{
		  System.out.println(i.getSchoolName());
		}
		System.out.println("******** 5 COMPLETE ********\n\n");

		
		
		System.out.println("******** 6 ********");
		
		System.out.println("View list of users");
		nai.logOut();
		uc.logOn("nadmin", "admin");
		for(User i : ai.viewUsers()) {
			System.out.println(i.getUserName());
		}
		
		System.out.println("******** 6 COMPLETE ********");
		
		
		
		System.out.println("******** LogOn  *********");
		
		System.out.println("Logging in with valid user credentials");
		uc.logOn("juser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with invalid user credentials");
		//TODO Print error message
		System.out.println("Test 1: User with Incorrect Password");
		uc.logOn("juser", "incorrectPassword");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		System.out.println();
		
		System.out.println("Test 2: User with Incorrect Username, Correct Password");
		uc.logOn("jNotAUser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		System.out.println();
		
		System.out.println("Test 3: User with Incorrect Username and Incorrect Password");
		uc.logOn("jNotAUser", "incorrectPassword");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with deactivated user credentials");
		//TODO Print error message: deactivated, not wrong password
		uc.logOn("luser", "user");
		System.out.println("IsLoggedIn status: "+uc.isLoggedIn());
		
		System.out.println("");
		
		System.out.println("Logging in with valid admin credentials");
		uc.logOn("nadmin", "admin");
		//System.out.println(uc.getLoggedOnUser().getUserName());
		System.out.println("IsAdminLoggedIn status: "+uc.isAdminLoggedIn());
		
		System.out.println("******** LogOn Complete!!! ********\n\n");

		
		
		System.out.println("********** ADMIN Functionalities **********\n\n");
		
		System.out.println("********** AddUser ***********\n");
		
		System.out.println("adding Gavin as a nonAdmin");
		ai.addUser("Gavin", "Wollenberg", "GWOLLENBE001@csbsju.edu", "ww2", 'u', 'Y');
		
		System.out.println("adding Zach as an Admin");
		ai.addUser("Zachary", "Heinen", "ZHEINEN001@csbsju.edu", "zaciscool", 'a', 'Y');
		
		System.out.println("********** AddUser Complete!!! ***********\n\n");
		
		System.out.println("********** ViewUsers ***********\n");
		
		ArrayList<User> users = ai.viewUsers();
		for(User i : users) {
			System.out.println("First Name: " + i.getFirstName());
			System.out.println("Last Name: " + i.getLastName());
			System.out.println("Username: " + i.getUserName());
			System.out.println("Password: " + i.getPassword());
			System.out.println("Type: " + i.getType());
			System.out.println("Status: " + i.getStatus());
			System.out.println();
		}
		
		System.out.println("********** ViewUsers Complete!!! ***********\n\n");
		
		System.out.println("********** University Funtionalities ***********\n");
		
		System.out.println("*********** Viewing University & view university details ***********\n");
		
		ArrayList<University> printUniv = new ArrayList<University>();
		printUniv = ai.viewUniversities();
		for(University i:printUniv) {
			for(String x:ai.showSchoolDetails(i)) {
				System.out.print(x + ", ");
			}
			System.out.println();
		}
		
		System.out.println("************ Adding University of Zac ************\n");
		
		ArrayList<String> newUnivEmp = new ArrayList<String>();	
		newUnivEmp.add("COMPUTER SCIENCE");
		newUnivEmp.add("BIOLOGY");
		
		ai.addSchool("Zach", "Minnesota", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, newUnivEmp);
		ai.addSchool("Zach2", "Minnesota", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, newUnivEmp);
		printUniv = ai.viewUniversities();
		for(University i:printUniv) {
			for(String x:ai.showSchoolDetails(i)) {
				System.out.print(x + ", ");
			}
			System.out.println();
		}
		
		
		System.out.println("*********** Edit University **********\n");
		
		newUnivEmp.add("Hispanic studies");
		System.out.println("Changes made to university of zac changed to urban, public, number of students = 1, 0% female, and added Hispanic studies emphasis\n");
		ai.editSchool("Zach", "Minnesota", "Urban", "Public", 1, 0, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, newUnivEmp);
		for(University i:printUniv) {
			for(String x:ai.showSchoolDetails(i)) {
				System.out.print(x + ", ");
			}
			System.out.println();
		}
		
		System.out.println("*********** Remove University **********\n");
		
		System.out.println("Zach removed\n");
		University removeZac = new University("Zach", "Minnesota", "Urban", "Public", 1, 0, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, newUnivEmp, 0);
		ai.removeUniversity(removeZac);
		for(University i:printUniv) {
			for(String x:ai.showSchoolDetails(i)) {
				System.out.print(x + ", ");
			}
			System.out.println();
		}
		System.out.println("********** University Functionalities Complete!!! *************\n\n");
    
	}
}
