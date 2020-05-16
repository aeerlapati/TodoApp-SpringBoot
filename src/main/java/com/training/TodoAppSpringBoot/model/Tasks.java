package com.training.TodoAppSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

 

@Entity
public class Tasks {
	
	
	@Column(name = "id")
    @Id
    @GeneratedValue
	public String Id;
	
	public String loginId;
	
	public String taskDescription;
	
	public String taskName;
	
	public String firstName;
	
	public String lastName;
	
	public String dob;
	
	public Boolean taskCompleteFlag;
	
	public String taskCreationDate;
	
	public String taskUpdateDate;
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public String getTaskDescription() {
		return taskDescription;
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
	
	public Boolean getTaskCompleteFlag() {
		return taskCompleteFlag;
	}
	
	public void setTaskCompleteFlag(Boolean taskCompleteFlag) {
		this.taskCompleteFlag = taskCompleteFlag;
	}
	
	public String getTaskCreationDate() {
		return taskCreationDate;
	}
	
	public void setTaskCreationDate(String taskCreationDate) {
		this.taskCreationDate = taskCreationDate;
	}
	
	
}