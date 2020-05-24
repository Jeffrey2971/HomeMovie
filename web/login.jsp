<%--
  Created by IntelliJ IDEA.
  User: jeffrey
  Date: 2020/5/24
  Time: 下午6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="/video/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>请输入密码</td>
            <td><input type="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit">登录</td>
        </tr>
    </table>

</form>
</body>
</html>
