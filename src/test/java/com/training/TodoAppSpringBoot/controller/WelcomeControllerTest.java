package com.training.TodoAppSpringBoot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@WebMvcTest(WelcomeController.class)
@AutoConfigureMockMvc
public class WelcomeControllerTest{
	
	private static final Logger logger = LogManager.getLogger(WelcomeControllerTest.class);

	@Autowired
	private MockMvc	mockMvc;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/coal-mine")).andDo(print()).andExpect(status().isOk());
	}
//	@Test
//	public void testCoalMine() {
//		try {
//			logger.error("1234");
//
//			mockMvc.perform(get("/coal-mine")).andDo(print()).andExpect(status().isOk()).andExpect((ResultMatcher) content().string("Tweet"));
//		}catch(Exception e){
//			logger.error(e.getMessage());
//		}
//	}
	
}