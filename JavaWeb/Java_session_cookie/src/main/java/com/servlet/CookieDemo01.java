package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器告诉你，你来的时间，把这个时间封装成为一个信件，我就知道你来了

        //解决中文乱码
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        //Cookie,服务端从客户端获取
        Cookie[] cookies = req.getCookies();//Cookie可能存在多个

        //判断Coolie是否存在
        if (cookies != null){
            out.write("您上一次访问的时间是：");
            for (int i = 0 ; i < cookies.length ;i++){
                Cookie cookie = cookies[i];
                //获取Cookie的名字
               if ( cookie.getName().equals("lastLoginTime")){
                   //获取cookie的值
                   long lastLoginTime = Long.parseLong(cookie.getValue());
                   Date date = new Date(lastLoginTime);
                   out.write(date.toLocaleString());
               }
            }
        }else{
            out.write("这是您第一次访问本站！");
        }

        //服务器给客户端响应一个Cookie
//        Cookie cookie = new Cookie("name", "xiao明");
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        //cookie有效期为1天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
