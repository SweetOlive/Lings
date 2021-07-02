package com.servlet;

import com.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object USER_SESSION = req.getSession().getAttribute(Constant.USER_SESSION);

        if (USER_SESSION != null){
            req.getSession().removeAttribute(Constant.USER_SESSION);
            resp.sendRedirect("/Java_Filter_war_exploded/Login.jsp");
        }else{
            resp.sendRedirect("/Java_Filter_war_exploded/Login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
