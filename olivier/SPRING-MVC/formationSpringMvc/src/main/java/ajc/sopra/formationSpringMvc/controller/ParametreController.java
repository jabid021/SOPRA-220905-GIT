package ajc.sopra.formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ajc.sopra.formationSpringMvc.model.Personne;

@Controller
@RequestMapping("/demo")
public class ParametreController {
	@GetMapping("/param")
	public String parametre(@RequestParam(name="prenom",required = false,defaultValue = "world")String prenom,
			@RequestParam String nom, Model model) {
//		model.addAttribute("prenom", prenom);
//		model.addAttribute("nom", nom);
		Personne p=new Personne(prenom, nom);
		model.addAttribute("personne", p);
		return "param";
	}
	
	@GetMapping("/objet")
	//2 actions
	//instancie un objet de type Personne
	//recuperation auto les parametres qui correspondent à un setter
	public String utilisationModelAttribute(@ModelAttribute Personne personne,Model model) {
		model.addAttribute("personne", personne);
		return "param";
		
	}
}
