package Etablissement.carte;

public class BoissonGzeuse extends Boisson{
   private   String marque;
      public BoissonGzeuse (String m,String nom ) { 
    	  super(nom);
    	  this.marque=m;
      }

	

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}



	@Override
	public String toString() {
		return "BoissonGzeuse [marque=" + marque +    super.toString() +"]";
	}
	
	
	
	
      
	

}
