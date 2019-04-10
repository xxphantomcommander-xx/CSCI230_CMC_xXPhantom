package csci230.project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DBControllerTest.class, UniversityControllerTest.class, UniversityTest.class, UserControllerTest.class,
		UserTest.class, AdminFunctionalityControllerTest.class, NonAdminFunctionalityControllerTest.class })
public class AllTests {

}
