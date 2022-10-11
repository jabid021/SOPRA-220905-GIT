package heritage.joined;

import javax.persistence.Entity;

//@Entity
public class Bateau extends Vehicule{

	private boolean hs;
	private String nom;

	
	public Bateau() {
	
	}



	public Bateau(int roues, boolean hs, String nom) {
		super(roues);
		this.hs = hs;
		this.nom=nom;
	}



	public boolean isHs() {
		return hs;
	}



	public void setHs(boolean hs) {
		this.hs = hs;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	@Override
	public String toString() {
		return "Bateau [id=" + id + ", roues=" + roues + ", hs=" + hs + ", nom=" + nom + "]";
	}
	
	
	
	
}
