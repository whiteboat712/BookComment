<%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/19
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="system.bookcomment.model.User" %>
<%@ page import="system.bookcomment.dao.UserDao" %>
<jsp:useBean id="user" class="system.bookcomment.model.User" scope="session" />
<%
    UserDao userDao = new UserDao();
    List<User> users = userDao.getAllUsers();
%>
<!DOCTYPE html>
<html>
<head>
    <title>所有用户</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f06c6c;
            color: white;
        }
        td img {
            border-radius: 50%;
        }
        button {
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
            background-color: #f06c6c;
            color: white;
            cursor: pointer;
        }
        button:hover {
            background-color: #f8e4e4;
            color: black;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<main>
    <table>
        <tr>
            <th>用户ID</th>
            <th>头像</th>
            <th>用户名</th>
            <th>密码</th>
            <th>身份</th>
            <th>操作</th>
        </tr>
        <%
            for (User u : users) {
        %>
            <tr>
                <td><%= u.getUid() %></td>
                <td><img src="image-servlet?id=<%= u.getUid() %>&type=user" style="height: 50px; width: 50px; border-radius: 50%; " /></td>
                <td><%= u.getUname() %></td>
                <td>********</td>
                <td><%= u.getRole() == User.Role.ADMIN ? "管理员" : "普通用户" %></td>
                <td>
                    <button onclick="window.location.href='view-user-servlet?uid=<%= u.getUid() %>'">修改</button>
                    <button onclick="window.location.href='delete-user-servlet?uid=<%= u.getUid() %>'">删除</button>
                </td>
            </tr>
        <%
            }
        %>
    </table>
</main>
</body>
</html>
