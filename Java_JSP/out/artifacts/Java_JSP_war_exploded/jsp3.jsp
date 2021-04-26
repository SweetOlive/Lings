<%--
  Created by IntelliJ IDEA.
  User: Cai Ronggui
  Date: 2021/4/26
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--将两个页面合2为1--%>
    <%@ include file="common/header.jsp"%>
    <h1>网页主体</h1>
    <%@ include file="common/footer.jsp"%>

    <hr>

    <%--JSP标签--%>
    <%--拼接页面，本质还是3个--%>
    <jsp:include page="common/header.jsp"/>
    <h1>网页主体</h1>
    <jsp:include page="common/footer.jsp"/>



</body>
</html>
