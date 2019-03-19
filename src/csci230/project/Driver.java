package csci230.project;

import java.util.ArrayList;

/**
 * @author xXPhantomCommander$Xx
 * @version 3/19/19
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
		UniversityController univc = new UniversityController();
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("BIOLOGY");
		al2.add("BUSINESS-ADMINISTRATION");
		al2.add("");
		al2.add("");
		al2.add("");
		al.add("");
		al.add("");
		al.add("");
		al.add("");
		al.add("");
		University u = new University("ADELPHI", "NEW YORK", "-1", "PRIVATE", 15000, 70, 500, 475, 37437, 60, 5500, 70, 40, 2, 2, 2, al2, 0, 0, 0);
		
		
		
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
		
		
		
		
		
		System.out.println("*********** User Functionalities for admins ************\n");
		
		System.out.println("********** AddUser ***********\n");
		
		System.out.println("adding Gavin as a nonAdmin");
		ai.addUser("Gavin", "Wollenberg", "GWOLLENBE001@csbsju.edu", "ww2", 'u', 'Y');
		
		System.out.println("adding Zach as an Admin");
		ai.addUser("Zachary", "Heinen", "ZHEINEN001@csbsju.edu", "zaciscool", 'a', 'Y');
		
		System.out.println("********** AddUser Complete!!! ***********\n\n");
		
		System.out.println("********** ViewUsers ***********\n\n");
		ArrayList<User> users2 = ai.viewUsers();
		for(User i : users2) {
			System.out.println("First Name: " + i.getFirstName());
			System.out.println("Last Name: " + i.getLastName());
			System.out.println("Username: " + i.getUserName());
			System.out.println("Password: " + i.getPassword());
			System.out.println("Type: " + i.getType());
			System.out.println("Status: " + i.getStatus());
			System.out.println();
		}
		
		System.out.println("********** ViewUsers Complete!!! ***********\n\n");
		
		System.out.println("*********** resetPassword by Email **********\n");
		ai.resetPasswordByEmail("ABREYEN001@csbsju.edu");
		ArrayList<User> users = ai.viewUsers();
		for(User i : users) {
			System.out.println("Username: " + i.getUserName());
			System.out.println("Password: " + i.getPassword());
			System.out.println();
		}
		
		System.out.println("*********** resetPassword by Email Complete **********\n\n");
		
		
		System.out.println("************* Edit User *************\n");
		
		System.out.println("Changing gavin");
		ai.editUser("Dingus2.0", "Jahoyhoy", "GWOLLENBE001@csbsju.edu", "ww2", 'u', 'Y');
		ai.editUser("Zachary", "Heinen", "ZHEINEN001@csbsju.edu", "zaciscool", 'a', 'Y');
		ArrayList<User> users3 = ai.viewUsers();
		for(User i : users3) {
			System.out.println("First Name: " + i.getFirstName());
			System.out.println("Last Name: " + i.getLastName());
			System.out.println("Username: " + i.getUserName());
			System.out.println("Password: " + i.getPassword());
			System.out.println("Type: " + i.getType());
			System.out.println("Status: " + i.getStatus());
			System.out.println();
		}
		System.out.println("************* Edit User Complete!!!! *************\n\n");
		
		
		
		System.out.println("********** Remove Users ***********\n");
		
		ai.deleteUser("GWOLLENBE001@csbsju.edu");
		ArrayList<User> users4 = ai.viewUsers();
		for(User i : users4) {
			System.out.println("First Name: " + i.getFirstName());
			System.out.println("Last Name: " + i.getLastName());
			System.out.println("Username: " + i.getUserName());
			System.out.println();
		}
		
		System.out.println("********** University Functionalities for admins ***********\n");
		
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
		ArrayList<University> printUniv2 = new ArrayList<University>();
		printUniv2 = ai.viewUniversities();
		for(University i:printUniv2) {
			for(String x:ai.showSchoolDetails(i)) {
				System.out.print(x + ", ");
			}
			System.out.println();
		}
		
		
		System.out.println("*********** Edit University **********\n");
		
		newUnivEmp.add("Hispanic studies");
		System.out.println("Changes made to university of zac changed to urban, public, number of students = 1, 0% female, and added Hispanic studies emphasis\n");
		ai.editSchool("Zach", "Minnesota", "Urban", "Public", 1, 0, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, newUnivEmp);
		ArrayList<University> printUniv3 = new ArrayList<University>();
		printUniv3 = ai.viewUniversities();
		for(University i:printUniv3) {
			if(i.getSchoolName().contains("ZAC")) {
				for(String x:ai.showSchoolDetails(i)) {
				System.out.print(x + ", ");
				}
			}
			
		}
		System.out.println();
		System.out.println("*********** Remove University **********\n");
		
		System.out.println("Zach removed\n");
		University removeZac = new University("Zach", "Minnesota", "Urban", "Public", 1, 0, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, newUnivEmp, 0, 0, 0);
		ai.removeUniversity(removeZac);
		ArrayList<University> printUniv4 = new ArrayList<University>();
		printUniv4 = ai.viewUniversities();
		for(University i:printUniv4) {
			for(String x:ai.showSchoolDetails(i)) {
				System.out.print(x + ", ");
			}
			System.out.println();
		}
		System.out.println("********** University Functionalities Complete!!! *************\n\n");
		
		
		
		System.out.println("********** Set School of The Week ***********\n");
		ai.setSchoolOfTheWeek("NEW YORK UNIVERSITY");
		System.out.println(ai.getSchoolOfTheWeek().getSchoolName());
		System.out.println("********** Set School of The Week Complete!!! ***********\n");
		System.out.println("********** Admin Functionalities Complete!!!! ***********");
		System.out.println("*************************************************************************************************\n\n\n");
		
		System.out.println("********** Non-Admin Funtionalities ***********\n");	
		
		ai.logOut();
		nai.logOn("abreyen001@csbsju.edu", "myPassword");
		
		System.out.println("********** View my Profile ***********\n");
		User andrew = nai.viewMyProfile();
		System.out.println(andrew.getFirstName());
		System.out.println(andrew.getLastName());
		System.out.println(andrew.getUserName());
		System.out.println(andrew.getPassword());
		System.out.println(andrew.getType());
		System.out.println(andrew.getStatus());
		System.out.println("********** View my Profile Complete!!! ***********\n\n");
		
		System.out.println("********** Edit my Profile ***********\n");
		nai.editProfile("Andrew2", "Breyen2", "myPassword", "Ph@nt0mC0mm@nder$$");
		User andrew2 = nai.viewMyProfile();
		System.out.println(andrew2.getFirstName());
		System.out.println(andrew2.getLastName());
		System.out.println(andrew2.getUserName());
		System.out.println(andrew2.getPassword());
		System.out.println(andrew2.getType());
		System.out.println(andrew2.getStatus());
		nai.editProfile("Andrew", "Breyen", "Ph@nt0mC0mm@nder$$", "myPassword");
		System.out.println("********** Edit my Profile Complete!!! ***********\n\n");
		
		System.out.println("********** Random School Generated ***********\n");
		System.out.println(nai.randomSchool().getSchoolName());
		System.out.println("*********** Random School Complete!!!************\n\n");
		
		System.out.println("*********** Normal Recomend **********\n");
		ArrayList<University> ual = univc.topRecommended2(u);
		for(int i = 1; i < 6; i++)
		{
			System.out.println(ual.get(i).getSchoolName());
			System.out.println(ual.get(i).getDistance());
		}
		System.out.println("********** Normal Recommend Complete!!! *********\n\n");
		
		System.out.println("*********** Our Recomend **********\n");
		ArrayList<University> ual2 = univc.topRecommended(u);
		for(int i = 1; i < 6; i++)
		{
			System.out.println(ual2.get(i).getSchoolName());
			System.out.println(ual2.get(i).getCount());
		}
		System.out.println("********** Our Recommend Complete!!! *********\n\n");
		
		System.out.println("*********** Super Recommend ****************\n");
		ArrayList<University> ual3 = univc.superRecommend(u);
		for(int i = 1; i < 6; i++)
		{
			System.out.println(ual3.get(i).getSchoolName());
			System.out.println(ual3.get(i).getSup());
		}
		System.out.println("*********** Super Recommend Complete!!! ****************\n\n");
		
		System.out.println("*********** Search Schools ****************\n");
		ArrayList<University> searchedUniv = new ArrayList<University>();
		searchedUniv = nai.searchSchools("", "MASSACHUSETTS", "URBAN", "PRIVATE", 5000, 30000, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, al);
		for(University i:searchedUniv) {
				System.out.println(i.getSchoolName());
		}
		System.out.println("*********** Search Schools Complete!!! ****************\n\n");

		System.out.println("*********** Search History ****************\n");
		ArrayList<University> history = new ArrayList<University>();
		nai.searchSchools("Zach2", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, al);
		history = nai.viewHistory();
		for(University i:history) {
			System.out.println(i.getSchoolName());
		}
		System.out.println("*********** Search History Complete!!! ****************\n");
		
		System.out.println("*********** Save Schools ****************\n");
		System.out.println("Saving Adelphi and Zach2 to this profile which is Andrew");
		nai.saveUniversity(u);
		University zach2 = new University("Zach2", "Minnesota", "SUBURBAN", "PRIVATE", 30000, 60, 600, 650, 30000, 70, 10000, 40, 80, 4, 5, 5, newUnivEmp, 0, 0, 0);
		nai.saveUniversity(zach2);
		University cal = new University("Cal tech", "California", "suburban", "Private", 10000, 30, 650, 780, 28557, 70, 4000, 15, 90, 5, 1, 3, newUnivEmp, 0, 0, 0);
		University prince = new University("Princeton", "New Jersey", "Small-City", "Private", 10000, 35, 650, 675, 55801, 50, 11500, 20, 60, 5, 3, 3, newUnivEmp, 0, 0, 0);
		nai.saveUniversity(cal);
		nai.saveUniversity(prince);
		System.out.println("*********** Save Schools Complete!!! ****************\n\n");
		
		System.out.println("*********** View Saved Schools ****************\n");
		ArrayList<University> savedUnivs = new ArrayList<University>();
		savedUnivs = nai.viewSavedSchools();
		for(University i: savedUnivs) {
			System.out.println(i.getSchoolName());
		}
		System.out.println("*********** View Saved Schools Complete!!! ****************\n\n");
		
		System.out.println("*********** Remove Saved Schools ****************\n");
		nai.removeSavedSchool(u);
		ArrayList<University> savedUnivs2 = new ArrayList<University>();
		savedUnivs2 = nai.viewSavedSchools();
		for(University i: savedUnivs2) {
			System.out.println(i.getSchoolName());
		}
		System.out.println("*********** Remove Saved Schools Complete!!! ****************\n\n");
		
		System.out.println("*********** Sort Saved Schools by Percent Enrolled ****************\n");
		nai.sortByPerEnrolled(savedUnivs2);
		for(University i: nai.viewSortedSavedSchools()) {
			System.out.println(i.getSchoolName());
		}
		System.out.println("*********** Sort Saved Schools by Percent Enrolled Complete!!! ****************\n");
		
		System.out.println("*********** Sort Saved Schools by Size ****************\n");
		nai.sortBySize(savedUnivs2);
		for(University i: nai.viewSortedSavedSchools()) {
			System.out.println(i.getSchoolName());
		}
		System.out.println("*********** Sort Saved Schools by Size Complete!!! ****************\n");
		
		System.out.println("*********** Sort Saved Schools by Expense ****************\n");
		nai.sortByExpense(savedUnivs2);
		for(University i: nai.viewSortedSavedSchools()) {
			System.out.println(i.getSchoolName());
		}
		System.out.println("*********** Sort Saved Schools by Expense Complete!!! ****************\n");
		System.out.println("-_-_-_- DRIVER COMPLETE -_-_-_-");
}
}
