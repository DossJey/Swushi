<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/header.style/register.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="WebContent/js/formvalidation.js"></script>

    <%@include file="WebContent/header.jsp" %>
    <title>REGISTRAZIONE</title>
</head>
<body>

<div class="register">
    <img src="WebContent/images/food/rolls.jpg"  class="img-register">


    <div class="register-form">


        <form action="RegisterServlet" method="post">
        <h1>Register</h1>

            <input type="text" id="nome" placeholder="Nome" name="Nome" number="10">
            <input type="text" id="cognome" placeholder="Cognome" name="Cognome" number="10">
            <input type="text" id="email" onkeyup="formvalidation()" placeholder="email" name="Email" number="10">
            <span id="msg0" name="result" style="color:red"></span>
            <input type="text" id="username" onkeyup="verifyUsername(this.value)" placeholder="Username" name="Username" number="10">
            <span id="msg" name="result" style="color:red"></span>
             <input type="password" id="password" onkeyup="formvalidation()" placeholder="*******" name="Password">
            <button type="submit" id="register-btn">REGISTER</button>

        </form>

    </div>

</div>

<%@include file="WebContent/footer.jsp" %>

<script>

    function verifyUsername(str){
            console.log(str);
        var xmlHttpReq = new XMLHttpRequest();

        xmlHttpReq.responseType = 'json';

        xmlHttpReq.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {   //request finished and response is ready

                    console.log(this.response);
               if(this.response.exists){
                   document.getElementById("msg").innerHTML = "&#10006";
                   document.getElementById("register-btn").disabled = true;
                   document.getElementById("msg").style.color = "red";

               }
               else{

                   document.getElementById("msg").innerHTML = "&#10003";
                   document.getElementById("msg").style.color = "green";
                   document.getElementById("register-btn").disabled = false;
               }

            }
        }

        xmlHttpReq.open("GET", "CheckUsernameServlet?q="+encodeURIComponent(str), true);
        xmlHttpReq.send();

    }


</script>


</body>
</html>
