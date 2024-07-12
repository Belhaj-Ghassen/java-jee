package Etablissement;

import Etablissement.carte.*;

public class MainAppli {

	public static void main(String[] args) {
		Restaurant r=new Restaurant("Houba","ghassen",55);
		System.out.println(r);
		BoissonGzeuse b=new BoissonGzeuse("fanta","boite");
		System.out.println(b);
		Plat l=new Plat("spagetti");
		Plat m=new Plat("sandwish");
		Plat n=new Plat("burger");
		Plat y=new Plat("Brika");
		r.AjoutPlat(l);
		r.AjoutPlat(m);
		r.AjoutPlat(n);
		r.AjoutPlat(y);
		r.AffichePlat();
		r.SuppPlat(n);
		r.AffichePlat();
		Restaurant res=new Restaurant();
		Boisson B=new Boisson("safia","eau");
		Boisson R=new Boisson("coca","boisson");
		Boisson V=new Boisson("tropico","jus");
		Boisson x=new Boisson("sabrine","eau");
		Boisson k=new Boisson("fanta","boisson");
		Boisson z=new Boisson("bnino","jus");
		res.Remplir(B);
		res.Remplir(R);
		res.Remplir(V);
		res.Remplir(x);
		res.Remplir(k);
		res.Remplir(z);
		res.Affiche();
		
	}

}
