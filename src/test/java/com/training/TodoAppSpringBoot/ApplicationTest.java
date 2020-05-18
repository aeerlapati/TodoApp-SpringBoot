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
import org.springframework.http.MediaType;
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
	
	@Test public void validateloginGetService() throws Exception {
		try {
			
			String sampleJson = gson.toJson(createloginMap());
		  	logger.error(sampleJson + "sampleJson");
		  	
			this.mockMvc.perform(get("/login").header("accept-language", "application/json").content(sampleJson)).andDo(print()).andExpect(status().
					isOk()).andExpect(MockMvcResultMatchers.content().
							string("Login Successfull")); 
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
		
	}
	
	@Test public void validateloginGetServiceheader() throws Exception {
		try {
			String sampleJson = gson.toJson(createloginMap());
		  	logger.error(sampleJson + "sampleJson");
			this.mockMvc.perform(get("/login").contentType(MediaType.APPLICATION_JSON).content(sampleJson)).andDo(print()).andExpect(status().
					isOk()).andExpect(MockMvcResultMatchers.content().
							string("Header is missing")); 
		
		}catch(Exception e) {
			logger.info(e.getMessage());

		}
		
		}
	
	
	  @Test
	    public void validatesignUpPostServiceheader() {
		  try {
				this.mockMvc.perform(post("/signup").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().
						isBadRequest());
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	  
	  
	  @Test
	    public void validatesignUpPostService() {
		  
		  
		  try {
			  	
			  	String sampleJson = gson.toJson(createSignUpMap());
			  	logger.error(sampleJson + "sampleJson");
				this.mockMvc.perform(post("/signup").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(sampleJson)).andDo(print()).andExpect(status().
						isOk());
			
			}catch(Exception e) {
				logger.error(e.getMessage());

			}
	    }
	  
	  
	  	@Test
	    public void validateAddTaskService() {
  
		  try {
			  	
			  	String sampleJson = gson.toJson(createAddTaskMap());
			  	logger.error(sampleJson + "sampleJson");
				this.mockMvc.perform(post("/addTask").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(sampleJson)).andDo(print()).andExpect(status().
						isOk());
			
			}catch(Exception e) {
				logger.error(e.getMessage());

			}
	    }
	  
	    @Test
	    public void validateAddTaskServiceContent() {
		  try {
				this.mockMvc.perform(post("/addTask").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().
						isBadRequest());
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	    
	    @Test
	    public void validateAddTaskServiceheader() {
		  try {
				this.mockMvc.perform(post("/addTask").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().
						isOk()).andExpect(MockMvcResultMatchers.content().
								string("Header is missing")); 
			
			}catch(Exception e) {
				logger.info(e.getMessage());

			}
	    }
	  
	  
	/* 
	 * @Test public void validateHelloGetService_Json() throws Exception {
	 * this.mockMvc.perform(get("/hello/123456").header("accept-language",
	 * "application/json")).andDo(print()).andExpect(status().isOk())
	 * .andExpect(jsonPath("$.value").value("Hello 123456")); }
	 * 
	 * 
	 * @Test public void validateHelloPutService_Json() throws Exception {
	 * this.mockMvc.perform(get("/hello/123456").header("accept-language",
	 * "application/json")).andDo(print()).andExpect(status().isOk())
	 * .andExpect(jsonPath("$.value").value("Hello 123456")); }
	 * 
	 * @Test public void validateCoalMineService() throws Exception {
	 * this.mockMvc.perform(get("/coal-mine")).andDo(print()).andExpect(status().
	 * isOk()).andExpect(MockMvcResultMatchers.content().string("Tweet")); }
	 */
	  
	  
	  private static Map<String,String> createloginMap(){
	      Map<String,String> loginMap = new HashMap<String,String>();
	      loginMap.put("username", "name1");
	      loginMap.put("password", "password1");
	      return loginMap;
	  }
	  
	  private static Map<String,String> createSignUpMap(){
		      Map<String,String> signupMap = new HashMap<String,String>();
		      signupMap.put("username", "name1");
		      signupMap.put("password", "password1");
		      signupMap.put("firstName", "name1");
		      signupMap.put("lastName", "name1");
		      signupMap.put("dob", "dob1");
		      return signupMap;

	  }
 
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
