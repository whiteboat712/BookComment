<%@ page import="system.bookcomment.model.User" %>
<%@ page import="system.bookcomment.model.Book" %>
<%@ page import="system.bookcomment.dao.BookDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="books" class="java.util.ArrayList" scope="session" />
<%
    BookDao bookDao = new BookDao();
    List<Book> tmp = bookDao.getAllBooks();
    request.setAttribute("books", tmp);
%>
<!DOCTYPE html>
<html>
<head>
    <title>书评网</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .content {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            padding: 10px;
            width: 70%;
            margin: auto;
            background-color: #f8f9fa;
        }
        .box {
            width: 200px;
            height: 350px;
            margin: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            background-color: white;
            padding: 10px;
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
        <c:forEach items="${books}" var="book">
            <div class="box">
                <a href="view-book-servlet?bid=${book.getBid()}">
                    <img src="image-servlet?id=${book.getBid()}&type=book" style="width: 200px;" alt="封面" />
                </a>
                <h3>${book.getBname()}</h3>
                <p>${book.getBauthor()}</p>
            </div>
        </c:forEach>
        <div class="box" style="width: 200px;">
            <img src="image-servlet" style="width: 200px;" />
            <h3>书名</h3>
            <p>作者</p>
        </div>
        <!-- 更多的方块... -->
    </div>
</main>
</body>
</html>