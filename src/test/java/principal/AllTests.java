package principal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FacebookAppTest.class, MailAppTest.class, TwitterAppTest.class })

public class AllTests {

}
