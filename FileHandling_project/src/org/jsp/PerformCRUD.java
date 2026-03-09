package org.jsp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PerformCRUD 
{
	public static void signup_Hr()
	{
		System.out.println("Enter name");
		String name = CreateScanner.scanner.next();
		
		System.out.println("Enter email");
		String email=CreateScanner.scanner.next();
		
		System.out.println("Enter password");
		String password=CreateScanner.scanner.next();
		
		System.out.println("Enter number");
		long number = CreateScanner.scanner.nextLong();
		
		Hr hr= new Hr();
		hr.setName(name);
		hr.setEmail(email);
		hr.setPassword(password);
		hr.setNumber(number);
		
		File file = new File(email+".text");
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(hr);
			objectOutputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Signup successful");
		System.out.println("Please login");
		for(int i=1;i<=5;i++)
		{
			System.out.print('.');
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		hr_login();
 	}
	
	public static void hr_login()
	{
		System.out.println("Enter email");
		String email=CreateScanner.scanner.next();
		
		System.out.println("Enter password");
		String password=CreateScanner.scanner.next();
		
		File file = new File(email+".text");
		if(!file.exists())
			throw new UserNotFoundException("user not found with email"+email);
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Hr hr = (Hr)inputStream.readObject();
			if(hr.getPassword().equals(password))
			{
				System.out.println("Login successful");
			}
			else
			{
				System.out.println("Invalid password please try again");
				hr_login();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
