package movie_database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectRecords {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/movies_database";
	
	static final String USER = "root";
	static final String PASS = "";
	
	private static Connection c = null;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		selectRecords selectrecords = new selectRecords(); 
		try {
			// Load the driver
			Class.forName(JDBC_DRIVER);
			
			// Creating a connection
			c = DriverManager.getConnection(DB_URL, USER, PASS);
	
			System.out.println("Enter Choice: ");
			System.out.println("1.Retrieve without Parameter..");
			System.out.println("2.Retrieve with Parameter..");
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice){
				case 1: 
					selectrecords.selectAllRecords();
					break;
				case 2:
					System.out.println("Enter actor name: ");
					String names = br.readLine();
					selectrecords.selectSingleRecords(names);
					break;
				default:
					System.out.println("Wrong Choice");
					
			}
			
		}catch(Exception e){
			e.printStackTrace();	  
		}

	}
	
	private void selectAllRecords() throws SQLException {
		// Create a Statement
		String sql = "select * from movies";
		PreparedStatement ps = c.prepareStatement(sql);
		
		// Execute query
		ResultSet resultSet = ps.executeQuery();
		while(resultSet.next()) {
			System.out.println("Name = " + resultSet.getString("name"));
			System.out.println("Actor = " + resultSet.getString("actor"));
			System.out.println("Actress = " + resultSet.getString("actress"));
			System.out.println("Director = " + resultSet.getString("director"));
			System.out.println("Year of release = " + resultSet.getString("year_of_release"));
			System.out.println("------------------------------------------");
		}
		resultSet.close();
		ps.close();
		c.close();		
	}
	
	private void selectSingleRecords(String names) throws SQLException, IOException {
		
		// Create a Statement
		String sql = "select * from movies where actor = ?"; 
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, names);
		
		// Execute query
		ResultSet resultSet = ps.executeQuery();
		
		boolean found = false;
		while(resultSet.next()) {
			System.out.println("Name = " + resultSet.getString("name"));
			System.out.println("Actor = " + resultSet.getString("actor"));
			System.out.println("Actress = " + resultSet.getString("actress"));
			System.out.println("Director = " + resultSet.getString("director"));
			System.out.println("Year of release = " + resultSet.getString("year_of_release"));
			System.out.println("------------------------------------------");
			found = true;
		}
		
		if(!found) {
			System.out.println("No record found!!");
		}
		resultSet.close();
		ps.close();
		c.close();		
	}
}
