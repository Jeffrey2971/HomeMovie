<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: jeffrey
  Date: 2020/5/24
  Time: 下午8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
    <script>
        window.onload = function () {
            sec = 5;
            var time = document.getElementById("time");

            function fun() {
                if (sec === 1) {
                    location.href = "/video/index/index.html"
                }
                sec--;
                time.innerHTML = sec;

            }

            setInterval(fun, 1000);
        }
    </script>
</head>

<body>

<%
    String username = null;
    User user = (User) request.getSession().getAttribute("user");
    if(user!=null){
        username = user.getUsername();
    }else{
        username = "null";
    }

%>


<p>登陆成功，<%=username%>，欢迎您<span id="time">5</span>，将在秒之后，自动跳转到首页</p>

</body>
</html>
