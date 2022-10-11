package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import heritage.Elephant;
import heritage.Lion;
import heritage.Ours;

public class TestHeritage {

	public static void main(String[] args) {
		
		
		Ours o1= new Ours(2000);
		Lion l1 = new Lion(600,false);
		Elephant e1 = new Elephant(12000,true);
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();



		em.getTransaction().begin();

		em.persist(o1);
		em.persist(l1);
		em.persist(e1);
		
		
		em.getTransaction().commit();



		em.close();
		emf.close();

	}

}
