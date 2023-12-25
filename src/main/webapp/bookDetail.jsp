
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/17
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="system.bookcomment.model.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="system.bookcomment.model.Book" %>
<%@ page import="system.bookcomment.model.User" %>
<jsp:useBean id="user" class="system.bookcomment.model.User" scope="session" />
<jsp:useBean id="book" class="system.bookcomment.model.Book" scope="request"/>
<jsp:useBean id="comments" class="java.util.ArrayList" scope="request"/>
<%
    ArrayList<Comment> commentNew = (ArrayList<Comment>) request.getAttribute("comments");
    int rating = (int) request.getAttribute("rating");
%>
<!DOCTYPE html>
<html>
<head>
    <title>读书评论网-<%= book.getBname()%></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .content {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            background-color: #f8f9fa;
        }
        .book-info {
            width: 70%;
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
        .book-info h3, .book-info p {
            margin: 0 0 10px 0;
        }

        .comment-content {
            width: 60%;
            padding: 20px;
            display: flex;
            flex-direction: column;
            background-color: white;
            border-radius: .5rem;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            align-items: center;
            margin-top: 20px;
        }

        .comment-form {
            width: 90%;
            border-radius: .5rem;
            border: 2px solid #d0d7de;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: white;
            padding: 10px;
            margin: 10px;
        }

        .comment-form form {
            display: flex;
            flex-direction: column;
        }

        .comment-form textarea {
            resize: none;
            border: 1px solid #d0d7de;
            border-radius: .25rem;
            background-color: #f6f8fa;
            min-height: 80px;
            padding: 5px;
            margin-bottom: 10px;
        }

        .comment-form button {
            width: 100px;
            border-radius: .25rem;
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
        }

        .comments {
            width: 90%;
            display: flex;
            flex-direction: column;
        }

        .comment {
            border-radius: .5rem;
            border: 2px solid #d0d7de;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: white;
            padding: 10px;
            margin: 10px;
            display: flex;
            flex-direction: column;
        }

        .comment:hover {
            transform: scale(1.02);
        }

        .comment-header {
            display: flex;
            flex-direction: row;
        }

        .comment-header img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
        }

        .comment-header h3 {
            margin: 0;
            align-self: center;
        }

        .comment-footer {

            background-color: #f6f8fa;
            padding: 10px;
        }
        .comment-footer form {
            display: flex;
            flex-direction: row;
            align-items: center;
        }
        .comment-footer textarea {
            flex-grow: 1;
            resize: none;
            border: 1px solid #d0d7de;
            border-radius: .25rem;
            background-color: white;
            padding: 5px;
            margin-right: 10px;

        }
        .comment-footer button {
            width: 100px;
            border-radius: .25rem;
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
        }

        .follow-comment {
            width: 90%;
            margin-top: 0;
            margin-left: 5%;
        }

        /*.comment-content {*/
        /*    flex-grow: 1;*/
        /*}*/
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<main>
    <div class="content">
        <div class="book-info">
            <img src="image-servlet?id=${book.bid}&type=book" style="width: 400px"  alt="封面"/>
            <h3><%= book.getBname() %></h3>
            <p>评分： <%= rating / 10 + "." + rating % 10 %></p>
            <p>作者：<%= book.getBauthor() %></p>
            <p>出版商：<%= book.getPublisher() %></p>
            <p>出版时间：<%= book.getPublishDate() %></p>
            <p>简介：<%= book.getBinfo() %></p>
        </div>
        <div class="comment-content">
            <h2>${comments.size()}条评论</h2>
            <c:if test="${user != null && user.uid != 0}">
                <div class="comment-form">
                    你为这本书打分：
                    <form action="submit-rating-servlet" method="post">
                        <input type="hidden" name="bid" value="${book.bid}">
                        <input type="hidden" name="uid" value="${user.uid}">
                        <select name="rating" style="width: 100px; font-size: 14px;">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5" selected>5</option>
                        </select>
                        <button type="submit">评分</button>
                    </form>
                </div>
                <div class="comment-form">
                    <form action="comment-comment-servlet" method="post">
                        <input type="hidden" name="bid" value="${book.bid}">
                        <input type="hidden" name="uid" value="${user.uid}">
                        <input type="hidden" name="parentid" value="0">
                        <textarea name="content" placeholder="写下你的评论..."  ></textarea>
                        <button type="submit">发布</button>
                    </form>
                </div>
            </c:if>
            <div class="comments">
                <%
                    for (Comment pc : commentNew) {
                        if (pc.getParentid() == 0) {
                %>
                <div class="comment">
                    <div class="comment-header">
                        <img src="image-servlet?id=<%= pc.getUid() %>&type=user" alt="用户头像">
                        <h3><%= pc.getDate() %></h3>
                    </div>
                    <p><%= pc.getContent() %></p>
                    <div class="comment-footer">
                        <form action="comment-comment-servlet" method="post">
                            <input type="hidden" name="bid" value="${book.bid}">
                            <input type="hidden" name="uid" value="${user.uid}">
                            <input type="hidden" name="parentid" value="<%= pc.getCid() %>">
                            <textarea name="content" placeholder="回复"  ></textarea>
                            <button type="submit">回复</button>
                        </form>
                    </div>

                </div>
                <%
                    for (Comment cc : commentNew) {
                        if (cc.getParentid() == pc.getCid()) {
                %>
                <div class="comment follow-comment">
                    <div class="comment-header">
                        <img src="image-servlet?id=<%= pc.getUid() %>&type=user" alt="用户头像">
                        <h3><%= pc.getDate() %></h3>
                    </div>
                    <p><%= cc.getContent() %></p>
                </div>
                <%
                                }
                            }
                        }
                    }
                %>
            </div>
        </div>
    </div>
</main>
</body>
</html>
