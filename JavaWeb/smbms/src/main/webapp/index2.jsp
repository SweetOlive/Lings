<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" id="btn" value="获取数据"/>
<table width="80%" align="center">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">
    </tbody>
</table>

<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script>

    $(function () {
        $("#btn").click(function () {
            $.post("${pageContext.request.contextPath}/ajax/a1",function (data) {
                console.log(data)
                let data2 = JSON.parse(data);
                console.log(data2)
                var html="";
                for (var i = 0; i <data2.length ; i++) {
                    html+= "<tr>" +
                        "<td>" + data2[i].name + "</td>" +
                        "<td>" + data2[i].age + "</td>" +
                        "<td>" + data2[i].sex + "</td>" +
                        "</tr>"
                }
                $("#content").html(html);
            });
        })
    })
</script>
</body>
</html>