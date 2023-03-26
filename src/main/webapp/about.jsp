<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="./css/header.style/about.css" type="text/css">
    <script src="https://kit.fontawesome.com/00580d2f0a.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%@include file="WebContent/header.jsp" %>

    <title>ABOUT US</title>
</head>
<body>

<h1>OUR STAFF</h1>
<div class="about-container">

    <div class="about">
        <img src="./WebContent/images/simone.jpg" class="chef">
        <div class="container">
            <h1>Sumika Tanayu </h1>
            <h2>Head Chef</h2>
        </div>
    </div>


    <div class="about">
        <img src="./WebContent/images/chef2.png" class="chef">
        <div class="container">
            <h1>Ichiri Yorika</h1>
            <h2>Sous Chef</h2>
        </div>
    </div>

    <div class="about">
        <img src="./WebContent/images/chef3.jpg" class="chef">
        <div class="container">
            <h1>Sotho Kagashi</h1>
            <h2>Sushi Chef</h2>
        </div>
    </div>

</div>


    <div id="google-maps">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3022.8981413361203!2d14.606725915242563!3d40.74226677932852!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133bbed685d5fda3%3A0x1fb76d15563119f8!2sVia%20Ferrante%2C%202%2C%2084016%20Pagani%20SA!5e0!3m2!1sit!2sit!4v1650899459336!5m2!1sit!2sit" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        <h3>Per qualsiasi informazioni siamo reperibili ai seguenti recapiti
            <br>
            <i class="fa fa-phone"> </i> +39 380 171 7673 <br>
            <i class="fa fa-envelope-o"> </i> j.gambardella2@studenti.unisa.it

        </h3>
    </div>



<%@include file="WebContent/footer.jsp" %>
</body>
</html>
