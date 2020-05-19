package com.training.TodoAppSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "TASKS")
public class Tasks {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;
	
    @Column(name = "username")
    String userName;

    @Column(name = "taskdescription")
	String taskDescription;
	
    @Column(name = "taskname")
	String taskName;
	
    @Column(name = "taskcompleteflag")
	String taskCompleteFlag;
	
    @Column(name = "createdate")
	String createDate;
	
    @Column(name = "updatedate")
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