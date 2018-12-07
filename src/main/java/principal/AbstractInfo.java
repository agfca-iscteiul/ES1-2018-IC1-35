package principal;

import java.util.Date;

public abstract class AbstractInfo {

	private String autor;
	private String post;
	private Date data;
	boolean isTwitter = false;
	boolean isFacebook = false;
	boolean isEmail = false;

	/**
	 * Cria a classe
	 * 
	 * @param autor Autor
	 * @param post  Post
	 * @param data  Data
	 */
	public AbstractInfo(String autor, String post, Date data) {
		this.autor = autor;
		this.post = post;
		this.data = data;
	}

	/**
	 * Obtem o autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Obter o post
	 */
	public String getPost() {
		return post;
	}

	/**
	 * Obter o conteudo
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Escreve a data e o conteudo da mensagem
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return ("  " + this.getData() + "  " + this.getPost());
	}

	/**
	 * Verifica se a fonte de informação é o twitter
	 */
	abstract public boolean checkTwitter();

	/**
	 * Verifica se a fonte de informação é o facebook
	 */
	abstract public boolean checkFacebook();

	/**
	 * Verifica se a fonte de informação é o email
	 */
	abstract public boolean checkEmail();

}
