package org.spring.app.messenger.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 * This class is replacement of spring-servlet.xml(application context) 
 * and let to configure it programmatically
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.spring.app.messenger.configuration.controller")
public class MessengerAppConfiguration extends WebMvcConfigurerAdapter{

	

	/*
	 * Settings for content negotiation for the application, default is set to
	 * JSON
	 * 
	 */
	@Override
	  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer.favorPathExtension(true).
	            favorParameter(false).
	            parameterName("mediaType").
	            ignoreAcceptHeader(true).
	            useJaf(false).
	            defaultContentType(MediaType.APPLICATION_JSON).
	            mediaType("xml", MediaType.APPLICATION_XML).
	            mediaType("json", MediaType.APPLICATION_JSON);
	  }
	
}
