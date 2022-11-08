package ajc.sopra.demoBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.demoBoot.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	Optional<Compte> findByLogin(String login);
}
