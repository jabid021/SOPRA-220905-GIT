package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Patient;

//interface definit à partir d'un entité(Patient) et du type de sa clé (Integer)
//genere automatiquement le code correspondant
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
