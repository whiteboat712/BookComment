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
            font-family: MiSans, sans-serif;
            background-color: #f0f0f0;
        }
        .navbar {
            display: flex;
            justify-content: flex-end;
            padding: 10px;
            margin-bottom: 10px;
            background-color: white;
            color: #636363;
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
            background-color: #f6f6f6;
            padding: 5px;
            border-radius: 50vh;
            border: 2px solid #f06c6c;
        }
        .navbar input[type="text"]:focus {
            border: 2px solid #f06c6c;
            outline: #f06c6c;
        }
        .navbar button[type="submit"], .navbar button {
            padding: 5px 10px;
            margin: 0 5px;
            border: 2px solid #f06c6c;
            border-radius: 3px;
            background-color: #f06c6c;
            color: white;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .navbar button[type="submit"]:hover, .navbar button:hover {
            background-color: white;
            color: #f06c6c;
            border: 2px solid #f06c6c;
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
        .logo {
            color: #636363;
            font-family: '苹方 常规',serif;
            font-size: 30px;
            border-bottom: white 3px solid;
            margin-right: 10px;
            text-decoration: none;
            transition: all 0.3s ease;
        }
        .logo:hover {
            border-bottom: 3px #f06c6c solid;
        }

    </style>
</head>
<body>
<header>
    <div class="navbar">
        <a class="logo" href="index.jsp" style="">
            书影留声
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
