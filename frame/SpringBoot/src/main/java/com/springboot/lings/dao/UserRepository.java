package com.springboot.lings.dao;

import com.springboot.lings.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author Lings 603656949@qq.com
 * @Date 2019/7/12 10:52
 * @Version 1.0
 * @Desc
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * @Author Lings 603656949@qq.com
     * @Date  2019/7/12
     * @Param  [username] 用户名
     * @return java.util.List<com.springboot.lings.entity.User>
     * @Desc  根据用户名查询用户信息
     **/
    List<User> findAllByUsername(String username);

}
