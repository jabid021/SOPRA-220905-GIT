package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Console;
import model.Personne;

public class TestLazy {



	//Acces aux consoles APRES le em.close ❌
	//Impossible de faire des filtres sur les consoles ❌
	public static List<Personne> showLazy()
	{

		List<Personne> personnes=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		personnes = em.createQuery("from Personne p where p.consoles.libelle='Switch'").getResultList();


		emf.close();
		em.close();

		return  personnes;
	}


	//Acces aux consoles APRES le em.close ❌
	//Possible de faire des filtres sur les consoles ✔
	public static List<Personne> showJoinFilter()
	{

		List<Personne> personnes=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		personnes = em.createQuery("SELECT p from Personne p join p.consoles c  where c.libelle='Switch'").getResultList();


		emf.close();
		em.close();

		return  personnes;
	}


	//Acces aux consoles APRES le em.close ❌
	//Les personnes n'ayant PAS de consoles ne sont pas return ❌
	//Retourne des doublons si la personne a plusieurs consoles ❌
	public static List<Personne> showJoin()
	{

		List<Personne> personnes=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		personnes = em.createQuery("SELECT p from Personne p join p.consoles c").getResultList();

		emf.close();
		em.close();

		return  personnes;
	}


	//Acces aux consoles APRES le em.close ❌
	//Les personnes n'ayant PAS de consoles ne sont pas return ❌
	//Ne Retourne pas de doublons si la personne a plusieurs consoles ✔
	public static List<Personne> showJoinNoDoublons()
	{

		List<Personne> personnes=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		personnes = em.createQuery("SELECT distinct p from Personne p join p.consoles c").getResultList();

		emf.close();
		em.close();

		return  personnes;
	}


	//Acces aux consoles APRES le em.close ❌
	//Les personnes n'ayant PAS de consoles sont return  ✔
	//Ne Retourne pas de doublons si la personne a plusieurs consoles ✔
	public static List<Personne> showJoinNoDoublonsNoConsoles()
	{

		List<Personne> personnes=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		personnes = em.createQuery("SELECT distinct p from Personne p left join p.consoles c").getResultList();

		emf.close();
		em.close();

		return  personnes;
	}



	//Acces aux consoles APRES le em.close ✔
	//Les personnes n'ayant PAS de consoles sont return  ✔
	//Ne Retourne pas de doublons si la personne a plusieurs consoles ✔
	public static List<Personne> showJoinNoDoublonsNoConsolesAfterClose()
	{

		List<Personne> personnes=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		personnes = em.createQuery("SELECT distinct p from Personne p left join fetch p.consoles c").getResultList();

		emf.close();
		em.close();

		return  personnes;
	}

	//Acces aux modules APRES le em.close ✔
	//Les personnes n'ayant PAS de consoles sont return  ✔
	//Ne Retourne pas de doublons si la personne a plusieurs consoles ✔
	public static List<Personne> showJoinNoDoublonsNoModulesAfterClose()
	{
		List<Personne> personnes=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		personnes = em.createQuery("SELECT distinct p from Personne p left join fetch p.modules m").getResultList();

		emf.close();
		em.close();

		return  personnes;
	}
	
	
	
	public static List<Personne> showJoinNoDoublonsNoConsolesAndModulesAfterCloseNotWorking()
	{
		return null;
	}
	
	
	public static List<Personne> showJoinNoDoublonsNoConsolesAndModulesAfterCloseWorking()
	{
		return null;
	}

	
	
	
	public static void main(String[] args) {


		for(Personne p : showJoinNoDoublonsNoModulesAfterClose()) 
		{
			System.out.println(p);
			System.out.println(p.getModules());
		}
		
		
		System.out.println("------");
		List<Personne> test = showJoinNoDoublonsNoConsolesAfterClose();


		for(Personne p : test) 
		{
			System.out.println(p);
			System.out.println("Voici mes consoles : ");
			for(Console c : p.getConsoles()) 
			{
				System.out.println(c);
			}
		}



	}

}
