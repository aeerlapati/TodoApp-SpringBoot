package com.training.TodoAppSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "TASKS")
public class Tasks {
	
	
	@Column(name = "id")
    @Id
    @GeneratedValue
	Integer Id;
	

	String loginPassword;

	String taskDescription;
	
	String taskName;
	
	String firstName;
	
	String lastName;
	
	String dob;
	
	String taskCompleteFlag;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	
	public String getTaskCompleteFlag() {
		return taskCompleteFlag;
	}
	public void setTaskCompleteFlag(String taskCompleteFlag) {
		this.taskCompleteFlag = taskCompleteFlag;
	}

	public String taskCreationDate;
	
	public String taskUpdateDate;
	
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
	
	public String getTaskCreationDate() {
		return taskCreationDate;
	}
	
	public void setTaskCreationDate(String taskCreationDate) {
		this.taskCreationDate = taskCreationDate;
	}
	
	
}