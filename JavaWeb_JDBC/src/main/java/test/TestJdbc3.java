package test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc3 {

    @Test
    public void test(){
        //配置信息
        //解决中文乱码useUnicode=true&characterEncoding=utf-8
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "";

        Connection connection = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.链接数据库,代表数据库
            connection = DriverManager.getConnection(url, username, password);

            //3.通知数据库开启事务:false-开启；true-关闭
            connection.setAutoCommit(false);
            String sql_1 = "update account set money = money-100 where name = 'A'";
            connection.prepareStatement(sql_1).executeUpdate();

            //制造错误
//            int i = 1/0;

            String sql_2 = "update account set money = money+100 where name = 'B'";
            connection.prepareStatement(sql_2).executeUpdate();

            connection.commit();;//以上两条SQL都执行成功了，就提交事务！
            System.out.println("Success!");
        } catch (Exception e) {
            try {
                //如果出现异常就通知数据库回滚事务
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
