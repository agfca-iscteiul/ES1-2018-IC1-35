package principal;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class FacebookInfoTest {

	private FacebookInfo teste = new FacebookInfo("AAA", "BBBB", new Date(0));

	@Test
	public void testCheckTwitter() {
		assertFalse(teste.checkTwitter());
	}

	@Test
	public void testCheckFacebook() {
		assertTrue(teste.checkFacebook());
	}

	@Test
	public void testCheckEmail() {
		assertFalse(teste.checkEmail());
	}

	@Test
	public void testFacebookInfo() {
		assertTrue(teste.getAutor().equals("AAA"));
		assertTrue(teste.getPost().equals("BBBB"));
		assertTrue(teste.getData().equals(new Date(0)));
	}

}
