package principal;

public class MailInfo extends AbstractInfo{
	
	public MailInfo(String autor, String post, String data) {
		super(autor, post, data);
	}

	@Override
	public boolean checkTwitter() {
		return false;
	}

	@Override
	public boolean checkFacebook() {
		return false;
	}

	@Override
	public boolean checkEmail() {
		return true;
	}
	

}
