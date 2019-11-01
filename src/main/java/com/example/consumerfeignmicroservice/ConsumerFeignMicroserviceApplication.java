package com.example.consumerfeignmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.example.consumerfeignmicroservice.client")
public class ConsumerFeignMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignMicroserviceApplication.class, args);
    }

}
