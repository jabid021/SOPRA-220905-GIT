package heritage.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue("felin")
public class Lion extends Animal {

	private boolean sauvage;
	
	
	public Lion() {
	}


	public Lion(double poids, boolean sauvage) {
		super(poids);
		this.sauvage = sauvage;
	}


	public boolean isSauvage() {
		return sauvage;
	}


	public void setSauvage(boolean sauvage) {
		this.sauvage = sauvage;
	}


	@Override
	public String toString() {
		return "Lion [id=" + id + ", poids=" + poids + ", sauvage=" + sauvage + "]";
	}


	
	
	
}
