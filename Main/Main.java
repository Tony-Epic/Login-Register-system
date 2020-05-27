package Main;

import java.util.ArrayList;
import java.sql.DriverManager;
import DAO.UserDAOImplementation;
import java.util.Scanner;

import DTO.User;

public class Main {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu()
	{
		System.out.println("Unesite 1 za login");
		System.out.println("Unesite 2 za register");
		int izbor=input.nextInt();
		
		switch (izbor) {
		case 1:
			login();
			break;
		case 2 :
			register();
			break;

		default:
			errorMessage();
			break;
		}
	}

	public static void errorMessage() 
	{
		System.out.println("Greska,pokušajte ponovo!");
		menu();
	}

	public static void register() 
	{
		System.out.println("Unesite vaše ime : ");
		
		String ime=input.next();
		System.out.println("Unesite vaše prezime : ");
		
		String prezime=input.next();
		System.out.println("Unesite vaš username : ");
		
		String username=input.next();
		System.out.println("Unesite vaš password : ");
		
		String password=input.next();
		
		User user=new User(ime,prezime,username,password);
		UserDAOImplementation.users.add(user);
		UserDAOImplementation test=new UserDAOImplementation();
		
		try {
			test.addUser(ime,prezime,username,password);
		} catch (Exception e) {
			
		}
		
	}

	public static void login() 
	{
		System.out.println("Unesite vaš username : ");
		input.nextLine();
		String username=input.nextLine();
		System.out.println("Unesite vaš password : ");
		input.nextLine();
		String password=input.nextLine();
	}

}

