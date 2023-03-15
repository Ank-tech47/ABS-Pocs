package com.demo.employeeservice.controller;

import com.demo.employeeservice.model.Address;
import com.demo.employeeservice.model.Employee;
import com.demo.employeeservice.model.TechStack;
import com.demo.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable("id") String employeeId) {
        Mono<Employee> employeeMono=employeeService.reteriveEmployeeById(employeeId);
        return employeeMono;
    }
}
