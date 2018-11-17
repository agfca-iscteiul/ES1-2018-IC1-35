package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterApp {

	private List<TwitterInfo> lista = new ArrayList<TwitterInfo>();

	public TwitterApp() {

	}

	public void runTwitter() {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("W1f0VvgWPfT8OBqVxvy4Mw")
					.setOAuthConsumerSecret("zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw")
					.setOAuthAccessToken("36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c")
					.setOAuthAccessTokenSecret("OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			List<Status> statuses = twitter.getHomeTimeline();
			for (Status status : statuses) {
				if (status.getUser().getName() != null && status.getUser().getName().contains("ISCTE")) {
					lista.add(new TwitterInfo(status.getUser().getName(), status.getText(),
							status.getCreatedAt().toString()));
				}

			}
			// for(TwitterInfo lst : lista) {
			// System.out.println(lst);
			//
			// }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<AbstractInfo> getList() {
		List<AbstractInfo> listaaux = new ArrayList<AbstractInfo>();
		for (TwitterInfo post : lista) {
			listaaux.add(post);
		}
		return listaaux;
	}

	public void writeTwitterXML() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element rootElement = doc.createElement("Serviços");
			doc.appendChild(rootElement);
			Element tree = doc.createElement("Serviço");
			rootElement.appendChild(tree);
			tree.setAttribute("serv", "Twitter");
			String autor, data, post;
			for (TwitterInfo tdados : lista) {
				autor = tdados.getAutor();
				data = tdados.getData();
				post = tdados.getPost();
				Element tweet = doc.createElement("Tweet");
				tweet.setAttribute("Autor", autor);
				tweet.setAttribute("Data", data);
				tweet.setTextContent(post);
				tree.appendChild(tweet);
			}
			System.out.println("\nSave XML document.");
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("database.xml"));
			transformer.transform(source, result);
			StreamResult consoleResult = new StreamResult(System.out);
	        transformer.transform(source, consoleResult);
			System.out.println("File saved!!");
		} catch (ParserConfigurationException | TransformerFactoryConfigurationError |
				TransformerException e) {
			e.printStackTrace();
		}
	}

}
