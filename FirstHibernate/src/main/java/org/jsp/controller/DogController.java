package org.jsp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.dto.Dog;

public class DogController {
	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Second");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Dog dog = new Dog();	
		dog.setId(1);
		dog.setName("Tokki");
		dog.setBreed("Siberian Husky");
		dog.setAddress("chandanagar");
		dog.setColor("white and brown");
		
		entityTransaction.begin();
		entityManager.persist(dog);
		entityTransaction.commit();
	}
}
