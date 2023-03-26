<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProductBean" %><%--
  Created by IntelliJ IDEA.
  User: golum
  Date: 26/04/2022
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="./css/header.style/menu.css" type="text/css">
    <script src="https://kit.fontawesome.com/00580d2f0a.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="WebContent/js/filter.js"></script>
    <%@include file="WebContent/header.jsp" %>

    <title>MENU</title>
</head>
<body>

<div class="filters" id="myBtnContainer">
    <button class="btn" id="show">SHOW ALL</button>
    <button class="btn" id="sashimi">SASHIMI</button>
    <button class="btn" id="nigiri">NIGIRI</button>
    <button class="btn" id="chirashi">CHIRASHI</button>
    <button class="btn" id="maki">MAKI</button>
    <button class="btn" id="uramaki">URAMAKI</button>
    <button class="btn" id="gio">GIO</button>
</div>


<div class="menu">
    <div class="menu-cont">

        <% if(request.getAttribute("products")!=null){ %>


        <% ArrayList<ProductBean>list =  (ArrayList<ProductBean>)request.getAttribute("products");
            for(ProductBean product : list){ %>

            <% if(product.getNome().equals("Sashimi")){ %>
            <div class = "card sashimi">
                <img src="WebContent/images/food/sashimi.webp" class="food">
            <% } %>
            <% if(product.getNome().equals("Nigiri")){ %>
            <div class = "card nigiri">
                <img src="WebContent/images/food/nigiri.jpg" class="food">
            <% } %>
            <% if(product.getNome().equals("Chirashi")){ %>
            <div class = "card chirashi">
                <img src="WebContent/images/food/chirashi.webp" class="food">
            <% } %>
            <% if(product.getNome().equals("Maki")){ %>
            <div class = "card maki">
                <img src="WebContent/images/food/maki.jpg" class="food">
            <% } %>
            <% if(product.getNome().equals("Uramaki")){ %>
            <div class = "card uramaki">
                <img src="WebContent/images/food/uramaki.jpg" class="food">
            <% } %>
            <% if(product.getNome().equals("Gio")){ %>
            <div class = "card gio">
                <img src="WebContent/images/food/gio.jpg" class="food">
            <% } %>


                <form action = "CarrelloServlet" method="get">

               <div class = "ingredients">


                    <input type="text" value="<%= product.getIdprod() %>" name="codice" style="display:none">
                   <h2 id="nomeprod" name ="Nome"><%= product.getNome()%></h2>
                   <h3 id="descrizioneprod" name="Description"><%=product.getDescrizione()%></h3>
                   <h3 id="prezzoprod" name="Prezzo"><%=product.getPrezzo()%>€</h3>
               </div>
               <div class="prices">
                   <input name = "quantita" type="number" min="1" max="" value="1">
               </div>
               <button type = "submit" class="add">ADD TO CART</button>

               </form>

           </div>

        <% } %>

        <%} %>

    </div>
</div>

        <%@include file="WebContent/footer.jsp" %>

<script>





</script>



</body>
</html>
