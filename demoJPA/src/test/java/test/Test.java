package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Civilite;
import model.Console;
import model.Formateur;
import model.Matiere;
import model.Module;
import model.Ordinateur;
import model.Personne;

public class Test {

	public static void main(String[] args) {

		
		Console c1 = new Console("PS5", 499.99);
		Console c2 = new Console("Xbox", 350.99);
		Console c3 = new Console("Switch", 250.00);
		
		
		Adresse a1 = new Adresse("6", "rue rougemont");

		Personne p1 = new Personne("Jordan",LocalDate.parse("1993-05-01"),true,1500.005,Civilite.homme);

		Personne p2 = new Personne("Abid","Jeremy",LocalDate.parse("1997-05-14"),false,0.0,Civilite.nb);

		p1.setAdresse(a1);
		p2.setAdresse(a1);
		p1.getConsoles().add(c1);
		p1.getConsoles().add(c2);
		p1.getConsoles().add(c3);

		Ordinateur o1 = new Ordinateur("Mac");
		Ordinateur o2 = new Ordinateur("Asus");

		
		p1.setOrdi(o1);
		p2.setOrdi(o2);

		Formateur f1 = new Formateur("Olivier Gozlan");
		Matiere m1  = new Matiere("Spring", f1);
		Matiere m2  = new Matiere("Angular", f1);

		
		Module module1 = new Module(m1, p1);
		Module module2 = new Module(m2, p1);
		Module module3 = new Module(m1, p2);
		
	


		//Creation de la connexion à la BDD avec la persistence-unit sopraJPA (ligne 7 persistence.xml)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		//select * where id = x
		//Personne p1 = em.find(Personne.class, 1);


		//Pour les opérations insert/update/delete, il faut une transaction qui "begin" puis qui commit"
		em.getTransaction().begin();

	
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(o1);
		em.persist(o2);
		em.persist(f1);
		em.persist(m1);
		em.persist(m2);
		
		
	
		
		
		
		//insert p1
		em.persist(p1);
		//insert p2
		em.persist(p2);
		
		em.persist(module1);
		em.persist(module2);
		em.persist(module3);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
