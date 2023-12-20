<%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/17
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="system.bookcomment.model.User" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <title>书籍添加</title>
    <style>
        body {
            font-family: MiSans, sans-serif;
            background-color: #f0f0f0;
        }
        .content {
            display: flex;
            justify-content: center;
            padding: 50px;
            background-color: #f8f9fa;
        }
        .box {
            width: 800px;
            padding: 20px 50px;
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .box h3 {
            text-align: center;
            margin-bottom: 20px;
        }
        .box table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 10px;
        }
        .box table input,textarea {
            font-size: 16px;
        }

        .box input[type="text"], .box input[type="number"], .box input[type="date"], .box textarea {
            width: 100%;
            padding: 5px;
            border: 1px solid #ddd;
            border-radius: 3px;
            box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
        }
        .box button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 3px;
            background-color: #f06c6c;
            color: white;
            cursor: pointer;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .box button:hover {
            background-color: #f8e4e4;
            color: black;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<main>
    <div class="content">
        <div class="box">
            <h3>书籍添加</h3>
            <form action="add-book-servlet" method="post" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td>书名：</td>
                        <td><input type="text" name="bname" required></td>
                    </tr>
                    <tr>
                        <td>作者：</td>
                        <td><input type="text" name="bauthor" required></td>
                    </tr>
                    <tr>
                        <td>出版社：</td>
                        <td><input type="text" name="publisher" required></td>
                    </tr>
                    <tr>
                        <td>出版日期：</td>
                        <td><input type="date" name="publishDate" required></td>
                    </tr>
                    <tr>
                        <td>封面：</td>
                        <td><input type="file" name="cover"></td>
                    </tr>
                    <tr>
                        <td>简介：</td>
                        <td><textarea name="binfo" cols="30" rows="10"></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <button type="submit">添加</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>
</body>
</html>
