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

		ArrayList<University> searchList = new ArrayList<University>();
		searchList = allUnivs;
		searchByEmphasis(searchByQualityOfLife(searchBySocialLife(searchByAcademicScale(searchByPercEnrolled(searchByPercAdmitted(searchByNumOfApps
				(searchByPercentFinAid(searchByExpenses(searchBySATMath(searchBySATVerbal(searchByPercentFemale(searchByNumOfStudents(searchByControl(searchByState(searchBySchool(searchList, sch), st),  c),nStuLow, nStuHigh)
				, prctfLow, prctfHigh), svLow, svHigh), smLow, smHigh), eLow, eHigh), prctfinLow, prctfinHigh), nApLow, nApHigh), prctaLow, prctaHigh), prcteLow, prcteHigh),
				asLow, asHigh), ssLow, ssHigh), qLow, qHigh), emp);
	}
	
	private ArrayList<University> searchBySchool(ArrayList<University> temp, String sch)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		String schoolName = sch.toUpperCase();
		if(sch.equals(null))
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				String name = i.getSchoolName();
				if(name.contains(schoolName)) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
		}
	}
	
	private ArrayList<University> searchByState(ArrayList<University> temp, String st)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		String state = st.toUpperCase();
		if(st.equals(null))
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				String name = i.getState();
				if(name.contains(state)) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
		}
			

		}
	
	
	private ArrayList<University> searchByControl(ArrayList<University> temp, String c)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		String control = c.toUpperCase();
		if(c.equals(null))
		{
			return temp;
		}
		else{
			
			for(University i: temp)
			{
				String name = i.getControl();
				if(name.contains(control)) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
		}
	
	}
	
	
	private ArrayList<University> searchByNumOfStudents(ArrayList<University> temp, int nStuLow, int nStuHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(nStuLow == -1 && nStuHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getNumOfStudents();
				if(v >= nStuLow && v <= nStuHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
			
		}
	}
	
	private ArrayList<University> searchByPercentFemale(ArrayList<University> temp, int prctfLow, int prctfHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(prctfLow == -1 && prctfHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getPerFem();
				if(v >= prctfLow && v <= prctfHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
		}
	}
	
	private ArrayList<University> searchBySATVerbal(ArrayList<University> temp, int svLow, int svHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(svLow == -1 && svHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getSatVerbal();
				if(v >= svLow && v <= svHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;
			
		}
	}
	
	private ArrayList<University> searchBySATMath(ArrayList<University> temp, int smLow, int smHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(smLow == -1 && smHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getSatMath();
				if(v >= smLow && v <= smHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	
	private ArrayList<University> searchByExpenses(ArrayList<University> temp, int eLow, int eHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(eLow == -1 && eHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getExpenses();
				if(v >= eLow && v <= eHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	
	private ArrayList<University> searchByPercentFinAid(ArrayList<University> temp, int prctfinLow, int prctfinHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(prctfinLow == -1 && prctfinHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getFinancialAid();
				if(v >= prctfinLow && v <= prctfinHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	
	private ArrayList<University> searchByNumOfApps(ArrayList<University> temp, int nApLow, int nApHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(nApLow == -1 && nApHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getNumOfApps();
				if(v >= nApLow && v <= nApHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	
	private ArrayList<University> searchByPercAdmitted(ArrayList<University> temp, int prctaLow, int prctaHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(prctaLow == -1 && prctaHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getPerAdmitted();
				if(v >= prctaLow && v <= prctaHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	
	private ArrayList<University> searchByPercEnrolled(ArrayList<University> temp, int prcteLow, int prcteHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(prcteLow == -1 && prcteHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getPerEnrolled();
				if(v >= prcteLow && v <= prcteHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	
	private ArrayList<University> searchByAcademicScale(ArrayList<University> temp, int asLow, int asHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(asLow == -1 && asHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getAcademicScale();
				if(v >= asLow && v <= asHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	
	private ArrayList<University> searchBySocialLife(ArrayList<University> temp, int ssLow, int ssHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(ssLow == -1 && ssHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getSocialScale();
				if(v >= ssLow && v <= ssHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	
	private ArrayList<University> searchByQualityOfLife(ArrayList<University> temp, int qLow, int qHigh)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(qLow == -1 && qHigh == -1)
		{
			return temp;
		}
		else{
			for(University i: temp)
			{
				int v = i.getQualOfLife();
				if(v >= qLow && v <= qHigh) {
					matchedSchools.add(i);
				}
			}
			return matchedSchools;

		}
	}
	
	private ArrayList<University> searchByEmphasis(ArrayList<University> temp, String[] emp)
	{
		ArrayList<University> matchedSchools = new ArrayList<University>();
		if(emp == null)
		{
			
			return temp;
		}
		else{
			for(University i: temp) {
				ArrayList<String> v = i.getEmp();
				for(String u:emp) {
					if(u.equals(v.get(0)) || u.equals(v.get(1)) || u.equals(v.get(2)) || u.equals(v.get(3)) || u.equals(v.get(4)) ) {
						matchedSchools.add(i);
					}
				}
			}
			return matchedSchools;
		}
	}
	
	public ArrayList<University> loadUniversities() {
		String [][] univData;
		String [][] univEmp;
		ArrayList<University> univ = new ArrayList<University>();
		univData = dbCon.getUniversities();
		univEmp = dbCon.getEmphasis();
		/**
		 * Create list of Universities and Store their info into them.
		 */
		for(int i = 0; i < univData.length; i++) {
			
			University temp = new University(univData[i][0], univData[i][1], univData[i][2],univData[i][3], Integer.parseInt(univData[i][4]), Integer.parseInt(univData[i][5]), Integer.parseInt(univData[i][6]),
					Integer.parseInt(univData[i][7]), Integer.parseInt(univData[i][8]), Integer.parseInt(univData[i][9]), Integer.parseInt(univData[i][10]), Integer.parseInt(univData[i][11]),
					Integer.parseInt(univData[i][12]), Integer.parseInt(univData[i][13]), Integer.parseInt(univData[i][14]), Integer.parseInt(univData[i][15]));
			univ.add(temp);
		}
		for(int i = 0; i < univEmp.length; i++) {
			

			for(University u : univ) {
				if(univEmp[i][0] == u.getSchoolName()) {
					u.addEmp(univEmp[i][1]);
				}
			
			}
		}
		allUnivs = univ;
		return univ;
		
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
