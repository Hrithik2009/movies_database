package movie_database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insert_data {
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
			
			String q = "insert into movies(name, actor, actress, director, year_of_release) values(?, ?, ?, ?, ?)";
			PreparedStatement ps = c.prepareStatement(q);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter movie name: ");
			String name = br.readLine();
			
			System.out.println("Enter actor name: ");
			String actor = br.readLine();
			
			System.out.println("Enter actress name: ");
			String actress = br.readLine();
			
			System.out.println("Enter director name: ");
			String director = br.readLine();
			
			System.out.println("Enter Date: ");
			String date = br.readLine();
			
			ps.setString(1, name);
			ps.setString(2, actor);
			ps.setString(3, actress);
			ps.setString(4, director);
			ps.setString(5, date);
			ps.executeUpdate();
			
			System.out.println("Data Inserted!!");
			c.close();
		}catch(Exception e){
			e.printStackTrace();	  
		}

	}

} 
