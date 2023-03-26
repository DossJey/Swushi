
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/header.style/login.css">
    <%@include file="WebContent/header.jsp" %>
    <title>LOGIN</title>
</head>
<body>
<div class="login">
     <img src="WebContent/images/food/rolls.jpg"  class="img-login">
    <div class="login-form">
        <form action="LoginServlet" method="post">
            <h1>Login</h1>

        <input type="text" id="username" placeholder="Username" name = "Username" number="10">
        <input type="password" id="password" placeholder="*******" name="Password">
        <button type="submit" id="login-btn">SIGN IN</button>

        </form>
    </div>
</div>
    <%@include file="WebContent/footer.jsp" %>
</body>
</html>
