package com.springboot.lings.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Lings 603656949@qq.com
 * @Date 2019/7/11 16:37
 * @Version 1.0
 * @Desc 测试实体
 **/
@Entity(name = "t_user")
@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 8655851615465363473L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",length = 255)
    private String username;

    private String password;

    @Transient
    private String email;

    public  User(){

    }

    public  User( String username, String password){
        this.username = username;
        this.password = password;
    }

    public  User(Long id, String username, String password){
        this.id = id;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
