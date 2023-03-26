<%--
  Created by IntelliJ IDEA.
  User: golum
  Date: 18/06/2022
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/header.style/acquisto.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <%@include file="WebContent/header.jsp" %>

</head>
<body>

<div class="register">
    <img src="WebContent/images/food/rolls.jpg"  class="img-register">
<div class="register-form">

    <form action="AcquistoServlet" method="post">
        <h1>Acquista</h1>
        <input type="text" id="nome" placeholder="Nome" name="Nome" number="10">
        <input type="text" id="cognome" placeholder="Cognome" name="Cognome" number="10">
        <input type="text" id="indirizzo" placeholder="Indirizzo" name="Indirizzo" number="10">
        <input type="text" id="paycard" placeholder="Numero Carta" name="paycard">
        <input type="text" id="cvv" placeholder="CVV" name="cvv" maxlength="3">
        <span id="msg" name="result" style="color:red"></span>

        <button type="submit" id="register-btn">ACQUISTA</button>
    </form>

</div>

</div>

<%@include file="WebContent/footer.jsp" %>

</body>
</html>
