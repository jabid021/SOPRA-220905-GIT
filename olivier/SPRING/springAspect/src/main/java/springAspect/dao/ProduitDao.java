package springAspect.dao;

import org.springframework.stereotype.Component;

import springAspect.model.Produit;

@Component
public class ProduitDao {

	public Produit save(Produit produit) {
		// simule une ecriture en base
		System.out.println("on simule une ecriture");
		produit.setId(100);
		//throw new IllegalArgumentException("erreur");
		 return produit;
	}
}
