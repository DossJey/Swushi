<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SWUSHI HOMEPAGE</title>

    <link rel="stylesheet" href="./css/header.style/homepage.css" type="text/css">
    <link rel="stylesheet" href="./css/header.style/carousel.css" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="./css/header.style/header.css" type="text/css">
    <script src="WebContent/js/slideshow.js"></script>
    <script src="https://kit.fontawesome.com/00580d2f0a.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%@include file="./WebContent/header.jsp" %>

</head>

<body>

<div class="slide-container">

    <div class="slideshow">

        <div id="im1" class="slide fade">
            <img src="./WebContent/images/immagine1.jpg" class="slide-imm">
            <div class="food-des">
                <h1>MIGLIORE ESPERIENZA SUSHI</h1>
                <h3>Il miglior sushi che potrete mangiare.</h3></div>
        </div>

        <div class="slide fade">
            <img src="./WebContent/images/immagine2.webp" id="im2" class="slide-imm">
            <div class="food-des">
                <h1>SUSHI SUBLIME</h1>
                <h3>Assaggia il sapore della vera cucina giapponese.</h3></div>
        </div>
        <div class="slide fade">
            <img src="./WebContent/images/immagine3.jpg" id="im3" class="slide-imm">
            <div class="food-des">
                <h1>I MIGLIORI CHEFS</h1>
                <h3>Con noi i migliori professionisti di sushi.</h3></div>
        </div>
    </div>
</div>

<div class="prev" onclick="pushSlide(-1)"><i class="fa-solid fa-angle-left"></i></div>
<div class="next" onclick="pushSlide(1)"><i class="fa-solid fa-angle-right"></i></div>
</div>


<div class="visitus">
    <div class="visit-text">
        <h1>VIENI A TROVARCI</h1><br>
        <h2>Via Ferrante 2</h2>
        <h2>swushirestaurant@gmail.com</h2>
        <h2>ORARIO DI APERTURA : </h2><br><br>
        <h3>Lunedì-Venerdì 11.00  - 23.00 </h3>
        <h3>Sabato-Domenica 12.00  - 0.00 </h3>
    </div>
    <div class="visit-image">
        <img style="object-fit: cover; object-position: center" src="./WebContent/images/sake.jpg" height="100%"
             width="100%">
    </div>

</div>

<div class="book">
    <div class="immagine">
        <img style="object-fit: cover; object-position: center"  id="prenota_imm" src="./WebContent/images/tables.jpg" height="100%"
             width="100%">
    </div>

    <form action="PrenotazioneServlet" method="get">
    <div class="book-in">
        <div class="book-text">
            BOOK
        </div>
        <div class="infos">
            <div class="infos1">
                <select id="fname1" name="persone">
                    <option value="1">1 Person</option>
                    <option value="2">2 Persons</option>
                    <option value="3">3 Persons</option>
                    <option value="4">4 Persons</option>
                    <option value="5">5 Persons</option>
                    <option value="6">6 Persons</option>
                    <option value="7">7 Persons</option>
                    <option value="8">8 Persons</option>
                    <option value="9">9 Persons</option>
                    <option value="10">10 Persons</option>
                </select>
                <input type="date" id="fname2" name="giorno">
                <input type="text" id="fname3" name="ora" placeholder="Specifica l'ora">
            </div>
            <div class="infos2">
                <input type="text" id="fname4" name="nome" placeholder="Cognome">
                <input type="text"  id="fname5" name="email" placeholder="Email">
                <input type="text" id="fname6" name="cellulare" placeholder="Telefono">
            </div>



        </div>
         <div class="pulsante-container">
            <button type="submit" id="submit-book">SUBMIT</button>
        </div>

    </div>

    </form>
</div>
<%@include file="./WebContent/footer.jsp" %>

</body>
</html>