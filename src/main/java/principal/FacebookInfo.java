package principal;

import java.util.Date;

public class FacebookInfo extends AbstractInfo {

	/**
	 * Obter o username
	 */
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
	
}
