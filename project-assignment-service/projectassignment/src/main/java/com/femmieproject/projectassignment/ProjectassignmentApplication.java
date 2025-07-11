package com.femmieproject.projectassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjectassignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectassignmentApplication.class, args);
	}

}
