package principal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TwitterInfoTest.class , FacebookInfoTest.class, MailInfoTest.class})

public class AllTests {

}
