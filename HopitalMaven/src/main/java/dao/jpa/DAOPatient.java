package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import context.Context;
import dao.IDAOPatient;
import model.Patient;

public class DAOPatient implements IDAOPatient{

	@Override
	public Patient findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Patient p = em.find(Patient.class, id);
		em.close();

		return p;
	}

	@Override
	public List<Patient> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Patient> patients = em.createQuery("from Patient").getResultList();

		em.close();

		return patients;
	}

	@Override
	public Patient save(Patient p) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		em.getTransaction().begin();

		em.merge(p);

		em.getTransaction().commit();


		em.close();

		return p;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Patient p = em.find(Patient.class, id);
		
		em.getTransaction().begin();

		em.remove(p);

		em.getTransaction().commit();


		em.close();
	}

	
}
