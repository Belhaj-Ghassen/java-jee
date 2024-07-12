package Etablissement;

import java.util.Vector;
import Etablissement.carte.*;

public class Restaurant {
private	String Nom;
private	String Proprietaire;
private	int Couvert;
	public Restaurant() {};
	public Restaurant(String a,String b,int x) {
		this.Nom=a;
		this.Proprietaire=b;
		this.Couvert=x;
	}
	@Override
	public String toString() {
		return "Restaurant [Nom=" + Nom + ", Proprietaire=" + Proprietaire + ", Couvert=" + Couvert + "]";
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getProprietaire() {
		return Proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		Proprietaire = proprietaire;
	}
	public int getCouvert() {
		return Couvert;
	}
	public void setCouvert(int couvert) {
		Couvert = couvert;
	}
	
	Vector v=new Vector();
	public void AjoutPlat(Plat p) {
		v.addElement(p);
	}
	public void SuppPlat(Plat p) {
		v.removeElement(p);
	}
	public void AffichePlat() {
		System.out.print("[");
		for(int i=0;i<v.size();i++) {
			System.out.print(v.elementAt(i)+"/");
		}
		System.out.println("]");
	}
	String [][] mat=new String [3][3];
	
	public void Remplir(Boisson B) {
		int i=1,j=1,k=1;
		int x,y,z;
		mat[0][0]=new String("eau");
		mat[0][1]=new String("boisson");
		mat[0][2]=new String("jus");
		if(B.getType().equals(mat[0][0])) {
			if(x==1) {
			mat[i][0]=B.getNom();
			i++;
			x=i;
			}
			else {
				mat[x][0]=B.getNom();
			}
		}
		else if(B.getType().equals(mat[0][1])){
			mat[j][1]=B.getNom();
			j++;
		}
		else if(B.getType().equals(mat[0][2])){
			mat[k][2]=B.getNom();
			k++;
		}
	}
	public void Affiche() {
		System.out.println("Voici notre carte Boisson:");
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				System.out.print(mat[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	
	

}
