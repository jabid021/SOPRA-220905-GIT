package heritage.tablePerClass;

import javax.persistence.Entity;

//@Entity
public class Blanc extends Chocolat{

	private int gras;
	

	public Blanc() {
	}


	public Blanc(int cacao, int calories, double poids, int gras) {
		super(cacao, calories, poids);
		this.gras = gras;
	}


	public int getGras() {
		return gras;
	}


	public void setGras(int gras) {
		this.gras = gras;
	}


	@Override
	public String toString() {
		return "Blanc [id=" + id + ", cacao=" + cacao + ", calories=" + calories + ", poids=" + poids + ", gras=" + gras
				+ "]";
	}
	
	
	
}
