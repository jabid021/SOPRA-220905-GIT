package springAspect;

import org.springframework.beans.factory.annotation.Autowired;

import springAspect.dao.ProduitDao;
import springAspect.model.Produit;

public class AppSpring {

	@Autowired
	private ProduitDao produitDao;
	
	public void run(String...args) {
		Produit p=new Produit();
		p=produitDao.save(p);
		System.out.println(p.getId());
	}
}
