package movie_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class create_table {
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
			Statement s = c.createStatement();
			
			String q = "CREATE TABLE Movies(name varchar(200) not null, actor varchar(200) not null, actress varchar(200) not null, director varchar(200) not null, year_of_release date not null)";
			s.executeUpdate(q);
			System.out.println("Movies Table created!!");
			s.close();
			c.close();
		}catch(Exception e){
			e.printStackTrace();	  
		}

	}

}