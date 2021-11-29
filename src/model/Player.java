package model;

public class Player {
	int x,y;
	char nom;
	
	
	public Player(int x, int y, char nom) {
		super();
		this.x = x;
		this.y = y;
		this.nom = nom;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public char getNom() {
		return nom;
	}


	public void setNom(char nom) {
		this.nom = nom;
	}
	
	

}
