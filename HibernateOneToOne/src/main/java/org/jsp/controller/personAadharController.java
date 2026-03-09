package org.jsp.controller;

import org.jsp.dao.PersonAadharDao;
import org.jsp.dto.Aadhar;
import org.jsp.dto.Person;

public class personAadharController 
{
	public static void main(String[] args) 
	{
		Person person = new Person();
		person.setId(101);
		person.setName("ram");
		person.setAddress("Hyderabad");
		person.setEmail("ram@gmail.com");
		person.setPassword("ram123");
		
		Aadhar aadhar = new Aadhar();
		aadhar.setAadhar_id(9876345643217865L);
		aadhar.setDate_of_birth("12-07-2004");
		aadhar.setGender("Male");
		
		PersonAadharDao aadharDao = new PersonAadharDao();
		aadharDao.savePerson(person);
		person.setAadhar(aadhar);
	}
}
