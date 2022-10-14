package test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Console;
import model.Personne;
import model.Module;

public class TestLazy {

	public static String saisieString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		String saisie = sc.nextLine();
		return saisie;
	}

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
	
	
	//Impossible de fetch plusieurs listes en meme temps ! ❌
	public static List<Personne> showJoinNoDoublonsNoConsolesAndModulesAfterCloseNotWorking()
	{
		List<Personne> personnes=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		personnes = em.createQuery("SELECT distinct p from Personne p left join fetch p.modules m left join fetch p.consoles c").getResultList();

		emf.close();
		em.close();

		return  personnes;
	}
	
	//Fetch TOUTES les personnes avec leur liste de consoles + modules, sans doublons ✔
	public static List<Personne> showJoinNoDoublonsNoConsolesAndModulesAfterCloseWorking()
	{
		List<Personne> personnes=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();

		personnes = em.createQuery("SELECT distinct p from Personne p left join fetch p.modules m").getResultList();
		personnes = em.createQuery("SELECT distinct p from Personne p left join fetch p.consoles c").getResultList();
		emf.close();
		em.close();

		return  personnes;
	}

	
	
	
	
	public static void demoVersion() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
		EntityManager em = emf.createEntityManager();
		
		
		Console c = em.find(Console.class, 1);
		
		System.out.println(c);
		
		c.setLibelle(saisieString("Saisir libelle"));
		
		System.out.println(c);
		
		
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		
		
		
		emf.close();
		em.close();
		
	}
	public static void main(String[] args) {


		demoVersion();
		
		System.out.println("------");
		List<Personne> test = showJoinNoDoublonsNoConsolesAndModulesAfterCloseWorking();


		for(Personne p : test) 
		{
			System.out.println(p);
			System.out.println("Voici mes consoles : ");
			for(Console c : p.getConsoles()) 
			{
				System.out.println(c);
			}
			
			System.out.println("Liste des modules :");
			for(Module m : p.getModules()) 
			{
				System.out.println(m);
			}
			
			System.out.println("\n");
		}


		
		
		
		
		
		
		

	}

}
