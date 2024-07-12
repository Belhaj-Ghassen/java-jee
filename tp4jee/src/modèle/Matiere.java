package modèle;

public class Matiere {
	
	private int id;
	private String nom;
	private int nbHcours;
	private int nbHTp;
	private double coeff;
	GroupeModule grpmod;
	public Matiere(int id, String nom, int nbHcours, int nbHTp, double coeff, GroupeModule grpmod) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbHcours = nbHcours;
		this.nbHTp = nbHTp;
		this.coeff = coeff;
		this.grpmod = grpmod;
	}

}
