package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.UserRegister;

public class UserDAOImplementation {
	
	

	
	Connection connection = ConnectionManager.getInstance().getConnection();
	public ArrayList<UserRegister> getUsers() throws SQLException {

		// create an array list to hold students
		 ArrayList<UserRegister> users = new ArrayList<UserRegister>();
		
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
				users.add(new UserRegister( rs.getString("Ime"), rs.getString("Prezime"),
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
	public void updateUser(String ime, String prezime, String username) throws SQLException
	{
		String query = "UPDATE useri SET Ime = ?, Prezime = ? WHERE username = '" + username + "'";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) 
		{
			statement.setString(1, ime);
			statement.setString(2, prezime);

			statement.executeUpdate();

			System.out.println("User updated.");
		}
	}
	
	public void deleteUser(String username) throws SQLException
	{
		String query = "DELETE FROM useri WHERE username = '" + username + "'";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) 
		{
			statement.executeUpdate();

			System.out.println("User obrisan");
		}
	}
	
	
}

