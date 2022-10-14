package dao;

import java.util.List;

import model.Mission;
import model.Statut;

public interface IDAOMission extends IDAO<Mission,Integer> {

	List<Mission> findWithAstronautes(Integer id);

	List<Mission> findAllByStatut(Statut statut);

	List<Mission> findByDateDebutBetween(String debut, String fin);	
		
	List<Mission> findAllByPays(Integer id);
	
	List<Mission> findAllByPlanete(Integer id);
	
	List<Mission> findAllByVaisseau(Integer id);
	
	List<Mission> findAllByAstronaute(Integer id);
		

}
