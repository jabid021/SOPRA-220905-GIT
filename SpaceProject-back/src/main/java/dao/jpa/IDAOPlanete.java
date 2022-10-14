package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import context.Context;
import dao.IDAOPlanete;
import model.Planete;
import model.Planete;

public class DAOPlanete implements IDAOPlanete{

	@Override
	public Planete findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();		
		Planete p = em.find(Planete.class, id);
		em.close();

		return p;
	}

	@Override
	public List<Planete> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Planete> planetes = em.createQuery("from Planete").getResultList();

		em.close();

		return planetes;
	}

	@Override
	public Planete save(Planete p) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		em.getTransaction().begin();

		p=em.merge(p);

		em.getTransaction().commit();


		em.close();

		return p;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Planete p = em.find(Planete.class, id);
		
		em.getTransaction().begin();

		em.remove(p);

		em.getTransaction().commit();


		em.close();
	}

	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("space_project");
    
   
	public List<Planete> findAllByIdPlanetes(Integer idMission) {
		EntityManager em = emf.createEntityManager();

		Query requete = em.createQuery("select p from Planete p where p.mission.id=:idMission");
		requete.setParameter("idMission", idMission);
		List<Planete> planetes = requete.getResultList();
		
		em.close();

		return planetes;
		
	}

	
}
