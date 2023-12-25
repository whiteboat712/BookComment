<%--
  Created by IntelliJ IDEA.
  User: 123456
  Date: 2023/12/16
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <style>
        body {
            font-family: MiSans, sans-serif;
            margin: 0;
            padding: 0;
            background: #66ccff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            width: 300px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 12px;
            background-color: white;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="password"] {
            width: 90%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #f06c6c;
            color: white;
            cursor: pointer;
        }
        button:hover {
            background-color: #f8e4e4;
        }
        .error-message {
            color: red;
        }
    </style>
</head>
<body>
    <div>
        <form action="login-servlet" method="post">
            <h1>登录</h1>
            <div class="form-group">
                <label for="uid">账户：</label>
                <input type="text" id="uid" name="uid" placeholder="输入你的账户">
            </div>
            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" id="password" name="password" placeholder="输入你的密码">
            </div>
            <div class="form-group">
                <label>身份：</label>
                <input type="radio" name="role" value="USER"> 用户
                <input type="radio" name="role" value="ADMIN"> 管理员
            </div>
            <div class="form-group">
                <button type="submit">登录</button>
            </div>
            <div class="form-group">
                <span class="error-message"></span>
            </div>
        </form>
    </div>
</body>
</html>
