package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import heritage.joined.Vehicule;
import heritage.singleTable.Animal;
import heritage.tablePerClass.Blanc;
import heritage.tablePerClass.Lait;
import heritage.tablePerClass.Praline;

public class TestHeritage {

	public static void main(String[] args) {


		/*	Ours o1= new Ours(2000);
		Lion l1 = new Lion(600,false);
		Elephant e1 = new Elephant(12000,true);

		Avion avion = new Avion(10, 250);
		Voiture voiture = new Voiture(4,"Fiat Panda");
		Bateau bateau = new Bateau(0,true,"Vogue Merry");
		 */	

	/*	Lait l1 = new Lait(25,500,100,70);
		Praline p1 = new Praline(25,400,100,20);
		Blanc b1 = new Blanc(0,800,100,100);
*/

		

/*
		List<Vehicule> vehicules = em.createQuery("from Avion").getResultList();
		List<Animal> zoo = em.createQuery("from Animal").getResultList() ;
		List<Animal> chocolats = em.createQuery("from Blanc").getResultList() ;*/



		/*em.getTransaction().begin();
		em.persist(b1);
		em.persist(p1);
		em.persist(l1);
		//	em.persist(o1);
		//	em.persist(l1);
		//	em.persist(e1);
		//	em.persist(avion);
		//	em.persist(bateau);
		//	em.persist(voiture);

		em.getTransaction().commit();
*/


	/*	em.close();
		emf.close();*/

	}

}
