package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="modules")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cours")
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="stagiaire")
	private Personne apprenant;
	

	
	
	
	public Module() {
		
	}



	public Module(Matiere matiere, Personne apprenant) {
		this.matiere = matiere;
		this.apprenant = apprenant;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Matiere getMatiere() {
		return matiere;
	}



	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}



	public Personne getApprenant() {
		return apprenant;
	}



	public void setApprenant(Personne apprenant) {
		this.apprenant = apprenant;
	}



	@Override
	public String toString() {
		return "Module [id=" + id + ", matiere=" + matiere + ", apprenant=" + apprenant + "]";
	}
	
	
	
}
