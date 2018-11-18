package principal;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacebookAppTest {
	FacebookApp app = new FacebookApp();

	@Test
	public void testRunFacebook() {
		app.runFacebook();
		assertNotNull(app.getListPost());
	}

	@Test
	public void testGetList() {
		app.runFacebook();
		assertEquals(app.getList(), app.getListPost());
	}

	@Test
	public void testWriteFacebookXML() {
		fail("Not yet implemented");
	}

}
