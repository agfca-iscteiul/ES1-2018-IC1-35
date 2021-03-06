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

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterApp {

	private ArrayList<TwitterInfo> lista = new ArrayList<TwitterInfo>(); 
	private String consumerKey = "7jt7DCYjdjYjGoBaDPYCdYpvi";
	private String consumerSecret = "PktQuGnaU4SzMhmouwq0rR6EzOhe0wpFYYqhbqmHOG6XEh3Ypn";
	private String accessToken = "1067778655647121408-aMtSPX7fC5fjoke9yXbJaqr6zeH8Wd";
	private String accessTokenSecret = "xhqjK3CITYEeVHop8VjOPsM87pUrDMgRjdzLSyk2tyTJR";

	public TwitterApp() {

	}

	/**
	 * Aceder ao Token atravers da API twitter4j, imprimir os tweets da timeline do user com a palavra "ISCTE" e adiciona-los ao array como TwitterInfo
	 */
	public void runTwitter() { 
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessTokenSecret);
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			List<Status> statuses = twitter.getHomeTimeline();
			for (Status status : statuses) {
				if (status.getUser().getName() != null && status.getUser().getName().contains("ISCTE")) {
					lista.add(new TwitterInfo(status.getUser().getName(), status.getText(),
							status.getCreatedAt()));
				}

			}
		} catch (Exception e) {
			XMLEditor xml=new XMLEditor();
			xml.readFromXML();
			lista.addAll(xml.getListaTwitter());
		}
	}
	
	/**
	 * 
	 * Envio de tweets com o conteúdo que o utilizador apresentar na interface
	 * 
	 * @param content Texto que o utilizador pretender que o tweet tenha
	 */


	public void tweet(String content) {
		TwitterFactory twitterFactory = new TwitterFactory();
		Twitter twitter = twitterFactory.getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		AccessToken accessToken2 = new AccessToken(accessToken, accessTokenSecret);
		twitter.setOAuthAccessToken(accessToken2);
		try {
			Status status = twitter.updateStatus(content);
		} catch (TwitterException e) {
			System.out.println("not sending");
			e.printStackTrace();
		}
	}	
	
	/**
	 * 
	 * Retweetar determinado tweet através do ID desse
	 * 
	 * @param tweetId ID do tweet selecionado
	 */

	public void retweet(Long tweetId) {
		TwitterFactory factory = new TwitterFactory();
		Twitter twitter = factory.getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		AccessToken accessToken2 = new AccessToken(accessToken, accessTokenSecret);
		twitter.setOAuthAccessToken(accessToken2);
		try {
			twitter.retweetStatus(tweetId);
		} catch (TwitterException e) {
			System.out.println("Erro no Retweet!");
			e.printStackTrace();
		}
	}

	public ArrayList<TwitterInfo> getListPost(){
		return lista;
	}

	/**
	 * Transformar a lista de TwitterInfo para listas AbstractInfo
	 * @return lista AbstractInfo com os tweets
	 */
	public ArrayList<AbstractInfo> getList() {
		ArrayList<AbstractInfo> listaaux = new ArrayList<AbstractInfo>();
		for (TwitterInfo post : lista) {
			listaaux.add(post);
		}
		return listaaux;
	}

	/**
	 * Escrever no ficheiro XML todos os tweets do Twitter
	 */
	public void writeTwitterXML() {
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
				tree.setAttribute("Plataforma", "Twitter");
				String autor, post;
				Date data;
				for (TwitterInfo tdados : lista) {
					autor = tdados.getAutor();
					data = tdados.getData();
					post = tdados.getPost();
					Element tweet = doc.createElement("Tweet");
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
				tree.setAttribute("Plataforma", "Twitter");
				String autor, post;
				Date data;
				for (TwitterInfo tdados : lista) {
					autor = tdados.getAutor();
					data = tdados.getData();
					post = tdados.getPost();
					Element tweet = doc.createElement("Tweet");
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
