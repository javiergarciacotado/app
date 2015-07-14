package com.revlon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

@Configuration
@EnableWebMvc
@ComponentScan("com.revlon")
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String UPLOADTEMPDIR = "/tmp";
    private static final Integer MAXUPLOADSIZE = 2097152;

    @Bean
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("").addResourceLocations("").setCachePeriod(1);
    }

    @Bean
    public MultipartResolver multipartResolver() throws IOException {

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setUploadTempDir(new FileSystemResource(UPLOADTEMPDIR));
        multipartResolver.setMaxUploadSize(MAXUPLOADSIZE);
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;
    }


}
