package org.jsp;

public class Driver 
{
	public static void main(String[] args) 
	{
		System.out.println("Choose");
		System.out.println("1. HR");
		System.out.println("2. Student");
		int choice = CreateScanner.scanner.nextInt();
		
		switch (choice) {
		case 1: {
			hr();
			break;
		}
		case 2: {
			
			break;
		}
		default:
			throw new InvalidChoiceException("Wrong choice entered please try again");
		}
	}

	public static void hr() {
		System.out.println("choose");
		System.out.println("1. Login");
		System.out.println("2. signup");
		
		int choice =CreateScanner.scanner.nextInt();
		switch (choice) {
		case 1: {
			PerformCRUD.hr_login();
			break;
		}
		case 2: {
			PerformCRUD.signup_Hr();
			break;
		}
		default:
			throw new InvalidChoiceException("Wrong choice entered please try again");
		}
	}
}
