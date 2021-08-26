package com.guyko.micro2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class Micro2Application {

    public static void main(String[] args) {
        SpringApplication.run(Micro2Application.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World From micro2";
    }

    @PostMapping("hello-post")
    public ResponseEntity<Object> helloPost() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
    }

}
