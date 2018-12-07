package principal;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class DateComparatorTest {
	
	DateComparator comparator=new DateComparator();

	@Test
	public void testCheckComparator() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-1982 10:20:56";
		Date date1;
		date1 = sdf.parse(dateInString);
		sdf.parse(dateInString);
		dateInString = "31-08-1982 10:20:30";
		Date date2 = sdf.parse(dateInString);
		dateInString = "31-08-1990 10:20:50";
		Date date3 = sdf.parse(dateInString);
		AbstractInfo a1=new FacebookInfo("a","",date1);
		AbstractInfo a2=new TwitterInfo("b","",date2);
		AbstractInfo a3=new MailInfo("c","",date3);
		ArrayList<AbstractInfo> lista=new ArrayList<AbstractInfo>();
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		lista.sort(new DateComparator());
		assertTrue(lista.indexOf(a2)==0);
	}
	

}
