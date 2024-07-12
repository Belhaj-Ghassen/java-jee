package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Entraineur;
import Model.Groupe;
import Model.Membre;
import Model.Seance;

public class GestionClubImp {
    private Connection connection;

    public GestionClubImp(){
    	try {
            String url = "jdbc:mysql://localhost:3306/tp2";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

        }
        catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    // Implement the methods:	

    public List<Membre> getAllMembreByGp(int id) {
        List<Membre> membres = new ArrayList<>();
        try {
            String sql = "SELECT * FROM membre WHERE grp_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Membre membre = new Membre();
                membre.setIdm(resultSet.getInt("idm"));
                membre.setNom(resultSet.getString("nom"));
                membre.setGrp(getGbById(resultSet.getInt("grp_id")));

                membres.add(membre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }
        return membres;
    }

    public List<Groupe> getAllGroupe() {
        List<Groupe> groupes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM groupe";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Groupe groupe = new Groupe();
                groupe.setIdgp(resultSet.getInt("idgp"));
                groupe.setNom(resultSet.getString("nom"));
                groupe.setCapacite(resultSet.getInt("capacite"));

                groupes.add(groupe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupes;
    }

    public Membre addMembre(Membre m) {
        try {
            String sql = "INSERT INTO membre (nom, grp_id) VALUES ( ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, m.getNom());
            statement.setInt(2, m.getGrp().getIdgp());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public Membre getMembreById(int id) {
        Membre membre = null;
        try {
            String sql = "SELECT * FROM membre WHERE idm = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                membre = new Membre();
                membre.setIdm(resultSet.getInt("idm"));
                membre.setNom(resultSet.getString("nom"));
                membre.setGrp(getGbById(resultSet.getInt("grp_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membre;
    }

    public void deleteMembreById(int id) {
        try {
            // Create a SQL query to delete a member by ID
            String sql = "DELETE FROM membre WHERE idm = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            // Execute the delete statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    public int getNbMembreByGb(int idgp) {
        int count = 0;
        try {
            // Create a SQL query to count the number of members in a group
            String sql = "SELECT COUNT(*) FROM membre WHERE grp_id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idgp);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public Groupe getGbById(int idgp) {
        Groupe groupe = null;
        try {
            String sql = "SELECT * FROM groupe WHERE idgp = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idgp);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                groupe = new Groupe();
                groupe.setIdgp(resultSet.getInt("idgp"));
                groupe.setNom(resultSet.getString("nom"));
                groupe.setCapacite(resultSet.getInt("capacite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupe;
    }
    public Entraineur getEntraineurById(int id) {
    	Entraineur entraineur = new Entraineur();
    	try {
            String sql = "SELECT * FROM `entraineur` WHERE ide = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            entraineur.setIde(id);
            entraineur.setNom(resultSet.getString("nom"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return entraineur;
    	
    }
    public List<Seance> getSeanceById(int grpId) {
		GestionClubImp gestion = new GestionClubImp();
    	List<Seance> seances = new ArrayList<Seance>();

        try {
            String sql = "SELECT * FROM `seance` WHERE grp_id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, grpId);
            
            ResultSet resultSet = statement.executeQuery();
            System.out.println("1");
            while (resultSet.next()) {
                Seance seance = new Seance();
                seance.setIds(resultSet.getInt("ids"));
                seance.setNums(resultSet.getString("nums"));
                seance.setJour(resultSet.getString("jour"));
                Groupe grp = gestion.getGbById(grpId);
                System.out.println("2");
                seance.setGrp(grp);
                Entraineur ent = gestion.getEntraineurById(resultSet.getInt("entraineur_id"));
                System.out.println("3");
                seance.setEntraineur(ent);
                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }


}
