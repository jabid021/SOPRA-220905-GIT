package dao;

import java.util.List;

import model.Pays;

public interface IDAOPays extends IDAO<Pays,Integer> {

	public List<Pays> findAllByMission(Integer id);

	
}
