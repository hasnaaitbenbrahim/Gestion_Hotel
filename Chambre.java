package Entities;

public class Chambre {

	private int id;
	private String telephone;
	private Categorie Cat;
	
public Chambre(int id, String tele, Categorie Cat) {
    this.id = id;
    this.telephone = tele;
    this.Cat = Cat;
}
public Chambre(String telephone, Categorie cat) {
    // Implémentez la logique ici
    this.telephone = telephone;
    this.Cat = cat;
}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Categorie getCat() {
		return Cat;
	}

	public void setCat(Categorie cat) {
		Cat = cat;
	}

	@Override
	public String toString() {
		return telephone;
	}
	
}