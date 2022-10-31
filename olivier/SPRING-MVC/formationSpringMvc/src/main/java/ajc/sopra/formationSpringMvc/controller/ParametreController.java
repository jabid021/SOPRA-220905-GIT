package ajc.sopra.formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demo")
public class ParametreController {
	@GetMapping("/param")
	public String parametre(@RequestParam(name="prenom",required = false,defaultValue = "world")String prenom,
			@RequestParam String nom, Model model) {
		model.addAttribute("prenom", prenom);
		model.addAttribute("nom", nom);
		return "param";
	}
}
