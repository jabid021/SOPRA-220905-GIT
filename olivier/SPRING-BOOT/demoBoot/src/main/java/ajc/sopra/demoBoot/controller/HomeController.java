package ajc.sopra.demoBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ajc.sopra.demoBoot.service.CompteService;

@Controller
public class HomeController {

	@Autowired
	private CompteService compteService;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/inscription")
	public String inscription() {
		return "inscription";
	}

	@PostMapping("/inscription")
	public String saveUser(@RequestParam String login, @RequestParam(name = "mdp") String password) {
		compteService.creationUser(login, password);
		return "redirect:/home";
	}
}
