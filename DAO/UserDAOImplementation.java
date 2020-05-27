package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.User;

public class UserDAOImplementation {
	public static ArrayList<User> users = new ArrayList<User>();
	

	
	Connection connection = ConnectionManager.getInstance().getConnection();
	public ArrayList<User> getUsers() throws SQLException {

		// create an array list to hold students
		
		// create an SELECT SQL query
		String query = "SELECT * FROM users";

		// create a new ResultSet
		ResultSet rs = null;

		try (
				// java.sql.Statement
				Statement statement = connection.createStatement();) {

			// execute the query
			rs = statement.executeQuery(query);

			// add students to the arrayList
			while (rs.next()) {
				users.add(new User( rs.getString("Ime"), rs.getString("Prezime"),
						rs.getString("Username"), rs.getString("Password")));

			
			}

		}

		return users;
	}
	public void addUser(String ime,String prezime,String username,String password) throws SQLException {

		// create an SELECT SQL query
		String query = "INSERT INTO users(Ime,Prezime, Username, Password) VALUES (?, ?, ?, ?)";
		try (
				// java.sql.Statement
				PreparedStatement statement = connection.prepareStatement(query);) {

			// fill in the placeholders/parameters
			statement.setString(1,ime);
			statement.setString(2, prezime);
			statement.setString(3, username);
			statement.setString(4, password);

			// execute the query
			statement.executeUpdate();
			System.out.println("Uspjesno dodano");
		}
	}
	
	
}

