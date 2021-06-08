package com.gutan.service.provider;

import com.gutan.dao.bill.BillDao;
import com.gutan.dao.bill.BillDaoImpl;
import com.gutan.dao.provider.ProviderDao;
import com.gutan.dao.provider.ProviderDaoImpl;
import com.gutan.pojo.Provider;
import com.gutan.util.jdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProviderServiceImpl implements ProviderService {
    // 之后容器会帮我们做这件事
    private BillDao billDao;
    private ProviderDao providerDao;
    public ProviderServiceImpl() {
        billDao = new BillDaoImpl();
        providerDao = new ProviderDaoImpl();
    }



    //获取provider的列表  获取指定的供应商列表
    @Override
    public List<Provider> getProviderList(String proName, String proCode) {
        List<Provider> providerList = new ArrayList<Provider>();
        Connection conn = null;
        System.out.println("query proName ---- > " + proName);
        System.out.println("query proCode ---- > " + proCode);
        try {
            conn = jdbcUtil.getConnection();
            providerList = providerDao.getProviderList(conn,proName,proCode);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.release(conn,null,null);
        }
        return providerList;
    }

    // 增加供应商
    @Override
    public boolean add(Provider provider) {
        boolean flag = false;
        Connection conn = null;
        try{
            conn = jdbcUtil.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            if(providerDao.add(conn, provider)>0){
                flag = true;
            }
            //提交事务
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            try {
                System.out.println("=========rollback");
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            jdbcUtil.release(conn,null,null);
        }
        return flag;
    }

    //删除供应商
    /*
    在删除供应商的ID时，先去bill中查找是否存在供应商，有的话不能删除
    billcount = -1 删除失败
    billCount == 0 删除成功
    billcount >0 存在账单
     */
    @Override
    public int deleteProviderById(String id) {
        Connection conn = null;
        int billCount = -1;
        try{
            conn = jdbcUtil.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            billCount = billDao.getBillCountByProviderId(conn,id);
            if (billCount == 0){
                providerDao.deleteProviderById(conn,id);
            }
            //提交事务
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            billCount = -1;
            try {
                System.out.println("=========Rollback");
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            jdbcUtil.release(conn,null,null);
        }
        return billCount;
    }

    // 查询供应商通过ID
    @Override
    public Provider getProviderById(String id) {
        Provider provider = null;
        Connection conn = null;
        try {
            conn = jdbcUtil.getConnection();
            provider = providerDao.getProviderById(conn, id);
        }catch (Exception e){
            e.printStackTrace();
            provider = null;
        }finally {
            jdbcUtil.release(conn,null,null);
        }
        return provider;
    }

    //修改供应商
    @Override
    public boolean modify(Provider provider) {
        boolean flag = false;
        Connection conn = null;
        try{
            conn = jdbcUtil.getConnection();
            conn.setAutoCommit(false);// 开启事务
            if(providerDao.modify(conn,provider)>0)
                flag = true;
            conn.commit(); // 提交事务
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
            try {
                System.out.println("========ROLLBACK");
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            jdbcUtil.release(conn,null,null);
        }
        return flag;
    }

    @Test
    public void sad(){
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(date.toLocaleString());
        System.out.println(date.toGMTString());
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(format);
        String format1 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(date);
        System.out.println(format1);
    }
}
