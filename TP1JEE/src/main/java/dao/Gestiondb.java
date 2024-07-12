package dao;
import model.Etudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Gestiondb implements IGestion {
	Connection cnx;
	public Gestiondb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tp1jee","root","");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
   public List<Etudiant> getAllEtudiants(){
	   List<Etudiant> etudiants=new ArrayList<>();
	   try {
		   String sql1="SELECT * FROM etudiants";
		   PreparedStatement sts=cnx.prepareStatement(sql1);
		   ResultSet result =sts.executeQuery();
		   while(result.next()) {
			   int num=result.getInt("numero");
			   String nom=result.getString("nom");
			   String prenom=result.getString("prenom");
			   String tel=result.getString("tel");
               Etudiant etudiant =new Etudiant(num,nom,prenom,tel);
               etudiants.add(etudiant);

		   }
		   result.close();
		   sts.close();
		   
		   
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return etudiants;
   }

@Override
     public void addEtudiant(Etudiant p) {
        try {
	       String sql2="INSERT INTO etudiants (nom,prenom,tel) VALUES (?,?,?)";
	           PreparedStatement stat=cnx.prepareStatement(sql2);
	       stat.setString(1,p.getNom());
	       stat.setString(2,p.getPrenom());
	       stat.setString(3,p.getNumerotelephone());
           stat.executeUpdate();
           stat.close();
	
      }catch(SQLException e) {
	   e.printStackTrace();
	   }
}

@Override
public void deleteEtudiant(int num) {
try {
	String sql3="DELETE FROM etudiants WHERE numero=?";
	PreparedStatement stat=cnx.prepareStatement(sql3);
	stat.setInt(1,num);
	stat.executeUpdate();
	stat.close();
}catch(SQLException e) {
	   e.printStackTrace();
	   }
}

@Override
public boolean verif(String user, String mp) {
	boolean utilisateurTrouve=false;
	try {
	 String query = "SELECT * FROM comptes WHERE username = ? AND password = ?";
     PreparedStatement preparedStatement = cnx.prepareStatement(query) ;
         preparedStatement.setString(1, user);
         preparedStatement.setString(2, mp);

         ResultSet resultSet = preparedStatement.executeQuery() ;
            if(resultSet!=null) {
            	utilisateurTrouve=true;
            }
         
     
 } catch (SQLException e) {
     e.printStackTrace(); 
 }

 return utilisateurTrouve;
}
	
	
}
