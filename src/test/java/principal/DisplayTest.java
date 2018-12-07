package principal;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import interfaces.Display;
import interfaces.DisplayDB;
import interfaces.Email;

public class DisplayTest {

	@Test
	public void test() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-1982 10:20:56";
		Date date1 = sdf.parse(dateInString);
		Display inter=new Display(new FacebookInfo("","",date1));
		Display dis=new Display(new FacebookInfo("","",date1));
	}

}
