package DTO;

import BO.Validation;

import Main.Main;
import DAO.UserDAOImplementation;

public class UserRegister {
	private String ime;
	private String prezime;
	private String username;
	private String password;
	private boolean successfull;
	
	public UserRegister(String ime, String prezime, String username, String password) {
		super();
		setIme(ime);
		setPrezime(prezime);
		setUsername(username);
		setPassword(password);
		setSuccessfull(true);
		
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
		if(Validation.usernameRegisterValidation(username)==true)
		{
			this.username = username;
		}
		else
		{
			Main.errorMessage();
			Main.start();
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
			Main.start();
		}
	}

	public boolean isSuccessfull() {
		return successfull;
	}

	public void setSuccessfull(boolean successfull) {
		this.successfull = successfull;
	}
	
	
	

}
