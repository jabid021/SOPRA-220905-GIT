package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import context.Context;
import dao.IDAOPays;
import model.Astronaute;
import model.Pays;


public class DAOPays implements IDAOPays{
	
	@Override
	public Pays findById(Integer id) {
	
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Pays c = em.find(Pays.class, id);
		em.close();

		return c;
	}

	@Override
	public List<Pays> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Pays> payss = em.createQuery("from Pays").getResultList();

		em.close();

		return payss;
	}

	@Override
	public Pays save(Pays c) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Context.getSingleton().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			c = em.merge(c);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return c;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Pays c = em.find(Pays.class, id);

		em.getTransaction().begin();

		em.remove(c);

		em.getTransaction().commit();


		em.close();
	}




}
