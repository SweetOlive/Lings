package com.lings.springcloud.controller;

import com.lings.springcloud.pojo.Dept;
import com.lings.springcloud.service.DeptService;
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

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return service.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> getAll(){
        return service.queryAll();
    }

    //获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;
    //注册进来的微服务~获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>sercices"+services);

        //得到一个具体的微服务信息,通过具体的微服务id，application_name
        List<ServiceInstance> instances = client.getInstances("SPRING-CLOUD-PROVIDERDEPT-8001");
        for (ServiceInstance instance : instances) {
            System.out.println(
            instance.getHost()+"\t"+
            instance.getPort()+"\t"+
            instance.getUri()+"\t"+
            instance.getServiceId()
            );
        }
        return this.client;
    }
}
