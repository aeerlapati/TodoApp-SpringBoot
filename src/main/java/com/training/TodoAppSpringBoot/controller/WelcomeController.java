package com.training.TodoAppSpringBoot.controller;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public String addTask(@RequestHeader HttpHeaders headers,HttpServletRequest request) throws IOException {
		if(headers.get("accept-language").isEmpty()) {
			return "Header is missing";
		}
		Gson gson = new Gson(); 
		BufferedReader sign_in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine;
		String userName;
		String password;
		boolean validUser = false;
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
			
				tasks.setUserName("user");
			
		    Date date = new Date(System.currentTimeMillis());
		    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		    String s = formatter.format(date);
			
		    tasks.setCreateDate(s);
		    tasks.setUpdateDate(s);
			
		    tasksService.createTasks(tasks);
			
			logger.error("User " + tasks.getTaskName() + " is created Successfully for " + tasks.getUserName());
			inputLine = "User " + tasks.getTaskName() + " is created Successfully for " + tasks.getUserName();
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
	
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/getTasks", method = RequestMethod.GET)
	public String getTasks(@RequestHeader HttpHeaders headers,HttpServletRequest request) throws IOException {
		if(headers.get("accept-language").isEmpty()) {
			return "Header is missing";
		}
		Gson gson = new Gson(); 
		BufferedReader sign_in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		//JSONObject jsonObject = new JSONObject(content.toString());
		List<Tasks> allTasks = new ArrayList<Tasks>();
		String returnVal = null;
		try {
	        
			logger.error(headers.get("accept-language"));
			logger.error(request.getRequestURI());
			
			while ((inputLine = sign_in.readLine()) != null) {
				response.append(inputLine);
				//logger.error(inputLine);
			}
		    			
			allTasks = tasksService.getAllTasks();
			
			if (allTasks.size() > 0) {
				for(int i=0;i<allTasks.size();i++) {					
					if(returnVal == null) {
						returnVal =  allTasks.get(i).getTaskName();
					}else {
						returnVal = returnVal + "  " + allTasks.get(i).getTaskName();
					}
					
				}
				
			}else {
				returnVal = "No Tasks Found";
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			returnVal = "Something Went Wrong";

		}finally {
			sign_in.close();
		}
		
		return returnVal;

	}
	
}