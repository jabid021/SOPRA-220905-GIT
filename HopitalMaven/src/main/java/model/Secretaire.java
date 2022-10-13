package model;

import javax.persistence.Entity;

@Entity
public class Secretaire extends Compte {

	
	public Secretaire() {
		
	}
	
	public Secretaire(Integer id, String mail, String password) {
		super(id, mail, password);

	}	
	

	
}
