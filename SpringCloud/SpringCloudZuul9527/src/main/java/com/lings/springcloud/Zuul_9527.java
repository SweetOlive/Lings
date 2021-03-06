package com.lings.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启代理
public class Zuul_9527 {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527.class,args);
    }
}
