package com.gutan.service.provider;

import com.gutan.pojo.Provider;

import java.util.List;

public interface ProviderService {
    // 获取指定的供应商列表
    public List<Provider> getProviderList(String proName, String proCode);

    // 增加供应商
    public boolean add(Provider provider);

    //删除供应商
    public int deleteProviderById(String id);

    // 通过id查询供应商的全部信息
    public Provider getProviderById(String id);

    //修改供应商
    public boolean modify(Provider provider);
}
