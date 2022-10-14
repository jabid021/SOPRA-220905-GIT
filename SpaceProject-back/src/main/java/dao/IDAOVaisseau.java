package dao;

import java.util.List;

import model.Mission;
import model.Vaisseau;

public interface IDAOVaisseau extends IDAO<Vaisseau, Integer>{
	
		public List<Vaisseau> findAllByMission(Mission idMission); 

}
