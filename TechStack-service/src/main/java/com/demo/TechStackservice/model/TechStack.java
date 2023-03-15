package com.demo.TechStackservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechStack {

    private String employeeId;
    private String lang;

    private String framework;

    private int experience;


}
