package com.training.TodoAppSpringBoot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.training.TodoAppSpringBoot.model.SignupForm;
import com.training.TodoAppSpringBoot.model.Tasks;
import com.training.TodoAppSpringBoot.service.TasksService;
import com.training.TodoAppSpringBoot.service.UsersService; 

@RestController
@Component
public class WelcomeController {
	
	private static final Logger logger = LogManager.getLogger(WelcomeController.class);
	
	SignupForm signupForm = new SignupForm();
	
	Tasks tasks = new Tasks();
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	TasksService tasksService;
	
	
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestHeader HttpHeaders headers,HttpServletRequest request) throws IOException{
		if(headers.get("accept-language").isEmpty()) {
			return "Header is missing";
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine;
		StringBuffer response = null;
		try {
			logger.error(headers.get("accept-language"));
			logger.error(request.getRequestURI());

			while ((inputLine = in.readLine()) != null) {
				logger.error(inputLine);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			in.close();
		}
		return "Login Successfull";
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@RequestHeader HttpHeaders headers,HttpServletRequest request) throws IOException {
		if(headers.get("accept-language").isEmpty()) {
			return "Header is missing";
		}
		Gson gson = new Gson(); 
		BufferedReader sign_in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		//JSONObject jsonObject = new JSONObject(content.toString());
		Map<String, String[]> requestMap = request.getParameterMap();
		
		try {
	        
			logger.error(headers.get("accept-language"));
			logger.error(request.getRequestURI());
			
			while ((inputLine = sign_in.readLine()) != null) {
				response.append(inputLine);
				//logger.error(inputLine);
			}
		    
			JSONObject json = new JSONObject(response.toString());
			
			//Map the values to the model
			if(json.getString("userName") != null  && !json.getString("userName").isEmpty()) {
				signupForm.setUserName(json.getString("userName"));
			}else {
				return "Username value is missing";
			}
			
			if(json.getString("password") != null  && !json.getString("password").isEmpty()) {
				signupForm.setPassword(json.getString("password"));
			}
			else {
				return "password value is missing";
			}
			
			if(json.getString("firstName") != null  && !json.getString("firstName").isEmpty()) {
				signupForm.setFirstName(json.getString("firstName"));
			}else {
				return "firstname value is missing";
			}
			
			if(json.getString("lastName") != null  && !json.getString("lastName").isEmpty()) {
				signupForm.setLastName(json.getString("lastName"));
			}else {
				return "lastname value is missing";
			}
			
			if(json.getString("dob") != null  && !json.getString("dob").isEmpty()) {
				signupForm.setDob(json.getString("dob"));
			}else {
				return "dob value is missing";
			}
			
			usersService.createUsers(signupForm);
			logger.error("User" + signupForm.getUserName().toString() + "is created Successfully");
			inputLine = "User" + signupForm.getUserName().toString() + "is created Successfully";
			if (signupForm.getId() > 0) {
				return inputLine;
			}else {
				return "Unsuccessfull";
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			return e.getMessage();

		}finally {
			sign_in.close();
		}

	}
	
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public String addTask(@RequestHeader HttpHeaders headers,HttpServletRequest request) throws IOException {
		if(headers.get("accept-language").isEmpty()) {
			return "Header is missing";
		}
		Gson gson = new Gson(); 
		BufferedReader sign_in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		//JSONObject jsonObject = new JSONObject(content.toString());
		Map<String, String[]> requestMap = request.getParameterMap();
		
		try {
	        
			logger.error(headers.get("accept-language"));
			logger.error(request.getRequestURI());
			
			while ((inputLine = sign_in.readLine()) != null) {
				response.append(inputLine);
				//logger.error(inputLine);
			}
		    
			JSONObject json = new JSONObject(response.toString());
			
			//Map the values to the model
			if(json.getString("userName") != null  && !json.getString("userName").isEmpty()) {
				tasks.setUserName(json.getString("userName"));
			}else {
				return "Username value is missing";
			}
			
			if(json.getString("password") != null  && !json.getString("password").isEmpty()) {
				tasks.setLoginPassword(json.getString("password"));
			}
			else {
				return "password value is missing";
			}
			
			if(json.getString("taskName") != null  && !json.getString("taskName").isEmpty()) {
				tasks.setTaskName(json.getString("taskName"));
			}
			else {
				return "taskname value is missing";
			}
			
			if(json.getString("taskDescription") != null  && !json.getString("taskDescription").isEmpty()) {
				tasks.setTaskDescription(json.getString("taskDescription"));
			}
			
			if(json.getString("taskCompleteFlag") != null  && !json.getString("taskCompleteFlag").isEmpty()) {
				tasks.setTaskCompleteFlag(json.getString("taskCompleteFlag"));
			}
			
			tasksService.createTasks(tasks);
			logger.error("User" + tasks.getTaskName() + "is created Successfully for" + tasks.getUserName());
			inputLine = "User" + tasks.getTaskName() + "is created Successfully for" + tasks.getUserName();
			if (tasks.getId() > 0) {
				return inputLine;
			}else {
				return "Unsuccessfull";
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			return e.getMessage();

		}finally {
			sign_in.close();
		}

	}
	
}