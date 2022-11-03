package ajc.sopra.formationSpringMvc.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ajc.sopra.formationSpringMvc.model.Personne;
import ajc.sopra.formationSpringMvc.model.Societe;

@RestController
@RequestMapping("/api")
public class DemoRest {

//	public Data qui sera automatiquement transformer en JSON methodeAAppeler() {
//		
//	}

	@GetMapping("/bonjour")
	public String bonjour() {
		return "bonjour";
	}

	@GetMapping("/olivier")
	public Personne bonjourOlivier() {
		Personne olivier = new Personne("olivier", "gozlan");
		olivier.setSociete(new Societe("ajc"));
		return olivier;
	}

	@GetMapping("/info/{nom}")
	public void hello(@PathVariable String nom) {
		System.out.println(nom);
	}

	@PostMapping("/create")
	public Personne constructionPersonne(@RequestBody Personne personne) {
		System.out.println(personne.getPrenom());
		System.out.println(personne.getNom());
		return personne;
	}
}
