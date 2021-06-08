package com.gutan.service.User;
import com.gutan.dao.user.UserDao;
import com.gutan.dao.user.UserDaoImpl;
import com.gutan.pojo.User;
import com.gutan.util.jdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userdao;
    public UserServiceImpl() {
        userdao = new UserDaoImpl();
    }
    // 上面二行或者也可以这样写：private UserDao userDao = new UserDaoImpl();
    // 接口 var = new 接口实现类；

    // 用户登录
    public User Login( String userCode, String userPassword) throws Exception {
        Connection con = jdbcUtil.getConnection();
        //通过service层调dao层
        User user = userdao.getLoginUser(con, userCode);
        jdbcUtil.release(con,null,null);
        // 字符串比较不能用'==',equal才能解决
        //比较前端传来的密码和从数据库里查到的密码进行比较
        if(!user.getUserPassword().equals(userPassword)){
            return null;
        }
        return user;
    }

    //修改密码根据用户id
    public boolean UpdatePwd(int id, String password) {
        boolean flag = false;
        Connection con = jdbcUtil.getConnection();

        int i = 0;
        try {
            i = userdao.UpdatePwd(con, id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 修改成功
        if (i>0){
            flag = true;
        }
        jdbcUtil.release(con,null,null);
        return flag;
    }

    // 查询用户的记录数
    public int getUserCount(String username, int userRole) {
        int count = 0;
        Connection con = jdbcUtil.getConnection();
        try {
            count = userdao.getUserCount(con, username, userRole);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.release(con,null,null);
        }
        return count;
    }


    //根据条件查询用户列表
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        List<User> userList = new ArrayList<User>();
        Connection con = jdbcUtil.getConnection();
        try {
            userList= userdao.getUserList(con, queryUserName, queryUserRole, currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  userList;
    }

    //新增用户名是否存在
    public boolean userCodeExist(String userCode) {
        User user = null;
        boolean flag = false;
        Connection con = null;
        try {
            con  = jdbcUtil.getConnection();
            user = userdao.getLoginUser(con,userCode);
            if (null !=user){
               flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.release(con,null,null);
        }
        return flag;
    }
    @Test
    public void etst(){
        Connection con = jdbcUtil.getConnection();
        User user = null;
        try {
            user = userdao.getLoginUser(con, "admin");
        } catch (Exception e) {
            System.out.println("wang");
        }
        if (user!=null && null!=user)
        System.out.println(user);
        else
            System.out.println("wrong");
    }

    // 新增用户
    @Override
    public boolean add(User user) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = jdbcUtil.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = userdao.add(connection,user);
            connection.commit();
            if(updateRows > 0){
                flag = true;
                System.out.println("add success!");
            }else{
                System.out.println("add failed!");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            //在service层进行connection连接的关闭
            jdbcUtil.release(connection, null, null);
        }
        return flag;
    }
    @Test
    public void test(){
        UserService userService = new UserServiceImpl();
        boolean amdin = userService.userCodeExist("admin1");
        System.out.println(amdin);
    }

    // 删除用户

    @Override
    public boolean deleteUserById(int id) {
        boolean flag = false;
        Connection conn = null;
        try{
            conn = jdbcUtil.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            int updateRow = userdao.deleteUserById(conn, id);
            conn.commit();// 提交事务
            if (updateRow>0)
                flag = true;
        }catch (Exception e){
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                conn.rollback(); // 回滚
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            jdbcUtil.release(conn,null,null);
        }
        return flag;
    }

    @Override
    public User getUserById(String id) {
        User user = null;
        Connection conn = null;
        try{
            conn = jdbcUtil.getConnection();
            user = userdao.getUserById(conn, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.release(conn,null,null);
        }
        return user;
    }

    @Override
    public boolean modify(User user) {
        boolean flag = false;
        Connection conn = jdbcUtil.getConnection();
        try {
            int updateRows = userdao.modify(conn, user);
            if (updateRows >0){
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.release(conn,null,null);
        }
        return flag;
    }
}
