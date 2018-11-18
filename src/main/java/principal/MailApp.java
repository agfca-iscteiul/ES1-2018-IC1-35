package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailApp {
	
	private List<MailInfo> lista = new ArrayList<MailInfo>();
	
	String host;
	String mailStoreType;
	String username;
	String password;
	
	Properties properties;
	
	public MailApp() {
		
	}
	
	private void check(String host, String storeType, String user, String password) {
		try {
			
			properties = new Properties();
			
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", "995");
			properties.put("mail.smtp.starttls.enable", "true");
			
			Session emailSession = Session.getDefaultInstance(properties);
			
			Store store = emailSession.getStore("pop3s");
			
			store.connect(host, user, password);
			
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			Message[] msgs = emailFolder.getMessages();
			
			for (int i = 0; i < 50; i++) {
				Message msg = msgs[i];
				if(msg.getContent().toString().contains("ISCTE")) {
					lista.add(new MailInfo(msg.getFrom()[0].toString(), msg.getContent().toString(),"indefinido"));
					System.out.println(msg);
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
	
	
	public List<AbstractInfo> getMailList(){
		List<AbstractInfo> listaaux = new ArrayList<AbstractInfo>();
		for(MailInfo mails : lista) {
			listaaux.add(mails);
		}
		return listaaux;
	}
	
	
	public void sendEmail(String to, String username, String password, String subject, String text) {
		
		String host="smtp.office365.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(text);

			// Send message
			Transport.send(message);
			
	      } catch (MessagingException e) {
		         throw new RuntimeException(e);
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
