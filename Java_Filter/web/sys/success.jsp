<%--
  Created by IntelliJ IDEA.
  User: Cai Ronggui
  Date: 2021/6/7
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object user_session = request.getSession().getAttribute("USER_SESSION");
    if (user_session == null){
        response.sendRedirect("/Java_Filter_war_exploded/Login.jsp");
    }
%>

<h1>主页</h1>

<p>
    <a href="/Java_Filter_war_exploded/servlet/logout">注销</a>
</p>

</body>
</html>
