package com.gutan.service.User;

import com.gutan.pojo.User;

import java.util.List;

public interface UserService {
    // 用户登录的接口
    public User Login(String userCode,String userPassword) throws Exception;

    //根据用户id修改密码
    // 修改成功与否就二个答案 ： 成功或者失败
    public boolean UpdatePwd(int id, String password ) ;


    //查询记录数（获取用户数量）
    public int getUserCount(String username,int userRole);

    //根据条件查询用户列表
    public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo,int pageSize);

    //新增用户用户名数据库是否已经存在
    public boolean userCodeExist(String userCode);

    //增加用户
    public boolean add(User user);

    // 删除用户
    public boolean deleteUserById(int id);

    //根据id查询用户
    public User getUserById(String id);

    //查询用户
    public boolean modify(User user);
}
