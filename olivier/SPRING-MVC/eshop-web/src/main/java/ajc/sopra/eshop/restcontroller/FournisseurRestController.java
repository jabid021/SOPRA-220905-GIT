package ajc.sopra.eshop.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.eshop.model.Fournisseur;
import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.service.FournisseurService;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurRestController {

	@Autowired
	private FournisseurService fournisseurSrv;

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Fournisseur findById(@PathVariable Integer id) {
		return fournisseurSrv.findById(id);
	}

	@JsonView(JsonViews.FournisseurWithProduit.class)
	@GetMapping("/{id}/produit")
	public Fournisseur findByIdWithProduit(@PathVariable Integer id) {
		return fournisseurSrv.findByIdFetchProduits(id);
	}
}
