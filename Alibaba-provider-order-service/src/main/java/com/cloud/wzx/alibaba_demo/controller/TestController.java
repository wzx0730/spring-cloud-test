package com.cloud.wzx.alibaba_demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;


    @Value("${service-url.provider-service-url}")
    private String serviceUrl;

    @RequestMapping("/get")
    public String get(){
        return restTemplate.getForObject(serviceUrl+"/hello/", String.class);
    }

}
