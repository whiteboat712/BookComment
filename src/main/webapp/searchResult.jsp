<%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/17
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="system.bookcomment.model.User" %>
<%@ page import="system.bookcomment.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="books" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
    <title>搜索结果</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .content {
            display: flex;
            flex-wrap: nowrap;
            flex-direction: column;
            justify-content: space-around;
            padding: 10px;
            width: 70%;
            margin: auto;
            background-color: #f8f9fa;
        }
        .box {
            display: flex;
            flex-direction: row;
            width: auto;
            height: 200px;
            margin: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            background-color: white;
            padding: 10px;
        }
        .box img {
            width: 200px;
            height: 200px;
            margin-right: 10px;
        }
        .box div {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }
        .box h3, .box p {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<main>
    <div class="content">
        <h1>搜索结果</h1>
        <c:forEach items="${books}" var="book">
            <div class="box">
                <a href="view-book-servlet?bid=${book.getBid()}">
                    <img src="image-servlet?id=${book.getBid()}&type=book" />
                </a>
                <div>
                    <h3>${book.getBname()}</h3>
                    <p>${book.getBauthor()}</p>
                    <p>${book.getPublishDate()}</p>
                    <p>${book.getPublisher()}</p>
<%--                    <p>${book.getBinfo()}</p>--%>
                </div>
            </div>
        </c:forEach>
        <!-- 更多的方块... -->
    </div>
</main>
</body>
</html>
