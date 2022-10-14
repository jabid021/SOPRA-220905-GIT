package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mission  implements Serializable {
	
	private Integer id;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String objectif;
	private String description;
	private Pays pays;
	private Statut statut;
	private Planete planete;
	private Vaisseau vaisseau;
	private List<Astronaute> astronautes =new ArrayList();
		
	
	
	



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
		if(astronautes.isEmpty()) {
			return "Mission [id="+id+",\n dateDebut=" + dateDebut + ",\n dateFin=" + dateFin + ",\n objectif=" + objectif + ",\n description="
				+ description + ",\n pays=" + pays + ",\n statut=" + statut + ",\n planete=" + planete + ",\n vaisseau="
				+ vaisseau + "]";
		}else {
			return "Mission [id="+id+",\n dateDebut=" + dateDebut + ",\n dateFin=" + dateFin + ",\n objectif=" + objectif + ",\n description="
					+ description + ",\n pays=" + pays + ",\n statut=" + statut + ",\n planete=" + planete + ",\n vaisseau="
					+ vaisseau +  " \n equipage :" + astronautes + "]";
		}
		
	}
}
