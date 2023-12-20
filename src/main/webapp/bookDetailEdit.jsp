<%@ page import="system.bookcomment.dao.BookDao" %>
<%@ page import="system.bookcomment.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/17
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    BookDao bookDao = new BookDao();
    Book book = bookDao.getBookById(Integer.parseInt(request.getParameter("bid")));
%>
<!DOCTYPE html>
<html>
<head>
    <title>书籍修改</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .content {
            display: flex;
            justify-content: center;
            padding: 20px;
            background-color: #f8f9fa;
        }
        .book-info {
            width: 60%;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .book-info img {
            width: 100%;
            height: auto;
            margin-bottom: 20px;
        }
        .book-info table {
            width: 100%;
        }
        .book-info input[type="text"], .book-info input[type="date"], .book-info textarea {
            width: 100%;
            padding: 5px;
            border: 1px solid #ddd;
            border-radius: 3px;
            box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
        }
        .book-info textarea {
            min-height: 200px;
        }
        .book-info button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 3px;
            background-color: #f06c6c;
            color: white;
            cursor: pointer;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .book-info button:hover {
            background-color: #f8e4e4;
            color: black;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="content">
        <div class="book-info">
            <img src="image-servlet?id=<%= book.getBid() %>&type=book" style="height: 600px; width: auto;" />
            <form action="update-book-servlet" method="post" enctype="multipart/form-data">
                <input type="file" name="cover" id="cover" accept="image/*">
                <table>
                    <tr>
                        <td>书籍ID</td>
                        <td><input type="text" name="bid" id="bid" value="<%= book.getBid() %>" readonly></td>
                    </tr>
                    <tr>
                        <td>书籍名称</td>
                        <td><input type="text" name="bname" id="bname" value="<%= book.getBname() %>"></td>
                    </tr>
                    <tr>
                        <td>作者</td>
                        <td><input type="text" name="bauthor" id="bauthor" value="<%= book.getBauthor() %>"></td>
                    </tr>
                    <tr>
                        <td>出版时间</td>
                        <td><input type="date" name="publishDate" id="publishDate" value="<%= book.getPublishDate() %>"></td>
                    </tr>
                    <tr>
                        <td>出版社</td>
                        <td><input type="text" name="publisher" id="publisher" value="<%= book.getPublisher() %>"></td>
                    </tr>
                    <tr>
                        <td>书籍简介</td>
                        <td><textarea type="text" name="binfo" id="binfo"><%= book.getBinfo() %></textarea></td>
                    </tr>

                </table>
                <div class="button-group">
                    <button type="submit" value="保存">保存</button>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
