package org.spring.app.messenger.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/*
 * This class is replacement of web.xml 
 * configure the ServletContext programmatically
 *
 */

public class MessengerAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();	
		appContext.register(MessengerAppConfiguration.class);
		appContext.setServletContext(servletContext);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet(
                "dispatcher", new DispatcherServlet(appContext));
 
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
		
	}

}
