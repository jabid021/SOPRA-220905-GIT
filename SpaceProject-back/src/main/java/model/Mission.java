package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="mission")
public class Mission  implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="debut",nullable = false)
	private LocalDate dateDebut;
	
	@Column(name="fin",nullable = false)
	private LocalDate dateFin;
	
	@Column(nullable = false,length = 30)
	private String objectif;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="pays",nullable = false)
	private Pays pays;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Prevu', 'EnCours', 'Retarde', 'Termine', 'Annule')")
	private Statut statut;
	
	@ManyToOne
	@JoinColumn(name="planete",nullable = false)
	private Planete planete;
	
	@ManyToOne
	@JoinColumn(name="vaisseau")
	private Vaisseau vaisseau;
	
	@ManyToMany
	@JoinTable(name="participation",joinColumns = @JoinColumn(name="mission"),inverseJoinColumns = @JoinColumn(name="astronaute"))
	private List<Astronaute> astronautes =new ArrayList();
		
	
	public Mission() {
	}
	



	public Mission(LocalDate dateDebut, LocalDate dateFin, String objectif, String description, Pays pays,
			Statut statut, Planete planete, Vaisseau vaisseau) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.objectif = objectif;
		this.description = description;
		this.pays = pays;
		this.statut = statut;
		this.planete = planete;
		this.vaisseau = vaisseau;
	}

	
	public Mission(Integer id,LocalDate dateDebut, LocalDate dateFin, String objectif, String description, Pays pays,
			Statut statut, Planete planete, Vaisseau vaisseau) {
		this.id=id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.objectif = objectif;
		this.description = description;
		this.pays = pays;
		this.statut = statut;
		this.planete = planete;
		this.vaisseau = vaisseau;
	}
	
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}


	public LocalDate getDateFin() {
		return dateFin;
	}


	public String getObjectif() {
		return objectif;
	}


	public String getDescription() {
		return description;
	}


	public Pays getPays() {
		return pays;
	}


	public Statut getStatut() {
		return statut;
	}


	public Planete getPlanete() {
		return planete;
	}


	public Vaisseau getVaisseau() {
		return vaisseau;
	}


	public List<Astronaute> getAstronautes() {
		return astronautes;
	}


	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setPays(Pays pays) {
		this.pays = pays;
	}


	public void setStatut(Statut statut) {
		this.statut = statut;
	}


	public void setPlanete(Planete planete) {
		this.planete = planete;
	}


	public void setVaisseau(Vaisseau vaisseau) {
		this.vaisseau = vaisseau;
	}


	public void setAstronautes(List<Astronaute> astronautes) {
		this.astronautes = astronautes;
	}
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}




	@Override
	public String toString() {
		return "Mission [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", objectif=" + objectif
				+ ", description=" + description + ", pays=" + pays + ", statut=" + statut + ", planete=" + planete
				+ ", vaisseau=" + vaisseau + "]";
	}


}
