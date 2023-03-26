<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: golum
  Date: 02/05/2022
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/header.style/cart.css">
    <%@include file="WebContent/header.jsp" %>

    <title>CARRELLO</title>
</head>
<body>

<div class="prod-list">


    <%
        CarrelloBean carrelloBean = (CarrelloBean)request.getSession().getAttribute("carrello");
        ArrayList<ProductcartBean> lista = new ArrayList<ProductcartBean>();
        double totale;
        if(request.getSession().getAttribute("totale")!=null) {
             totale = (double) request.getSession().getAttribute("totale");
        }
        else totale = 0;

        if(carrelloBean!=null) {
           lista = carrelloBean.getProducts();
        }
    %>


    <% for(ProductcartBean product : lista){ %>

    <div class="single-prod">
        <% if(product.getNome().equals("Sashimi")) { %>
        <img src="WebContent/images/food/sashimi.webp" class="food" style="width:120px; height:120px;">
        <% } %>

        <% if(product.getNome().equals("Nigiri")) { %>
        <img src="WebContent/images/food/nigiri.jpg" class="food" style="width:120px; height:120px;">
        <% } %>

        <% if(product.getNome().equals("Chirashi")) { %>
        <img src="WebContent/images/food/chirashi.webp" class="food" style="width:120px; height:120px;">
        <% } %>

        <% if(product.getNome().equals("Maki")) { %>
        <img src="WebContent/images/food/maki.jpg" class="food" style="width:120px; height:120px;">
        <% } %>

        <% if(product.getNome().equals("Uramaki")) { %>
        <img src="WebContent/images/food/uramaki.jpg" class="food" style="width:120px; height:120px;">
        <% } %>

        <% if(product.getNome().equals("Gio")) { %>
        <img src="WebContent/images/food/gio.jpg" class="food" style="width:120px; height:120px;">
        <% } %>




       <div class="informazioni">

        <p><%= product.getNome()%>: &nbsp</p>
        <p> <%= product.getDescrizione()%></p>
    </div>

    <p><%= product.getPrezzo() * product.getQuantita()%>€</p>

    </div>

    <% } %>


</div>

<div class="totale">
    <p>TOTALE : <%= totale %></p>
    <form action="VerificaLoginServlet" method="get">

        <input type="hidden" name="prezzotot">
        <button class="acquista" type="submit" value="Acquista">ACQUISTA</button>
    </form>

</div>

<%@include file="WebContent/footer.jsp" %>
</body>
</html>
