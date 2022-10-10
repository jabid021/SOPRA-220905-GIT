package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personne;

public class Test {

	public static void main(String[] args) {
		
		
		
		Personne p1 = new Personne("Abid","Jordan",LocalDate.parse("1993-05-01"),true,null);
		
		Personne p2 = new Personne("Abid","Jeremy",LocalDate.parse("1997-05-14"),false,null);
		System.out.println(p1);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();
	
		
		//Personne p1 = em.find(Personne.class, 1);
		
		em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(p2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		System.out.println(p1);

	}

}
