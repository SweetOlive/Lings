package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

///统计网站在线人数：统计session
public class OnlineListener implements HttpSessionListener {

    //创建session监听
    //一旦创建session就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        System.out.println("sessionID:"+se.getSession().getId());
        Integer online = (Integer) ctx.getAttribute("online");
        if (online == null){
            online = new Integer(1);
        }else{
            int count = online.intValue();
            online = new Integer(count+1);
        }
        ctx.setAttribute("online",online);
    }

    //销毁session监听
    //一旦销毁session就会触发一次这个事件
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer online = (Integer) ctx.getAttribute("online");
        System.out.println("sessionID:"+se.getSession().getId());
        if (online == null){
            online = new Integer(0);
        }else{
            int count = online.intValue();
            online = new Integer(count-1);
        }
        ctx.setAttribute("online",online);
    }
    /*
     Session销毁：
     1.手动销毁 getSession().invalidate()
     2.自动销毁
     */
}
