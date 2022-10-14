package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity //OBLIGATOIRE
@Table(name="pers")
public class Personne {

	@Id //OBLIGATOIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SEMI-OBLIGATOIRE pour de l'auto-increment
	private Integer numero;
	
	@Column(name="lastname",columnDefinition = "VARCHAR(35) default 'DOE'")
	private String nom;
	
	//length = 30 meme chose que columnDefinition = "VARCHAR(30)"
	@Column(name="firstname",length = 30, nullable = false)
	private String prenom;
	
	private LocalDate naissance;
	private boolean formateur;
	
	@Column(columnDefinition = "DECIMAL(7,2)")
	private Double salaire;

	//permet de stocker la valeur de l'enum et non son index 
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('homme','femme','nb')")
	private Civilite civ;
	
	private transient String attributJava;
	
	
	
	@OneToOne
	@JoinColumn(name="ordinateur")
	private Ordinateur ordi;
	
	
	/*@ManyToMany
	@JoinTable(
			name="modules",
			joinColumns = @JoinColumn(name="stagiaire"), //joinColumn = col principale = id maitre = classe actuelle donc ici Personne
			inverseJoinColumns = @JoinColumn(name="cours"), // col secondaire = id esclave =  l'autre classe donc ici Matiere
			uniqueConstraints = @UniqueConstraint(columnNames = {"stagiaire","cours"})
			)
	private List<Matiere> modules=new ArrayList();
	*/
	
	@OneToMany(mappedBy = "apprenant")
	private List<Module> modules;
	
	
	@ManyToMany
	private List<Console> consoles=new ArrayList();
	
	
	@Embedded
	private Adresse adresse;
	
	
	//Constructeur vide OBLIGATOIRE + Tous les GETTERS / SETTERS
	public Personne() {
	}

	public Personne(String nom, String prenom, LocalDate naissance, boolean formateur, Double salaire,Civilite civ) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.formateur = formateur;
		this.salaire = salaire;
		this.civ=civ;
	}
	public Personne(String prenom, LocalDate naissance, boolean formateur, Double salaire,Civilite civ) {
		
		this.prenom = prenom;
		this.naissance = naissance;
		this.formateur = formateur;
		this.salaire = salaire;
		this.civ=civ;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getNaissance() {
		return naissance;
	}
	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	public boolean isFormateur() {
		return formateur;
	}
	public void setFormateur(boolean formateur) {
		this.formateur = formateur;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	

	public Civilite getCiv() {
		return civ;
	}

	public void setCiv(Civilite civ) {
		this.civ = civ;
	}

	
	public String getAttributJava() {
		return attributJava;
	}

	public void setAttributJava(String attributJava) {
		this.attributJava = attributJava;
	}

	
	
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Ordinateur getOrdi() {
		return ordi;
	}

	public void setOrdi(Ordinateur ordi) {
		this.ordi = ordi;
	}
	
	

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	

	public List<Console> getConsoles() {
		return consoles;
	}

	public void setConsoles(List<Console> consoles) {
		this.consoles = consoles;
	}

	@Override
	public String toString() {
		return "Personne [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance
				+ ", formateur=" + formateur + ", salaire=" + salaire + ", civ=" + civ + ", ordi=" + ordi + ", adresse="
				+ adresse + "]";
	}


	
	
	
	
	
	
}
