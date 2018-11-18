package principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterInfo extends AbstractInfo {
	
	public TwitterInfo(String autor, String post, Date data) {
		super(autor, post, data);
	}

	@Override
	public boolean checkTwitter() {
		return true;
	}

	@Override
	public boolean checkFacebook() {
		return false;
	}

	@Override
	public boolean checkEmail() {
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Autor: " + this.getAutor() + " \n \n" + this.getPost() + " \n \n" + this.getData() + "\n \n \n \n \n");
	}

}