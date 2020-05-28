package Main;

import java.util.Scanner;

import DAO.UserDAOImplementation;
import DTO.UserLogin;
import DTO.UserRegister;

public class Main 
{
	static Scanner sc = new Scanner (System.in);
	static String nowLoggedIn = "";
	static Scanner input=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		start();
	}
	
	public static void start()
	{
		
		System.out.println("1) Login\n2) Register");
		int choice = sc.nextInt();
		
		switch (choice)
		{
			case 1:
				login();
				break;
				
			case 2:
				register();
				break;
			
			default:
				errorMessage();
				break;
		}
	}
	
	public static void login()
	{
		
		
		System.out.println("Unesite username: ");
		String username = input.next();
		
		System.out.println("Unesite password: ");
		String password = input.next();
		UserLogin user = new UserLogin(username, password);
		
		if (user.isLoginSuccessful() == true)
		{
			System.out.println("Login uspješan!");
			nowLoggedIn = username;
			options();
		}
		
		else
		{
			errorMessage();
		}
	}
	
	public static void register()
	{
		
		
		System.out.println("Unesite ime: ");
		String ime = input.next();
		
		System.out.println("Unesite prezime: ");
		String prezime = input.next();
		
		System.out.println("Unesite username: ");
		String username = input.next();
		System.out.println("Unesite password: ");
		String password = input.next();
		
		UserRegister user = new UserRegister(ime,prezime,username,password);
		
		if (user.isSuccessfull() == true)
		{
			try
			{
				UserDAOImplementation addData = new UserDAOImplementation();
				addData.addUser(ime,prezime,username,password);
				System.out.println("Register uspješan !");
				start();
			}
			
			catch (Exception e)
			{
				System.out.println(e);
				errorMessage();
			}
		}
		
		else
		{
			errorMessage();
		}
	}
	
	public static void options()
	{
		int choice;
		
		
		System.out.println("1) Change name\n2) Delete account");
		
		choice = input.nextInt();
		
		switch (choice)
		{
			case 1:
				changeName();
				break;
				
			case 2:
				deleteAcc();
				break;
				
			default:
				errorMessage();
				break;
		}
	}
	
	public static void changeName()
	{
		
		
		System.out.println("Enter new name: ");
		String ime =input.next();
		
		System.out.println("Enter new surname: ");
		String prezime = input.next();
			
		try
		{
			UserDAOImplementation user = new UserDAOImplementation();
			user.updateUser(ime, prezime, nowLoggedIn);
			start();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
			start();
		}
	}
	
	public static void deleteAcc()
	{
		int choice;
		
		System.out.println("Jeste li sigurni da želite obrisati vas racun");
		System.out.println("1) Da\n2) Ne");
		
		choice = sc.nextInt();
		
		switch (choice)
		{
			case 1:
				deleteFinal();
				break;
			
			default:
				start();
				break;
		}
	}
	
	public static void deleteFinal()
	{
		try
		{
			UserDAOImplementation user = new UserDAOImplementation();
			user.deleteUser(nowLoggedIn);
			start();
		}
		
		catch (Exception e)
		{
			
			start();
		}
	}
	
	public static void errorMessage()
	{
		System.out.println("Greska,pokusajte ponovo!");
		start();
	}
	
	
}
