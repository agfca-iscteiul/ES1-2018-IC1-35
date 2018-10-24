package principal;

public abstract class AbstractInfo {
	
	private String autor;
	private String post;
	private String data;
	boolean isTwitter=false;
	boolean isFacebook=false;
	boolean isEmail=false;
	
	public AbstractInfo(String autor, String post, String data){
		this.autor=autor;
		this.post=post;
		this.data=data;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	

}
