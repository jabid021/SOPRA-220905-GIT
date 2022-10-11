package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personne;
import model.Produit;

public class Test {

	public static void main(String[] args) {
		Personne personne1 = new Personne("Abid","Jordan");
		Produit produit1 = new Produit("Formation Algo",1200);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		
		em.persist(personne1);
		em.persist(produit1);
		
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
	}

}
