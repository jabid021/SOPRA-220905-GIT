package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

<<<<<<< Updated upstream
import model.Patient;
import model.Adresse;
import model.Ordinateur;
import model.Patient;
import model.Personne;

import model.Visite;

public class TestJPA {


	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");


	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sopraJPA");
	

	///insert / update Patient (save)
	//findById Patient
	//deleteById Patient
	//findAll Patient
	//FindAll Visite
	//FindAllVisitesByIdPatient


	public Patient save(Patient p) 
	{
		EntityManager em = emf.createEntityManager();


		em.getTransaction().begin();

		em.merge(p);

		em.getTransaction().commit();


		em.close();

		return p;
	}
	
	public Patient findById(Integer id) 
	{
		EntityManager em = emf.createEntityManager();
		Patient p = em.find(Patient.class, id);
		em.close();

		return p;
	}
	public static void insert(Patient p) 
	{
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(p);

		em.getTransaction().commit();


		em.close();
	}


	public static Patient savej1(Patient p) 
	{
		EntityManager em = emf.createEntityManager();

		
		em.getTransaction().begin();

		p=em.merge(p);

		em.getTransaction().commit();


		em.close();
		
		return p;

		
	}
	
	public static Patient select(Integer id) 
	{

		EntityManager em = emf.createEntityManager();

		Patient p1 = em.find(Patient.class, id);

		em.close();

		return p1;

	}
	
	public static void deleteById(Integer id) 
	{

		EntityManager em = emf.createEntityManager();

		Patient p = em.find(Patient.class,id);
				
		em.getTransaction().begin();

		em.remove(p);

		em.getTransaction().commit();


		em.close();


	}
	
	
	public static List<Patient> selectAllPatient() 
	{
		EntityManager em = emf.createEntityManager();

	
		List<Patient> patients = em.createQuery("FROM Patient").getResultList();

		em.close();

		return patients;

	}

	public static List<Visite> selectAllVisite() 
	{
		EntityManager em = emf.createEntityManager();

	
		List<Visite> visites = em.createQuery("FROM Visite").getResultList();

		em.close();

		return visites;

	}

	public static List<Visite> selectAllById(int Id) 
	{
		EntityManager em = emf.createEntityManager();

	

		Query requete = em.createQuery("SELECT v FROM Visite v where v.patient.id=:patientId");
		requete.setParameter("Id", Id);


		List<Visite> visites = requete.getResultList();

		em.close();

		return visites;

	}
	
	public static void main(String[] args) {
		
	}
	
	public void deleteById(Integer id) 
	{
		
		EntityManager em = emf.createEntityManager();

		Patient p = em.find(Patient.class, id);
		Patient p1 = new Patient("John", "Smith");

		p1=save(p1);

	
		
	
		
		save(p1);
		
		
	
>>>>>>> Stashed changes
		
		em.getTransaction().begin();

		em.remove(p);

		em.getTransaction().commit();


		em.close();
	}
	
	
	public List<Patient> findAllPatient() 
	{
		EntityManager em = emf.createEntityManager();

		List<Patient> patients = em.createQuery("from Patient").getResultList();

		em.close();

		return patients;
	}
	
	public List<Visite> findAllVisite() 
	{
		EntityManager em = emf.createEntityManager();

		List<Visite> visites = em.createQuery("from Visite").getResultList();

		em.close();

		return visites;
	}
	
	public List<Visite> findAllVisiteByPatient(Integer id) 
	{
		EntityManager em = emf.createEntityManager();

		Query requete = em.createQuery("select v from Visite v where v.patient.id=:idPatient");
		requete.setParameter("idPatient", id);
		List<Visite> visites = requete.getResultList();
		
<<<<<<< Updated upstream
		//List<Visite> visites= em.createQuery("select v from Visite v where v.patient.id=:idPatient").setParameter("idPatient", id).getResultList();
=======
		//Patient p1 = select();
		//System.out.println(p1);

		//System.out.println(selectAll());
		//System.out.println(selectAllByNumero("6"));



>>>>>>> Stashed changes
		
		em.close();

		return visites;
	}




	public static void main(String[] args) {

		emf.close();

	}

}
