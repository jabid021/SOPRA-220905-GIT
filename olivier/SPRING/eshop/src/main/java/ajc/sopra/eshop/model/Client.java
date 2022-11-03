package ajc.sopra.eshop.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {

	private Integer age;

	@Column(name = "birthdate")
	private LocalDate naissance;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable( name="achats", joinColumns = @JoinColumn(name="acheteur"),
	 * inverseJoinColumns = @JoinColumn(name="produit") ) private List<Produit>
	 * achats = new ArrayList();
	 */

	@OneToMany(mappedBy = "acheteur")
	private List<Achat> achats;

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

	public String getDetails() {
		return getId() + " " + getPrenom() + " " + getNom();
	}

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", age=" + age
				+ ", naissance=" + naissance + ", achats=" + achats + "]";
	}

}
