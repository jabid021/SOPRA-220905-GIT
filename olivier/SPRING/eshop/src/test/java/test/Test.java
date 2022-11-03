package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ajc.sopra.eshop.config.JpaConfig;
import ajc.sopra.eshop.model.Achat;
import ajc.sopra.eshop.model.Adresse;
import ajc.sopra.eshop.model.Client;
import ajc.sopra.eshop.model.Fournisseur;
import ajc.sopra.eshop.model.Produit;
import ajc.sopra.eshop.service.ProduitService;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(JpaConfig.class);
		ProduitService produitSrv=ctx.getBean(ProduitService.class);
		Produit p1=produitSrv.findById(9);
		Produit p2=produitSrv.findById(9);
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		ctx.close();
	}

}
