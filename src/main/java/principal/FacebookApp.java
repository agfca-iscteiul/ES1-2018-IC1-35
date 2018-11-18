package principal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.restfb.Version;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FacebookApp {
	private ArrayList<FacebookInfo> lista = new ArrayList<FacebookInfo>();

	public FacebookApp() {

	}
	
	/**
	 * Aceder ao Token e extender o tempo do mesmo, imprimir os post da timeline do user e adiciona-los ao array como FacebookInfo
	 */
	public void runFacebook() {
		try {
			String accessToken = "EAAffZC9Xl8dEBAOpvb3CAZAKWziOZA6jxu5Fda0cuTg3z2vreASSR83nZAy2O7KYxOXg2nsLL8u4EOP1rMsXhG3hKtQiZCjxo7fWZASdwWTVH9Ks0gPIUSvCUHUZBbiqFO7HlqDWOSpp02O7AZA7aed1txz3VEMBudSgkk0QxtTjLDVzFbAGrtz2OLUpipWyxQq90gFVxedI6xiUVX3Yn0oO";
			FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_12);
			User me = fbClient.fetchObject("me", User.class);

			// Imprimir Nome e ID
			System.out.println("Facebook:");
			System.out.println("Id: " + me.getId());
			System.out.println("Name: " + me.getName()); 

			// Extender o tempo do token
			AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("2216614735245777",
					"47baee1d3c2b6366f7212a3dfa403dd3");
			System.out.println("ExtendedAccessToken: " + extendedAccessToken.getAccessToken());
			System.out.println("Expires: " + extendedAccessToken.getExpires());
			System.out.println("1");
			
			// Imprimir os post da timeline do user
			Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
			System.out.println("2");
			System.out.println("\nPosts:");
			int counter = 0;
			int counterTotal = 0;
			for (List<Post> page : result) {
				for (Post aPost : page) {
					// Filters only posts that contain the word "ISCTE"
					if (aPost.getMessage() != null && aPost.getMessage().contains("ISCTE")) {
						lista.add(new FacebookInfo(me.getName(), aPost.getMessage(), aPost.getCreatedTime()));
						counter++;
					}
					counterTotal++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	/**
	 * Transformar as lista de FacebookInfo para listas AbstractInfo
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
					tree.setAttribute("Nome", "Facebook");
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
					StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
					transformer.transform(source, result);
					StreamResult consoleResult = new StreamResult(System.out);
					transformer.transform(source, consoleResult);
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
					tree.setAttribute("Nome", "Facebook");
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