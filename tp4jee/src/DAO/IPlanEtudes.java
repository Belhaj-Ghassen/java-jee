package DAO;

import java.util.List;

import modèle.Compte;
import modèle.GroupeModule;
import modèle.Matiere;

public interface IPlanEtudes {
	List<GroupeModule> getallGroupesModules();
	void addMatiere(Matiere m);
	boolean verifier(String email,String password);

}
