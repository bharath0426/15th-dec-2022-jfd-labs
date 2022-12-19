import java.sql.*;
import java.util.Scanner;

public class JDBCApplication {
	public static void main(String[] args) {
	  a java application to retrieve information 
(author ID, name, and city) about the authors who are 
living in the city where the city name begins with the 
letter “S”. In jdbc

import java.sql.*;
import java.util.Scanner;

public class JDBCApplication {
	public static void main(String[] args) {
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/authors_database";

		// Database credentials
		final String USER = "root";
		final String PASS = "password";

		// Variables for user input
		String city = "";

		// Create a scanner object for user input
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter a city with a name starting with "S"
		System.out.println("Please enter a city beginning with the letter 'S': ");
		city = scanner.nextLine();

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			// Retrieve information about authors living in the city
			String sql = "SELECT author_id, name, city FROM authors WHERE city = '" + city + "'";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			System.out.println("Author ID \tName \t\t\tCity");
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("author_id");
				String name = rs.getString("name");
				String cityName = rs.getString("city");

				// Display values
				System.out.println(id + "\t\t" + name + "\t\t" + cityName);
			}
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}
}
