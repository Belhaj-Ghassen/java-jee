package Vue;

import javax.swing.*;

import DAO.PlanEtudesImp;

import java.awt.*;
import java.awt.event.*;

public class Login  implements ActionListener {
    JFrame f=new JFrame("Connexion");
	JLabel eml = new JLabel("Email:");
    JLabel psw = new JLabel("Mot de passe:");
    JTextField texeml=new JTextField("");
    JTextField texpsw=new JTextField("");
    JButton btn = new JButton("se connecter");

    public Login() {
        f.setLayout(new GridLayout(4,2));
        f.add(eml);
        f.add(texeml);
        f.add(psw);
        f.add(texpsw);
        f.add(btn);
        f.setBounds(150,150,150,150);
        f.setVisible(true);
        btn.addActionListener(this);
    }
public void actionPerformed(ActionEvent e) {
	 
	PlanEtudesImp p=new PlanEtudesImp();
	String email=texeml.getText();
	String password=texpsw.getText();

	if(e.getSource()==btn) {
		if(p.verifier(email, password)) {
		GestionMatieres m=new GestionMatieres();
		}
	
	else {
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, "Invalid email/password ! Please try again");
			
		}}
	}
	
	




}

