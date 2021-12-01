package utils;

import java.util.HashMap;

import main.Game;
import model.Pion;

public class Moves {
 static boolean gameOn = true;
	public static void move(Pion P, String[][] ecran, int x, int y) {

		ecran[P.getX()][P.getY()] = ".";
		P.setX(x);
		P.setY(y);
		if(!ecran[x][y].contains(".")) {
		Pion toRemove = Game.hmP.get(ecran[x][y]);
		if(toRemove.getCouleur().equals("b")) {
			Game.hmPB.remove(toRemove.getName());
		} else {
			Game.hmPN.remove(toRemove.getName());
		}
		}
		ecran[P.getX()][P.getY()] = P.getName();
	}

	public static void mouv_User(String[][] ecran, HashMap<String, Pion> hmP) {
		
		do 
		{
			System.out.print("Choisissez un pion : ");
			String choix = Utilitaires.saisieString().toLowerCase();
			while (!hmP.containsKey(choix)) {
				
				System.out.print("Mauvaise entree. Choississez un pion : ");
				choix = Utilitaires.saisieString().toLowerCase();

			}
			Utilitaires.writeDataInFile("Pion choisis par le joueur : "+choix.toLowerCase(), "./Mouvement.txt");
			
			System.out.print("Choisissez la position du pion (xy) : ");
			String choix_pos = Utilitaires.saisieString();
			if (checkMove(hmP.get(choix),ecran,choix_pos)) {
				Utilitaires.writeDataInFile("Position choisis par le joueur : " + choix_pos.toLowerCase(), "./Mouvement.txt");
				int x = Integer.valueOf(choix_pos.charAt(0));
				int y = Integer.valueOf(choix_pos.charAt(1));
				move(hmP.get(choix),ecran,x,y);
				Utilitaires.printEcran(ecran);
			} else {
				System.out.println("Le pion selectionne ne peut pas bouge");
			}
			isGameOver();
		}while(gameOn);
		
		
	}
	
	public static void isGameOver() {
		if(Game.hmPB.size() == 0 || Game.hmPN.size() ==0) {
			System.out.println("Le jeu est termine");
			gameOn = false;
		}
	}
	
	public static boolean checkMove(Pion pion, String[][] ecran, String moveToCheck) {
		boolean isValid = false;
		
		if(!moveToCheck.equals("")) {
			System.out.println(" ( X ="+pion.getX() + ", Y = "+pion.getX() +")");
			switch(pion.getCouleur()) {
			case "b":
				System.out.println("pion blanc ");
				if(Integer.valueOf(moveToCheck.charAt(0)) ==pion.getX()-1 ) {
					
					if(Integer.valueOf(moveToCheck.charAt(1)) ==pion.getY()-1) {
						if(ecran[pion.getX()-1][pion.getY()-1].contains("n") || ecran[pion.getX()-1][pion.getY()-1].contains(".") ) {
							System.out.println("pion blanc diagonal gauche ");
							isValid= true;
						}
					} else if (Integer.valueOf(moveToCheck.charAt(0)) ==pion.getY()+1) {
						if(ecran[pion.getX()-1][pion.getY()+1].contains("n") || ecran[pion.getX()-1][pion.getY()+1].contains(".") ) {
							System.out.println("pion blanc diagonale droite");
							isValid= true;
						}
					}
				}
				break;
			case "n":
				System.out.print("pion noir ");
				if(Integer.valueOf(moveToCheck.charAt(0)) ==pion.getX()+1 ) {
					
					if(Integer.valueOf(moveToCheck.charAt(1)) ==pion.getY()-1) {
						if(ecran[pion.getX()+1][pion.getY()-1].contains("b") || ecran[pion.getX()+1][pion.getY()-1].contains(".") ) {
							System.out.print("pion noir diagonal gauche ");
							isValid= true;
						}
					} else if (Integer.valueOf(moveToCheck.charAt(0)) ==pion.getY()+1) {
							if(ecran[pion.getX()+1][pion.getY()+1].contains("b") || ecran[pion.getX()+1][pion.getY()+1].contains(".") ) {
								System.out.print("pion noir diagonale droite ");
							isValid= true;
						}
					}
				}
				break;
			}
			
		}
		
		return isValid;
		
	}

}
