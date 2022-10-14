package model;

import java.io.Serializable;

public abstract class Compte implements Serializable {
	
	protected Integer id;
	protected String password;
	protected String login;
	protected Adresse adresse;


	public Compte(String password, String login, Adresse adresse) {
		this.password = password;
		this.login = login;
		this.adresse = adresse;
	}

	
	public Compte(Integer id,String password, String login, Adresse adresse) {
		this.id=id;
		this.password = password;
		this.login = login;
		this.adresse = adresse;
	}

	public Compte(Integer id,String password, String login) {
		this.id=id;
		this.password = password;
		this.login = login;
	}


	public Adresse getAdresse() {
		return adresse;
	}




	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

