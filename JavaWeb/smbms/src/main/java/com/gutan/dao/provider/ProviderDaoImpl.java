package com.gutan.dao.provider;

import com.gutan.pojo.Provider;
import com.gutan.util.jdbcUtil;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProviderDaoImpl implements ProviderDao {
    // 通过proName 和 proCode 查询指定的供应商
    @Override
    public List<Provider> getProviderList(Connection conn, String proName, String proCode) throws Exception {
        List<Provider> providerList = new ArrayList<Provider>();
        ResultSet rs = null;
        if (null !=conn){
            StringBuffer sql = new StringBuffer();
            sql.append("select * from smbms_provider  where 1= 1");
            List<Object> list = new ArrayList<Object>();
            if (!StringUtils.isNullOrEmpty(proName)){
                sql.append(" and proName like ?");
                list.add("%"+proName+"%");
            }
            if(!StringUtils.isNullOrEmpty(proCode)){
                sql.append(" and proCode like ?");
                list.add("%"+proCode+"%");
            }
            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            rs = jdbcUtil.excute(conn, sql.toString(), params);
            while (rs.next()){
                Provider _provider = new Provider();
                _provider.setId(rs.getInt("id"));
                _provider.setProCode(rs.getString("proCode"));
                _provider.setProName(rs.getString("proName"));
                _provider.setProDesc(rs.getString("proDesc"));
                _provider.setProContact(rs.getString("proContact"));
                _provider.setProPhone(rs.getString("proPhone"));
                _provider.setProAddress(rs.getString("proAddress"));
                _provider.setProFax(rs.getString("proFax"));
                _provider.setCreationDate(rs.getTimestamp("creationDate"));
                providerList.add(_provider);
            }
            jdbcUtil.release(null,null,rs);
        }
        return providerList;
    }

    // 增加供应商
    @Override
    public int add(Connection conn,Provider provider) throws Exception {
        Integer updateRows = 0;
        if (null !=conn){
            String sql = "insert into `smbms_provider`(proCode,proName,proDesc,proContact,proPhone,proAddress,proFax,createdBy,creationDate)" +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            Object [] params = {provider.getProCode(),provider.getProName(),provider.getProDesc(),
            provider.getProContact(),provider.getProPhone(),provider.getProAddress(),provider.getProFax(),
            provider.getCreatedBy(),provider.getCreationDate()};
            updateRows = jdbcUtil.excuteUpdate(conn, sql, params);
        }
        return updateRows;
    }

    //删除供应商
    @Override
    public int deleteProviderById(Connection conn, String id) throws Exception {
        int updateRows = 0;
        if (null!=conn){
            String sql = "delete from `smbms_provider` where id =?";
            Object [] params = {id};
            updateRows= jdbcUtil.excuteUpdate(conn, sql, params);
        }
        return updateRows;
    }

    //通过ID获取供应商的全部信息
    @Override
    public Provider getProviderById(Connection conn, String id) throws Exception {
        Provider _provider = null;
        ResultSet rs = null;
        if (null!=conn){
            String sql = "select * from smbms_provider where id=?";
            Object [] params = {id};
            rs = jdbcUtil.excute(conn, sql, params);
            if (rs.next()){
                 _provider = new Provider();
                _provider.setId(rs.getInt("id"));
                _provider.setProCode(rs.getString("proCode"));
                _provider.setProName(rs.getString("proName"));
                _provider.setProDesc(rs.getString("proDesc"));
                _provider.setProContact(rs.getString("proContact"));
                _provider.setProPhone(rs.getString("proPhone"));
                _provider.setProAddress(rs.getString("proAddress"));
                _provider.setProFax(rs.getString("proFax"));
                _provider.setCreatedBy(rs.getInt("createdBy"));
                _provider.setCreationDate(rs.getTimestamp("creationDate"));
                _provider.setModifyBy(rs.getInt("modifyBy"));
                _provider.setCreationDate(rs.getDate("creationDate"));
            }
            jdbcUtil.release(null,null,rs);
        }
        return _provider;
    }

    // 修改供应商
    @Override
    public int modify(Connection conn, Provider provider) throws Exception {
        int updateRows = 0;
        if (null!=conn){
            String sql = "update smbms_provider set proName=?,proDesc=?,proContact=?," +
                    "proPhone=?,proAddress=?,proFax=?,modifyBy=?,modifyDate=? where id = ? ";
            Object[] params = {provider.getProName(),provider.getProDesc(),provider.getProContact(),provider.getProPhone(),provider.getProAddress(),
                    provider.getProFax(),provider.getModifyBy(),provider.getModifyDate(),provider.getId()};
            updateRows = jdbcUtil.excuteUpdate(conn,sql,params);
        }
        return updateRows;
    }
}
