package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.IDAOPatient;
import model.Patient;

@Repository
public class DAOPatient implements IDAOPatient {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Patient findById(Integer id) {
		return em.find(Patient.class, id);
	}

	@Override
	public List<Patient> findAll() {
		return em.createQuery("from Patient", Patient.class).getResultList();

	}

	@Override
	@Transactional
	public Patient save(Patient p) {
		return em.merge(p);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Patient p = em.find(Patient.class, id);
		em.remove(p);
	}

}
