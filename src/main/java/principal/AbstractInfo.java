package principal;

import java.util.Date;

public abstract class AbstractInfo {
	
	private String autor;
	private String post;
	private Date data;
	boolean isTwitter=false;
	boolean isFacebook=false;
	boolean isEmail=false;
	
	public AbstractInfo(String autor, String post, Date data){
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return (this.getPost());
	}

	
	 abstract public boolean checkTwitter();
	 abstract public boolean checkFacebook();
	 abstract public boolean checkEmail();
	

}
