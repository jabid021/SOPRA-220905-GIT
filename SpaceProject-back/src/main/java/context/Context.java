package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOMission;
import dao.IDAOPays;
import dao.IDAOPlanete;
import dao.IDAOVaisseau;
import dao.jpa.DAOCompte;
import dao.jpa.DAOMission;
import dao.jpa.DAOPays;
import dao.jpa.DAOPlanete;
import dao.jpa.DAOVaisseau;

public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("space");
	
	private IDAOVaisseau daoVaisseau = new DAOVaisseau();	
	private IDAOPlanete daoPlanete = new DAOPlanete();	
	private IDAOMission daoMission = new DAOMission();	
	private IDAOCompte daoCompte = new DAOCompte();	
	private IDAOPays daoPays = new DAOPays();	
	
	private static Context singleton=null;

	private Context() {}
	
	public static Context getSingleton() {
	
		if(singleton==null) 
		{
			singleton=new Context();	
		}
		return singleton;
	}

	
	
	
	
	public IDAOVaisseau getDaoVaisseau() {
		return daoVaisseau;
	}

	public void setDaoVaisseau(IDAOVaisseau daoVaisseau) {
		this.daoVaisseau = daoVaisseau;
	}

	public IDAOPlanete getDaoPlanete() {
		return daoPlanete;
	}

	public void setDaoPlanete(IDAOPlanete daoPlanete) {
		this.daoPlanete = daoPlanete;
	}

	public IDAOMission getDaoMission() {
		return daoMission;
	}

	public void setDaoMission(IDAOMission daoMission) {
		this.daoMission = daoMission;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	
	
	public IDAOPays getDaoPays() {
		return daoPays;
	}

	public void setDaoPays(IDAOPays daoPays) {
		this.daoPays = daoPays;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	
	
	
	
	
	
}
