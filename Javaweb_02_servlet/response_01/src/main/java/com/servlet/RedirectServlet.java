package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*
       重定向与转发的区别？
       相同点：页面都会实现跳转
       不同点：请求转发的时候，url不会发生变化 307
               请求重定向时候，url会发生变化  302
        */
        /*
        resp.setHeader("Location","/response_01_war/im");
        resp.setStatus(HttpServletResponse.SC_FOUND);
         */
        resp.sendRedirect("/response_01_war/im");//重定向
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
