package com.demo.addressservice.Controller;

import com.demo.addressservice.Exception.DataNotFoundException;
import com.demo.addressservice.model.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController

public class AddressController {

    //http://localhost:8082/address/41430
    @GetMapping("/address/{id}")
    public Mono<Address> getAddressById(@PathVariable("id") String employeeId) {
        if (employeeId.equals("41430")) {
            return Mono.just(new Address("41430", "Narnaul", "123001", "Haryana"));
        } else {
            throw new DataNotFoundException("Address not found with this EmployeeId:" + employeeId);
        }

    }
}

