package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import main.Game;
import model.Pion;

public class Utilitaires {

	int L = 10;
	int H = 10;
	String[][] map = new String[L][H];

	public static void writeDataInFile(String strToWrite, String fileName) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.write(strToWrite + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void nomUtilisateur() {

		System.out.println("--------Jeu de Dame--------");
		System.out.println("Entrez le nom du premier joueur");
		String nom1 = saisieString();
		writeDataInFile(nom1.toLowerCase(), "./info_player.txt");
		System.out.println("Entrez le nom du deuxieme joueur");
		String nom2 = saisieString();
		writeDataInFile(nom2.toLowerCase(), "./info_player.txt");

	}

	public static String saisieString() {
		@SuppressWarnings("resource")
        String s = new Scanner(System.in).nextLine();
        return s;
	}

	public static void printEcran(String[][] ecran) {

		//System.out.println(" + - - - - - - - - - - - - - - - - - - - - - - - - - +");

		for (int i = 0; i < ecran.length; i++) {
			//System.out.print(" | ");
			for (int j = 0; j < ecran[i].length; j++) {

				System.out.print("	" + ecran[j][i]);

			}
			//System.out.println("|");
			System.out.println('\n');
		}
		//System.out.println(" + - - - - - - - - - - - - - - - - - - - - - - - - - +");
	}

	public static void fillEcran(String[][] ecran) {

		for (int i = 0; i < ecran.length; i++) {

			for (int j = 0; j < ecran[i].length; j++) {

				ecran[i][j] = " . ";

			}

		}
		add_Boarders(ecran);

	}

	// fonctions pour affichier les pions sur l'ecran
	public static void filltab(String[][] ecran, HashMap<String, Pion> hmP) {
		int id = 1;
		Pion pB = new Pion(id, id, null);
		Pion pN = new Pion(id, id, null);
		for (int ligne = 1; ligne < 4; ligne++) {
			for (int colonne = 1; colonne < 8; colonne = colonne + 2) {
				if (ligne == 2) {
					pB = new Pion(colonne, ligne + 5, "blanc");
					pN = new Pion(colonne+1, ligne, "noir");

				}else {
					pB = new Pion(colonne+1, ligne + 5, "blanc");
					pN = new Pion(colonne, ligne, "noir");
					
				}

				pB.setName(pB.getName() + String.valueOf(id));
				hmP.put(pB.getName(), pB);
				Game.hmPB.put(pB.getName(), pB);
				ecran[pB.getX()][pB.getY()] = pB.getName();

				// System.out.println(mapNoir[i].getX()+" "+mapNoir[i].getY());
				pN.setName(pN.getName() + String.valueOf(id));
				hmP.put(pN.getName(), pN);
				Game.hmPN.put(pN.getName(), pN);
				ecran[pN.getX()][pN.getY()] = pN.getName();
				id++;
			}

		}

	}
	
    public static void add_Boarders(String[][] ecran) {
        //String[] letters = new String[] { "A", "B", "C", "D", "E", "F", "G", "H"};
        String[] numbers = new String[] { "1", "2", "3", "4", "5", "6", "7", "8"};
        String[] reversenumbers = new String[] { "9","8", "7", "6", "5", "4", "3", "2"};
        for (int i = 1; i < ecran.length - 1; i++) {
            for (int j = 1; j < ecran[i].length - 1; j++) {
            	ecran[0][j] = reversenumbers[j - 1];
            	ecran[ecran.length - 1][j] = reversenumbers[j - 1];
           
            	ecran[i][0] = numbers[i - 1];
            	ecran[i][ecran[i].length - 1] = numbers[i - 1];
            	ecran[i][j] = ".";
            
            }
            
    
        }
      
    }

}
