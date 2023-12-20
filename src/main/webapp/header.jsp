<%@ page import="system.bookcomment.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/18
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="system.bookcomment.model.User" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .navbar {
            display: flex;
            justify-content: flex-end;
            padding: 10px;
            background-color: #333;
            color: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .navbar form {
            display: flex;
            justify-content: center;
            margin-right: auto;
        }
        .navbar input[type="text"] {
            width: 200px;
            margin-right: 10px;
            padding: 5px;
            border: none;
            border-radius: 3px;
        }
        .navbar button[type="submit"], .navbar button {
            padding: 5px 10px;
            margin: 0 5px;
            border: none;
            border-radius: 3px;
            background-color: #f06c6c;
            color: white;
            cursor: pointer;
        }
        .navbar button[type="submit"]:hover, .navbar button:hover {
            background-color: #f8e4e4;
            color: black;
        }

        .navbar span {
            height: 36px;
            display: flex;
            align-items: center;
        }
        .avatar {
            width: 36px;
            height: 36px;
            border-radius: 3px;
            margin-bottom: 0;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<header>
    <div class="navbar">
        <a href="index.jsp" style="color: #66ccff; margin-right: 10px; text-decoration: none">
            读书评论网
        </a>
        <form action="search-servlet" method="get">
            <input type="text" name="key" placeholder="搜索...">
            <button type="submit">搜索</button>
        </form>
        <%
            if (user == null || user.getUid() == 0) {
        %>
        <a href="login.jsp">
            <button>登录</button>
        </a>
        <a href="register.jsp">
            <button>注册</button>
        </a>
        <%
        } else {
        %>
        <span>
            <a href="userDetail.jsp">
                <img class="avatar" src="image-servlet?id=${user.uid}&type=user"  alt="头像"/>
           </a>
            <%= user.getUname() %>
            <a href="logout-servlet">
                <button>退出登录</button>
            </a>
            <%
                if (user.getRole() == User.Role.ADMIN) {
            %>
            <a href="backendManager.jsp">
                <button>后台管理</button>
            </a>
            <%
                }
            %>
        </span>
        <%
            }
        %>
    </div>
</header>
</body>
</html>
