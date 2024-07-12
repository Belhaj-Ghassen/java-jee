package Etablissement.carte;

public class Boisson {
	private String Nom;
	private String type;
	public Boisson() {};
	public Boisson(String a) {
		this.Nom=a;
	}
	public Boisson(String a,String b) {
		this.Nom=a;
		this.type=b;
	}
	
	
	public String toString() {
		return  Nom ;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
