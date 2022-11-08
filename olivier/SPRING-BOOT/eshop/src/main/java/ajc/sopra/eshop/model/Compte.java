package ajc.sopra.eshop.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Compte {

	@OneToOne(mappedBy = "compte")
	private Client client;
}
