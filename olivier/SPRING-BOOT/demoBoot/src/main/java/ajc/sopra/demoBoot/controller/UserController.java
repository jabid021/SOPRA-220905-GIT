package ajc.sopra.demoBoot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ajc.sopra.demoBoot.entity.Compte;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@GetMapping("")
	public String home(@AuthenticationPrincipal Compte compte) {
		LOGGER.info(compte.toString());
		LOGGER.info(compte.getLogin());
		LOGGER.info(compte.getPassword());
		LOGGER.info(compte.getAuthorities().toString());
		return "user/home";
	}
}
