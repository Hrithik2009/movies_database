package movie_database;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect_database {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/movies_database";
	
	static final String USER = "root";
	static final String PASS = "";
	public static void main(String[] args) {
		try {
			// Load the driver
			Class.forName(JDBC_DRIVER);
			
			// Creating a connection
			Connection c = DriverManager.getConnection(DB_URL, USER, PASS);	
			
			if(c.isClosed()) {
				System.out.print("Connection is closed!!");
			}
			else {
				System.out.print("Connection is there!!!!"); 
			}
		}catch(Exception e){
			e.printStackTrace();	
		}
	}

}