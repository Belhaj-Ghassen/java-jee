package Model;

public class Membre {
    private int idm;
    private String nom;
    private Groupe grp;
    
    public Membre() {
    	
    }
    
    public Membre(int idm, String name, Groupe group) {
        this.idm = idm;
        this.nom = name;
        this.grp = group;
    }
    
    public Membre( String name, Groupe group) {
        this.nom = name;
        this.grp = group;
    }

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Groupe getGrp() {
        return grp;
    }

    public void setGrp(Groupe grp) {
        this.grp = grp;
    }
}
