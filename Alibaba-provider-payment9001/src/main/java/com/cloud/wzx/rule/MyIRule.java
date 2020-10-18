package com.cloud.wzx.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class MyIRule {

    @Bean
    public IRule MyIRule(){
        return new RandomRule();
    }
}
