<%--
  Created by IntelliJ IDEA.
  User: Cai Ronggui
  Date: 2021/4/26
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--JSP表达式
  作用：用来将程序的输出，输出到客户端
  <%= 变量或者表达式 %>
  --%>
  <%= new Date()%>

  <hr>
  <%--JSP脚本片段--%>
  <%
    int sum = 0 ;
    for (int i = 1; i <=100; i++) {
      sum+=i;
    }
    out.println("<h1>Sum = "+sum+"</h1>");
  %>

  <%
   int x = 10;
   out.println(x);
  %>

  <p>这是一个JSP文档</p>
  <%
    int y = 2;
    out.println(y);
  %>
  <hr>

  <%--在代码中嵌入HTML元素--%>
  <%--EL表达式 ${变量名} --%>
  <%
    for (int i = 0; i < 5; i++) {
  %>
  <h1>hello world! <%= i%>  ${i} </h1>
  <%
    }
  %>

  <hr>

  <%--JSP声明，会被编译到JSP生成的Java类中，其他的，就会被生成到_jspService方法中！--%>
  <%!
    static {
      System.out.println("Loading Servlet");
    }
    private int globaVar = 0;

    public void ming(){
      System.out.println("进入了方法ming()!");
    }

  %>
<!--我是HTML的注释-->
  <%--JSP的注释不会显示在界面代码上，更安全，html就会--%>

  </body>
</html>
