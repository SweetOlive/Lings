<%--
  Created by IntelliJ IDEA.
  User: Cai Ronggui
  Date: 2021/4/27
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--脚本片段中的代码，会被原封不动生成到jsp.java中
    要求：这里的代码必须保证Java语法的正确性--%>
<%
    /*通过pageContext取出我们定义的参数*/
    //从底层到高层（作用域）
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String)pageContext.findAttribute("name2");
    String name3 = (String)pageContext.findAttribute("name3");
    String name4 = (String)pageContext.findAttribute("name4");
    String name5 = (String)pageContext.findAttribute("name5");
    %>
    <%--使用EL表达式输出 ${} --%>
    <h1>取出的值为：</h1>
    <h3>${name1}</h3>
    <h3>${name2}</h3>
    <h3>${name3}</h3>
    <h3>${name4}</h3>
    <h3><%=name5 %></h3>

</body>
</html>
