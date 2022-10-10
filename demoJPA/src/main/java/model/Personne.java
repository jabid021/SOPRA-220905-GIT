package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity //OBLIGATOIRE
public class Personne {

	@Id //OBLIGATOIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SEMI-OBLIGATOIRE
	private Integer numero;
	private String nom;
	private String prenom;
	private LocalDate naissance;
	private boolean formateur;
	private Double salaire;
	
	
	//Constructeur vide OBLIGATOIRE
	public Personne() {
	}

	public Personne(String nom, String prenom, LocalDate naissance, boolean formateur, Double salaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.formateur = formateur;
		this.salaire = salaire;
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
	public LocalDate getNaissance() {
		return naissance;
	}
	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	public boolean isFormateur() {
		return formateur;
	}
	public void setFormateur(boolean formateur) {
		this.formateur = formateur;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", formateur=" + formateur
				+ ", salaire=" + salaire + "]";
	}
	
	
	
	
	
	
}
