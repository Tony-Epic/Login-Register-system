package BO;
import Main.Main;
import DAO.UserDAOImplementation;
public class Validation {
	
	public static boolean validateUserame(String username)
	{
		for(int i=0;i<UserDAOImplementation.users.size();i++)
		{
			if(username.equals(UserDAOImplementation.users.get(i).getUsername()))
			{
				return false;
			}
		}
		return true;
		
	}
	public static boolean validatePasswordLength(String password)
	{
		if(password.length()<6)
		{
			return false;
			
		}
		return true;
		
	}

}
