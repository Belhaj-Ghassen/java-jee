package Model;

public class Seance {
	
	private int ids;
	private String nums;
	private String jour;
	private Groupe grp;
	private Entraineur entraineur;
	
	
	public int getIds() {
		return ids;
	}
	public void setIds(int ids) {
		this.ids = ids;
	}
	public String getNums() {
		return nums;
	}
	public void setNums(String nums) {
		this.nums = nums;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public Groupe getGrp() {
		return grp;
	}
	public void setGrp(Groupe grp) {
		this.grp = grp;
	}
	public Entraineur getEntraineur() {
		return entraineur;
	}
	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}
	

}
