package com.demo.employeeservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private  String employeeId;

    private String city;

    private String pincode;

    private String state;

}
