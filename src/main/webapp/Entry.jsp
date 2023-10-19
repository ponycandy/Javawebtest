<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Management System</title>
</head>
<body>

<!--  <h1>这是一个管理系统的原型</h1>

 <h1>图形的例子</h1>
    <img src="image/pic.jpg" alt="Your Image">
     <h1>Welcome to My Sample JSP Page</h1>
    
    Link to your SampleServlet
    <a href="Sampleserv">Go to SampleServlet</a>
    
     <form action="Sampleserv" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        <input type="submit" value="Submit">
    </form> -->

    
    <h3 style="text-align: center">用户登录</h3>
        <form action="Loginservlet" method="post">
            <table border="1" cellpadding="10" style="margin: 0px auto">
                <tr>
                    <td align="center">账号</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td align="center">密码</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value="登录"/>
                        <input type="reset" value="重置"/>
                    </td>
                </tr>
            </table>
        </form>
    
</body>
</html>
