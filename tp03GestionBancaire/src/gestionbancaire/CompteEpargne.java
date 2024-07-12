package gestionbancaire;

public class CompteEpargne extends Compte{
	double Depotmin=500;
	public CompteEpargne(Client clt, double mont) {
		super(clt, mont);
	}
	public void RetraitE(double a) {
		if((super.getMont()-a)<this.Depotmin) {
			System.out.println("Erreur ! Retrait Impossible vous depassez le depot minimal ");
		}
		else {
			super.Retrait(a);
		}
	}
		

	public String toString() {
		return "CompteEpargne :"  + super.toString()  ;
	}

}
