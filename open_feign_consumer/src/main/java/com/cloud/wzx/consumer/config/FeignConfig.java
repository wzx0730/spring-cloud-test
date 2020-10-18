package com.cloud.wzx.alibaba_demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level getLeveL(){
        return Logger.Level.FULL;
    }
}
