package com.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {
    /*
     * @Author Lings 603656949@qq.com
     * @Date 14:56 2019/7/9
     * @Param []
     * @return java.lang.String
     * @Desc
     **/
    @RequestMapping("/hello")
    public String index() {
        return "spring-cloud-eureka-client!";
    }
}
