package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdministrateur;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
	public Administrateur() {
		super();
	}
	public Administrateur(int idAdministrateur, String nom, String prenom, String login, String mdp) {
		super();
		this.idAdministrateur = idAdministrateur;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
	}
	public int getIdAdministrateur() {
		return idAdministrateur;
	}
	public void setIdAdministrateur(int idAdministrateur) {
		this.idAdministrateur = idAdministrateur;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
