package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOVaisseau;

public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("space");
	
	private DAOVaisseau daoVaisseau = new DAOVaisseau();	
	
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

	public static void setSingleton(Context singleton) {
		Context.singleton = singleton;
	}


	
	
	
	
	
}
