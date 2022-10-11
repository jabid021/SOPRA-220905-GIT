package heritage.joined;

import javax.persistence.Entity;

//@Entity
public class Avion extends Vehicule {

	private Integer capacite;
	
	
	public Avion() {
		
	}


	public Avion(int roues, Integer capacite) {
		super(roues);
		this.capacite = capacite;
	}


	public Integer getCapacite() {
		return capacite;
	}


	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}


	@Override
	public String toString() {
		return "Avion [id=" + id + ", roues=" + roues + ", capacite=" + capacite + "]";
	}
	
	
	
	
	
}
