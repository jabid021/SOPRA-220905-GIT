package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Formateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	
	@OneToMany(mappedBy = "formateur")
	private List<Matiere> matieres;
	
	
	public Formateur() {
	}


	public Formateur(String nom) {
		this.nom = nom;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public List<Matiere> getMatieres() {
		return matieres;
	}


	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}


	@Override
	public String toString() {
		return "Formateur [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
