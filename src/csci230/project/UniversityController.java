package csci230.project;

import java.util.ArrayList;

/**
 * This class controls how Universities object interact 
 * with the system
 * @author AndrewBreyen
 * @version 2/25/19
 */
public class UniversityController {
	private DBController dbCon;
	/**
	 * Constructor for University controller
	 */
	public UniversityController() {
		super();
		// TODO Auto-generated constructor stub
		dbCon = new DBController();
		
	}
	
	/**
	 * searches for schools using parameters
	 * @param sch
	 * @param st
	 * @param l
	 * @param c
	 * @param nStuLow
	 * @param nStuHigh
	 * @param prctfLow
	 * @param prctfHigh
	 * @param svLow
	 * @param svHigh
	 * @param smLow
	 * @param smHigh
	 * @param eLow
	 * @param eHigh
	 * @param prctfinLow
	 * @param prctfinHigh
	 * @param nApLow
	 * @param nApHigh
	 * @param prctaLow
	 * @param prctaHigh
	 * @param prcteLow
	 * @param prcteHigh
	 * @param asLow
	 * @param asHigh
	 * @param ssLow
	 * @param ssHigh
	 * @param qLow
	 * @param qHigh
	 * @param emp
	 */
	public void searchSchools(String sch, String st, String l, String c, 
			int nStuLow, int nStuHigh, int prctfLow, int prctfHigh, int svLow, int svHigh, int smLow, int smHigh, int eLow, int eHigh, int prctfinLow, int prctfinHigh, int nApLow, int nApHigh,
			int prctaLow, int prctaHigh, int prcteLow, int prcteHigh, int asLow, int asHigh, int ssLow, int ssHigh, int qLow, int qHigh, String emp) {
		String [][] univData;
		String [][] univEmp;
		univData = dbCon.getUniversities();
		univEmp = dbCon.getEmphasis();
		ArrayList<University> univ = new ArrayList<University>(); 
		/**
		 * Create list of Universities and Store their info into them.
		 */
		for(int i = 0; i < univData.length; i++) {
			
			University temp = new University(univData[i][0], univData[i][1], univData[i][2], Integer.parseInt(univData[i][3]), Integer.parseInt(univData[i][4]), Integer.parseInt(univData[i][5]),
					Integer.parseInt(univData[i][6]), Integer.parseInt(univData[i][7]), Integer.parseInt(univData[i][8]), Integer.parseInt(univData[i][9]), Integer.parseInt(univData[i][10]),
					Integer.parseInt(univData[i][11]), Integer.parseInt(univData[i][12]), Integer.parseInt(univData[i][13]), Integer.parseInt(univData[i][14]));
			univ.add(temp);
		}
		
		/**
		 * TODO add the emphasis to the Universities in the list
		 */
		for(int i = 0; i < univEmp.length; i++) {
			
			
			for(int j = 0; j < univEmp[i].length; j++) {
				
			}
		}
		
		//TODO Sort through the schools... Maybe do that before putting them in lists? 
	}
	
	/**
	 * 
	 * Sets school name
	 * @param String of school searched
	 * @return String of results
	 */
	public String setSchoolName(String schoolSearched) {
		return "";
	}
	

	/**
	 * 
	 * Sets state
	 * @param String of school searched
	 * @return String of results
	 */
	public String setState(String schoolSearched) {
		return "";
	}
	
	/**
	 * 
	 * Sets location
	 * @param String of school searched
	 * @return String of results
	 */
	public String setLocation(String schoolSearched) {
		return "";
	}
	
	/**
	 * 
	 * Sets number of students
	 * @param String of school searched
	 * @return String of results
	 */
	public int setNumOfStudents(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets percent female
	 * @param String of school searched
	 * @return String of results
	 */
	public int setPercFem(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets SAT Verbal
	 * @param String of school searched
	 * @return String of results
	 */
	public int setSatVerbal(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets SAT Math
	 * @param String of school searched
	 * @return String of results
	 */
	public int setSatMath(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets Expenses
	 * @param String of school searched
	 * @return String of results
	 */
	public int setExpenses(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets Financial Aid
	 * @param String of school searched
	 * @return String of results
	 */
	public int setFinancialAid(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets Number of applications
	 * @param String of school searched
	 * @return String of results
	 */
	public int setNumOfApps(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets Percent Admitted
	 * @ param String of school searched
	 * @ return String of results
	 */
	public int setPerAdmitted(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets Percent Enrolled
	 * @param String of school searched
	 * @return String of results
	 */
	public int setPerEnrol(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets Academic Scale
	 * @param String of school searched
	 * @return String of results
	 */
	public int setAcademicScale(String schoolSearched) {
		return 0;
	}
	
	
	/**
	 * 
	 * Sets Social Scale
	 * @param String of school searched
	 * @return String of results
	 */
	public int setSocialScale(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Sets Quality Of Life
	 * @param String of school searched
	 * @return String of results
	 */
	public int setQualOfLife(String schoolSearched) {
		return 0;
	}
	
	/**
	 * 
	 * Shows University Details
	 * @param String of school searched
	 * @return String of results
	 */
	public int showUniversityDetails() {
		return 0;
	}

}
