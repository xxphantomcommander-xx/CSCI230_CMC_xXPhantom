/**
 * 
 */
package csci230.project;

/**
 * @author zheinen001
 *
 */
public class UserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*********** User Test *******************\n");
		
		User test = new User("John", "Smith", "JSmith22", "Password", 'u', 'Y');
		System.out.println("Creating user: John Smith. Username: JSmith22. Password: Password. Type: u. Status: Y.");
		
		System.out.println("Getting first name. Expected output: John");
		System.out.println(test.getFirstName());
		System.out.println();
		
		System.out.println("Getting last name. Expected output: Smith");
		System.out.println(test.getLastName());
		System.out.println();
		
		System.out.println("Getting Username. Expected output: JSmith22");
		System.out.println(test.getUserName());
		System.out.println();
		
		System.out.println("Getting Password. Expected output: Password");
		System.out.println(test.getPassword());
		System.out.println();
		
		System.out.println("Getting Type. Expected output: u");
		System.out.println(test.getType());
		System.out.println();
		
		System.out.println("Getting Status. Expected output: Y");
		System.out.println(test.getStatus());
		System.out.println();
		
		System.out.println("Setting first name. Expected output: Imad");
		test.setFirstName("Imad");
		System.out.println(test.getFirstName());
		System.out.println();
		
		System.out.println("Setting last name. Expected output: Rahal");
		test.setLastName("Rahal");
		System.out.println(test.getLastName());
		System.out.println();
		
		System.out.println("Setting Username. Expected output: BestProf");
		test.setuserName("BestProf");
		System.out.println(test.getUserName());
		System.out.println();
		
		System.out.println("Setting Password. Expected output: SomeUnknown");
		test.setPassword("SomeUnknown");
		System.out.println(test.getPassword());
		System.out.println();
		
		System.out.println("Setting Type. Expected output: a");
		test.setType('a');
		System.out.println(test.getType());
		System.out.println();
		
		System.out.println("Setting Status. Expected output: N");
		test.setStatus('N');
		System.out.println(test.getStatus());
		System.out.println();
		
		System.out.println("***********************************************************");
		System.out.println("************** User Test Complete!!! ************************");
		
	}

}
