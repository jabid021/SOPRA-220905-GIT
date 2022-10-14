package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Context;
import dao.IDAOMission;
import model.Compte;
import model.Mission;
import model.Statut;


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
	
	public List<Statut> findAll(Statut statut) 
	{
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		List<Statut> s = em.createQuery("from Statut").getResultList();

		em.close();

		return s;
	}
	
	public List<Mission> findByDateDebutBetween(String debut, String fin){

		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		
        List<Mission> m = em.createQuery("select m from Mission where m.debut > :debut and m.debut < :fin ").getResultList(); 
       
        em.close();

		return m ;
        
	}
}
