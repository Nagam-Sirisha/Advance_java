package org.jsp.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Aadhar 
{
	@Id
	private long aadhar_id;
	private String date_of_birth;
	private String gender;
	@OneToOne(cascade = CascadeType.ALL)
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public long getAadhar_id() {
		return aadhar_id;
	}
	public void setAadhar_id(long aadhar_id) {
		this.aadhar_id = aadhar_id;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
