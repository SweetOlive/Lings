package com.springboot.lings.entity;

/**
 * @Author Lings 603656949@qq.com
 * @Date 2019/7/11 16:37
 * @Version 1.0
 * @Desc 测试实体
 **/
public class User {
    private Long id;

    private String username;

    private String password;

    public  User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
