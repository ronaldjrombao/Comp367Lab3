package com.ronaldjro.dev.comp367lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Comp367Lab3Application {

    public static void main(String[] args) {
        SpringApplication.run(Comp367Lab3Application.class, args);
    }

    @GetMapping("/morning/{name}")
    public ResponseEntity<MessageResponse> morning(@PathVariable("name") String name) {
        MessageResponse messageResponse = new MessageResponse(String.format("Good Morning, %s", name));
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

}