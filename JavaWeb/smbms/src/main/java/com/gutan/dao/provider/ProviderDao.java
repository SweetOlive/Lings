package com.gutan.dao.provider;

import com.gutan.pojo.Provider;

import java.sql.Connection;
import java.util.List;

public interface ProviderDao {
    // 获取指定的供应商列表
    public List<Provider> getProviderList(Connection conn,String proName,String proCode) throws Exception;
    // 增加供应商
    public int add(Connection conn,Provider provider) throws Exception;

    //删除供应商
    public int deleteProviderById(Connection conn,String id) throws Exception;

    //通过Id获取供应商信息
    public Provider getProviderById(Connection conn,String id) throws Exception;

    // 修改供应商信息
    public int modify(Connection conn,Provider provider) throws  Exception;

}
