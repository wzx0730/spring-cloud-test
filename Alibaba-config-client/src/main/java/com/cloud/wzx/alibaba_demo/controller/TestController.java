package com.cloud.wzx.alibaba_demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/config")
public class TestController {

    @Value("${spring.rankey}")
    private String configInfo;

    @RequestMapping("/get")
    public String get() {
        return configInfo;
    }
}
