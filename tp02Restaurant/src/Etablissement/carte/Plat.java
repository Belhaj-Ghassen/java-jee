package Etablissement.carte;

public class Plat {
   private 	String Nom;
	public Plat() {};
	public Plat(String b) {
		this.Nom=b;
	}
	public String toString() {
		return "Plat= " + Nom ;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	

}
