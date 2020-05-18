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
	
	String userName;
	
	String loginPassword;

	String taskDescription;
	
	String taskName;
	
	String taskCompleteFlag;
	
	String createDate;
	
	String updateDate;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getTaskCompleteFlag() {
		return taskCompleteFlag;
	}
	public void setTaskCompleteFlag(String taskCompleteFlag) {
		this.taskCompleteFlag = taskCompleteFlag;
	}
	
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
	
}