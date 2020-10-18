package com.cloud.wzx.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApp7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApp7002.class,args);
    }
}
