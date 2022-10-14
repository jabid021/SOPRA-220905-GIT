package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vaisseau")
public class Vaisseau implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
   @Column(columnDefinition = "varchar(25) ", nullable = false)
	private String nom;

	
	private int capacite;
	@Column(name="date_service",columnDefinition = "date ", nullable = false)
	private LocalDate miseEnService;
	@Column(nullable = false)
	private boolean fonctionnel;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type_vaisseau",columnDefinition = "ENUM('Fusee','Navette','Sonde')")
	private TypeVaisseau typeVaisseau ;
	
	@OneToMany(mappedBy = "vaisseau")
	private List<Mission> missions;
	
	
	public Vaisseau(String nom, int capacite, LocalDate miseEnService, boolean fonctionnel,TypeVaisseau typeVaisseau) {
		this.nom = nom;
		this.capacite = capacite;
		this.miseEnService = miseEnService;
		this.fonctionnel = fonctionnel;
		this.typeVaisseau = typeVaisseau; 
	}
	
	public Vaisseau(Integer id,String nom, int capacite, LocalDate miseEnService, boolean fonctionnel,TypeVaisseau typeVaisseau) {
		this.id=id;
		this.nom = nom;
		this.capacite = capacite;
		this.miseEnService = miseEnService;
		this.fonctionnel = fonctionnel;
		this.typeVaisseau = typeVaisseau; 
	}
	
	
	
	public Vaisseau() {
		super();
	}

	//GETTERS
	public String getNom() {
		return nom;
	}

	public int getCapacite() {
		return capacite;
	}
	
	public LocalDate getMiseEnService() {
		return miseEnService;
	}

	public boolean isFonctionnel() {
		return fonctionnel;
	}

	public TypeVaisseau getTypeVaisseau() {
		return typeVaisseau;
	}
	
	//SETTERS
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public void setMiseEnService(LocalDate miseEnService) {
		this.miseEnService = miseEnService;
	}

	public void setFonctionnel(boolean fonctionnel) {
		this.fonctionnel = fonctionnel;
	}
	
	public void setTypeVaisseau(TypeVaisseau typeVaisseau) {
		this.typeVaisseau = typeVaisseau;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vaisseau [id=" + id + ", nom=" + nom + ", capacite=" + capacite + ", miseEnService=" + miseEnService
				+ ", fonctionnel=" + fonctionnel + ", typeVaisseau=" + typeVaisseau + "]";
	}

	
	
	
	
	
	
	
	
}
