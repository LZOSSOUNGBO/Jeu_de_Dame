package utils;

import java.util.Scanner;

public class Utilitaires {
	
	int L = 10;
	int H = 10;
	char[][] map = new char[L][H];
	
public static void printEcran(char[][] ecran) {
		
		for(int i = 0; i < ecran.length; i++) {
			for(int j = 0; j < ecran[i].length; j++) {
				System.out.print(ecran[j][i]);
			}
			System.out.println("");
		}
	}

	

public static void fillEcran(char[][] ecran) {
    int L = ecran.length;
    int H = ecran[0].length;
    for(int i=0;i<L;i++) {
        for(int j=0;j<H;j++) {
            if(i==0 && j==0 || i==0 && j==H-1 || i==L-1 && j==0 ||i==L-1 && j==H-1) {
                ecran[i][j]='+';
            }else if (i==0 && (j!=0 || j!=H-1)|| i == L-1 && (j!=0 || j!=H-1)) {
                ecran[i][j]='|';                    
            }else if (j==0 && (i!=0 || i!=L-1) || j==H-1 && (i!=0 || i!=L-1)) {            
                ecran[i][j]='-';
            }else {
                ecran[i][j]='.';
            }
        }
    }

    
    
}
	
        

	
	public String saisieUtilString() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
}

