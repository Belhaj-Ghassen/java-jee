package Model;

public class Groupe {
	
	private int idgp;
	private String nom;
	private int capacite;
	public Groupe(int idgp, String nom, int capacite) {
		super();
		this.idgp = idgp;
		this.nom = nom;
		this.capacite = capacite;
	}
	public int getIdgp() {
		return idgp;
	}
	public void setIdgp(int idgp) {
		this.idgp = idgp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
}
