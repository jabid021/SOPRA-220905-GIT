package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name="num",nullable = false)
	private String numero;
	
	@Column(nullable = false)
	private String voie;
	
	public Adresse() {
	}

	public Adresse(String numero, String voie) {
		this.numero = numero;
		this.voie = voie;
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

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + "]";
	}
	
	
	
}
