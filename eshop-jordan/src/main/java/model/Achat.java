package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Achat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="acheteur",nullable = false)
	private Client acheteur;
	
	@ManyToOne
	@JoinColumn(name="produit",nullable = false)
	private Produit produit;

	
	public Achat() {
	}


	public Achat(Client acheteur, Produit produit) {
		this.acheteur = acheteur;
		this.produit = produit;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Client getAcheteur() {
		return acheteur;
	}


	public void setAcheteur(Client acheteur) {
		this.acheteur = acheteur;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	@Override
	public String toString() {
		return "Achat [id=" + id + ", acheteur=" + acheteur + ", produit=" + produit + "]";
	}
	
	
	
}
