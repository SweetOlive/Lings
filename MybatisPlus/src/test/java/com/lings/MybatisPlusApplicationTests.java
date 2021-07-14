package com.lings;

import com.lings.mapper.UserMapper;
import com.lings.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    // 继承了BaseMapper，所有方法都来自父类
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    // 测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("Lings");
        user.setAge(99);
        user.setEmail("lings@qq.com");

        int insert = userMapper.insert(user);// 帮我们自动生成id
        System.out.println("=====result:"+insert);// 受影响的行数
        System.out.println("====="+user);// 发现 id 会自动回写
    }
}
