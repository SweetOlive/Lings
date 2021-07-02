package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    //Chain：链
    /*
    1.过滤中的所有代码，在过滤特定的请求的时候都会执行
    2.必须要让过滤器继续执行  chain.doFilter(request,response);
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter执行前....！");
        chain.doFilter(request,response);//让我们的请求继续走，如果不写，程序到这里就被拦截了，不往下走了
        System.out.println("CharacterEncodingFilter执行后....！");
    }

    //初始化:web服务器启动，就初始化了
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化！");
    }

    //销毁：web服务器关闭的时候
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁！");
    }
}
