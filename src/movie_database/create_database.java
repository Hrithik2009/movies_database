package movie_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class create_database {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost";
	
	static final String USER = "root";
	static final String PASS = "";
	
	public static void main(String[] args)throws Exception {
		
		Class.forName(JDBC_DRIVER);
		
		Connection c = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement s = c.createStatement();
		
		String sql = "CREATE DATABASE MOVIES_DATABASE";
		s.executeUpdate(sql);
		 
		System.out.println("Database created!!"); 
		s.close();
		c.close();
	}

}
