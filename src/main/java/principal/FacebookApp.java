package principal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.Group;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FacebookApp {

	private ArrayList<FacebookInfo> lista = new ArrayList<FacebookInfo>();
	long yourmilliseconds = System.currentTimeMillis();
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
	Date resultdate = new Date(yourmilliseconds);
<<<<<<< HEAD
	private ArrayList<String> tokens = new ArrayList<String>();
	private String firstExtend, secondExtend;

=======
	String accessToken = "EAAEfJq3XIicBAHbGP4KfR5crUqfFU7NDj7HZBwZAvdirRjUSmYx1LE6ozGqTKz8MGf2hHF5fIgDHlzfmyLr7vaagVS1TZA0cI4NUOtW1pebeZBmQkqDd6ESCcl0kDHB499kRi5ojT3hQFBSexGx5sNbUP9kkwdo01kB4XSqUOBK6ZAhAyQg1M0ZAhZBRmbozC9Oh06izXb2PHm1YXD43dcZBhpvDEAFWi2IZD";
>>>>>>> branch 'master' of https://github.com/agfca-iscteiul/ES1-2018-IC1-35
	public FacebookApp() {

	}

	/**
	 * Aceder ao Token e extender o tempo do mesmo através da API RestFB, imprimir
	 * os post da timeline do user com a palavra "ISCTE" e adiciona-los ao array
	 * como FacebookInfo
	 */
	public void runFacebook() {
		try {
<<<<<<< HEAD
			String accessToken = "EAAEfJq3XIicBAMaihs0igfAGMdbmyrWFEOgWlh8RcZBCAvEgegZCqIoMvun6VrhXyo3g4x8cNp9qM7AUVEZBhfG8ZAUQO7SONOJusYjZCExUtqdXp1Bbo0gTVwEyx2HIiU9zKXlg7mueaYszb2HwscRO4ZCXXhLEumNQUApPIB5mQ8J1ZCe1xOw0ez7q8pU9ciZAdxq9M0d5gddr59DWNuMlWAeMTZCXnxhcZD";
=======
>>>>>>> branch 'master' of https://github.com/agfca-iscteiul/ES1-2018-IC1-35
			FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_12);
			User me = fbClient.fetchObject("me", User.class);

			tokens.add(accessToken);
			firstExtend = "315725962486311";
			secondExtend = "e4a7080fe0f8b1d33e682f71875971f0";

			// Extender o tempo do token
			AccessToken exAcessToken = fbClient.obtainExtendedAccessToken(firstExtend, secondExtend);
			tokens.add(firstExtend);
			tokens.add(secondExtend);
			System.out.println(exAcessToken.getAccessToken() + exAcessToken.getExpires());
			System.out.println(exAcessToken.toString());

			// Imprimir os post da timeline do user

			Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);

			for (List<Post> page : result) {
				for (Post aPost : page) {
					// Filters only posts that contain the word "ISCTE"
					if (aPost.getMessage() != null/* && aPost.getMessage().contains("ISCTE") */) {
						lista.add(new FacebookInfo(me.getName(), aPost.getMessage(), aPost.getCreatedTime()));
						System.out.println("added to list");
					}
				}
				tokens.add(accessToken);
			}

			Connection<Group> groupFeed = fbClient.fetchConnection("me/groups", Group.class);

			for (List<Group> page : groupFeed) {
				for (Group aGroup : page) {
					System.out.println("fb.com/" + aGroup.getId());
					System.out.println("Post deste grupo");
					Connection<Post> postFeed = fbClient.fetchConnection(aGroup.getId() + "/feed", Post.class);
					for (List<Post> postPage : postFeed) {
						for (Post aPost : postPage) {

							lista.add(new FacebookInfo("ES", aPost.getMessage(), resultdate));
						}
					}
				}
			}

			// Postar na timeline de grupos aos quais somos admin
			// ***********FacebookType response = fbClient.publish("372019400036311/feed",
			// FacebookType.class, Parameter.with("message", "testetesteteste"));
			// Se quisermos acrescentar um link
			// FacebookType response = fbClient.publish("id grupo/feed", FacebookType.class,
			// Parameter.with("message", "testetesteteste"), Parameter.with("link",
			// "www.google.pt"));
			// Para publicar uma imagem
			// FileInputStream file = new FileInputStream(new File(local onde imagem está no
			// disco));
			// FacebookType response = fbClient.publish("id grupo/feed", FacebookType.class,
			// binaryAttachment.with("nomeimg", file), Parameter.with("message",
			// "testetesteteste"));
			// FileInputStream file = new FileInputStream(new File(local onde video está no
			// disco));
			// FacebookType response = fbClient.publish("id grupo/feed", FacebookType.class,
			// binaryAttachment.with("nomevideo", file), Parameter.with("message",
			// "testetesteteste"));

			// System.out.println("fb.com/"+response.getId());

		} catch (Exception e) {
			// XMLEditor xml = new XMLEditor();
			// xml.readFromXML();
			// lista.addAll(xml.getListaFacebook());
		}
	}

	public ArrayList<FacebookInfo> getListPost() {
		return lista;

	}
<<<<<<< HEAD

	public ArrayList<String> getListTokens() {
		return tokens;
	}

	/*
	 * public void publicGroup(String content()) {
	 * 
	 * }
	 */
=======
	
	
	public void publicGroup(String content) {
		//a publicar no grupo ES que a conta é administradora
		FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_12);
		FacebookType response = fbClient.publish("372019400036311/feed", FacebookType.class, Parameter.with("message", content));
	}
>>>>>>> branch 'master' of https://github.com/agfca-iscteiul/ES1-2018-IC1-35
	/**
	 * Transformar as lista de FacebookInfo para listas AbstractInfo
	 * 
	 * @return lista AbstractInfo com os post
	 */
	public ArrayList<AbstractInfo> getList() {
		ArrayList<AbstractInfo> listaaux = new ArrayList<AbstractInfo>();
		for (FacebookInfo post : lista) {
			listaaux.add(post);
		}
		return listaaux;
	}

	/**
	 * Escrever no ficheiro XML todos os post do facebook
	 */
	// Escrever no ficheiro XML
	public void writeFacebookXML() {
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
				tree.setAttribute("Plataforma", "Facebook");
				System.out.println(tokens);
				tree.setAttribute("TokenAcesso", tokens.get(0));
				tree.setAttribute("ObterExtensao1", tokens.get(1));
				tree.setAttribute("ObterExtensão2", tokens.get(2));
				String autor, post;
				Date data;
				for (FacebookInfo tdados : lista) {
					autor = tdados.getAutor();
					data = tdados.getData();
					post = tdados.getPost();
					Element tweet = doc.createElement("Post");
					tweet.setAttribute("Autor", autor);
					tweet.setAttribute("Data", data.toString());
					tweet.setTextContent(post);
					tree.appendChild(tweet);
				}
				System.out.println("\nSave XML document.");
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				DOMSource source = new DOMSource(doc);
				FileOutputStream foutstream = new FileOutputStream("config.xml");
				StreamResult result = new StreamResult(foutstream);
				transformer.transform(source, result);
				StreamResult consoleResult = new StreamResult(System.out);
				transformer.transform(source, consoleResult);
				foutstream.close();
			} catch (ParserConfigurationException | SAXException | TransformerFactoryConfigurationError
					| TransformerException | IOException e) {
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
				tree.setAttribute("Plataforma", "Facebook");
				String autor, post;
				Date data;
				for (FacebookInfo tdados : lista) {
					autor = tdados.getAutor();
					data = tdados.getData();
					post = tdados.getPost();
					Element tweet = doc.createElement("Post");
					tweet.setAttribute("Autor", autor);
					tweet.setAttribute("Data", data.toString());
					tweet.setTextContent(post);
					tree.appendChild(tweet);
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
}
