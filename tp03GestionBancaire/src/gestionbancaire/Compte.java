package gestionbancaire;

public class Compte {
	Client clt;
	static private int num =99;
	private double mont;
	
	
	public Compte(Client clt,double mont) {
		this.clt=clt;
		this.num++;
		this.mont=mont;
	}
	
	public Compte() {
		this.mont=0;
	}

	public void Depot(double a) {
		this.mont=this.mont+a;
	}
	public void Retrait(double b) {
		this.mont=this.mont-b;
	}

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Compte.num = num;
	}

	public double getMont() {
		return mont;
	}

	public void setMont(double mont) {
		this.mont = mont;
	}
	public String toString() {
		return "Client :nom=" + this.clt.getNom() + "  Num compte:"+this.num +"  Montant"+this.mont ;
	}
	
    
}
