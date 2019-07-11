package com.springboot.lings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lings 603656949@qq.com
 * @Date 2019/7/11 14:43
 * @Version 1.0
 * @Desc
 **/
@RestController
public class TestController {

    @GetMapping("/demo2")
    public String demo1() {
        return "Hello demo2";
    }
}
