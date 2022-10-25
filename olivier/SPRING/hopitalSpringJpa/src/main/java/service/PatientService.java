package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.PatientException;
import model.Patient;
import repository.PatientRepository;
import repository.VisiteRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private VisiteRepository visiteRepo;
	
	public List<Patient> findAll(){
		return patientRepo.findAll();
	}

	public Patient findById(Integer id) {
//		Optional<Patient> opt= patientRepo.findById(id);
//		if(opt.isPresent()) {
//			return opt.get();
//		}else {
//			throw new PatientException("id inconnu");
//		}
		return patientRepo.findById(id).orElseThrow(()->{
			throw new PatientException("id inconnu");
		});
	}
	
	public Patient findByIdFetch(Integer id) {
		return patientRepo.findByIdFetchVisites(id).orElseThrow(()->{
			throw new PatientException("id inconnu");
		});
	}
	
//	public void update(Patient patient) {
//		
//	}
	
	public void create(Patient patient) {
		if(patient.getPrenom()==null||patient.getPrenom().isBlank()) {
			//probleme
			throw new PatientException("prenom obligatoire");
		}
		if(patient.getNom()==null||patient.getNom().isBlank()) {
			//probleme
			throw new PatientException("nom obligatoire");
		}
		patientRepo.save(patient);
	}
	
	public void delete(Patient patient) {
		//si on veut garder les visites il faut mettre le patient de la visite à null
		//visiteRepo.setPatientToNullByPatient(patient);
		visiteRepo.deleteByPatient(patient);
		patientRepo.delete(patient);
	}
	
	public void deleteById(Integer id) {
		delete(findById(id));
	}
}
