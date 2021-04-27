<%--
  Created by IntelliJ IDEA.
  User: Cai Ronggui
  Date: 2021/4/27
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--jsp:include page=""--%>
<%--
http://localhost:8080/Java_JSP_war_exploded/jsptag2.jsp?name=xiaoming&age=12
--%>
<jsp:forward page="/jsptag2.jsp">
  <jsp:param name="name" value="xiaoming"/>
  <jsp:param name="age" value="12"/>
</jsp:forward>

</body>
</html>
