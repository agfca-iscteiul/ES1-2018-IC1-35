package principal;

import static org.junit.Assert.*;

import org.junit.Test;

import interfaces.Email;

public class EmailTest {
	
	Email email;

	@Test
	public void test() {
		MailApp mapp=new MailApp();
		email=new Email(mapp);
	}

}
