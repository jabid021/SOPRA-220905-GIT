package test;

import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JpaConfig;
import exception.PatientException;
import model.Patient;
import repository.PatientRepository;
import repository.VisiteRepository;
import service.PatientService;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(JpaConfig.class);
		PatientService patientSrv=ctx.getBean(PatientService.class);
		//saisie clavier pour recuperer id,prenom,nom
		Integer id=22;
		String prenom="";
		String nom="toto";
		Patient patient=new Patient(id,nom,prenom);
		patientSrv.create(patient);
		
		id=33;
		prenom="eee";
		nom="eee";
		patient=new Patient(id,nom,prenom);
		patientSrv.create(patient);
		ctx.close();
	}
}
