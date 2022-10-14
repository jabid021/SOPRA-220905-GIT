package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import dao.jpa.DAOCompte;
import dao.jpa.DAOPatient;
import dao.jpa.DAOVisite;

public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
	
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOPatient daoPatient = new DAOPatient();
	private IDAOVisite daoVisite = new DAOVisite();
	
	
	private static Context singleton=null;


	
	private Context() {}
	

	public static Context getSingleton() {
	
		if(singleton==null) 
		{
			singleton=new Context();	
		}
		return singleton;
	}








	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}


	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}


	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}


	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}


	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}


	public void setDaoVisite(IDAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}
	
	
	
	
	
}
