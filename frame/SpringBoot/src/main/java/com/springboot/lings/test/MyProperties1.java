package com.springboot.lings.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/*
 * @Author Lings 603656949@qq.com
 * @Date  2019/7/11
 * @Desc  定义 MyProperties1.java 文件，
 * 用来映射我们在 application.properties 中的内容，
 * 这样一来我们就可以通过操作对象的方式来获得配置文件的内容了
 **/
@Component
@ConfigurationProperties(prefix = "my1")
public class MyProperties1 {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProperties1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}