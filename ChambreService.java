package Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import DAO.IDAO;
import Entities.Categorie;
import Entities.Chambre;

public class ChambreService implements IDAO<Chambre> {
	private CategorieService cs=new CategorieService();

	public boolean create(Chambre o) {
       String req = "INSERT INTO chambre (telephone, categorie_id) VALUES (?, ?)";
    try (PreparedStatement ps = Connexion.getCnx().prepareStatement(req)) {
        ps.setString(1, o.getTelephone());
        ps.setInt(2, o.getCat().getId());
        
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected == 1) {
            System.out.println("Chambre ajoutée avec succès !");
            return true;
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'insertion de la chambre !");
        e.printStackTrace(); // Affiche les détails de l'erreur
    }
    return false;
    }

    @Override
    public boolean update(Chambre o) {
        String req = "UPDATE chambre SET Telephone = ?, CategorieId = ? WHERE Id = ?";
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
            ps.setString(1, o.getTelephone());
            ps.setInt(2, o.getCat().getId());
            ps.setInt(3, o.getId());

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur Update !");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Chambre o) {
        String req = "DELETE FROM chambre WHERE Id = ?";
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
            ps.setInt(1, o.getId());

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la chambre !");
            e.printStackTrace();
        }
        return false;
    }

    @Override
  public Chambre findById(int id) {
    String req = "SELECT * FROM chambre WHERE Id = ?";
    try (PreparedStatement ps = Connexion.getCnx().prepareStatement(req)) {
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Categorie categorie = cs.findById(rs.getInt("categorie_id"));
                return new Chambre(id, rs.getString("Telephone"), categorie);
            }
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la recherche de la chambre par ID !");
        e.printStackTrace();
    }
    return null;
}

    @Override
    public List<Chambre> findAll() {
        String req = "SELECT * FROM chambre";
        List<Chambre> chambres = new ArrayList<>();
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
              chambres.add(new Chambre(rs.getInt(1),rs.getString(2),cs.findById(rs.getInt(3))));
              
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de toutes les chambres !");
            e.printStackTrace();
        }
        return chambres;
    }
 public List<Chambre> findChambreByCategorie(Categorie c) {
    List<Chambre> chambres = new ArrayList<>();
    String query = "SELECT * FROM chambre WHERE categorie_id = ?";
    
    try {
        PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
        ps.setInt(1, c.getId());  // Using the CategorieId to filter rooms by category
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("Id");  // Get the ID from the ResultSet
            String telephone = rs.getString("Telephone");  // Get the telephone number
            Chambre ch = new Chambre(id, telephone, c);  // Pass the ID, telephone, and category
            chambres.add(ch);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return chambres;
}
}