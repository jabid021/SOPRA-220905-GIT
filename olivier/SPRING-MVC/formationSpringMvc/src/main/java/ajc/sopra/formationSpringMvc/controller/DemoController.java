package ajc.sopra.formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//definition d'un controller
@Controller
public class DemoController {

	//url pour arriver sur la methode
	@RequestMapping("/maison/hello")
	//le String en retour => vue
	public String hello() {
		return "hello";
	}
}
