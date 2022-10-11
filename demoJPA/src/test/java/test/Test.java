package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Civilite;
import model.Formateur;
import model.Matiere;
import model.Ordinateur;
import model.Personne;

public class Test {

	public static void main(String[] args) {

		Adresse a1 = new Adresse("6", "rue rougemont");

		Personne p1 = new Personne("Jordan",LocalDate.parse("1993-05-01"),true,1500.005,Civilite.homme);

		Personne p2 = new Personne("Abid","Jeremy",LocalDate.parse("1997-05-14"),false,0.0,Civilite.nb);

		p1.setAdresse(a1);
		p2.setAdresse(a1);


		Ordinateur o1 = new Ordinateur("Mac");
		Ordinateur o2 = new Ordinateur("Asus");


		Formateur f1 = new Formateur("Olivier Gozlan");
		Matiere m1  = new Matiere("Spring", f1);
		Matiere m2  = new Matiere("Angular", f1);

		p1.getModules().add(m1);
		p1.getModules().add(m2);


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

		em.persist(o1);
		em.persist(o2);
		em.persist(f1);
		em.persist(m1);
		em.persist(m2);

		em.getTransaction().commit();



		System.out.println(em.find(Personne.class, 1));
		System.out.println(em.find(Personne.class, 2));
		em.close();
		emf.close();

	}

}
