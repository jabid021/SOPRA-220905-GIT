package dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import dao.IDAOVisite;
import model.Visite;

//annotation specifique au DAO pour en faire un bean spring
@Repository
public class DAOVisite implements IDAOVisite {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Visite findById(Integer id) {
		return em.find(Visite.class, id);
	}

	@Override
	public List<Visite> findAll() {
		return em.createQuery("from Visite", Visite.class).getResultList();
	}

	@Override
	@Transactional
	public Visite save(Visite v) {
		return em.merge(v);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Visite v = em.find(Visite.class, id);
		em.remove(v);
	}

	@Override
	public List<Visite> findAllByIdPatient(Integer id) {
		TypedQuery<Visite> requete = em.createQuery("select v from Visite v where v.patient.id=:idPatient",
				Visite.class);
		requete.setParameter("idPatient", id);
		return requete.getResultList();

	}

}
