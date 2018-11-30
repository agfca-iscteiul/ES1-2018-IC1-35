package principal;

import java.io.File;

public class XMLEditor {
	
	FacebookApp facebook = new FacebookApp();
	TwitterApp twitter = new TwitterApp();
	MailApp outlook= new MailApp();
	
	public void createXMLFile() {
		facebook.writeFacebookXML();
		twitter.writeTwitterXML();
		outlook.writeMailXML();
	}
	
	public void removeXMLFile() {
		File data = new File("config.xml");
		if(data.delete()) {
			System.out.println("O ficheiro XML foi removido");
		}else{
			System.out.println("Não existe ficheiro XML para ser removido");
		}
	}
}
