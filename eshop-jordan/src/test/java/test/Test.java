package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Achat;
import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Adresse a1 = new Adresse("6","rue rougemont","Paris","75009");
		
		Client client1 = new Client("Abid","Jordan",29,LocalDate.parse("1993-05-01"));
		Client client2 = new Client("Doe","John",null,LocalDate.parse("1980-01-01"));
		
		Fournisseur fournisseur = new Fournisseur("Abid","Charly","AJC");
		fournisseur.setAdresse(a1);
		
		Produit produit1 = new Produit("Formation Algo",1200,fournisseur);
		Produit produit2 = new Produit("Formation Java",1600,fournisseur);
		Produit produit3 = new Produit("Formation JPA",2200,fournisseur);
		
		Achat achat1= new Achat(client1,produit1);
		Achat achat2= new Achat(client1,produit2);
		Achat achat3= new Achat(client2,produit3);
		
		/*client1.getAchats().add(produit1);
		client1.getAchats().add(produit2);
		client2.getAchats().add(produit3);
*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();
		
		
		//em.getTransaction().begin();
		
		
		/*em.persist(fournisseur);
		em.persist(produit1);
		em.persist(produit2);
		em.persist(produit3);
		em.persist(client1);
		em.persist(client2);
		em.persist(achat1);
		em.persist(achat2);
		em.persist(achat3);
		em.getTransaction().commit();
		
		*/
		em.close();
		emf.close();
		
	}

}
