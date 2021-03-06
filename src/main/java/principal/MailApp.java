package principal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import interfaces.Interface;
import interfaces.LoginInterface;


public class MailApp {

	private List<MailInfo> lista = new ArrayList<MailInfo>();
	String host;
	String mailStoreType;
	public String username;
	public String password;
	Properties properties;

	public MailApp() {

	}


	/**
	 * 
	 * Cria uma lista auxiliar de AbastractInfo. 
	 * Os e-mails presentes na lista de MailInfo são transferidos para a lista auxiliar criada.
	 * 
	 * @return lista de AbstractInfo com os e-mails que se encontravam na lista de MailInfo.
	 */

	public ArrayList<AbstractInfo> getMailList(){
		ArrayList<AbstractInfo> listaaux = new ArrayList<AbstractInfo>();
		for(MailInfo mails : lista) {
			listaaux.add(mails);
		}
		return listaaux;
	}

	public List<MailInfo> getListPost(){
		return lista;

	}

	/**
	 * 
	 * É fornecida a informação para usar os serviços oferecidos pela JavaMail API.
	 * A informção é respetiva ao servido do ISCTE, pois é este que é usado para ler e-mails.
	 * É lida a mail box do e-mail cujas credenciais são fornecidas nos parâmetros da função.
	 * Os e-mails presentes na mail box são colocados numa lista para posteriormente ser utilizada na interface.
	 * 
	 * @param host	fornecedor do host
	 * @param storeType	protocolo fornecedor que dá acesso a message store
	 * @param user	email do utilizador
	 * @param password	password do utilizador
	 */

	private void check(String host, String storeType, String user, String password) {
		try {

			properties = new Properties();

			properties.setProperty("mail.store.protocol", "imaps");
			properties.put("mail.imap-mail.outlook.com.ssl.enable", "true");
			properties.put("mail.pop3.host", "outlook.com");
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");


			Session emailSession = Session.getDefaultInstance(properties);

			Store store = emailSession.getStore();

			//verifica se esta offline
			if(check()){
				LoginInterface login=new LoginInterface();
				while(!login.isValido()) {
					System.out.println("não conectado");
				}
				store.connect(host, login.getUN(), login.getPW());
				username=login.getUN();
				this.password=login.getPW();
			}

			Folder emailFolder = store.getFolder("INBOX"); 
			emailFolder.open(Folder.READ_ONLY);

			Message[] msgs = emailFolder.getMessages();

			for (int i = 0; i < msgs.length; i++) {
				Message msg = msgs[i];
				if(msg.getContent().toString().contains("iscte")) {
					lista.add(new MailInfo(msg.getFrom()[0].toString(),Jsoup.parse(msg.getContent().toString()).text(),msg.getSentDate()));
				}
			}

			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			XMLEditor xml=new XMLEditor();
			xml.readFromXML();
			lista.addAll(xml.getListaMail());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 
	 * É fornecida a informação para usar os serviços oferecidos pela JavaMail API.
	 * As credenciais do utilizador, oferecidas nos parametros, são autenticadas.
	 * É criada uma mensagem com o assunto e corpo da mensagem indicados nos parametros e é enviada para o destinatário.
	 * 
	 * 
	 * @param to	e-mail do destinatário
	 * @param username  e-mail do utilizador
	 * @param password	password do utiliador
	 * @param subject	assunto do e-mail a enviar
	 * @param text	corpo da mensagem do e-mail a enviar
	 */

	public void sendEmail(String to, String subject, String text) {

		System.out.println(username+"   "+password);
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

		check(host, mailStoreType, username, password);

	}


	/**
	 * 
	 * Insere num ficheiro xml os e-mails que o utilizador possui na sua mail box, com informção relativa ao ISCTE
	 */

	public void writeMailXML() {
		File datebase = new File("config.xml");
		if (datebase.exists()) {
			System.out.println("A file já existe");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(datebase);
				Node root = doc.getDocumentElement();
				root.normalize();
				Element tree = doc.createElement("Serviço");
				root.appendChild(tree);
				tree.setAttribute("Plataforma", "Mail");
				String autor, post;
				Date data;
				for (MailInfo tdados : lista) {
					autor = tdados.getAutor();
					data = tdados.getData();
					post=tdados.getPost();
					Element mail = doc.createElement("Mail");
					mail.setAttribute("Autor", autor);
					mail.setAttribute("Data", data.toString());
					mail.setTextContent(post);
					tree.appendChild(mail);
				}
				System.out.println("\nSave XML document.");
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				DOMSource source = new DOMSource(doc);
				FileOutputStream foutstream=new FileOutputStream("config.xml");
				StreamResult result = new StreamResult(foutstream);
				transformer.transform(source, result);
				StreamResult consoleResult = new StreamResult(System.out);
				transformer.transform(source, consoleResult);
				foutstream.close();
			} catch (ParserConfigurationException | SAXException | IOException | TransformerFactoryConfigurationError
					| TransformerException e) {
				e.printStackTrace();
			}

		} else {
			try {
				System.out.println("A file não existe");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.newDocument();
				Element rootElement = doc.createElement("Serviços");
				doc.appendChild(rootElement);
				Element tree = doc.createElement("Serviço");
				rootElement.appendChild(tree);
				tree.setAttribute("Plataforma", "Mail");
				String autor, post;
				Date data;
				for (MailInfo tdados : lista) {
					autor = tdados.getAutor();
					data = tdados.getData();
					post=tdados.getPost();
					Element mail = doc.createElement("Mail");
					mail.setAttribute("Autor", autor);
					mail.setAttribute("Data", data.toString());
					mail.setTextContent(post);
					tree.appendChild(mail);
				}
				System.out.println("\nSave XML document.");
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("config.xml"));
				transformer.transform(source, result);
				StreamResult consoleResult = new StreamResult(System.out);
				transformer.transform(source, consoleResult);
			} catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * função verifica se o utilizador está ligado ou não, retorna true quando este efetua o login com sucesso
	 * 
	 * @return true quando efetua o login com sucesso, false quando ainda não o fez
	 * @throws Exception
	 */

	public boolean check() throws Exception { 
		Process process = java.lang.Runtime.getRuntime().exec("ping www.geeksforgeeks.org"); 
		int x = process.waitFor(); 
		if (x == 0) { 
			return true;
		} 
		else { 
			return false;
		} 
	} 





}