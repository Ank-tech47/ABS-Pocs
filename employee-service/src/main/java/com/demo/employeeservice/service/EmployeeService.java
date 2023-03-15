package com.demo.employeeservice.service;


import com.demo.employeeservice.model.Address;
import com.demo.employeeservice.model.Employee;
import com.demo.employeeservice.model.TechStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {


    @Autowired
    private WebClient webClient;

    public EmployeeService(WebClient webClient) {
        this.webClient= WebClient.create();
    }

    public Employee getEmployeeInstance(){
        return new Employee("41430","Ankit","Developer");
    }

    public Mono<Employee> reteriveEmployeeById(String employeeId){
        Employee employee=getEmployeeInstance();

        Mono<Employee> employeeMono= webClient.get()
                .uri("http://localhost:8082/address/41430")
                .retrieve()
                .bodyToMono(Address.class)
                .flatMap(address -> {
                    employee.setAddress(address);
                    return Mono.just(employee);
                });
        return   webClient.get().uri("http://localhost:8083/techstack/41430")
                .retrieve()
                .bodyToMono(TechStack.class)
                .flatMap(techStack -> {
                    return employeeMono.map(employee1 -> {employee1.setTechStack(techStack);
                        return employee1;});
                });
    }
}
