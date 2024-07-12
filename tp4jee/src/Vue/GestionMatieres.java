package Vue;

import javax.swing.*;
import java.awt.*;

public class GestionMatieres {
	 JFrame a=new JFrame("Ajouter Matière");
		JLabel Nom = new JLabel("Nom matière:");
	    JLabel NHC = new JLabel("Nombre H cours:");
	    JLabel NHT = new JLabel("Nombre H TP:");
	    JLabel CO = new JLabel("Coefficient:");
	    JLabel GRMO = new JLabel("Groupe de Module:");
	    String[] tab= {"info","math","physique"};
	    JTextField texnom=new JTextField("");
	    JTextField texnhc=new JTextField("");
	    JTextField texnht=new JTextField("");
	    JTextField texco=new JTextField("");
	    JComboBox <String> cobgrp =new JComboBox<String>(tab);
	    JButton btaj = new JButton("Ajouter");
	    JButton btan = new JButton("Annuler");


	    public  GestionMatieres() {
	        a.setLayout(new GridLayout(6,2));
	        a.add(Nom);
	        a.add(texnom);
	        a.add(NHC);
	        a.add(texnhc);
	        a.add(NHT);
	        a.add(texnht);
	        a.add(CO);
	        a.add(texco);
	        a.add(GRMO);
	        a.add(cobgrp);
	        a.add(btaj);
	        a.add(btan);
	        a.setBounds(150,150,150,150);
	        a.setVisible(true);

	    }

}
