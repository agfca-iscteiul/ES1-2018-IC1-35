package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class MailApp {
	
	private List<MailInfo> lista = new ArrayList<MailInfo>();
	
	public MailApp() {
		
	}
	
	private void check(String host, String storeType, String user, String password) {
		try {
			
			Properties properties = new Properties();
			
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", "995");
			properties.put("mail.smtp.starttls.enable", "true");
			
			Session emailSession = Session.getDefaultInstance(properties);
			
			Store store = emailSession.getStore("pop3s");
			
			store.connect(host, user, password);
			
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			Message[] msgs = emailFolder.getMessages();
			
			for(int i=0, n=msgs.length; i<n; i++) {
				Message msg = msgs[i];
				if(msg.getContent().toString().contains("ISCTE")) {
					lista.add(new MailInfo(msg.getFrom()[0].toString(), msg.getContent().toString(),"indefinido"));
				}
			}
			
		emailFolder.close(false);
		store.close();
			
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runMail() {
		
		String host = "smtp.outlook.com";
		String mailStoreType = "smtp";
		String username = "";//escrever o e-mail aqui
		String password = "";//respetiva password
		
		
		check(host, mailStoreType, username, password);
		
		
	}
	

	

}
