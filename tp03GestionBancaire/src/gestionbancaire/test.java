package gestionbancaire;

public class test {

	public static void main(String[] args) {
		Client G=new Client ("ghassen","07/05/2001");
		CompteCourant R=new CompteCourant(G,1000);
         R.RetraitC(500);
         System.out.println(R);
         R.Depot(2000);
         System.out.println(R);
         Client H=new Client ("amal","08/04/2000");
 		CompteEpargne Y=new CompteEpargne(H,2700);
          Y.RetraitE(3000);
          Y.Depot(1000);
          System.out.println(Y);
          Client A=new Client ("safa","06/04/2008");
  		CompteCourant M=new CompteCourant(A,5000);
           M.RetraitC(6000);
           M.Depot(3000);
           System.out.println(M);
         
	}

}
