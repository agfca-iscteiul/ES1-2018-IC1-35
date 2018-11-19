package principal;

import static org.junit.Assert.*;

import org.junit.Test;

public class MailAppTest {
	
	MailApp app = new MailApp();
	
	@Test
	public void testGetMailList() {
		app.runMail();
		assertEquals(app.getMailList(), app.getListPost());
	}

}
