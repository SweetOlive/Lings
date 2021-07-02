package com.gutan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = "";
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        if (name!=null ){
            if ("admin".equals(name)){
                msg = "ok";
            }else {
                msg="用户名有误";
            }
        }
        if (pwd!=null ){
            if ("admin".equals(pwd)){
                msg = "ok";
            }else {
                msg="密码输入有误";
            }
        }
        resp.getWriter().write(msg);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
