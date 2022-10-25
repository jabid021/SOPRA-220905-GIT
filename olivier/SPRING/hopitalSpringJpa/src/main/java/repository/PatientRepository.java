package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Patient;

//interface definit à partir d'un entité(Patient) et du type de sa clé (Integer)
//genere automatiquement le code correspondant
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	List<Patient> findByNom(String nom);
	List<Patient> findByPrenom(String prenom);
	List<Patient> findByPrenomAndNom(String prenom,String nom);
	//les methodes doivent renvoyer soit List<T> ici List<Patient>
	//soit Optional<T> ici Optional<Patient>
	
	//@Query permet de definir sa propre requete
	//on analyse plus le nom de la methode
	@Query("select p from Patient p left join fetch p.visites where p.id=:id")
	//@Param substitution du parametre :id de la query
	Optional<Patient> findByIdFetchVisites(@Param("id") Integer id);
}
