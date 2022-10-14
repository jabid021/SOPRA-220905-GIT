package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Vaisseau implements Serializable {
	
	private Integer id;
	private String nom;
	private int capacite;
	private LocalDate miseEnService;
	private boolean fonctionnel;
	private TypeVaisseau typeVaisseau ;
	
	public Vaisseau(String nom, int capacite, LocalDate miseEnService, boolean fonctionnel,TypeVaisseau typeVaisseau) {
		this.nom = nom;
		this.capacite = capacite;
		this.miseEnService = miseEnService;
		this.fonctionnel = fonctionnel;
		this.typeVaisseau = typeVaisseau; 
	}
	
	public Vaisseau(Integer id,String nom, int capacite, LocalDate miseEnService, boolean fonctionnel,TypeVaisseau typeVaisseau) {
		this.id=id;
		this.nom = nom;
		this.capacite = capacite;
		this.miseEnService = miseEnService;
		this.fonctionnel = fonctionnel;
		this.typeVaisseau = typeVaisseau; 
	}
	
	
	
	//GETTERS
	public String getNom() {
		return nom;
	}

	public int getCapacite() {
		return capacite;
	}
	
	public LocalDate getMiseEnService() {
		return miseEnService;
	}

	public boolean isFonctionnel() {
		return fonctionnel;
	}

	public TypeVaisseau getTypeVaisseau() {
		return typeVaisseau;
	}
	
	//SETTERS
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public void setMiseEnService(LocalDate miseEnService) {
		this.miseEnService = miseEnService;
	}

	public void setFonctionnel(boolean fonctionnel) {
		this.fonctionnel = fonctionnel;
	}
	
	public void setTypeVaisseau(TypeVaisseau typeVaisseau) {
		this.typeVaisseau = typeVaisseau;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vaisseau [id=" + id + ", nom=" + nom + ", capacite=" + capacite + ", miseEnService=" + miseEnService
				+ ", fonctionnel=" + fonctionnel + ", typeVaisseau=" + typeVaisseau + "]";
	}

	
	
	
	
	
	
	
	
}
