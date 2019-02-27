package csci230.project;
/**
 * This class contains all the info about Universities
 * @author zheinen001
 * @version 2/25/19
 */
public class University {
	//name of University
	String schoolName;
	//State of University
	String state;
	//Location of school(urban or rural)
	String location;
	// number of students in the university
	int numOfStudents;
	// percent female
	int perFem;
	// sat score for verbal
	int satVerbal;
	// sat score for math
	int satMath;
	// how much does this university cost
	int expenses;
	// Financial aid offered by the university
	int financialAid;
	// number of applicants to this university
	int numOfApps;
	// percent admitted to this university
	int perAdmitted;
	// percent of admitted that actually enrolled
	int perEnrolled;
	// academic scale of this university 0-10
	int acedemicScale;
	// social scale of this university 0-10
	int socialScale;
	// quality of life scale of this university 0-10
	int qualOfLife;
	
	/**
	 * creates a University
	 * @param schoolName
	 * @param state
	 * @param location
	 * @param numOfStudents
	 * @param perFem
	 * @param satVerbal
	 * @param satMath
	 * @param expenses
	 * @param financialAid
	 * @param numOfApps
	 * @param perAdmitted
	 * @param perEnrolled
	 * @param academicScale
	 * @param socialScale
	 * @param qualOfLife
	 */
	public University(String schoolName, String state, String location, 
			int numOfStudents, int perFem, int satVerbal, int satMath,
			int expenses, int financialAid, int numOfApps, int perAdmitted, 
			int perEnrolled, int acedemicScale, int socialScale, 
			int qualOfLife) {
		
	}
	
	/**
	 * Gets the school name from this University
	 * @return schoolName
	 */
	public String getSchoolName() {
		
		return "";
	}

	/**
	 * gets the State of the University
	 * @return state
	 */
	public String getState() {
		
		return "";
	}
	
	/**
	 * gets Location of university (Rural, suburb or Urban)
	 * @return
	 */
	public String getLocation() {
		
		return "";
	}
	
	/**
	 * gets the number of students at the university
	 * @return numOfStudents
	 */
	public int getNumOfStudents() {
	
		return 0;
	}
	
	/**
	 * gets the percent female 0-100 %
	 * @return percent female
	 */
	public int getPercFem() {
		return 0;
	}
	
	/**
	 * gets the SatVerb requirements for this University
	 * @return Sat Verbal score
	 */
	public int getSatVerb() {
		return 0;
	}
	
	/**
	 * gets the Sat Math score for this university
	 * @return SatMath
	 */
	public int getSatMath() {
		return 0;
	}
	
	/**
	 * gets the cost of attending this university
	 * @return Expense of attending this University
	 */
	public int getExpenses() {
		return 0;
	}
	
	/**
	 * gets the FinancialAid offer from the University
	 * @return Financial Aid
	 */
	public int getFinancialAid() {
		return 0;
	}
	
	/**
	 * gets the number of applicants to this university
	 * @return number of applicants
	 */
	public int getNumOfApps() {
		return 0;
	}
	
	/**
	 * gets the percent of applicants admitted
	 * @return percent admitted
	 */
	public int getPerAdmitted() {
		return 0;
	}
	
	/**
	 * gets the percent of admitted enrolled at this university
	 * @return percent Enrolled
	 */
	public int getPerEnrolled() {
		return 0;
	}
	
	/**
	 * Scale of academics for this university
	 * @return
	 */
	public int getAcademicScale() {
		return 0;
	}
	
	/**
	 * gets the social scale of this university
	 * @return social scale
	 */
	public int getSocialScale() {
		return 0;
	}
	
	/**
	 * gets the scale of the quality of life at this univerisity
	 * @return quality of life scale
	 */
	public int getQualOfLife() {
		return 0;
	}
	
	/**
	 * Uses all the gets to show all the university's details
	 * formats it nicely for output to the GUI
	 * @return String
	 */
	public String showUniversityDetails() {
		//basically use all the gets and format it nicely for an output
		return "";
	}
}
