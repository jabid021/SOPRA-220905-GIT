package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM('Medecin','Secretaire')")
@Table(name="compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(length = 35,nullable = false)
	protected String login;
	@Column(length = 100,nullable = false)
	protected String password;
	
	
	public Compte() {
	}
	
	
	public Compte(Integer id, String mail, String password) {

		this.id = id;
		this.login = mail;
		this.password = password;
	}
	
	public Compte(String mail, String password) {
		this.login = mail;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String mail) {
		this.login = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", mail=" + login + ", password=" + password + "]";
	}
	
	
	
}
