package com.lings.Swagger.controller;

import com.lings.Swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="HelloController",tags={"Hello操作接口"})
@RestController
public class HelloController {
    // @ApiOperation注解  放在方法上面
    @ApiOperation("hello world！")
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    // 只要我们的接口中，返回值存在实体类，他就会被扫描
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }
}
