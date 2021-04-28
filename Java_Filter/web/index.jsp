<%--
  Created by IntelliJ IDEA.
  User: Cai Ronggui
  Date: 2021/4/28
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
   <h1>当前有<span style="color: blue"><%=this.getServletConfig().getServletContext().getAttribute("online")%></span>人在线</h1>
  </body>
</html>
