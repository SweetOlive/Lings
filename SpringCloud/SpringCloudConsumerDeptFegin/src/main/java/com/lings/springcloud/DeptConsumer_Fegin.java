package com.lings.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.lings.springcloud"})
@Component("com.lings.springcloud")
public class DeptConsumer_Fegin {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Fegin.class,args);
    }
}
