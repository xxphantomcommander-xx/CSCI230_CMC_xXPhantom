
//
/**
 * 
 */
package csci230.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author zheinen001
 *
 */
public class UserTest {
	User u;
	  @Before
	  public void setUp() throws Exception {
	   u = new User("John", "Smith", "ZHEINEN001@csbsju.edu", "password", 'u', 'Y');
	  }
	  
	/**
	 * Test method for {@link csci230.project.User#User(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test
	public void testUser() {
		 User newUser = new User("bob", "Doe", "jdoe@gmail.com", "password", 'a', 'N');
		 assertTrue(newUser.getUserName().equals("jdoe@gmail.com"));
	}

	 @Test(expected=IllegalArgumentException.class)
	 public void testUser_InvalidUserName(){
		new User("bob", "Doe", "jdoe", "password", 'a', 'N');
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUser_InvalidStatus(){
		 new User("bob", "Doe", "jdoe@gmail.com", "password", 'a', 'p');
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testUser_InvalidType(){
		new User("bob", "Doe", "jdoe", "password", 'z', 'N');
	 }
	 
	/**
	 * Test method for {@link csci230.project.User#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		assertTrue("getFirstName() expected John got " + u.getFirstName(), u.getFirstName().equals("John"));
	}

	/**
	 * Test method for {@link csci230.project.User#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		assertTrue("getLastName() expected Smith got " + u.getLastName(), u.getLastName().equals("Smith"));
	}

	/**
	 * Test method for {@link csci230.project.User#getUserName()}.
	 */
	@Test
	public void testGetUserName() {
		assertTrue("getUserName() expected ZHEINEN001@csbsju.edu got " + u.getUserName(), u.getUserName().equals("ZHEINEN001@csbsju.edu"));
	}

	/**
	 * Test method for {@link csci230.project.User#getPassword()}.
	 */
	@Test
	public void testGetPassword() {
		assertTrue("getPassword() expected password got " + u.getPassword(), u.getPassword().equals("password"));
	}

	/**
	 * Test method for {@link csci230.project.User#getType()}.
	 */
	@Test
	public void testGetType() {
		assertTrue("getType() expected u got " + u.getType(), u.getType() == 'u');
	}

	/**
	 * Test method for {@link csci230.project.User#getStatus()}.
	 */
	@Test
	public void testGetStatus() {
		assertTrue("getStatus() expected Y got " + u.getStatus(), u.getStatus() == 'Y');
	}

	/**
	 * Test method for {@link csci230.project.User#setFirstName(java.lang.String)}.
	 */
	@Test
	public void testSetFirstName() {
		String expected = "Imad";
		u.setFirstName("Imad");
		assertTrue("setFirstName() expected Imad got " + u.getFirstName(), u.getFirstName().equals(expected));
	}

	/**
	 * Test method for {@link csci230.project.User#setLastName(java.lang.String)}.
	 */
	@Test
	public void testSetLastName() {
		String expected = "Rahal";
		u.setFirstName("Rahal");
		assertTrue("setLastName() expected Rahal got " + u.getLastName(), u.getLastName().equals(expected));
	}

	/**
	 * Test method for {@link csci230.project.User#setuserName(java.lang.String)}.
	 */
	@Test
	public void testSetuserName() {
		String expected = "rahal@gmail.com";
		u.setuserName("rahal@gmail.com");
		assertTrue("setuserName() expected rahal@gmail.com got " + u.getUserName(), u.getUserName().equals(expected));
	}

	/**
	 * Test method for {@link csci230.project.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword() {
		String expected = "12345";
		u.setPassword("12345");
		assertTrue("setPassword() expected 12345 got " + u.getPassword(), u.getPassword().equals(expected));
	}

	/**
	 * Test method for {@link csci230.project.User#setType(char)}.
	 */
	@Test
	public void testSetType() {
		char expected = 'a';
		u.setType('a');
		assertTrue("setType() expected 'a' got " + u.getType(), u.getType() == expected);
	}

	/**
	 * Test method for {@link csci230.project.User#setStatus(char)}.
	 */
	@Test
	public void testSetStatus() {
		char expected = 'N';
		u.setStatus('N');
		assertTrue("setStatus() expected 'N' got " + u.getStatus(), u.getStatus() == expected);
	}

}
