package utils;

import java.util.HashMap;

import model.Pion;

public class Moves {

	public static void move(Pion P, String[][] ecran, int x, int y) {

		ecran[P.getY()][P.getX()] = ".";
		P.setX(x);
		P.setY(y);
		ecran[P.getY()][P.getX()] = P.getName();
	}

	public static void mouv_User(String[][] ecran, HashMap<String, Pion> hmP) {
		
		do 
		{
			System.out.print("Choisissez un pion : ");
			String choix = Utilitaires.saisieString().toLowerCase();
			Utilitaires.writeDataInFile(choix.toLowerCase(), "./Mouvement.txt");
			while (!hmP.containsKey(choix)) {

				choix = Utilitaires.saisieString().toLowerCase();

			}
			System.out.print("Choisissez la position du pion : ");
			String choix_pos = Utilitaires.saisieString();
			Utilitaires.writeDataInFile(choix_pos.toLowerCase(), "./Mouvement.txt");
			while (choix_pos == "") {
				choix_pos = Utilitaires.saisieString();
				
			}
			int x = choix_pos.charAt(0);
			int y = choix_pos.charAt(1);
			move(hmP.get(choix),ecran,x-48,y-48);
			Utilitaires.printEcran(ecran);
			
		}while(true);
		
		
	}

}
