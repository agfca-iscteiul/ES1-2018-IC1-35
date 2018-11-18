package principal;

import java.util.Date;

public class FacebookInfo extends AbstractInfo {

	public FacebookInfo(String autor, String post, Date data) {
		super(autor, post, data);
	}
	
	@Override
	public boolean checkTwitter() {
		return false;
	}

	@Override
	public boolean checkFacebook() {
		return true;
	}

	@Override
	public boolean checkEmail() {
		return false;
	}
	
	@Override
	public String toString() {
		return ("Autor: " + this.getAutor() + " \n \n" + this.getPost() + " \n \n" + this.getData() + "\n \n \n \n \n");
	}
}
