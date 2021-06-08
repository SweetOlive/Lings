package com.gutan.filter;
import com.gutan.pojo.User;
import com.gutan.util.Constans.Constant;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        // 过滤器，从Session中获取用户
        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);
        if( user == null){ // 被注销或者被移除
            resp.sendRedirect("/smbms/error.jsp");
        }else {
            filterChain.doFilter(servletRequest, servletResponse); // 链往下走
        }
    }
    public void destroy() {
    }
}
