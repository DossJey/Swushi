<%--
  Created by IntelliJ IDEA.
  User: golum
  Date: 23/06/2022
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/header.style/login.css">
    <link rel="stylesheet" href="./css/header.style/amministratore.css"
    <%@include file="./WebContent/header.jsp" %>
    <title>PAGINA AMMINISTRATORE</title>
</head>
<body>

    <%
        CustomerBean customerBean = (CustomerBean)request.getSession().getAttribute("customer");


        if(customerBean.getIsAdmin() == 1){
    %>

    <div class = opzioni>


        <a class="opzione"  href="VisualizzaClientiServlet">Visualizza clienti</a>



        <a class="opzione" href="VisualizzaPrenotazioniServlet">Visualizza prenotazioni</a>



        <a class="opzione" href="MenuServlet">Visualizza prodotti</a>


    </div>

<%}%>

    <%@include file="./WebContent/footer.jsp" %>
</body>
</html>
