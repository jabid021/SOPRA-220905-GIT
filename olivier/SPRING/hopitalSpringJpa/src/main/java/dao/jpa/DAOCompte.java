package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.IDAOCompte;
import model.Compte;

@Repository
public class DAOCompte implements IDAOCompte {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Compte findById(Integer id) {
		return em.find(Compte.class, id);
	}

	@Override
	public List<Compte> findAll() {
		return em.createQuery("from Compte", Compte.class).getResultList();

	}

	@Override
	@Transactional
	public Compte save(Compte c) {
		return em.merge(c);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Compte c = em.find(Compte.class, id);
		em.remove(c);
	}

	@Override
	public Compte seConnecter(String login, String password) {
		Compte compte = null;

		try {

			Query requete = em.createQuery("select c from Compte c where c.login=:login and c.password=:password");
			requete.setParameter("login", login);
			requete.setParameter("password", password);
			compte = (Compte) requete.getSingleResult();
		} catch (Exception e) {
		}
		return compte;
	}

}
