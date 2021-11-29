package main;


import utils.Utilitaires;

public class Game {
	
	char[][] ecran = new char[20][20];
	
public void launch() {
		
		Utilitaires.fillEcran(ecran);
		Utilitaires.printEcran(ecran);
		
}

}
