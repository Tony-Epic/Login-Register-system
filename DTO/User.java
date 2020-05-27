package DTO;

import BO.Validation;

import Main.Main;
import DAO.UserDAOImplementation;

public class User {
	private String ime;
	private String prezime;
	private String username;
	private String password;
	
	public User(String ime, String prezime, String username, String password) {
		super();
		setIme(ime);
		setPrezime(prezime);
		setUsername(username);
		setPassword(password);
		
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime=prezime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(Validation.validateUserame(username)==true)
		{
			this.username = username;
		}
		else
		{
			Main.errorMessage();
			Main.menu();
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
		if(Validation.validatePasswordLength(password)==true)
		{
			this.password=password;
		}
		else
		{
			Main.errorMessage();
			Main.menu();
		}
	}
	
	

}
