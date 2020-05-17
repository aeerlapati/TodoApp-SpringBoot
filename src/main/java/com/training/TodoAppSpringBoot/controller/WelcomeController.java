package com.training.TodoAppSpringBoot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController; 

@RestController
@Component
public class WelcomeController {
	
	private static final Logger logger = LogManager.getLogger(WelcomeController.class);
	
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
		BufferedReader sign_in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine;
		StringBuffer response = null;
		try {
			logger.error(headers.get("accept-language"));
			logger.error(request.getRequestURI());

			while ((inputLine = sign_in.readLine()) != null) {
				logger.error(inputLine);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			logger.error("6387367");
			sign_in.close();
		}

		return "123456";
	}
	
}