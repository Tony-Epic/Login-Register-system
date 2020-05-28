package BO;

import DAO.UserDAOImplementation;
import Main.Main;

public class Validation 
{
	public static boolean usernameRegisterValidation(String username)
	{
		UserDAOImplementation user = new UserDAOImplementation();
		
		try
		{
			for (int i = 0; i < user.getUsers().size(); i++)
			{
				if (username.equals(user.getUsers().get(i).getUsername()))
				{
					return false;
				}
			}
		}
		
		catch (Exception e)
		{
			
			Main.errorMessage();
		}
	
		return true;
	}
	
	public static boolean usernameLoginValidation(String username)
	{
		UserDAOImplementation user = new UserDAOImplementation();
		
		try
		{
			for (int i = 0; i < user.getUsers().size(); i++)
			{
				if (username.equals(user.getUsers().get(i).getUsername()))
				{
					return true;
				}
			}
		}
		
		catch (Exception e)
		{
			
			Main.errorMessage();
		}
	
		return false;
	}
	
	public static boolean validatePasswordLength(String password)
	{
		if (password.length() < 6)
		{
			return false;
		}
		
		else
		{
			return true;
		}	
	}
	
	public static boolean passwordValidation(String username, String password)
	{
		UserDAOImplementation user = new UserDAOImplementation();
		
		try
		{
			for (int i = 0; i < user.getUsers().size(); i++)
			{
				if (username.equals(user.getUsers().get(i).getUsername()))
				{
					if (password.equals(user.getUsers().get(i).getPassword()))
					{
						return true;
					}
				}
			}
		}
		
		catch (Exception e)
		{
			
			Main.errorMessage();
		}
		
		return false;
	}
}
