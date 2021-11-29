package model;

public class Pion {
 int x , y;
 String couleur;
 char Name = '@';
 

public Pion(int x, int y, String couleur) {
	
	this.x = x;
	this.y = y;
	this.couleur = couleur;
	
	Name = couleur == "blanc" ? 'b' : 'n';
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


public String getCouleur() {
	return couleur;
}


public void setCouleur(String couleur) {
	this.couleur = couleur;
}


public char getName() {
	return Name;
}


public void setName(char name) {
	Name = name;
}



 
 
}
