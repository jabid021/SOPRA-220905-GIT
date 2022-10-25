package test;

import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JpaConfig;
import dao.IDAOPatient;
import model.Patient;
import repository.PatientRepository;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(JpaConfig.class);
		PatientRepository patientRepo=ctx.getBean(PatientRepository.class);
		System.out.println(patientRepo.count());
		Optional<Patient> opt= patientRepo.findById(10000);
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}else {
			System.out.println("pas de resultat");
		}
		ctx.close();
	}
}
