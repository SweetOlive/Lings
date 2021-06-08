package com.gutan.dao.user;
import com.gutan.pojo.User;
import com.gutan.util.jdbcUtil;
import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    // 通过userCode得到user
    public User getLoginUser(Connection con, String userCode) throws Exception {
        ResultSet rs = null;
        User user = null;
        // 确保连接上了数据库
        if (null !=con) {
            String sql = "select * from `smbms_user` where userCode=?";
            Object[] params = {userCode}; // 这个userCode为参数传进来的值，setObject
            rs = jdbcUtil.excute(con, sql, params);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("UserCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
        }
        jdbcUtil.release(null,null,rs);
        return user;
    }

    // 用户修改密码Dao
    public int UpdatePwd(Connection con,int id,String password) throws Exception{
        int UpdateRows = 0;

        if (con!=null){
            String sql = "update `smbms_user` set `userPassword`=? where id=?";
            Object[] params = {password,id};
            UpdateRows= jdbcUtil.excuteUpdate(con, sql, params);
        }
        //没有释放的资源，所以不用写
        return UpdateRows;
    }

    // 获取用户数量的DaoImpl
    // 根据用户名和用户角色查询用户总数（多少条记录）{最难Sql}
    public int getUserCount(Connection con, String username, int userRole) throws Exception {
        ResultSet rs = null;
        Integer count = 0;
        if (con!=null){
            StringBuffer sql = new StringBuffer();
            ArrayList<Object> list = new ArrayList<Object>();  // 先使用list，后来再转为Object数组
            //Object params[] = new Object[];
            sql.append("SELECT COUNT(1) as count from `smbms_user` as u," +
                    " `smbms_role` as r WHERE u.userRole = r.id");
            if(!StringUtils.isNullOrEmpty(username)){
                sql.append(" and u.userName like ?");
                list.add("%"+username+"%"); // list默认下标是0，不显示定义也可以
                // params[0]="%"+username+"%";
            }
            if (userRole>0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
                // params[1] = userRole
            }
            // 把List转换为数组
            Object[] params = list.toArray();
            System.out.println("完整的sql为---》"+sql.toString());  // 调试
             rs = jdbcUtil.excute(con, sql.toString(), params);
             if (rs.next()){
                  count = rs.getInt("count");  // 从结果集中获取最终的数量
             }
             jdbcUtil.release(con,null,rs);
        }
        return count;
    }

    //通过条件查询获得用户列表
    @Override
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)
            throws Exception {
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }
            if(userRole > 0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            rs = jdbcUtil.excute(connection,sql.toString(), params);
            while(rs.next()){
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            jdbcUtil.release(null,null, rs);
        }
        return userList;
    }

    // 增加用户
    @Override
    public int add(Connection conn, User user) throws Exception {
        int updateRows  = 0;
        if (null!=conn){
            String sql = "insert into smbms_user (userCode,userName,userPassword," +
                    "userRole,gender,birthday,phone,address,creationDate,createdBy) " +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object [] params = {user.getUserCode(),user.getUserName(),user.getUserPassword(),
                    user.getUserRole(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),
                    user.getCreationDate(),user.getCreatedBy()};
            updateRows  = jdbcUtil.excuteUpdate(conn, sql, params);
        }
        return updateRows;
    }

    //删除用户
    @Override
    public int deleteUserById(Connection conn, int id) throws Exception {
        int updateRows = 0;
        if (null !=conn){
            String sql = "delete from smbms_user where id = ?";
            Object [] params = {id};
            updateRows = jdbcUtil.excuteUpdate(conn,sql,params);
        }
        return updateRows;
    }

    //根据id查询用户
    @Override
    public User getUserById(Connection conn, String id) throws Exception {
        User user = null;
        ResultSet rs = null;
        if (null !=conn){
            String sql = "select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r " +
                    "where u.id =?" +
                    "and u.userRole = r.id";
            Object [] params = {id};
            rs = jdbcUtil.excute(conn, sql, params);
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
                user.setUserRoleName(rs.getString("userRoleName"));
            }
            jdbcUtil.release(null,null,rs);
        }
        return user;
    }

    //修改
    @Override
    public int modify(Connection conn, User user) throws Exception {
        int updateRows = 0;
        if (null !=conn){
            String sql = "update smbms_user set userName=?," +
                    "gender=?,birthday=?,phone=?,address=?,userRole=?,modifyBy=?,modifyDate=? where id = ? ";
            Object[] params = {user.getUserName(),user.getGender(),user.getBirthday(),
                    user.getPhone(),user.getAddress(),user.getUserRole(),user.getModifyBy(),
                    user.getModifyDate(),user.getId()};
            updateRows = jdbcUtil.excuteUpdate(conn, sql, params);

        }
        return updateRows;
    }
}
