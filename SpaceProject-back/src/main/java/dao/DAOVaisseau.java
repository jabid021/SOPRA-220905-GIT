package dao;

import java.util.List;

import javax.naming.Context;
import javax.persistence.EntityManager;

import model.Vaisseau;

public class DAOVaisseau implements IDAOVaisseau{

	@Override
	public Vaisseau findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Vaisseau v = em.find(Vaisseau.class, id);
		em.close();

		return v;
	}

	@Override
	public List<Vaisseau> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Vaisseau> vaisseaux = em.createQuery("from Vaisseau").getResultList();

		em.close();

		return vaisseaux;
	}

	@Override
	public Vaisseau save(Vaisseau v) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		em.getTransaction().begin();

		em.merge(v);

		em.getTransaction().commit();


		em.close();

		return v;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Vaisseau v = em.find(Vaisseau.class, id);
		
		em.getTransaction().begin();

		em.remove(v);

		em.getTransaction().commit();


		em.close();
	}
	
	
}
