package model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="planete")
public class Planete implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20,nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private double diametre;
	
	@Column(nullable = false)
	private int satellites;
	
	@Column(nullable = false)
	private int distance;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type_planete",columnDefinition = "ENUM('Tellurique','Gazeux')",nullable = false)
	private TypePlanete typePlanete;
	
	@OneToMany(mappedBy="planete")	
	private List<Mission> mission = new ArrayList();
	
	
	public Planete() {
	}
	
	public Planete(String nom, double diametre, int satellites, int distance, TypePlanete typePlanete) {
		this.nom = nom;
		this.diametre = diametre;
		this.satellites = satellites;
		this.distance = distance;
		this.typePlanete = typePlanete;
	}
	public Planete(Integer id,String nom, double diametre, int satellites, int distance, TypePlanete typePlanete) {
		this.id=id;
		this.nom = nom;
		this.diametre = diametre;
		this.satellites = satellites;
		this.distance = distance;
		this.typePlanete = typePlanete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getDiametre() {
		return diametre;
	}

	public void setDiametre(double diametre) {
		this.diametre = diametre;
	}

	public int getSatellites() {
		return satellites;
	}

	public void setSatellites(int satellites) {
		this.satellites = satellites;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public TypePlanete getTypePlanete() {
		return typePlanete;
	}

	public void setTypePlanete(TypePlanete typePlanete) {
		this.typePlanete = typePlanete;
	}

	public List<Mission> getMission() {
		return mission;
	}

	public void setMission(List<Mission> mission) {
		this.mission = mission;
	}

	@Override
	public String toString() {
		return "Planete [id=" + id + ", nom=" + nom + ", diametre=" + diametre + ", satellites=" + satellites
				+ ", distance=" + distance + ", typePlanete=" + typePlanete + ", mission=" + mission + "]";
	}
	
	
	
	
	
	
	
	

}
