package com.lings.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//Dept 实体类 orm 类表关系映射 mysql dept
@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {

    private Long deptno;//主键
    private String dname;

    //这个数据存在那个数据库，微服务，一个服务可以对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

    /*
    链式写法：
       Dept dept = new Dept();
       dept.setDeptno(11);
       dept.setDname("名字");

       dept.setDeptno(11).setDname("名字").setDb_source("db01");

     */

}
