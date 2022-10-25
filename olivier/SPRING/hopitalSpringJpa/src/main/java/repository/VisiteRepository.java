package repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Patient;
import model.Visite;

public interface VisiteRepository extends JpaRepository<Visite, Integer> {
	List<Visite> findByPatient(Patient patient);

	List<Visite> findByPatientId(Integer id);

	@Modifying
	@Transactional
	@Query("update Visite v set v.patient=null where v.patient=:patient")
	int setPatientToNullByPatient(@Param("patient") Patient patient);

	@Modifying
	@Transactional
	@Query("delete Visite v where v.patient=:patient")
	int deleteByPatient(@Param("patient") Patient patient);
}
