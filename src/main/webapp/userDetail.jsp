
<%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/17
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="system.bookcomment.model.User" %>
<jsp:useBean id="user" class="system.bookcomment.model.User" scope="session" />
<jsp:useBean id="orderUser" class="system.bookcomment.model.User" scope="request" />
<%
    User x = (User) session.getAttribute("user");
    if (request.getParameter("orderUser") != null) {
        x = (User) request.getAttribute("orderUser");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title><%= x.getUname() %>的个人页面</title>
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
        /*基本信息样式*/
        .user-info {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .user-info img {
            width: 300px;
            height: 300px;
            border-radius: 5%;
            margin-bottom: 20px;
        }
        .user-info table {
            margin: auto;
        }
        .user-info td {
            padding: 5px;
        }

        .user-info button {
            padding: 10px 20px;
            background-color: #f06c6c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }
        .user-info button:hover {
            background-color: #f8e4e4;
            color: black;
        }
        .button-group {
            display: flex;
            justify-content: space-between;
            width: 200px;
            margin-top: 20px;
        }
        .role {
            padding: 5px 10px;
            border-radius: 5px;
            color: white;
        }
        .role.admin {
            background-color: blue;
        }
        .role.user {
            background-color: green;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<main>
    <div class="user-info">
        <img src="image-servlet?id=<%= x.getUid() %>&type=user" alt="用户头像">
        <form action="update-user-servlet" method="post" enctype="multipart/form-data">
            <input type="file" name="avatar" id="avatar" accept="image/*" disabled>
            <table>
                <tr id="uid-row">
                    <td>UID</td>
                    <td><input type="text" name="uid" id="uid" value="<%= x.getUid() %>" readonly></td>
                </tr>
                <tr id="username-row">
                    <td>用户名：</td>
                    <td><input type="text" name="uname" id="uname" value="<%= x.getUname() %>" disabled></td>
                </tr>
                <tr id="password-row">
                    <td>密码：</td>
                    <td><input type="password" name="password" id="password" value="<%= x.getPassword() %>" disabled></td>
                </tr>
                <tr>
                    <td>身份：</td>
                    <td>
                        <input type="hidden" name="role" id="role" value="<%= x.getRole() %>">
                        <span class="role <%= x.getRole() == User.Role.ADMIN ? "admin" : "user" %>">
                            <%= x.getRole() == User.Role.ADMIN ? "管理员" : "普通用户" %>
                        </span>
                    </td>
                </tr>
            </table>
            <div class="button-group">
                <button type="button" onclick="editRow('username-row');editRow('password-row');editAvatar()">编辑</button>
                <button type="submit" value="保存" style="display: none;">保存</button>
            </div>
        </form>
    </div>
</main>
</body>
<script>
    function editRow(rowId) {
        var row = document.getElementById(rowId);
        var input = row.getElementsByTagName('input')[0];
        input.disabled = false;
        document.querySelector('button[value="保存"]').style.display = 'block';
    }

    function editAvatar() {
        var avatarInput = document.querySelector('input[type="file"]');
        avatarInput.disabled = false;
    }
</script>
</html>
