package model;

public class Etudiant {
	 private int numero;
	 private String nom ;
	 private String prenom;
	 private String numerotelephone;
public Etudiant() {}
public Etudiant(int numero, String nom, String prenom, String numerotelephone) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.numerotelephone = numerotelephone;
	}



public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getNumerotelephone() {
	return numerotelephone;
}

public void setNumerotelephone(String numerotelephone) {
	this.numerotelephone = numerotelephone;
}

@Override
public String toString() {
	return "Etudiant [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", numerotelephone=" + numerotelephone
			+ "]";
};
 
 
}
