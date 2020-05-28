package DTO;

import BO.Validation;
import Main.Main;

public class UserLogin 
{
	private String username;
	private String password;
	private boolean loginSuccessful;
	
	
	
	public UserLogin(String username, String password) 
	{
		setUsername(username);
		setPassword(username, password);
		setLoginSuccessful(true);
	}

	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		if (Validation.usernameLoginValidation(username) == true)
		{
			this.username = username;
		}
		
		else
		{
			Main.errorMessage();
		}
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String username, String password) 
	{
		if (Validation.passwordValidation(username, password))
		{
			this.password = password;
		}
		
		else
		{
			Main.errorMessage();
		}
	}

	public boolean isLoginSuccessful() {
		return loginSuccessful;
	}

	public void setLoginSuccessful(boolean loginSuccessful) {
		this.loginSuccessful = loginSuccessful;
	}
	
	
	
}
