package com.demo.TechStackservice.controller;


import com.demo.TechStackservice.exception.DataNotFoundException;
import com.demo.TechStackservice.model.TechStack;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TechStackController {

    @GetMapping("/techstack/{id}")
    public Mono<TechStack> getTechstackById(@PathVariable("id") String   employeeId){

        if(employeeId.equals("41430")){
            return Mono.just(new TechStack("41430","Java","SpringBoot",2));
        }
        else {
            throw new DataNotFoundException("TechStack not found with this EmployeeId:"+employeeId);
        }
    }
}
