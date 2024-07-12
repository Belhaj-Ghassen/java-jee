package DAO;

import java.util.List;

import Model.Groupe;
import Model.Membre;
import Model.Seance;

public interface IGestionClub {
	public List<Membre> getAllMembreByGp(int id);
	public List<Groupe> getAllGroupe();
	public Membre addMembre(Membre m);
	public Membre getMembreById(int id);
	public void deleteMembreById(int id);
	public int getNbMembreByGb(int idgp);
	public Groupe getGbById(int idgp);
	public List<Seance> getAllSeanceByGp(int id);

	
}
