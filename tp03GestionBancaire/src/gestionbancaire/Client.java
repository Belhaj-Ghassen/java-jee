package gestionbancaire;

public class Client {
private	String nom;
private	String date ;
	public Client(String a,String b){
		this.nom=a;
		this.date=b;
		}
	
	public String toString() {
		return "Client:nom=" + nom ;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	}

