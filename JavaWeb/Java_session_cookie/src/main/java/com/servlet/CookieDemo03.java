package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

//中文数据传递
public class CookieDemo03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        //Cookie,服务端从客户端获取
        Cookie[] cookies = req.getCookies();//Cookie可能存在多个i

        //判断Coolie是否存在
        if (cookies != null){
            out.write("您上一次访问的时间是：");
            for (int i = 0 ; i < cookies.length ;i++){
                Cookie cookie = cookies[i];
                //获取Cookie的名字
                if ( cookie.getName().equals("name")){
                    //获取cookie的值
                    System.out.println(cookie.getValue());
                    out.write(URLDecoder.decode(cookie.getValue(),"UTF-8"));
                }
            }
        }else{
            out.write("这是您第一次访问本站！");
        }

        Cookie cookie = new Cookie("name", URLEncoder.encode("xiao明","UTF-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
