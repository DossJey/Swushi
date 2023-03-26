<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: golum
  Date: 24/06/2022
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/header.style/cart.css">
    <%@include file="WebContent/header.jsp" %>
    <title>CUSTOMERS</title>
</head>
<body>

    <% CustomerBean customerr = (CustomerBean)request.getSession().getAttribute("customer");


    if(customerr.getIsAdmin()==1){
    %>

    <div class = "prod-list">

       <% ArrayList<CustomerBean> lista = new ArrayList<CustomerBean>();

           if(request.getSession().getAttribute("customers")!=null) {
              lista = (ArrayList<CustomerBean>) request.getSession().getAttribute("customers");
           }
           else{
               System.out.println("La lista è vuota");
           }
       %>

        <% for(CustomerBean customerBean : lista){ %>

        <div class = single-prod>
        <p><%= customerBean.getUsername()%></p>

        <div class="informazioni">
            <p><%= customerBean.getEmail()%></p>
        </div>

        </div>
        <% } %>
       </div>

    <% } %>

<%@include file="./WebContent/footer.jsp" %>
</body>
</html>
