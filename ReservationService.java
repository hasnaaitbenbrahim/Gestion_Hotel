package Service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connexion.Connexion;
import DAO.IDAO;
import Entities.Chambre;
import Entities.Client;
import Entities.Reservation;
import Entities.Categorie;

public class ReservationService implements IDAO<Reservation> {
            private ClientService cls=new ClientService();
            private ChambreService chms=new ChambreService();
    @Override
    public boolean create(Reservation o) {
        String req = "INSERT INTO Reservation (client_id, chambre_id, datedebut, datefin) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(req, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, o.getClt().getId()); 
            ps.setInt(2, o.getChm().getId()); 
            ps.setDate(3, new Date(o.getDatedebut().getTime()));
            ps.setDate(4, new Date(o.getDatefin().getTime()));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {
                // Retrieve the generated id
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    o.setId(generatedId); // Set the generated id in the reservation object
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur in Create Reservation !");
            e.printStackTrace();
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------

    @Override
    public boolean update(Reservation o) {
        String req = "UPDATE Reservation SET datedebut = ?, datefin = ? WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
            ps.setDate(1, new Date(o.getDatedebut().getTime()));
            ps.setDate(2, new Date(o.getDatefin().getTime()));
            ps.setInt(3, o.getId()); // Update based on the reservation id

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur Update reservation !");
            e.printStackTrace();
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------

    @Override
    public boolean delete(Reservation o) {
        String req = "DELETE FROM Reservation WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
            ps.setInt(1, o.getId()); // Delete based on the reservation id

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur Delete reservation !");
            e.printStackTrace();
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------

    @Override
    public Reservation findById(int id) {
        String req = "SELECT * FROM reservation WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Client clt = cls.findById(rs.getInt("client_id"));
                Chambre chm = chms.findById(rs.getInt("chambre_id"));
                Date datedebut = rs.getDate("datedebut");
                Date datefin = rs.getDate("datefin");

                return new Reservation(
                    rs.getInt("id"),
                    clt,
                    chm,
                    datedebut,
                    datefin
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur Find/id reservation !");
            e.printStackTrace();
        }
        return null;
    }

    //------------------------------------------------------------------------------------------------

    @Override
    public List<Reservation> findAll() {
        String req = "SELECT * FROM Reservation";
        List<Reservation> reservations = new ArrayList<>();
        try {
            PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            ClientService clientService = new ClientService();
            ChambreService chambreService = new ChambreService();

            while (rs.next()) {
                System.out.println("ID : " + rs.getInt("Id"));
                System.out.println("Client ID : " + rs.getInt("client_id"));
                System.out.println("Chambre ID : " + rs.getInt("chambre_id"));
                System.out.println("Date début : " + rs.getDate("datedebut"));
                System.out.println("Date fin : " + rs.getDate("datefin"));


                Client clt = clientService.findById(rs.getInt("client_id"));
                Chambre chm = chambreService.findById(rs.getInt("chambre_id"));
                Date datedebut = rs.getDate("datedebut");
                Date datefin = rs.getDate("datefin");

                reservations.add(new Reservation(
                rs.getInt("Id"),
                clt,
                chm,
                datedebut,
                datefin
            ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur FindAll reservations !");
            e.printStackTrace();
        }
        return reservations;
    }
    
     // Méthode pour récupérer les chambres réservées entre deux dates pour un client spécifique
    private List<Chambre> findChambreBetweenDates(Client selectedClient, Date dateDebut, Date dateFin) {
    List<Chambre> chambres = new ArrayList<>();
    String query = "SELECT c.id, c.telephone c.categorie_id "
                 + "FROM Reservation r "
                 + "JOIN chambre c ON r.chambre_id = c.id "
                 + "WHERE r.client_id = ? AND r.datedebut >= ? AND r.datefin <= ?";

    try (PreparedStatement ps = Connexion.getCnx().prepareStatement(query)) {
        // Set the parameters for the query
        ps.setInt(1, selectedClient.getId()); // Set client ID
        ps.setDate(2, new java.sql.Date(dateDebut.getTime())); // Set start date
        ps.setDate(3, new java.sql.Date(dateFin.getTime())); // Set end date

        // Execute the query
        ResultSet rs = ps.executeQuery();

        // Process the result set and create Chambre objects
        while (rs.next()) {
            int chambreId = rs.getInt("id");
            String telephone = rs.getString("telephone");
            Chambre chambre = new Chambre(chambreId, telephone, null); // Update with other necessary fields
            chambres.add(chambre);
        }
    } catch (SQLException e) {
        System.out.println("Error when retrieving rooms for the selected client and dates!");
        e.printStackTrace();
    }

    return chambres;
}

public List<Chambre> findChambresByClientAndDates(Client client, java.util.Date dateDebut, java.util.Date dateFin) {
    List<Chambre> chambres = new ArrayList<>();
    String req = "SELECT DISTINCT c.*, cat.code as cat_code, cat.libelle as cat_libelle " +
                 "FROM chambre c " +
                 "INNER JOIN reservation r ON c.id = r.chambre_id " +
                 "LEFT JOIN categorie cat ON c.categorie_id = cat.id " +
                 "WHERE r.client_id = ? " +
                 "AND ((r.datedebut BETWEEN ? AND ?) " +
                 "OR (r.datefin BETWEEN ? AND ?))";
    
    try {
        PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
        ps.setInt(1, client.getId());
        
        // Explicit conversion from java.util.Date to java.sql.Date
        java.sql.Date sqlDateDebut = null;
        java.sql.Date sqlDateFin = null;
        
        if (dateDebut != null) {
            sqlDateDebut = new java.sql.Date(dateDebut.getTime());
        }
        if (dateFin != null) {
            sqlDateFin = new java.sql.Date(dateFin.getTime());
        }
        
        // Set the dates in the prepared statement
        ps.setDate(2, sqlDateDebut);
        ps.setDate(3, sqlDateFin);
        ps.setDate(4, sqlDateDebut);
        ps.setDate(5, sqlDateFin);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            // Create Categorie object
            Categorie categorie = null;
            int categorieId = rs.getInt("categorie_id");
            if (!rs.wasNull()) {
                categorie = new Categorie(
                    categorieId,
                    rs.getString("cat_code"),
                    rs.getString("cat_libelle")
                );
            }
            
            // Create Chambre object with the constructor
            Chambre chambre = new Chambre(
                rs.getInt("id"),
                rs.getString("telephone"),
                categorie
            );
            
            chambres.add(chambre);
        }
    } catch (SQLException e) {
        System.out.println("Error finding chambres between dates: " + e.getMessage());
        e.printStackTrace();
    }
    
    return chambres;
}

}
