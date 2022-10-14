package model;

import java.io.Serializable;

public class Planete implements Serializable {
	
	private Integer id;
	private String nom;
	private double diametre;
	private int satellites;
	private int distance;
	private TypePlanete typePlanete;
	
	
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
	
	
	public String getNom() {
		return nom;
	}
	public TypePlanete getTypePlanete() {
		return typePlanete;
	}
	public void setTypePlanete(TypePlanete typePlanete) {
		this.typePlanete = typePlanete;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Planete [id=" + id + ", nom=" + nom + ", diametre=" + diametre + ", satellites=" + satellites
				+ ", distance=" + distance + ", typePlanete=" + typePlanete + "]";
	}
	
	
	
	
	

}
