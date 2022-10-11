package heritage.tablePerClass;

import javax.persistence.Entity;

//@Entity
public class Praline extends Chocolat{

	private int praline;
	

	public Praline() {
	}


	public Praline(int cacao, int calories, double poids, int praline) {
		super(cacao, calories, poids);
		this.praline = praline;
	}


	public int getPraline() {
		return praline;
	}


	public void setPraline(int praline) {
		this.praline = praline;
	}


	@Override
	public String toString() {
		return "Praline [id=" + id + ", cacao=" + cacao + ", calories=" + calories + ", poids=" + poids + ", praline="
				+ praline + "]";
	}
	
	
	
	
}
