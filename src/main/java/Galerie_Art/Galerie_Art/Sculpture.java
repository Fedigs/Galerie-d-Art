package Galerie_Art.Galerie_Art;

public class Sculpture extends Oeuvre {
private double volume ;
private double poids;
private String matière;
public Sculpture(String nom, String date_création, String thème, double prix, boolean vendue, String createur,
		double volume, double poids, String matière) {
	super(nom, date_création, thème, prix, vendue, createur);
	this.volume = volume;
	this.poids = poids;
	this.matière = matière;
}
public double getVolume() {
	return volume;
}
public void setVolume(double volume) {
	this.volume = volume;
}
public double getPoids() {
	return poids;
}
public void setPoids(double poids) {
	this.poids = poids;
}
public String getMatière() {
	return matière;
}
public void setMatière(String matière) {
	this.matière = matière;
}

}
