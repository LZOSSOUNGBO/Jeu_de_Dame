package utils;

import java.util.Scanner;

public class Utilitaires {
	
public static void printEcran(char[][] ecran) {
		
		for(int i = 0; i < ecran.length; i++) {
			for(int j = 0; j < ecran[i].length; j++) {
				System.out.print(ecran[j][i]);
			}
			System.out.println("");
		}
	}

	public static void fillEcran(char[][] ecran) {
		for(int i = 0; i<ecran.length; i++) {
			for(int j = 0; j<ecran[i].length; j++) {
				ecran[i][0] = '|';
				ecran[i][ecran.length-1] = '|';
				ecran[0][j] = '|';
				ecran[ecran.length-1][j] = '|';
				ecran[i][j]='.';
			}
		}
	}
	
	

	
	
	
	public String saisieUtilString() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
}

