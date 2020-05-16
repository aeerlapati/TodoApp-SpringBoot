package com.training.TodoAppSpringBoot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import 

@RestController
@Component
public class WelcomeController {
	
	@RequestMapping(value = "/hello/{var}", method = RequestMethod.PUT)
	public String helloput(@RequestBody Names names,@RequestHeader HttpHeaders headers,HttpServletRequest request) {
	
}