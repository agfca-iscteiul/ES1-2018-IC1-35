package principal;

import static org.junit.Assert.*;

import org.junit.Test;

import interfaces.Interface;

public class InterfaceTests {
	
	Interface inter=new Interface(new TwitterApp(),new MailApp(),new FacebookApp());

	@Test
	public void test() {
		inter.optionList();
		inter.filtrList();
	}

}
