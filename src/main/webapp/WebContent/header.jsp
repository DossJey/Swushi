<%@ page import="model.*"%>
<html>
<head>
    <link rel="stylesheet" href="./css/header.style/header.css" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body onload="textDec()">
<div class="header">

    <% CustomerBean customer = (CustomerBean) request.getSession().getAttribute("customer"); %>
    <% if((customer!=null)&&(customer.getIsAdmin()==1)){%>

    <div class="element" id="amministratore"><a href="amministratore.jsp">ADMIN</a></div>
    <% } %>

    <div class="element" id="menu"><a href="MenuServlet">MENU'</a></div>
    <div class="element" id="about"><a href="about.jsp">ABOUT US</a></div>
    <div class="titolo" id="swushi"><a href="index.jsp">SWUSHI</a></div>
    <div class="element" id="carrello"><a href="cart.jsp">CARRELLO</a></div>
    <div class="element" id="profilo">

        <% if(customer==null){ %>
        <btn class="profile">PROFILO</btn>
        <div class = "dropdown-content">
            <a href="login.jsp">SIGN IN</a>
            <a href="register.jsp">REGISTER</a>
         </div>
        <% } %>

        <% if(customer!=null){%>

        <btn class="profile">Ciao <%= customer.getUsername()%> </btn>
        <div class = "dropdown-content">
            <a href="LogoutServlet">LOGOUT</a>
        </div>

        <%}%>
    </div>

</div>

<script>
    function textDec(){
        var path = window.location.pathname;
        console.log(path);
        var e;

        if(path.includes("about")){
            e = document.getElementById("about");
        }
        else if(path.includes("index")){
            e = document.getElementById("swushi");
        }
        else if(path.includes("Menu")){
            e = document.getElementById("menu");
        }
        else if(path.includes("profilo")){
            e = document.getElementById("profilo");
        }
        else if(path.includes("cart")){
            e = document.getElementById("carrello");
        }
        e.style.textDecoration = "underline #C9AB82 5px";
    }
</script>


</body>
</html>

