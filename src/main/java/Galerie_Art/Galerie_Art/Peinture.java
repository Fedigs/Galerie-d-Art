package Galerie_Art.Galerie_Art;

public class Peinture extends Oeuvre{
	private double taille;

	public Peinture(String nom, String date_création, String thème, double prix, boolean vendue, String createur,
			double taille) {
		super(nom, date_création, thème, prix, vendue, createur);
		this.taille = taille;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}
	

}
