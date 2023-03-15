package com.demo.TechStackservice.controller;

import com.demo.TechStackservice.model.TechStack;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

public class TechStackControllerTest {
    @Mock
    TechStackController techStackController = new TechStackController();
    private final WebTestClient client=WebTestClient.bindToController(techStackController).build();
    @Test
    public void getTeckstackByIdTest(){
        TechStack techStack = new TechStack("41430","Java","SpringBoot",2);
        client.get()
                .uri("/techstack/{id}","41430")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(TechStack.class)
                .isEqualTo(techStack);
    }
    @Test
    public void getTechstackByIdNotFoundTest(){
        String id = "invalidId";

        client.get().uri("/techstack/{id}",id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isEqualTo(HttpStatusCode.valueOf(500));

    }
}
