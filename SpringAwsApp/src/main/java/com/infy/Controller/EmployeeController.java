package com.infy.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.EmployeeDTO.*;
import com.infy.Service.*;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
//	AwsService s = new AwsService();
	
	@GetMapping(value = "/")
	public String showData() {
		return "Welcome to Spring Boot Application";
	}
	
	@PostMapping(value="/emp")
	public String getDetails(@RequestBody List<EmployeeDTO> employeeDTOS) {
		String ad = employeeService.addFileIntoS3(employeeDTOS);
		System.out.println("Test");
		return ad;
		
	}
	
	
}
