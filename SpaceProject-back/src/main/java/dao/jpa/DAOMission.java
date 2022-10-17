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
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();		
		Mission m = em.find(Mission.class, id);
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
	@Override
	public List<Mission> findAllByStatut(Statut statut) 
	{
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		List<Mission> s = em.createQuery("SELECT m from Mission m where m.statut=:statut").setParameter("statut", statut).getResultList();

		em.close();

		return s;
	}
	@Override
	public List<Mission> findByDateDebutBetween(String debut, String fin){

		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		Query requete = em.createQuery("select m from Mission where m.debut between :debut and :fin ");
		requete.setParameter("debut", debut);
		requete.setParameter("fin", fin);
		List<Mission> m =requete.getResultList(); 

		em.close();

		return m ;

	}
	
	@Override
	public List<Mission> findWithAstronautes(Integer id) 
	{
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		List<Mission> s = em.createQuery("SELECT distinct m from Mission m left join fetch m.astronautes where m.id=:id").setParameter("id", id).getResultList();

		em.close();

		return s;
	}


	@Override
	public List<Mission> findAllByPays(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		List<Mission> s = em.createQuery("SELECT m from Mission m where m.pays.id=:id").setParameter("id", id).getResultList();

		em.close();

		return s;
	}


	@Override
	public List<Mission> findAllByPlanete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		List<Mission> s = em.createQuery("SELECT m from Mission m where m.planete.id=:id").setParameter("id", id).getResultList();

		em.close();

		return s;
	}


	@Override
	public List<Mission> findAllByVaisseau(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		List<Mission> s = em.createQuery("SELECT m from Mission m where m.vaisseau.id=:id").setParameter("id", id).getResultList();

		em.close();

		return s;
	}


	@Override
	public List<Mission> findAllByAstronaute(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		List<Mission> s = em.createQuery("SELECT m from Mission m join m.astronautes a where a.id=:id").setParameter("id", id).getResultList();

		em.close();

		return s;
	}
}
