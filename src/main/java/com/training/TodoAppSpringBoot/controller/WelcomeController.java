package com.training.TodoAppSpringBoot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.training.TodoAppSpringBoot.model.SignupForm;
import com.training.TodoAppSpringBoot.model.Tasks;
import com.training.TodoAppSpringBoot.repository.TasksRepository;
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
		BufferedReader sign_in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		//JSONObject jsonObject = new JSONObject(content.toString());

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

	@RequestMapping(value = "/getTaskDate/{var}", method = RequestMethod.GET)
	public String getTaskUpdateDate(@RequestHeader HttpHeaders headers,HttpServletRequest request,@PathVariable(value = "var") Integer var) throws IOException {
		if(headers.get("accept-language").isEmpty()) {
			return "Header is missing";
		}
		Tasks tasks = new Tasks();
		String returnVal = null;
		try {

			tasks = tasksService.getTasksById(var);
			if(!tasks.getUpdateDate().isEmpty() && tasks.getUpdateDate() != null) {
				returnVal =  tasks.getCreateDate();
			}else {
				returnVal =  "No Tasks Found, Please enter a valid Id to locate your task";
			}

		}catch(Exception e) {
			logger.error(e.getMessage());
			returnVal = "Something Went Wrong";

		}finally {

		}

		return returnVal;

	}


	@SuppressWarnings("null")
	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public String updateTask(@RequestHeader HttpHeaders headers,HttpServletRequest request) throws IOException, SQLException {
		if(headers.get("accept-language").isEmpty()) {
			return "Header is missing";
		}
		Tasks tasks = new Tasks();
		Tasks tasks1 = new Tasks();
		BufferedReader sign_in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		String returnVal = null;
		try {

			logger.error(headers.get("accept-language"));
			logger.error(request.getRequestURI());

			while ((inputLine = sign_in.readLine()) != null) {
				response.append(inputLine);
			}

			JSONObject json = new JSONObject(response.toString());

			if(json.has("id")) {
				logger.error(json.getString("id"));
				if(json.getString("id") != null  && !json.getString("id").isEmpty()) {
					tasks.setId(Integer.valueOf(json.getString("id")));
				}else {
					return "Please enter the Id number for the Task";
				}
			}else {
				return "Please enter the Id number for the Task";
			}

			if(json.has("taskName")) {
				logger.error(json.getString("taskName"));
				if(json.getString("taskName") != null  && !json.getString("taskName").isEmpty()) {
					tasks.setTaskName(json.getString("taskName"));
				}
			}


			if(json.has("taskDescription")) {
				if(json.getString("taskDescription") != null  && !json.getString("taskDescription").isEmpty()) {
					tasks.setTaskDescription(json.getString("taskDescription"));
				}
			}

			if(json.has("taskCompleteFlag")) {
				if(json.getString("taskCompleteFlag") != null  && !json.getString("taskCompleteFlag").isEmpty()) {
					tasks.setTaskCompleteFlag(json.getString("taskCompleteFlag"));
				}
			}

			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			String s = formatter.format(date);

			tasks.setUpdateDate(s);

			tasks1 = tasksService.createTasks(tasks);

			returnVal =  "The record for " + tasks1.getTaskName() + " has been successfully updated";

		}catch(Exception e) {
			logger.error(e.getMessage());
			logger.error(e.getStackTrace());

			for (StackTraceElement ste : e.getStackTrace()) {
				logger.error(ste);
			}

			returnVal = "Something Went Wrong";

		}finally {

		}

		return returnVal;

	}


}