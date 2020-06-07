package com.training.TodoAppSpringBoot;
import java.sql.SQLException;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.h2.*;


@Configuration
@PropertySource("classpath:messages.properties")
public class AppConfiguration {
    
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        return messageSource;
    }
	
	
	 @Bean
	    ServletRegistrationBean h2servletRegistration(){
	        ServletRegistrationBean registration = new ServletRegistrationBean( new org.h2.server.web.WebServlet());
	        registration.addUrlMappings("/h2-console/*");
	        registration.addInitParameter("webAllowOthers", "true");
	        registration.addInitParameter("webPort", "7777");// <-- the port your wish goes here

	        return registration;
	    }
	
}
