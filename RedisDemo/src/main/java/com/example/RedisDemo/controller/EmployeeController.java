package com.example.RedisDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedisDemo.entity.Employee;
import com.example.RedisDemo.reponsitory.EmployeeRepository;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@GetMapping("/list")
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	@CachePut(value = "employees", key = "#employee")
	@PostMapping("/create")
	public Employee save(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

}
