package principal;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwitterAppTest {
	TwitterApp app = new TwitterApp();
	
	@Test
	public void testRunTwitter() {
		app.runTwitter();
		assertNotNull(app.getListPost());
	}

	@Test
	public void testGetList() {
		app.runTwitter();
		assertEquals(app.getList(), app.getListPost());
	}

	@Test
	public void testWriteTwitterXML() {
		fail("Not yet implemented");
	}

}
