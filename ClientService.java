package Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import DAO.IDAO;
import Entities.Client;

public class ClientService implements IDAO<Client> {

	@Override
	public boolean create(Client o) {
		String req="insert into client values(null,?,?,?,?)";
		try {
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getTelephone());
			ps.setString(4, o.getEmail());
			
			if(ps.executeUpdate()==1) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error d'execution !!!!");
			e.printStackTrace();
		}
		
		return false;
	}
	//------------------------------------------------------------------------------------------------
	@Override
	public boolean update(Client o) {
		 String req = "UPDATE client SET Nom = ?, Prenom = ?, Telephone = ?, Email = ? WHERE Id = ?";
	        try {
	            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
	            ps.setString(1, o.getNom());
	            ps.setString(2, o.getPrenom());
	            ps.setString(3, o.getTelephone());
	            ps.setString(4, o.getEmail());
	            ps.setInt(5, o.getId());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error of Updating !");
	            e.printStackTrace();
	        }
		return false;
	}
//------------------------------------------------------------------------------------------------
	@Override
	public boolean delete(Client o) {
		 String req = "DELETE FROM client WHERE Id = ?";
	        try {
	            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
	            ps.setInt(1, o.getId());

	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("Erreur lors de la suppression !");
	            e.printStackTrace();
	        }
	        return false;
	    }
	//------------------------------------------------------------------------------------------------
	@Override
	public Client findById(int id) {
		String req = "SELECT * FROM client WHERE Id = ?";
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Client(
                    rs.getInt("id"),
                    rs.getString("Nom"),
                    rs.getString("Prenom"),
                    rs.getString("Telephone"),
                    rs.getString("Email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur , Id Not Found !");
            e.printStackTrace();
        }
        return null;
	}
	//------------------------------------------------------------------------------------------------
	@Override
	public List<Client> findAll() {
		 String req = "SELECT * FROM client";
	        List<Client> clients = new ArrayList<>();
	        
	        try {
	            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                clients.add(new Client(
	                   rs.getInt("id"),
	                    rs.getString("Nom"),
	                    rs.getString("Prenom"),
	                    rs.getString("Telephone"),
	                    rs.getString("Email")
	                ));
	            }
	        } catch (SQLException e) {
	            System.out.println("Erreur D'afficher tous les clients !");
	            e.printStackTrace();
	        }
	        return clients;
	    }
	

}