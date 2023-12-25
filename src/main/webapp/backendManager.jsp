<%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/17
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        main {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 90vh;
        }
        .func-block {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin-bottom: 20px;
        }
        .button-group {
            display: flex;
            justify-content: space-around;
            padding: 20px;
        }
        .button-group button {
            text-align: center;
            padding: 10px 20px;
            background-color: #f06c6c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin: 0 10px;
        }
        .button-group button:hover {
            background-color: #f8e4e4;
            color: black;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<main>
    <div class="func-block">
        <h1>增</h1>
        <div class="button-group">
            <button onclick="window.location.href='bookAdd.jsp'">添加书籍</button>
            <button onclick="window.location.href='userAdd.jsp'">添加用户</button>
            <button onclick="window.location.href='commentAdd.jsp'">添加评论</button>
        </div>
    </div>

    <div class="func-block">
        <h1>删</h1>
        <div class="button-group">
            <form action="delete-book-servlet" method="post">
                <input type="text" name="bid" placeholder="请输入书籍id">
                <button type="submit">删除书籍</button>
            </form>
            <form action="delete-user-servlet" method="post">
                <input type="text" name="uid" placeholder="请输入用户id">
                <button type="submit">删除用户</button>
            </form>
            <form action="delete-comment-servlet" method="post">
                <input type="text" name="cid" placeholder="请输入评论id">
                <button type="submit">删除评论</button>
            </form>
        </div>
    </div>

    <div class="func-block">
        <h1>查</h1>
        <div class="button-group">
            <form action="view-book-servlet" method="post">
                <input type="text" name="bid" placeholder="请输入书籍id">
                <button type="submit">查看书籍详情</button>
            </form>
            <form action="view-user-servlet" method="post">
                <input type="text" name="uid" placeholder="请输入用户id">
                <button type="submit">查看用户详情</button>
            </form>
        </div>
    </div>

    <div class="func-block">
        <div class="button-group">
            <button onclick="window.location.href='allUser.jsp'">查看所有用户</button>
            <button onclick="window.location.href='allBook.jsp'">查看所有书籍</button>
            <button onclick="window.location.href='allComment.jsp'">查看所有评论</button>
        </div>
    </div>

</main>
</body>
</html>
