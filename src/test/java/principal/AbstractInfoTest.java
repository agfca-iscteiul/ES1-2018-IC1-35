package principal;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class AbstractInfoTest {

	private AbstractInfo teste;
	private String autor = "AAA";
	private String post = "BBBB";
	private Date data = new Date(1);

	@Before
	public void createObjectTest() {
		teste = new AbstractInfo(autor, post, data) {

			@Override
			public boolean checkTwitter() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean checkFacebook() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean checkEmail() {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

	@Test
	public void testAbstractInfo() {
		assertTrue(teste.getAutor().equals(autor));
		assertTrue(teste.getPost().equals(post));
		assertTrue(teste.getData().equals(data));
	}

	@Test
	public void testGetAutor() {
		String expected = "AAA";
		String actual = teste.getAutor();
		assertEquals(expected, actual);
	}


	@Test
	public void testGetPost() {
		String expected = "BBBB";
		String actual = teste.getPost();
		assertEquals(expected, actual);
	}


	@Test
	public void testGetData() {
		Date expected = new Date(1);
		Date actual = teste.getData();
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
		String expected = "BBBB";
		String actual = teste.toString();
		assertEquals(expected, actual);
	}

}
