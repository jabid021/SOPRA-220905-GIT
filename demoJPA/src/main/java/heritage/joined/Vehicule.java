package heritage.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="vehi")
public abstract class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	protected Integer id;
	
	protected int roues;
	
	public Vehicule() {
	}
	
	public Vehicule(int roues) {
		this.roues = roues;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getRoues() {
		return roues;
	}

	public void setRoues(int roues) {
		this.roues = roues;
	}
	
	
}
