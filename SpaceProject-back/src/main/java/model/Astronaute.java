package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Astronaute extends Compte {
	
	@Column(length = 30)
	private String nom;
	
	@Column(length = 30)
	private String prenom;
	
	@Column(name="debut")
	private LocalDate debutCarriere;
	
	@Column(columnDefinition = "tinyint(4)")
	private boolean actif;
	
	@ManyToMany(mappedBy = "astronautes")
	private List<Mission> missions = new ArrayList();;
	

	public Astronaute() {

		
	}

	
	public Astronaute(String password, String login, Adresse adresse, String nom, String prenom,
			LocalDate debutCarriere, boolean actif) {
		super(password, login, adresse);
		this.nom = nom;
		this.prenom = prenom;
		this.debutCarriere = debutCarriere;
		this.actif = actif;
	}

	
	public Astronaute(Integer id,String password, String login, Adresse adresse, String nom, String prenom,
			LocalDate debutCarriere, boolean actif) {
		super(id,password, login, adresse);
		this.nom = nom;
		this.prenom = prenom;
		this.debutCarriere = debutCarriere;
		this.actif = actif;
	}
	
	
	
	public List<Mission> getMissions() {
		return missions;
	}


	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDebutCarriere() {
		return debutCarriere;
	}

	public void setDebutCarriere(LocalDate debutCarriere) {
		this.debutCarriere = debutCarriere;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}


	@Override
	public String toString() {
		return "Astronaute [id=" + id + ", password=" + password + ", login=" + login + ", adresse=" + adresse
				+ ", nom=" + nom + ", prenom=" + prenom + ", debutCarriere=" + debutCarriere + ", actif=" + actif + "]";
	}

	





}
