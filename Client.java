package Entities;


public class Client {

	private int id;
	private String Nom;
	private String Prenom;
	private String Telephone;
	private String Email;
	
	public Client(String nom,String prenom,String telephone,String email) {
		this.Nom=nom;
		this.Prenom=prenom;
		this.Telephone=telephone;
                this.Email=email;
	}
	public Client(int id, String nom, String prenom, String telephone, String email) {
		this.id=id;
		this.Nom=nom;
		this.Prenom=prenom;
		this.Telephone=telephone;
		this.Email=email;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
        @Override
        public String toString() {
		return this.Nom;
	}
}