package com.demo.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String employeeId;

    private String name;

    private String role;

    private Address address;

    private TechStack techStack;

    public Employee(String employeeId, String name, String role, Address address) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.address = address;
    }

    public Employee(String employeeId, String name, String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
    }
}
