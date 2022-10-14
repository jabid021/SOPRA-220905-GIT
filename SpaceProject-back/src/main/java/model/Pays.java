package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Pays implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	
	@OneToMany(mappedBy = "pays")
	private List<Mission> missions;
	
	public Pays() {
	}
	

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
