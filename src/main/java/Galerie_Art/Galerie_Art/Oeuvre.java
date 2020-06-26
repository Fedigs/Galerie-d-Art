package Galerie_Art.Galerie_Art;

public class Oeuvre {
	private String nom ;
	private String date_création;
	private String thème;
	private double prix;
	private boolean vendue;
	private String createur;
	public Oeuvre(String nom, String date_création, String thème, double prix, boolean vendue, String createur) {
		super();
		this.nom = nom;
		this.date_création = date_création;
		this.thème = thème;
		this.prix = prix;
		this.vendue = vendue;
		this.createur = createur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDate_création() {
		return date_création;
	}
	public void setDate_création(String date_création) {
		this.date_création = date_création;
	}
	public String getThème() {
		return thème;
	}
	public void setThème(String thème) {
		this.thème = thème;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isVendue() {
		return vendue;
	}
	public void setVendue(boolean vendue) {
		this.vendue = vendue;
	}
	public String getCreateur() {
		return createur;
	}
	public void setCreateur(String createur) {
		this.createur = createur;
	}
	
	

}
