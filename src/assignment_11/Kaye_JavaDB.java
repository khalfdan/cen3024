package assignment_11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Kaye_JavaDB {

	public static void main(String[] args) throws Exception {
		// getConnection();
		get();
	}

	public static ArrayList<String> get() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT word FROM spelling.word");

			ResultSet result = statement.executeQuery();

			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.println(result.getString("word"));

				array.add(result.getString("word"));
			}
			System.out.println("All records have been selected!");
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/spelling";
			String username = "khalfdan";
			String password = "DbAdmin1925";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
