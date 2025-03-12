package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
	private static final String url="jdbc:mysql://localhost:3306/Projet-GestionReservation";
	private static final String user="root";
	private static final String password="";
	private static Connection cnx=null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Successfuly Found");
			
			cnx=DriverManager.getConnection(url,user,password);
			System.out.println("Connection Successfuly Found");

			
		} catch (ClassNotFoundException e) {
			System.out.println("Error ! Driver Not Found !!!!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error ! Connection Not Found !!!!!");
			e.printStackTrace();
		}
		
	}
	public static Connection getCnx() {
		return cnx;
	}
}