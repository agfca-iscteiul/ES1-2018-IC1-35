package principal;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterMain {
	
	
	public static void main(String[] args) {
		List<TwitterS> lista = new ArrayList<TwitterS>();
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
					lista.add(new TwitterS(status.getUser().getName(), status.getText(), status.getCreatedAt().toString()));
				}
			
			}
			for(TwitterS lst : lista) {
				System.out.println("Autor: " + lst.getAutor() + " \n \n" + lst.getPost() + " \n \n" + lst.getData() + "\n \n \n \n \n");
				
				
			}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
	}
}
