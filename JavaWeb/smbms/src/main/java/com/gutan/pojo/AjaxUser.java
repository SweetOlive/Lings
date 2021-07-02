package com.gutan.pojo;

import lombok.Data;

@Data
public class AjaxUser {
    private String name;
    private int age;
    private String sex;

    public AjaxUser(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
