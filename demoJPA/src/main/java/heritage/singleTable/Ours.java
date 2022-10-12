package heritage.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue("ours")
public class Ours extends Animal {

	public Ours() {
	}

	public Ours(double poids) {
		super(poids);
	}

	@Override
	public String toString() {
		return "Ours [id=" + id + ", poids=" + poids + "]";
	}
	
	
	
}
