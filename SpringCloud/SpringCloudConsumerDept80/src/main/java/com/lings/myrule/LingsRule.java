package com.lings.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LingsRule {


    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
