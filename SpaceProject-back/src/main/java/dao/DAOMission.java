package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Context;
import model.Mission;


public class DAOMission implements IDAOMission{
	
	@Override
	public List<Mission> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Mission> missions = em.createQuery("from Mission").getResultList();

		em.close();

		return missions;
	}
	
	
	@Override
	public Mission findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();		Mission m = em.find(Mission.class, id);
		em.close();
		return m;
	}

	@Override
	public Mission save(Mission m) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		em.getTransaction().begin();

		m=em.merge(m);

		em.getTransaction().commit();


		em.close();

		return m;
	}
	
	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Mission m = em.find(Mission.class, id);
		
		em.getTransaction().begin();

		em.remove(m);

		em.getTransaction().commit();


		em.close();
	}
	
	
}
