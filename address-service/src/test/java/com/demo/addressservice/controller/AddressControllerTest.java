package com.demo.addressservice.controller;


import com.demo.addressservice.Controller.AddressController;
import com.demo.addressservice.model.Address;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

public class AddressControllerTest {

    @Mock
    AddressController addressController = new AddressController();
    private final WebTestClient client=WebTestClient.bindToController(addressController).build();
    @Test
    public void getTeckstackByIdTest(){
        Address tesAddress = new Address("41430", "Narnaul", "123001", "Haryana");
        client.get()
                .uri("/techstack/{id}","41430")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Address.class)
                .isEqualTo(tesAddress);
    }
    @Test
    public void getTechstackByIdNotFoundTest(){
        String id = "invalidId";

        client.get().uri("/address/{id}",id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isEqualTo(HttpStatusCode.valueOf(500));
    }


}
