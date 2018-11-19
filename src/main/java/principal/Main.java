package principal;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import interfaces.Interface;


public class Main {
	

	public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		TwitterApp ttapp=new TwitterApp();
		MailApp mapp=new MailApp();
		FacebookApp fbapp=new FacebookApp();
		ttapp.runTwitter();
		mapp.runMail();
		fbapp.runFacebook();
		Interface i=new Interface(ttapp,mapp,fbapp); 
	}

}
