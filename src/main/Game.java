package main;


import model.Pion;
import utils.Utilitaires;

public class Game {
	
	char[][] ecran = new char[10][10];
	Pion [] mapBlanc = new Pion[20];
	Pion [] mapNoir = new Pion[20];
	
	
	public void filltab() {
		
		for(int i = 0 ; i < 10; i++) {
			for (int j = 0; j < 10 ; j++){
				ecran[i][j] = '.';
			}
		}
		
		int modulo = 0;
		int place = 1;
		for(int i=0;i<mapBlanc.length;i++) {
			System.out.println(mapBlanc[i]);
			
			mapBlanc[i] = new Pion(place%10,place/10,"blanc") ;
			place += 2;
			modulo++;
			if(modulo % 5 == 0) {place -= 1;}
			System.out.println(mapBlanc[i].getX()+" "+mapBlanc[i].getY());
			ecran[mapBlanc[i].getX()][mapBlanc[i].getY()] = mapBlanc[i].getName();
		}
		place = 61;
		for(int i=0;i<mapNoir.length;i++) {
			System.out.println(mapNoir[i]);
			
			mapNoir[i] = new Pion(place%10,place/10,"noir") ;
			place += 2;
			System.out.println(mapNoir[i].getX()+" "+mapNoir[i].getY());
			ecran[mapNoir[i].getX()][mapNoir[i].getY()] = mapNoir[i].getName();
			
		}
		
		
	}
	
public void launch() {
		
		//Utilitaires.fillEcran(ecran);
		Utilitaires.printEcran(ecran);
		filltab();
		Utilitaires.printEcran(ecran);
		
}

}
