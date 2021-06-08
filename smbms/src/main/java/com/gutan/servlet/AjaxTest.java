package com.gutan.servlet;

import com.google.gson.Gson;
import com.gutan.pojo.AjaxUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AjaxTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AjaxUser> userList = new ArrayList<AjaxUser>();
        userList.add(new AjaxUser("hujesse4",20,"man"));
        userList.add(new AjaxUser("hujesse83",21,"man"));
        Gson gson = new Gson();
        String s=  gson.toJson(userList);
        resp.getWriter().write(s);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
