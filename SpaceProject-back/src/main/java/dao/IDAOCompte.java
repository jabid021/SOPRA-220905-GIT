package dao;

import java.util.List;

import model.Astronaute;
import model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer> {

	public Compte seConnecter(String login,String password);
	
	
}
