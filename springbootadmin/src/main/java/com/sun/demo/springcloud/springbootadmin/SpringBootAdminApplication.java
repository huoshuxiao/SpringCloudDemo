package com.sun.demo.springcloud.springbootadmin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableAdminServer
@EnableTurbine
public class SpringBootAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminApplication.class, args);
	}
}
