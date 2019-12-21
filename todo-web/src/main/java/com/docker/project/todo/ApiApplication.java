package com.docker.project.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {
    public static void main( String[] args )
    {
        SpringApplication.run(ApiApplication.class, args);
    }
}
