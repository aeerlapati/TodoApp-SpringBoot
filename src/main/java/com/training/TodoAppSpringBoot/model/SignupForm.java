package com.training.TodoAppSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "USERS")
public class SignupForm {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;
	
    @Column(name = "firstname")
    String firstName;
	
    @Column(name = "lastname")
    String lastName;
	
    @Column(name = "dob")
    String dob;
	
    @Column(name = "username")
    String userName;
	
    @Column(name = "password")
    String password;
	
	public SignupForm() {
		
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
}