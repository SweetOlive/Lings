package com.lings.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lings.pojo.User;
import org.springframework.stereotype.Repository;

// 在对应的Mapper 继承实现 对应的BaseMapper
@Repository // 代表持久层
public interface UserMapper extends BaseMapper<User> {

    // 所有的CRUD已经完成了
    // 不需要

}