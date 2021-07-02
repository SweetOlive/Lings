package com.gutan.servlet.User;

import com.google.gson.Gson;
import com.gutan.pojo.Role;
import com.gutan.pojo.User;
import com.gutan.service.User.UserService;
import com.gutan.service.User.UserServiceImpl;
import com.gutan.service.role.RoleService;
import com.gutan.service.role.RoleServiceImpl;
import com.gutan.util.Constans.Constant;
import com.gutan.util.PageSupport;
import com.mysql.cj.util.StringUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// UserServlet中有很多User的操作，所以需要复用
public class UserServlet extends HttpServlet {
    private UserService userService;
    public UserServlet(){
        userService = new UserServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("savepwd".equals(method) && method!=null){
            this.UpdateWpd(req,resp);
        }else if("pwdmodify".equals(method) && method!=null){
            this.pwdModify(req,resp);
        }else if("query".equals(method)){
            this.query(req,resp);
        }
        else if("getrolelist".equals(method)){
            this.getRoleList(req,resp);
        }else if ("ucexist".equals(method)){
            this.userCodeExist(req,resp);
        }else if("add".equals(method)){
            this.add(req, resp);
        }else if("deluser".equals(method)){
            this.delete(req, resp);
        }else if("modify".equals(method)){
            this.getUserById(req,resp,"usermodify.jsp");
        }else if("modifyexe".equals(method)){
            this.modify(req,resp);
        }else if ("view".equals(method)){
            this.getUserById(req,resp,"userview.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    // 提取为一个用户修改密码的方法
    public void UpdateWpd(HttpServletRequest req, HttpServletResponse resp)  {
        // 从Session中拿用户的ID
        boolean flag = false;
        User user =(User) req.getSession().getAttribute(Constant.USER_SESSION);
        String password = req.getParameter("newpassword");
        if (user!=null && password!=null &&password.length()!=0){
            UserService userService = new UserServiceImpl();
            flag = userService.UpdatePwd(user.getId(), password);
            if (flag) {// 修改成功
                req.setAttribute("msg","修改密码成功，请退出重新登录");
                // 移除当前session
                req.getSession().removeAttribute(Constant.USER_SESSION);
                //因为拦截器的原因，没有了Session会跳转到Error界面
            }else{
                req.setAttribute("msg","密码修改失败");
            }
        }else {
            req.setAttribute("msg","新密码有问题");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 利用Ajax验证旧密码
    // Session中存放了用户的所以数据
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        // 从Session中拿到ID
        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");
        //万能的Map 结果集
        Map<String, String> resultMap = new HashMap<String, String>();
        if(user ==null){
            // session 过期了
            resultMap.put("result","sessionerror");
        }else if(oldpassword==null){
            resultMap.put("result","error");
        }else {
            if(user.getUserPassword().equals(oldpassword)){
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(new Gson().toJson(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 用户管理的Servlet
    private void query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //查询用户列表

        //从前端获取数据
        String queryUserName = request.getParameter("queryname");
        String temp = request.getParameter("queryUserRole");
        String pageIndex = request.getParameter("pageIndex");
        int queryUserRole = 0;

        //获取用户列表

        UserService userService = new UserServiceImpl();

        //第一次走页面一定是第一页,页面大小固定的
        List<User> userList = null;
        //设置页面容量
        int pageSize = 5;
        //当前页码
        int currentPageNo = 1;
        if(queryUserName == null){
            queryUserName = "";
        }
        if(temp != null && !temp.equals("")){
            queryUserRole = Integer.parseInt(temp);//给查询赋值
        }

        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                response.sendRedirect("error.jsp");
            }
        }
        //总数量（表）
        int totalCount	= userService.getUserCount(queryUserName,queryUserRole);
        //总页数
        PageSupport pages=new PageSupport();

        pages.setCurrentPageNo(currentPageNo);

        pages.setPageSize(pageSize);

        pages.setTotalCount(totalCount);

        int totalPageCount = pages.getTotalPageCount();

        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }

        userList = userService.getUserList(queryUserName,queryUserRole,currentPageNo, pageSize);
        request.setAttribute("userList", userList);
        List<Role> roleList = null;
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        request.setAttribute("roleList", roleList);
        request.setAttribute("queryUserName", queryUserName);
        request.setAttribute("queryUserRole", queryUserRole);
        request.setAttribute("totalPageCount", totalPageCount);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("currentPageNo", currentPageNo);
        request.getRequestDispatcher("userlist.jsp").forward(request, response);
    }

    // 获取用户增加表单下拉框中的RoleList
    public void getRoleList(HttpServletRequest req, HttpServletResponse resp){
        List<Role> roleList = null;
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();

        resp.setContentType("application/json");
        try {
            PrintWriter writer = resp.getWriter();
            writer.write(new Gson().toJson(roleList));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 增加用户表单中验证用户名是否存在
    public void userCodeExist(HttpServletRequest req,HttpServletResponse resp) {
        String userCode = req.getParameter("userCode");
        Map<String, String> map = new HashMap<String, String>();
        if (userService.userCodeExist(userCode))
            map.put("userCode", "exist");
        else
            map.put("userCode","notexist");

            resp.setContentType("applicaiton/json");
            try {
                PrintWriter writer = resp.getWriter();
                writer.write(new Gson().toJson(map));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    // 新增用户Bu
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("add()================");
        String userCode = request.getParameter("userCode");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");

        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreationDate(new Date());
        user.setCreatedBy(((User)request.getSession().getAttribute(Constant.USER_SESSION)).getId());

        UserService userService = new UserServiceImpl();
        if(userService.add(user)){
            response.sendRedirect(request.getContextPath()+"/jsp/user.do?method=query");
        }else{
            request.getRequestDispatcher("useradd.jsp").forward(request, response);
        }

    }

    // 删除用户
    private void delete(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getParameter("uid");
        boolean flag = false;
        Map<String, String> map = new HashMap<>();
        if (!StringUtils.isNullOrEmpty(userId)){
            flag = userService.deleteUserById(Integer.parseInt(userId));
            if (flag){
                map.put("delResult","true");
            }else {
                map.put("delResult","false");
            }
        }else {
            map.put("delResult","notexist");
        }

        // 把map转换为Json输出
        response.setContentType("application/json");
        try {
            PrintWriter writer = response.getWriter();
            writer.write(new Gson().toJson(map));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //根据用户Id获得用户
    private void getUserById(HttpServletRequest request, HttpServletResponse response,String url) throws IOException, ServletException {
        String uid = request.getParameter("uid");
        User user = null;
        if (!StringUtils.isNullOrEmpty(uid)){
            user = userService.getUserById(uid);
            request.setAttribute("user",user);
            request.getRequestDispatcher(url).forward(request,response);
        }
    }

    // 更改用户
    private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("uid");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUserName(userName);
        user.setGender(Integer.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.valueOf(userRole));
        user.setModifyBy(((User)request.getSession().getAttribute(Constant.USER_SESSION)).getId());
        user.setModifyDate(new Date());

        if (userService.modify(user)){
            response.sendRedirect(request.getContextPath()+"/jsp/user.do?method=query");
        }else
            request.getRequestDispatcher(request.getContextPath()+"usermodify.jsp").forward(request,response);
    }


 }
