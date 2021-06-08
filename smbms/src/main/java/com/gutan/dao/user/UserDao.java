package com.gutan.dao.user;
import com.gutan.pojo.User;
import java.sql.Connection;
import java.util.List;

public interface UserDao {
    // 通过UserCode得到user
    public User getLoginUser(Connection con,String UserCode) throws Exception;

    //修改密码
    public int UpdatePwd(Connection con,int id,String password) throws Exception;

    // 查询用户总数
    public int getUserCount(Connection con,String username,int userRole) throws Exception;

    //获取用户列表
    public List<User> getUserList(Connection con,String username,int userRole,int currentPageNo,int pageSize) throws Exception;

    // 增加用户
    public int add(Connection conn,User user) throws Exception;

    //删除用户
    public int deleteUserById(Connection conn,int id) throws Exception;

    // 根据Id获得用户的信息
    public User getUserById(Connection conn,String id) throws Exception;

    // 更新用户
    public int modify(Connection conn,User user) throws Exception;

}
