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
		
		
		//Creation de la connexion à la BDD avec la persistence-unit sopraJPA (ligne 7 persistence.xml)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();
	
		//select * where id = x
		//Personne p1 = em.find(Personne.class, 1);
		
		
		//Pour les opérations insert/update/delete, il faut une transaction qui "begin" puis qui commit"
		em.getTransaction().begin();
		
		//insert p1
		em.persist(p1);
		//insert p2
		em.persist(p2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	
	}

}
