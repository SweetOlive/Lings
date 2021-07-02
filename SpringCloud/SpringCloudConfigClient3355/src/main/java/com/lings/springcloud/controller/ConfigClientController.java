package com.lings.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String application;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String config(){
        return "application:"+application +
         "eurekaServer:"+eurekaServer +
         "port:"+port ;
    }

}
