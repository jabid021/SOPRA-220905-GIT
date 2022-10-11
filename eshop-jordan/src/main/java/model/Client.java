package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {

	
	private Integer age;
	
	@Column(name="birthdate")
	private LocalDate naissance;

	public Client() {
	}
	
	public Client(String nom, String prenom, Integer age, LocalDate naissance) {
		super(nom, prenom);
		this.age = age;
		this.naissance = naissance;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", age=" + age
				+ ", naissance=" + naissance + "]";
	}
	
	
	
	
	
	
}
