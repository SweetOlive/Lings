package com.lings.springcloud.controller;

import com.lings.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RestController
public class DeptConsumerController {

    //理解，消费者，不应该有service层
    // RestTemplate....供我们直接调用，注册到Spring中

    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程Http的方法，简单的Restful服务模板

    //通过Ribbon去实现，我们这里的地址应该是一个变量，通过服务名来访问
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRING-CLOUD-PROVIDERDEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

}
