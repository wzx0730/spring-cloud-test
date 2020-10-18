package com.cloud.wzx.alibaba_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerFApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFApp.class, args);
    }
}
