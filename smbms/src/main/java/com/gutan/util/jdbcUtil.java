package com.gutan.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

// 方法和类使用static就不用实例化对象了，可以全局使用
//操作数据库的工具类
public class jdbcUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    //类加载的时候，就初始化静态代码块
    static{
        Properties properties = new Properties();
        // 采用类加载的方式读取db.properties文件
        InputStream is = jdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }

         driver = properties.getProperty("driver");
         url = properties.getProperty("url");
         username = properties.getProperty("username");
         password = properties.getProperty("password");
    }


    //获取数据库的连接
    public static Connection getConnection()  {
        Connection con = null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    //编写Query（查询）公共方法
    public static ResultSet excute(Connection con,String sql,Object[] params) throws Exception{
        PreparedStatement st = con.prepareStatement(sql);
        //params 数组是占位符的数组
        //params.length 是占位符的长度
        for (int i = 0; i <params.length ; i++) {
            st.setObject(i+1,params[i]);
        }
        ResultSet rs = st.executeQuery();
        return rs;
    }
    //编写Update（增删改）工具类
    public static int excuteUpdate(Connection con,String sql,Object[] params) throws Exception{
        PreparedStatement st = con.prepareStatement(sql);
        //params 数组是占位符的数组
        //params.length 是占位符的长度
        // 不知sql有多少个参数，用数组的形式存放，在Dao层Object []param = {userCode}
        for (int i = 0; i <params.length ; i++) {
            st.setObject(i+1,params[i]);
        }
        // 返回的int值代表修改的行数
        int i = st.executeUpdate();
        return i;
    }
    //释放资源
    public static boolean release(Connection con,PreparedStatement st,ResultSet rs)  {
       //如果在回收过程中flag为false 我们还可以知道释放失败了
        boolean flag = true;
        if(rs!=null){
            try {
                rs.close();
                //gc回收
                rs = null ; //制空
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if(st!=null){
            try {
                st.close();
                st = null ; //制空
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if(con!=null){
            try {
                con.close();
                con = null ; //制空
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

}
