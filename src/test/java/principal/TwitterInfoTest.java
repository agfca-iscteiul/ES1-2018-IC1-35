package principal;

import junit.framework.TestCase;

public class TwitterInfoTest extends TestCase {

	public void testCheckTwitter() {
		TwitterInfo teste=new TwitterInfo("teste", "ola","2012");
		boolean expected=teste.isTwitter;
		expected=true;
		assertEquals(expected, teste.checkTwitter());
	}

	public void testCheckFacebook() {
		TwitterInfo teste=new TwitterInfo("teste", "ola","2012");
		boolean expected=teste.isFacebook;
		assertEquals(expected, teste.checkFacebook());
	}

	public void testCheckEmail() {
		TwitterInfo teste=new TwitterInfo("teste", "ola","2012");
		boolean expected=teste.isEmail;
		assertEquals(expected, teste.checkEmail());
	}

}
