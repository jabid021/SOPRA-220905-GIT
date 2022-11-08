package ajc.sopra.demoBoot;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import ajc.sopra.demoBoot.service.CompteService;

@SpringBootTest
public class CompteTest {

	@Autowired
	private CompteService compteService;
	
	@Disabled
	@Test
	@Transactional
	@Commit
	void creationCompteTest() {
		compteService.creationAdmin("admin", "admin");
		compteService.creationUser("toto", "toto");
	}
}
