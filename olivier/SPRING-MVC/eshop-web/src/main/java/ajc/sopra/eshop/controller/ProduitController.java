package ajc.sopra.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ajc.sopra.eshop.service.ProduitService;

@Controller
public class ProduitController {

	@Autowired
	private ProduitService produitSrv;
}
