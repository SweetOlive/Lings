package com.gutan.service.role;

import com.gutan.dao.role.RoleDao;
import com.gutan.dao.role.RoleDaoImpl;
import com.gutan.pojo.Role;
import com.gutan.pojo.User;
import com.gutan.service.User.UserService;
import com.gutan.service.User.UserServiceImpl;
import com.gutan.util.jdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    //引入Dao
    private RoleDao roleDao;
    public RoleServiceImpl(){
        roleDao = new RoleDaoImpl();
    }
    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = null;
        Connection  con = null;
        try {
            con = jdbcUtil.getConnection();
            roleList = roleDao.getRoleList(con);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.release(con,null,null);
        }
        return roleList;
    }
    // 测试获取角色列表
    @Test
    public void test1(){
        RoleService roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        for (Role role : roleList) {
            System.out.println(role);
        }
    }
    //测试获取指定的用户列表
    @Test
    public void test2(){
        UserService userService = new UserServiceImpl();
        List<User> userList = userService.getUserList(null, 3, 0, 5);
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
