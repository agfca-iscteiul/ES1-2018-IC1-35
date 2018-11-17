package principal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
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
		File data = new File("database.xml");
		try {
			if (data.createNewFile()) {

			} else {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(data);
				doc.getDocumentElement().normalize();
				
			}
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	}

}
