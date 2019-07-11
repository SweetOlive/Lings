package com.springboot.lings.controller;

import com.springboot.lings.test.MyProperties1;
import com.springboot.lings.test.MyProperties2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*
     * @Author Lings 603656949@qq.com
     * @Date  2019/7/11
     * @Param  []
     * @return java.lang.String
     * @Desc  初步测试用
     **/
    @GetMapping("/demo2")
    public String demo1() {
        return "Hello demo2";
    }


    /*
     * @Author Lings 603656949@qq.com
     * @Date  2019/7/11
     * @Param
     * @return
     * @Desc   用来注入 MyProperties1 测试我们编写的代码
     *         值得注意的是 Spring4.x 以后，推荐使用构造函数的形式注入属性
     **/
    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    private final MyProperties1 myProperties1;
    private final MyProperties2 myProperties2;
    @Autowired
    public TestController(MyProperties1 myProperties1,MyProperties2 myProperties2) {
        this.myProperties1 = myProperties1;
        this.myProperties2 = myProperties2;
    }
    @GetMapping("/demo3")
    public MyProperties1 myProperties1() {
        log.info("demo3=================================================================================================");
        log.info(myProperties1.toString());
        log.info("demo3=================================================================================================");
        return myProperties1;
    }

    @GetMapping("/demo4")
    public MyProperties2 myProperties2() {
        log.info("demo4=================================================================================================");
        log.info(myProperties2.toString());
        log.info("demo4=================================================================================================");
        return myProperties2;
    }
}
