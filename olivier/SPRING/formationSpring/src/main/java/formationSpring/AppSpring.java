package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;

import formationSpring.bean.Musicien;

public class AppSpring {
	//si on est dans un bean 
	//@Autowired permet de faire un injection
	//plus rapide à ecrire que getBean()...
	@Autowired
	private Musicien musicien;
	//on attend de 0 à n string
	public void run(String... args ) {
		musicien.jouer();
	}
	
}
