package model;

public class Admin extends Compte{
	
	public Admin(String login, String password, Adresse adresse) {
		super(login, password, adresse);
	
	}
	
	public Admin(Integer id,String login, String password) {
		super(id,login, password);
	
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + ", login=" + login + ", adresse=" + adresse + "]";
	}

	
}
