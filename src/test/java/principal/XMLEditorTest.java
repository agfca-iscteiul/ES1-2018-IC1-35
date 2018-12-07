package principal;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class XMLEditorTest {
	
	XMLEditor xml=new XMLEditor();

	@Test
	public void testContent() {
		String content=xml.getContent();
		System.out.println(content.isEmpty());
		assertTrue(!content.isEmpty());
	}
	
	@Test
	public void testRemoveOutlook() {
		xml.readFromXML();
		xml.removeOutlook();
		assertTrue(xml.getListaMail().isEmpty());
	}
	
	@Test
	public void testRemoveFacebook() {
		xml.readFromXML();
		xml.removeFacebook();
		assertTrue(xml.getListaMail().isEmpty());
	}
	
	@Test
	public void testRemoveTwitter() {
		xml.removeTwitter();
		System.out.println(xml.getListaTwitter().size());
		assertTrue(xml.getListaTwitter().isEmpty());
	}
	
	@Test
	public void testXMLFile() {
		xml.removeXMLFile();
		xml.createXMLFile(new FacebookApp(), new TwitterApp(), new MailApp());
		File data = new File("config.xml");
		assertTrue(data.exists());
	}


}
