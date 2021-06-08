package com.gutan.dao.role;

import com.gutan.pojo.Role;
import com.gutan.util.jdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{
    @Override
    public List<Role> getRoleList(Connection con) throws Exception {
        List<Role> roleList = new ArrayList<Role>();
        ResultSet rs = null;
        if (con!=null){
            String sql = "select * from `smbms_role`";
            Object [] params = {};
            rs = jdbcUtil.excute(con, sql, params);
            while (rs.next()){
                Role _role = new Role();
                _role.setId(rs.getInt("id"));
                _role.setRoleCode(rs.getString("roleCode"));
                _role.setRoleName(rs.getString("roleName"));
                roleList.add(_role);
            }
            jdbcUtil.release(null,null,rs);
        }
        return roleList;
    }
}
