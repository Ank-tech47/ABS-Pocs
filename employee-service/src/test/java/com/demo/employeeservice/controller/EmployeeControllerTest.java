package com.demo.employeeservice.controller;


import com.demo.employeeservice.model.Address;
import com.demo.employeeservice.model.Employee;
import com.demo.employeeservice.model.TechStack;
import com.demo.employeeservice.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
class EmployeeControllerTest {

    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    private WebClient.RequestHeadersSpec requestHeadersSpec;
    private WebClient.ResponseSpec responseSpec;
    private WebClient webClientMock =WebClient.create();
    private EmployeeService employeeService;


    @BeforeEach
    void mockWebClient() {
        requestHeadersUriSpec =mock(WebClient.RequestHeadersUriSpec.class);
        requestHeadersSpec =mock(WebClient.RequestHeadersSpec.class);
        responseSpec =mock(WebClient.ResponseSpec.class);
        webClientMock = mock(WebClient.class);
        employeeService=mock(EmployeeService.class);

    }
    @Test
    public void testWebclient() {
        String id="12345";
        Employee mockEmployee=new Employee("12345","Monty","Py Dev");

        when(employeeService.getEmployeeInstance()).thenReturn(mockEmployee);
        Address testAddress = new Address("12345", "karnal", "124007", "Punjab");
        when(webClientMock.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://localhost:8082/address/"+id)).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Address.class)).thenReturn(Mono.just(testAddress));

        TechStack testTechStack = new TechStack("12345", "Pyhton", "flask", 4);
        when(webClientMock.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://localhost:8083/techstack/"+id)).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(TechStack.class)).thenReturn(Mono.just(testTechStack));



        Mono<Employee> employeeMono=employeeService.reteriveEmployeeById("12345");

        StepVerifier.create(employeeMono)
                .expectNextMatches(employee -> employee.getName().equals("Monty"));

    }

}
