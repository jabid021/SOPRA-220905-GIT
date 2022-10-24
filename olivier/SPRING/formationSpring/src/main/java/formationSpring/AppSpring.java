package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;

import formationSpring.bean.Musicien;
import formationSpring.bean.Pianiste;

public class AppSpring {
	//si on est dans un bean 
	//@Autowired permet de faire un injection
	//plus rapide à ecrire que getBean()...
	@Autowired
	private Pianiste musicien;
	//on attend de 0 à n string
	public void run(String... args ) {
		
		//ajouter les spectateurs sous forme d'un aspect
		//public s'installe avant que le musien joue
		//public applaudit si c'est bien
		// siffle si fausse note(FausseNoteException)
		//le public part
		musicien.jouer();
	}
	
}
