package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ordinateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marque;
	
	
	@OneToOne(mappedBy = "ordi")
	private Personne utilisateur;
	
	
	
	public Ordinateur() {
	}
	
	public Ordinateur(String marque) {
		this.marque = marque;
	}
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	
	
	public Personne getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Personne utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Ordinateur [id=" + id + ", marque=" + marque + "]";
	}
	
	
	
	
	
	
}
