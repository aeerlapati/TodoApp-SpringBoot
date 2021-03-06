package com.training.TodoAppSpringBoot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()

		.withUser("user").password("{noop}password").roles("USER")

		.and()

		.withUser("admin").password("{noop}password").roles("ADMIN");
	}




	// Secure the endpoins with HTTP Basic authentication

	@Override

	protected void configure(HttpSecurity http) throws Exception {




		http

		//HTTP Basic authentication

		.httpBasic()

		.and()

		.authorizeRequests()

		 .antMatchers(HttpMethod.POST, "/addTask").hasRole("USER")

		 .antMatchers(HttpMethod.GET, "/getTasks").hasRole("USER")
		 
		 .antMatchers(HttpMethod.GET, "/getTaskDate/**").hasRole("USER")
		 
		 .antMatchers(HttpMethod.GET, "/updateTask/**").hasRole("USER")
		 
		 .antMatchers(HttpMethod.DELETE, "/deleteTask/**").hasRole("USER")

		 .antMatchers(HttpMethod.GET, "/getAllTasks").hasRole("USER")
		 
		 .antMatchers(HttpMethod.GET, "/getTaskUpdateDate/{var}").hasRole("USER")

		 
		.and()

		.csrf().disable()

		.formLogin().disable();
		
	    http.headers().frameOptions().disable();

	}
}