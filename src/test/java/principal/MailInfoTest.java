package principal;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class MailInfoTest {

	private MailInfo teste = new MailInfo("AAA", "BBBB", new Date(0));

	@Test
	public void testCheckTwitter() {
		assertFalse(teste.checkTwitter());
	}

	@Test
	public void testCheckFacebook() {
		assertFalse(teste.checkFacebook());
	}

	@Test
	public void testCheckEmail() {
		assertTrue(teste.checkEmail());
	}

	@Test
	public void testMailInfo() {
		assertEquals("AAA", teste.getAutor());
		assertEquals("BBBB", teste.getPost());
		assertEquals(new Date(0), teste.getData());
	}

}
