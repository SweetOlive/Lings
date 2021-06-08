<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <%--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function fun(){
            $.ajax({
                url:"${pageContext.request.contextPath}/ajax/a1",
                data:{"name":$("#textName").val()},
                success:function (data,status){
                    console.log(data);
                    console.log(status);
                }
            });
        }
    </script>
</head>
<body>

<%--onblur：失去焦点触发事件--%>
用户名：<input type="text" id="textName" name="name" onblur="fun()"/>
</body>
</html>