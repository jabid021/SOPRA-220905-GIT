package heritage.tablePerClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

//@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(sequenceName = "seqChocolat",name = "seqJPA")
public abstract class Chocolat {

	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE ,generator = "seqJPA")
	@Column(name="id_chocolat")
	protected Integer id;
	protected int cacao;
	protected int calories;
	protected double poids;
	
	
	public Chocolat() {
	}


	public Chocolat(int cacao, int calories, double poids) {
		this.cacao = cacao;
		this.calories = calories;
		this.poids = poids;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getCacao() {
		return cacao;
	}


	public void setCacao(int cacao) {
		this.cacao = cacao;
	}


	public int getCalories() {
		return calories;
	}


	public void setCalories(int calories) {
		this.calories = calories;
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	
	
	
	
}
