package ajc.sopra.demoBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.sopra.demoBoot.entity.Compte;
import ajc.sopra.demoBoot.entity.Role;
import ajc.sopra.demoBoot.repository.CompteRepository;

@Service
public class CompteService {
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Compte creationAdmin(String login,String password) {
		return compteRepo.save(new Compte(login, passwordEncoder.encode(password), Role.ROLE_ADMIN));
	}
	
	public Compte creationUser(String login,String password) {
		return compteRepo.save(new Compte(login, passwordEncoder.encode(password), Role.ROLE_USER));
	}
}
