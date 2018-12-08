package principal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AbstractInfoTest.class,DateComparatorTest.class,DisplayDBTest.class,DisplayTest.class
	,EmailTest.class,FacebookAppTest.class,FacebookInfoTest.class,FacebookTest.class,MailInfoTest.class
	,MailAppTest.class,TwitterAppTest.class,TwitterInfoTest.class,XMLEditorTest.class})

public class AllTests {

}
