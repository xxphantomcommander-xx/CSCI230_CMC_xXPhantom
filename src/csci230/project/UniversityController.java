package csci230.project;

import java.util.ArrayList;

/**
 * This class controls how Universities object interact 
 * with the system
 * @author zheinen001
 * @version 3/10/19
 */
public class UniversityController {
	private DBController dbCon;
	private ArrayList<University> allUnivs;
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
			int prctaLow, int prctaHigh, int prcteLow, int prcteHigh, int asLow, int asHigh, int ssLow, int ssHigh, int qLow, int qHigh, String[] emp) {

		ArrayList<University> searchList = new ArrayList();
		searchList = allUnivs;
		
	}
	
//	private ArrayList<University> searchBySchool(ArrayList<University> temp, String sch)
//	{
//		if(sch == null)
//		{
//			return temp;
//		}
//		else{
//			for(University i: temp)
//			{
//				String name = i.getSchoolName();
//				
//			}
//			
//			//TODO search by school return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByState(ArrayList<University> temp, String st)
//	{
//		if(st == null)
//		{
//			return temp;
//		}
//		else{
//		
//			
//			//TODO search by state return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByControl(ArrayList<University> temp, String c)
//	{
//		if(c == null)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by control return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByNumOfStudents(ArrayList<University> temp, int nStuLow, int nStuHigh)
//	{
//		if(nStuLow == -1 && nStuHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by number of students(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByPercentFemale(ArrayList<University> temp, int prctfLow, int prctfHigh)
//	{
//		if(prctfLow == -1 && prctfHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by percent female (high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchBySATVerbal(ArrayList<University> temp, int svLow, int svHigh)
//	{
//		if(svLow == -1 && svHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by average SAT verbal score(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchBySATMath(ArrayList<University> temp, int smLow, int smHigh)
//	{
//		if(smLow == -1 && smHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by average SAT math score(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByExpenses(ArrayList<University> temp, int eLow, int eHigh)
//	{
//		if(eLow == -1 && eHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by expenses(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByPercentFinAid(ArrayList<University> temp, int prctfinLow, int prctfinHigh)
//	{
//		if(prctfinLow == -1 && prctfinHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by percent financial aid given(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByNumOfApps(ArrayList<University> temp, int nApLow, int nApHigh)
//	{
//		if(nApLow == -1 && nApHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by number of applicants(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByPercAdmitted(ArrayList<University> temp, int prctaLow, int prctaHigh)
//	{
//		if(prctaLow == -1 && prctaHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by percent admitted(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByPercEnrolled(ArrayList<University> temp, int prcteLow, int prcteHigh)
//	{
//		if(prcteLow == -1 && prcteHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by percent enrolled(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByAcademicScale(ArrayList<University> temp, int asLow, int asHigh)
//	{
//		if(asLow == -1 && asHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by academic scale(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchBySocialLife(ArrayList<University> temp, int ssLow, int ssHigh)
//	{
//		if(ssLow == -1 && ssHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by social life scale(high to low) return sublist of matching schools
//		}
//	}
//	
//	private ArrayList<University> searchByQualityOfLife(ArrayList<University> temp, int qLow, int qHigh)
//	{
//		if(qLow == -1 && qHigh == -1)
//		{
//			return temp;
//		}
//		else{
//			
//			//TODO search by quality of life scale(high to low) return sublist of matching schools
//		}
//	}
//	
////	private ArrayList<University> searchByEmphasis(ArrayList<University> temp, String[] emp)
//	{
//		if(emp == null)
//		{
//			
//			return temp;
//		}
//		else{
//			
//			//TODO searby school emphasis
//		}
//	}
	
	public ArrayList<University> loadUniversities() {
		String [][] univData;
	
		ArrayList<University> univ = new ArrayList<University>();
		univData = dbCon.getUniversities();
	
		/**
		 * Create list of Universities and Store their info into them.
		 */
		for(int i = 0; i < univData.length; i++) {
			
			University temp = new University(univData[i][0], univData[i][1], univData[i][2],univData[i][3], Integer.parseInt(univData[i][4]), Integer.parseInt(univData[i][5]), Integer.parseInt(univData[i][6]),
					Integer.parseInt(univData[i][7]), Integer.parseInt(univData[i][8]), Integer.parseInt(univData[i][9]), Integer.parseInt(univData[i][10]), Integer.parseInt(univData[i][11]),
					Integer.parseInt(univData[i][12]), Integer.parseInt(univData[i][13]), Integer.parseInt(univData[i][14]), Integer.parseInt(univData[i][15]), loadEmp(univData[i][0]));
			univ.add(temp);
		}

		allUnivs = univ;
		//System.out.println(univEmp[0][1]);
		return univ;
		
	}
	
	
	private ArrayList<String> loadEmp(String univName){
		String [][] univEmp;
		univEmp = dbCon.getEmphasis();
		ArrayList<String> emp = new ArrayList<String>();
		for(int i = 0; i < univEmp.length; i++) {
			

			
				if(univEmp[i][0].equals(univName)) {
					emp.add(univEmp[i][1]);
			}
				
		}
		return emp;
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

	/**
	 * get all universities
	 * @return ArrayList<University> os all universities
	 */
	public ArrayList<University> getAllUnivs() {
		return allUnivs;
	}

}
