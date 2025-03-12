package Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import DAO.IDAO;
import Entities.Categorie;

public class CategorieService implements IDAO<Categorie> {
List<Categorie> categories;
	 public boolean create(Categorie o) {
	        String req = "INSERT INTO Categorie VALUES (NULL, ?, ?)";
	        try {
	            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
	            ps.setString(1, o.getCode());
	            ps.setString(2, o.getLibelle());
	            
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("Erreur lors de l'ajout de la catégorie !");
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	   public boolean update(Categorie o) {
    String req = "UPDATE Categorie SET Code = ?, Libelle = ? WHERE Id = ?";
    try {
        System.out.println("Preparing query: " + req); // Debug
        PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
        ps.setString(1, o.getCode());
        ps.setString(2, o.getLibelle());
        ps.setInt(3, o.getId());

        System.out.println("Executing update for ID=" + o.getId() +
                           ", Code=" + o.getCode() + 
                           ", Libelle=" + o.getLibelle()); // Debug

        if (ps.executeUpdate() == 1) {
            System.out.println("Update successful for ID: " + o.getId()); // Debug
            return true;
        } else {
            System.out.println("No record updated. Check if ID exists."); // Debug
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la mise à jour de la catégorie !");
        e.printStackTrace();
    }
    return false;
}


                @Override
       public boolean delete(Categorie o) {
           // Check if the Categorie object is valid and has a valid ID
           if (o == null || o.getId() <= 0) {
               System.out.println("Invalid Categorie object or ID.");
               return false;
           }

           String req = "DELETE FROM categorie WHERE Id = ?";
           try {
               PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
               ps.setInt(1, o.getId());

               // Execute the update and log the number of affected rows
               int rowsAffected = ps.executeUpdate();
               if (rowsAffected == 1) {
                   System.out.println("Category successfully deleted: " + o.getId());
                   return true;
               } else {
                   System.out.println("No category found with ID: " + o.getId());
                   return false;
               }
           } catch (SQLException e) {
               System.out.println("Erreur lors de la suppression de la catégorie !");
               e.printStackTrace();
           }
           return false;
       }

	    @Override
public Categorie findById(int id) {
    String req = "SELECT * FROM Categorie WHERE Id = ?";
    try {
        System.out.println("Executing query: " + req); // Debug
        PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Category found: ID=" + rs.getInt("id") + 
                               ", Libelle=" + rs.getString("Libelle") + 
                               ", Code=" + rs.getString("Code")); // Debug
            return new Categorie(
                rs.getInt("id"),
                rs.getString("Libelle"),
                rs.getString("Code")
            );
        } else {
            System.out.println("No category found with ID: " + id); // Debug
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la recherche de la catégorie !");
        e.printStackTrace();
    }
    return null;
}


	    @Override
	    
            public List<Categorie> findAll() {
        String query = "SELECT * FROM Categorie";
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            categories = new ArrayList<>();
            while(rs.next()){
                categories.add(new Categorie(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("libelle")
                ));
            }

        } catch (SQLException e) {
            System.err.println("[CategorieService.findAll] Erreur lors de la recuperation les données du categorie : " + e.getMessage());
            throw new RuntimeException(e);
        }
        return categories;
    }
}