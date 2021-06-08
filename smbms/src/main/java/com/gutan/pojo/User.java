package com.gutan.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;    //id
    private String userCode;   //用户编码
    private String userName;   //用户名
    private String userPassword;   //用户密码
    private int gender;  //性别
    private Date birthday;   //生日
    private String phone;   //电话
    private String address;  //地址
    private int userRole;   //用户角色
    private Integer createdBy;      // 创建者
    private Date creationDate;    //创建时间
    private Integer modifyBy;    // 更新者
    private Date modifyDate;    // 更新时间

    private int age;
    private String userRoleName;

    public Integer getAge() {
        Date date = new Date();
        Integer age = date.getYear()-birthday.getYear();
        return age;
    }



}
