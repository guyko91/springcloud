package com.guyko.callerservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@EnableEurekaClient
@SpringBootApplication
public class CallerserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallerserviceApplication.class, args);
    }

    @RestController
    @RequiredArgsConstructor
    public class TestController {

        @Autowired
        RestTemplate restTemplate;

        @GetMapping("hello")
        public String hello() {
            return restTemplate.getForObject("http://MICRO-SERVICE/hello", String.class);
        }

    }
}
