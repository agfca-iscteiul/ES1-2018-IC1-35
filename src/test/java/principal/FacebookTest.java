package principal;

import static org.junit.Assert.*;

import org.junit.Test;

import interfaces.Facebook;

public class FacebookTest {

	Facebook fb;
	
	@Test
	public void test() {
		FacebookApp fbapp=new FacebookApp();
		fb=new Facebook(fbapp);
		fbapp.publicGroup("ISCTE");
	}

}
