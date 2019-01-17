package com.example.keycloakdemo;

import com.example.keycloakdemo.model.Employee;
import com.example.keycloakdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Rohit Phatak
 */
@SpringBootApplication
public class KeycloakDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakDemoApplication.class, args);
	}

	@Bean
	public KeyCloackCommandLineRunner runner(){
		return new KeyCloackCommandLineRunner();
	}

}

class KeyCloackCommandLineRunner implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public void run(String... args) throws Exception {
		employeeService.addEmp(new Employee("1","Rohit"));
		employeeService.addEmp(new Employee("2","Rohan"));
	}
}


