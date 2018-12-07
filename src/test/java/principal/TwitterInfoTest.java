package principal;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TwitterInfoTest {

	private TwitterInfo teste = new TwitterInfo("AAA", "BBBB", new Date(0));
	
	@Test
	public void testCheckTwitter() {
		assertTrue(teste.checkTwitter());
	}

	@Test
	public void testCheckFacebook() {
		assertFalse(teste.checkFacebook());
	}

	@Test
	public void testCheckEmail() {
		assertFalse(teste.checkEmail());
	}

	@Test
	public void testTwitterInfo() {
		assertTrue(teste.getAutor().equals("AAA"));
		assertTrue(teste.getPost().equals("BBBB"));
		assertTrue(teste.getData().equals(new Date(0)));
	}

}
