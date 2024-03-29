package com.lings.Swagger.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("用户名")
    public String userName;

    @ApiModelProperty("密码")
    public String password;
}
