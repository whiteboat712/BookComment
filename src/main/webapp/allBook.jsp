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
<%@ page import="system.bookcomment.model.Book" %>
<%@ page import="system.bookcomment.dao.BookDao" %>
<jsp:useBean id="user" class="system.bookcomment.model.User" scope="session" />
<%
    BookDao bookDao = new BookDao();
    List<Book> books = bookDao.getAllBooks();
%>
<!DOCTYPE html>
<html>
<head>
    <title>所有书籍</title>
    <style>
        body {
            font-family: "Microsoft YaHei UI", sans-serif;
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
            <th>书籍ID</th>
            <th>封面</th>
            <th>书名</th>
            <th>作者</th>
            <th>出版时间</th>
            <th>出版社</th>
            <th>操作</th>
        </tr>
        <%
            for (Book b : books) {
        %>
        <tr>
            <td><%= b.getBid() %></td>
            <td><img src="image-servlet?id=<%= b.getBid() %>&type=book" style="height: 100px; width: 60px;" /></td>
            <td><%= b.getBname() %></td>
            <td><%= b.getBauthor() %></td>
            <td><%= b.getPublishDate() %></td>
            <td><%= b.getPublisher() %></td>
            <td>
                <button onclick="window.location.href='bookDetailEdit.jsp?bid=<%= b.getBid() %>'">修改</button>
                <button onclick="window.location.href='delete-book-servlet?bid=<%= b.getBid() %>'">删除</button>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</main>
</body>
</html>
