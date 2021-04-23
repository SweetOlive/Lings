<%--
  Created by IntelliJ IDEA.
  User: Cai Ronggui
  Date: 2021/4/23
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>登录</h1>
<div>
    <%--以post的方式提交表单，提交到login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名： <input type = "text" name="username" ><br>
        密码： <input type = "password" name="password"><br>
        爱好：
        <input type = "checkbox" name="hobbys" value="女孩">女孩
        <input type = "checkbox" name="hobbys" value="代码">代码
        <input type = "checkbox" name="hobbys" value="唱歌">唱歌
        <input type = "checkbox" name="hobbys" value="电影">电影
        <br>
        <input type="submit">
    </form>
</div>

</body>
</html>
