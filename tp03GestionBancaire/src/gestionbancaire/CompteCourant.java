package gestionbancaire;

public class CompteCourant extends Compte{
	
	

	public CompteCourant(Client clt, double mont) {
		super(clt, mont);
	}
	public CompteCourant() {super();};
	public void RetraitC(double a) {
		if((super.getMont()-a)<0) {
			System.out.println("Erreur ! Retrait Impossible Solde insuffisant ");
		}
		else {
			super.Retrait(a);
		}
	}

	public String toString() {
		return "CompteCourant :"  + super.toString()  ;
	}
		


	
	
	

}
