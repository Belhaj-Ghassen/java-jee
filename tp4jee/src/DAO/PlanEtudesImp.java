package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import modèle.*;
public class PlanEtudesImp implements IPlanEtudes{
	

	Connection con;
	
	
	public List<GroupeModule> getallGroupesModules(){
		return null;
	}
	public void addMatiere(Matiere m) {
	}
	
	public boolean verifier(String email,String password) {
		
		int i=0;
		
		
		
		try {
			Statement stm=(Statement) con.createStatement();
			PreparedStatement ps= con.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				 i++;}
		}
				catch(SQLException e) {
					e.printStackTrace();
				}
		if(i>0)
			return true;
		else
				return false;
			
	
		
		}
	
public PlanEtudesImp()  {
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/gestion";

	 con = DriverManager.getConnection(url,"root","");
}  catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("connexion etabli !");
}
}

