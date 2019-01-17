package com.example.keycloakdemo.controller;

import com.example.keycloakdemo.model.Employee;
import com.example.keycloakdemo.service.EmployeeService;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rohit Phatak
 */
@RestController
public class SampleController {
    private EmployeeService employeeService;

    public SampleController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping("/Test")
    public String testMapping(){
        RestTemplate restTemplate = new RestTemplate();

        // Set Headers
       /* MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type","application/x-www-form-urlencoded");
        headers.add("grant_type","password");*/

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        /*String body = "{'grant_type': 'password','client_id': 'login-app','userId': 'rohit','password': 'q1w2e3r4'}";*/
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        body.add("client_id","login-app");
        body.add("username","rohit");
        body.add("password","q1w2e3r4");
        body.add("grant_type","password");
        HttpEntity<String> httpEntity = new HttpEntity(body,headers);
        Map<String,String> map = new HashMap<>();

        // Call URL
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/auth/realms/demo/protocol/openid-connect/token",
                HttpMethod.POST,httpEntity,String.class);
        return response.getBody().toString();
    }

    @RequestMapping("/GetEmployees")
    public ResponseEntity<Collection<Employee>> getEmployees(){
        System.out.println("Into Get Employees");
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @PostMapping("/AddEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        System.out.println("Into Add Employee");
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }
}
