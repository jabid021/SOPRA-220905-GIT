package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Context;
import dao.IDAOVisite;
import model.Visite;

public class DAOVisite implements IDAOVisite{

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();		Visite v = em.find(Visite.class, id);
		em.close();

		return v;
	}

	@Override
	public List<Visite> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Visite> visites = em.createQuery("from Visite").getResultList();

		em.close();

		return visites;
	}

	@Override
	public Visite save(Visite v) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		em.getTransaction().begin();

		v=em.merge(v);

		em.getTransaction().commit();


		em.close();

		return v;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Visite v = em.find(Visite.class, id);
		
		em.getTransaction().begin();

		em.remove(v);

		em.getTransaction().commit();


		em.close();
	}

	@Override
	public List<Visite> findAllByIdPatient(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Query requete = em.createQuery("select v from Visite v where v.patient.id=:idPatient");
		requete.setParameter("idPatient", id);
		List<Visite> visites = requete.getResultList();
		
		em.close();

		return visites;
	}

	
}
