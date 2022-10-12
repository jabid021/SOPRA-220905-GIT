package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Matiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	
	@ManyToOne
	private Formateur formateur;

	
	public Matiere() {
	}


	public Matiere(String libelle, Formateur formateur) {
		this.libelle = libelle;
		this.formateur = formateur;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Formateur getFormateur() {
		return formateur;
	}


	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}


	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}
