package heritage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("elephant")
public class Elephant extends Animal {

	private boolean defenses;

	public Elephant() {
	}
	
	
	public Elephant(double poids, boolean defenses) {
		super(poids);
		this.defenses = defenses;
	}

	public boolean isDefenses() {
		return defenses;
	}

	public void setDefenses(boolean defenses) {
		this.defenses = defenses;
	}

	@Override
	public String toString() {
		return "Elephant [id=" + id + ", poids=" + poids + ", defenses=" + defenses + "]";
	}
	
	
	
	
	
}
