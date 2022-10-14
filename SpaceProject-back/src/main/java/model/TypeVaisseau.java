package model;

public enum TypeVaisseau {
	Fusee(20),Navette(28),Sonde(35);
	
	private int vitesse;
	
	private TypeVaisseau(int vitesse) {
		this.vitesse = vitesse;
	}
	
	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
}
