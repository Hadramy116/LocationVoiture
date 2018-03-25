package com.location.data;

import java.sql.Connection;
import java.sql.DriverManager;

///Singleton Connextion
public class ConnexionDB {

	private static Connection dbConnexion;
	public static boolean etatConnexion = false;
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			dbConnexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/locationvoiture","root","");
			
			etatConnexion = true;
			
		}catch (Exception e) {
			//e.printStackTrace();
			etatConnexion = false;
		}
	}

	public static Connection getDbConnexion() {
		return dbConnexion;
	}	
}
