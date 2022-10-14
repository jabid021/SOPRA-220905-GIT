package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Adresse;
import model.Ordinateur;
import model.Personne;

public class TestCommandes {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");





	public static Personne select(Integer id) 
	{

		EntityManager em = emf.createEntityManager();

		Personne p1 = em.find(Personne.class, id);

		em.close();

		return p1;

	}



	public static List<Personne> selectAll() 
	{
		EntityManager em = emf.createEntityManager();

		//SELECT * from pers
		List<Personne> personnes = em.createQuery("FROM Personne").getResultList();

		em.close();

		return personnes;

	}





	public static List<Personne> selectAllByMarque() 
	{
		EntityManager em = emf.createEntityManager();

		//SELECT * from pers JOIN ordinateur on ordinateur.id=pers.ordinateur where ordinateur.marque='Mac'

		/*Query requete = em.createQuery("SELECT p FROM Personne p where p.ordi.marque=?1");
		requete.setParameter(1, "mac");
		 */

		Query requete = em.createQuery("SELECT p FROM Personne p where p.ordi.marque=:marque");
		requete.setParameter("marque", "mac");


		List<Personne> personnes = requete.getResultList();

		em.close();

		return personnes;

	}


	public static List<Personne> selectAllByNumero(String numero) 
	{
		EntityManager em = emf.createEntityManager();


		Query requete = em.createQuery("SELECT p FROM Personne p where p.adresse.numero=:numero");
		requete.setParameter("numero", numero);


		List<Personne> personnes = requete.getResultList();

		em.close();

		return personnes;

	}



	/*public static void insert(Personne p) 
	{
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(p);

		em.getTransaction().commit();


		em.close();



	}
*/


	public static void deleteById(Integer id) 
	{

		EntityManager em = emf.createEntityManager();

		Personne p = em.find(Personne.class,id);
				
		
		em.getTransaction().begin();

		em.remove(p);

		em.getTransaction().commit();


		em.close();


	}




	public static void delete(Personne p) 
	{
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		p=em.merge(p);
		em.remove(p);

		em.getTransaction().commit();


		em.close();



	}
	
	
	
	public static Personne save(Personne p) 
	{
		EntityManager em = emf.createEntityManager();

		
		em.getTransaction().begin();

		em.merge(p);

		em.getTransaction().commit();


		em.close();

		return p;
		
	}
	
	
	
	public static Ordinateur save(Ordinateur o) 
	{
		EntityManager em = emf.createEntityManager();

		
		em.getTransaction().begin();

		o=em.merge(o);

		em.getTransaction().commit();


		em.close();
		
		return o;

		
	}
	
	
	
	public static void main(String[] args) {

		
		//Objet managed ?
		
		// em.find() => return objet Managed
		//em.persist(Object o ) => o est managed
		//em.findALL()=> Les objets sont managed
		//em.remove(Object o ) => o DOIT etre managed
		//em.merge(Object o) => o N'EST PAS MANAGED, mais return une version managed de o
		
		
		
		Ordinateur o1 = new Ordinateur("Asus");

		o1=save(o1);

		Adresse a1 = new Adresse("8","rue de paris");
		Personne p = new Personne("nom","prenom",null,false,null,null);
		p.setOrdi(o1);
		p.setAdresse(a1);
		
		p.setNumero(15);
		
		save(p);
		
		
		
		/*p.setPrenom("Toto");
		p.setSalaire(8000.50);
		
		update(p);
		
		
		System.out.println(select(p.getNumero()));
		
		
		deleteById(p.getNumero());
		
		System.out.println(select(p.getNumero()));
		
		
		*/
		
		//Personne p1 = select();
		//System.out.println(p1);

		//System.out.println(selectAll());
		//System.out.println(selectAllByNumero("6"));


		emf.close();
	}

}
