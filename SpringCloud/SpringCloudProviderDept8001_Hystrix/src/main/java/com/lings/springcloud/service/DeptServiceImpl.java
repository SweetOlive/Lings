package com.lings.springcloud.service;

import com.lings.springcloud.dao.DeptDao;
import com.lings.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptDao dao;

    @Override
    public boolean addDept(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return dao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return dao.queryAll();
    }
}
