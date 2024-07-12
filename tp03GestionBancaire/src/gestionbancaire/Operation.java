package gestionbancaire;

public class Operation {
	private double montant;
	private String date;
	private String lib;
	public Operation(double a,String b,String c) {
		this.montant=a;
		this.date=b;
		this.lib=c;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	@Override
	public String toString() {
		return date+"|cheque n° "+lib+"|"+montant+" Dt";
	}
	
	

}
