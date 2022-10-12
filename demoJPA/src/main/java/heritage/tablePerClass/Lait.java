package heritage.tablePerClass;

import javax.persistence.Entity;

//@Entity
public class Lait extends Chocolat{

	private int lait;

	public Lait() {
	}


	public Lait(int cacao, int calories, double poids, int lait) {
		super(cacao, calories, poids);
		this.lait = lait;
	}


	public int getLait() {
		return lait;
	}


	public void setLait(int lait) {
		this.lait = lait;
	}


	@Override
	public String toString() {
		return "Lait [id=" + id + ", cacao=" + cacao + ", calories=" + calories + ", poids=" + poids + ", lait=" + lait
				+ "]";
	}



}
