package principal;

import java.util.Date;

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
	
}