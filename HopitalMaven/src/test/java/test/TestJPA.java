package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Patient;
import model.Visite;

public class TestJPA {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");

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
	
	public void deleteById(Integer id) 
	{
		
		EntityManager em = emf.createEntityManager();

		Patient p = em.find(Patient.class, id);
		
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
		
		//List<Visite> visites= em.createQuery("select v from Visite v where v.patient.id=:idPatient").setParameter("idPatient", id).getResultList();
		
		em.close();

		return visites;
	}




	public static void main(String[] args) {

		emf.close();

	}

}
