package org.jsp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.dto.Student;

public class StudentController {
	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("First");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student = new Student();
		student.setId(101);
		student.setName("sirisha");
		student.setEmail("sirisha@gmail.com");
		student.setPassword("sirisha123");
		student.setNumber(9876543120l);
		student.setAddress("Hyderabad");
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
}
