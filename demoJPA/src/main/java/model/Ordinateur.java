package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordinateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marque;
	
	public Ordinateur() {
	}
	
	public Ordinateur(String marque) {
		this.marque = marque;
	}
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	@Override
	public String toString() {
		return "Ordinateur [id=" + id + ", marque=" + marque + "]";
	}
	
	
	
	
	
	
}
