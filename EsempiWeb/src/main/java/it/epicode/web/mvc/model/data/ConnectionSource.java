package it.epicode.web.mvc.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSource {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/epic_db?currentSchema=epic_schema&user=postgresMaster&password=goPostgresGo");
	}

}
