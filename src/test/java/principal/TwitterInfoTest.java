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
		assertEquals("AAA",teste.getAutor());
		assertEquals("BBBB",teste.getPost());
		assertEquals(new Date(0), teste.getData());
	}

}
