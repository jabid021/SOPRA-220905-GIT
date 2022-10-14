package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Context;
import dao.IDAOVaisseau;
import model.Mission;
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
	
	@Override
	public List<Vaisseau> findAllByMission(Mission idMission) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Query requete = em.createQuery("select v from Vaisseau v where v.mission.id=:idMission");
		requete.setParameter("idMission", idMission);
		List<Vaisseau> vaisseaux = requete.getResultList();
		
		em.close();

		return vaisseaux;
	}
	
	
}
