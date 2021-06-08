package com.gutan.service.bill;

import com.gutan.dao.bill.BillDao;
import com.gutan.dao.bill.BillDaoImpl;
import com.gutan.pojo.Bill;
import com.gutan.util.jdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BillServiceImpl implements BillService {

    private BillDao billDao;
    public BillServiceImpl(){
        billDao = new BillDaoImpl();
    }
    @Override
    public boolean add(Bill bill) {
        // TODO Auto-generated method stub
        boolean flag = false;
        Connection connection = null;
        try {
            connection = jdbcUtil.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            if(billDao.add(connection,bill) > 0) {
                flag = true;
            }
            connection.commit();
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

    @Override
    public List<Bill> getBillList(Bill bill) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<Bill> billList = null;
        System.out.println("query productName ---- > " + bill.getProductName());
        System.out.println("query providerId ---- > " + bill.getProviderId());
        System.out.println("query isPayment ---- > " + bill.getIsPayment());

        try {
            connection = jdbcUtil.getConnection();
            billList = billDao.getBillList(connection, bill);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            jdbcUtil.release(connection, null, null);
        }
        return billList;
    }

    @Override
    public boolean deleteBillById(String delId) {
        // TODO Auto-generated method stub
        Connection connection = null;
        boolean flag = false;
        try {
            connection = jdbcUtil.getConnection();
            if(billDao.deleteBillById(connection, delId) > 0)
                flag = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            jdbcUtil.release(connection, null, null);
        }
        return flag;
    }

    @Override
    public Bill getBillById(String id) {
        // TODO Auto-generated method stub
        Bill bill = null;
        Connection connection = null;
        try{
            connection = jdbcUtil.getConnection();
            bill = billDao.getBillById(connection, id);
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            bill = null;
        }finally{
            jdbcUtil.release(connection, null, null);
        }
        return bill;
    }

    @Override
    public boolean modify(Bill bill) {
        // TODO Auto-generated method stub
        Connection connection = null;
        boolean flag = false;
        try {
            connection = jdbcUtil.getConnection();
            if(billDao.modify(connection,bill) > 0)
                flag = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            jdbcUtil.release(connection, null, null);
        }
        return flag;
    }

}
