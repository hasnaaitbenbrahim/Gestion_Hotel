package Entities;

import java.util.Date;

public class Reservation {

    private int id;           // Add an id field for unique identification
    private Client Clt;
    private Chambre Chm;
    private Date Datedebut;
    private Date Datefin;

   
// Constructor with id (used when retrieving an existing reservation from the database)
    public Reservation( Client clt, Chambre chm, Date datedebut, Date datefin) {
        super();
        
        Clt = clt;
        Chm = chm;
        Datedebut = datedebut;
        Datefin = datefin;
    }


    // Constructor with id (used when retrieving an existing reservation from the database)
    public Reservation(int id, Client clt, Chambre chm, Date datedebut, Date datefin) {
        super();
        this.id = id;
        Clt = clt;
        Chm = chm;
        Datedebut = datedebut;
        Datefin = datefin;
    }


    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClt() {
        return Clt;
    }

    public void setClt(Client clt) {
        Clt = clt;
    }

    public Chambre getChm() {
        return Chm;
    }

    public void setChm(Chambre chm) {
        Chm = chm;
    }

    public Date getDatedebut() {
        return Datedebut;
    }

    public void setDatedebut(Date datedebut) {
        Datedebut = datedebut;
    }

    public Date getDatefin() {
        return Datefin;
    }

    public void setDatefin(Date datefin) {
        Datefin = datefin;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", Clt=" + Clt + ", Chm=" + Chm + ", Datedebut=" + Datedebut + ", Datefin=" + Datefin + "]";
    }
}
