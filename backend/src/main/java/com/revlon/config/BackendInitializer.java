package com.revlon.config;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class BackendInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);

        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(dispatcherContext));
        dispatcher.setInitParameter("", "");
        dispatcher.addMapping("/*");
        dispatcher.setLoadOnStartup(1);

        ServletRegistration.Dynamic jersey = servletContext.addServlet("jerseyServlet", new ServletContainer());
        jersey.setInitParameter("javax.ws.rs.Application", "");
        jersey.setInitParameter("jersey.config.server.wadl.disableWadl", "true");
        jersey.setInitParameter("jersey.config.server.languageMappings", "");
        jersey.addMapping("/api/*");
        jersey.setLoadOnStartup(2);

    }
}
