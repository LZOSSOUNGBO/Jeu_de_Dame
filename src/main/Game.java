package main;


import java.util.HashMap;

import model.Pion;
import utils.Moves;
import utils.Utilitaires;

public class Game {
	
	
	public static HashMap<String, Pion> hmPB = new HashMap<String, Pion>();
	public static HashMap<String, Pion> hmPN = new HashMap<String, Pion>();
	public static HashMap<String, Pion> hmP = new HashMap<String, Pion>();


	String[][] ecran = new String[10][10];

	
	
	//execution des fonctions etablis
	
public void launch() {
		
	    Utilitaires.nomUtilisateur();
		Utilitaires.fillEcran(ecran);
		Utilitaires.filltab(ecran,hmP);
		Utilitaires.printEcran(ecran);
		Moves.mouv_User(ecran, hmP);
		
		
}

}

