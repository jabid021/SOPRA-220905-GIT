package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable{
	
	@Column(nullable = false,columnDefinition = "VARCHAR(8) default 'NULL'")
	private String numero;
	
	@Column(nullable = false,columnDefinition = "VARCHAR(50) default 'NULL'")
	private String voie;
	
	@Column(nullable = false,columnDefinition = "VARCHAR(50) default 'NULL'")
	private String ville;
	
	@Column(nullable = false,columnDefinition = "VARCHAR(10) default 'NULL'")
	private String cp;
	
	@Column(nullable = false,columnDefinition = "INT(8) default 'NULL'")
	private Pays pays;

	
	public Adresse() {
	}
	
	public Adresse(String numero, String voie, String ville, String cp, Pays pays) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
		this.pays = pays;
	}


	public Pays getPays() {
		return pays;
	}


	public void setPays(Pays pays) {
		this.pays = pays;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", ville=" + ville + ", cp=" + cp + ", pays=" + pays
				+ "]";
	}
	
	
	
}
