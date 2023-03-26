<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: golum
  Date: 24/06/2022
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/header.style/cart.css">
    <link rel="stylesheet" href="./css/header.style/prenotazioni.css">
    <%@include file="WebContent/header.jsp" %>
    <title>PRENOTAZIONI</title>

</head>
<body>

    <% CustomerBean customerBean = (CustomerBean)request.getSession().getAttribute("customer");

       if(customerBean.getIsAdmin()==1){

    %>

<div class = "prod-list">

    <% ArrayList<PrenotazioneBean> lista = new ArrayList<PrenotazioneBean>();


        if(request.getSession().getAttribute("prenotazioni")!=null) {
            lista = (ArrayList<PrenotazioneBean>) request.getSession().getAttribute("prenotazioni");
        }
        else{
            System.out.println("La lista è vuota");
        }
    %>

    <% for(PrenotazioneBean prenotazioneBean : lista){ %>

    <div class = single-prod>

        <div class = informazioni>
        <p><%= prenotazioneBean.getEmail()%></p>
        </div>


        <div class="informazioni">
            <p style="width:150px"> <%= prenotazioneBean.getGiorno()%></p>
            <p style="width:50%"> <%= prenotazioneBean.getOra()%></p>
            <p style="width:50%">PERSONE: <%= prenotazioneBean.getPersone()%></p>
        </div>
        <div class="informazioni">
            <p style="width:50%">NOME: <%= prenotazioneBean.getNome()%></p>
        </div>



    </div>
    <% } %>
</div>

<% } %>

<%@include file="./WebContent/footer.jsp" %>



</body>
</html>
