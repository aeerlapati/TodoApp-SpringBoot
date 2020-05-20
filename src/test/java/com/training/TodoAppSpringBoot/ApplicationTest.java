package com.training.TodoAppSpringBoot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;



@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTest {
	
	private static final Logger logger = LogManager.getLogger(ApplicationTest.class);
	  Gson gson = new Gson();      
      
	@Autowired
	private MockMvc	mockMvc;
	  
	  	@Test
	    public void validateAddTaskService() {
  
		  try {
			  HttpHeaders httpHeaders = new HttpHeaders();
			  httpHeaders.setBasicAuth("user", "password");
			  	String sampleJson = gson.toJson(createAddTaskMap());
			  	logger.error(sampleJson + "sampleJson");
				this.mockMvc.perform(post("/addTask").accept(MediaType.APPLICATION_JSON).headers(httpHeaders).contentType(MediaType.APPLICATION_JSON).content(sampleJson)).andDo(print()).andExpect(status().
						isOk());
			
			}catch(Exception e) {
				logger.error(e.getMessage());

			}
	    }
	  
	    @Test
	    public void validateAddTaskServiceContent() {
		  try {
			  
			  HttpHeaders httpHeaders = new HttpHeaders();
			  httpHeaders.setBasicAuth("user", "password");
				this.mockMvc.perform(post("/addTask").contentType(MediaType.APPLICATION_JSON).headers(httpHeaders).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().
						isBadRequest());
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    @Test
	    public void validateAddTaskServiceheader() {
		  try {
			  
			  HttpHeaders httpHeaders = new HttpHeaders();
			  httpHeaders.setBasicAuth("user", "password");
				this.mockMvc.perform(post("/addTask").contentType(MediaType.APPLICATION_JSON).headers(httpHeaders)).andDo(print()).andExpect(status().
						isOk()).andExpect(MockMvcResultMatchers.content().
								string("Header is missing")); 
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    
	    
	    @Test
	    public void validategetTasksServiceNoheader() {
		  try {
			  
				this.mockMvc.perform(get("/getTasks").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isUnauthorized()); 
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    @Test
	    public void validategetTasksServiceSuccess() {
		  try {
			  
			  	HttpHeaders httpHeaders = new HttpHeaders();
			  	httpHeaders.setBasicAuth("user", "password");
				this.mockMvc.perform(get("/getTasks").contentType(MediaType.APPLICATION_JSON).headers(httpHeaders)).andDo(print()).andExpect(status().isOk());  
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    @Test
	    public void validategetTaskDateServiceheader() {
		  try {
			  
			  HttpHeaders httpHeaders = new HttpHeaders();
			  httpHeaders.setBasicAuth("user", "password");
				this.mockMvc.perform(get("/getTaskDate/**").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isUnauthorized()); 
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    @Test
	    public void validategetTaskDateServiceSuccess() {
		  try {
			  
			  HttpHeaders httpHeaders = new HttpHeaders();
			  httpHeaders.setBasicAuth("user", "password");
				this.mockMvc.perform(get("/getTaskDate/123").contentType(MediaType.APPLICATION_JSON).headers(httpHeaders)).andDo(print()).andExpect(status().isOk());
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    
	    @Test
	    public void validateupdateTaskServiceheader() {
		  try {
			  
			  HttpHeaders httpHeaders = new HttpHeaders();
			  httpHeaders.setBasicAuth("user", "password");
				this.mockMvc.perform(post("/updateTask").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isUnauthorized()); 
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    
	    
	    @Test
	    public void validatedeleteTaskServiceSuccess() {
		  try {
			  
			  HttpHeaders httpHeaders = new HttpHeaders();
			  httpHeaders.setBasicAuth("user", "password");
				this.mockMvc.perform(get("/deleteTask/123").contentType(MediaType.APPLICATION_JSON).headers(httpHeaders)).andDo(print()).andExpect(status().isOk());
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    
	    @Test
	    public void validatedeleteTaskServiceHeader() {
		  try {
			  
			  HttpHeaders httpHeaders = new HttpHeaders();
			  httpHeaders.setBasicAuth("user", "password");
				this.mockMvc.perform(post("/deleteTask/123").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isUnauthorized()); 
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    
	/*
	 * @Test public void validateupdateTaskService() { try {
	 * 
	 * HttpHeaders httpHeaders = new HttpHeaders(); httpHeaders.setBasicAuth("user",
	 * "password");
	 * this.mockMvc.perform(post("/updateTask/123").contentType(MediaType.
	 * APPLICATION_JSON).headers(httpHeaders)).andDo(print()).andExpect(status().
	 * isOk());
	 * 
	 * }catch(Exception e) { logger.info(e.getMessage()); } }
	 */
	    
	    
	  private static Map<String,String> createAddTaskMap(){
	      Map<String,String> taskMap = new HashMap<String,String>();
	      taskMap.put("username", "name1");
	      taskMap.put("password", "password1");
	      taskMap.put("firstName", "name1");
	      taskMap.put("lastName", "name1");
	      taskMap.put("dob", "dob1");
	      return taskMap;

	  }

}
