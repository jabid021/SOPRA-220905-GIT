package model;

import java.io.Serializable;

public class Pays implements Serializable {
	
	private Integer id;
	private String nom;
	
	

	public Pays(String nom) {
		this.nom = nom;
	}
	
	public Pays(Integer id,String nom) {
		this.id=id;
		this.nom = nom;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pays [id=" + id + ", nom=" + nom + "]";
	}
	
	

	
	
	

}
