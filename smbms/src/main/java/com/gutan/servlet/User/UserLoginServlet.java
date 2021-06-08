package com.gutan.servlet.User;
import com.gutan.pojo.User;
import com.gutan.service.User.UserService;
import com.gutan.service.User.UserServiceImpl;
import com.gutan.util.Constans.Constant;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class UserLoginServlet extends HttpServlet {
    // 控制层调用业务层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        // 获取前端传来的用户和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        UserService userService = new UserServiceImpl();
        try {
             user = userService.Login(userCode, userPassword); // 查询登录的用户
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 注意：转发是request的方法，重定向是Response的方法
        if(user == null){// 查无此人
            //转发回登录界面，并把提示信息保存在req里面，前端通过EL表达式取值
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {//查有此人
            // 将用户的全部信息放入Session中
            req.getSession().setAttribute(Constant.USER_SESSION,user);// 常量存封装类里面
            resp.sendRedirect("jsp/frame.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
