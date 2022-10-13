package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {

	
	
	///insert / update Patient (save)
	//findById Patient
	//deleteById Patient
	//findAll Patient
	//FindAll Visite
	//FindAllVisitesByIdPatient
	
	
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
		
		
		
		
		emf.close();

	}

}
