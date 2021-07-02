package com.lings.springcloud.controller;

import com.lings.springcloud.pojo.Dept;
import com.lings.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供RestFul服务
@Controller
@RestController
public class DeptControler {

    @Autowired
    private DeptService service;

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = service.queryById(id);
        if (dept == null){
            throw new RuntimeException("不存在这个id下的信息！");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("???").setDb_source("db_???");
    }

}
