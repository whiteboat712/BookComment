<%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/19
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="system.bookcomment.dao.CommentDao" %>
<%@ page import="system.bookcomment.model.Comment" %>
<jsp:useBean id="user" class="system.bookcomment.model.User" scope="session" />
<%
    CommentDao commentDao = new CommentDao();
    List<Comment> comments = commentDao.getAllComment();
%>
<!DOCTYPE html>
<html>
<head>
    <title>所有评论</title>
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
            <th>评论ID</th>
            <th>书籍ID</th>
            <th>用户ID</th>
            <th>评论内容</th>
            <th>评论时间</th>
            <th>操作</th>
        </tr>
        <%
            for (Comment c : comments) {
        %>
        <tr>
            <td><%= c.getCid() %></td>
            <td><%= c.getBid() %></td>
            <td><%= c.getUid() %></td>
            <td><%= c.getContent() %></td>
            <td><%= c.getDate() %></td>
            <td>
                <button onclick="window.location.href='delete-comment-servlet?cid=<%= c.getCid() %>'">删除</button>
            </td>
        </tr>
        <%
            }
        %>
    </table>

</main>
</body>
</html>
