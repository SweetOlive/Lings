<%--
  Created by IntelliJ IDEA.
  User: Cai Ronggui
  Date: 2021/4/26
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--定制错误页面--%>
<%@ page errorPage="error/500.jsp" %>

<%--显示的声明这是一个错误的页面--%>
<%--<%@ page isErrorPage="true" %>--%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  int x = 1/0;
%>

</body>
</html>
