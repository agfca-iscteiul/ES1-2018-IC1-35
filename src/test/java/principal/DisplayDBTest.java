package principal;

import static org.junit.Assert.*;

import org.junit.Test;

import interfaces.DisplayDB;

public class DisplayDBTest {

	DisplayDB display;
	
	@Test
	public void test() {
		DisplayDB display=new DisplayDB("base de dados");
	}

}
