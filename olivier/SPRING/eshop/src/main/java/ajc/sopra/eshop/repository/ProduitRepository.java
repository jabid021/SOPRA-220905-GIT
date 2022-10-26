package ajc.sopra.eshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
	List<Produit> findByLibelleContaining(String libelle);
}
