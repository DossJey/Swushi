function formvalidation(){

    var pass_pattern = /^(?=.*\d).{8,}$/;
    var email_pattern = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;


    if(!email.match(email_pattern)){
        document.getElementById("msg0").innerHTML = "&#10006";
        document.getElementById("msg0").style.color = "red";
    }
    else{
        document.getElementById("msg0").innerHTML = "&#10003";
        document.getElementById("msg0").style.color = "green";
    }


    if((!email.match(email_pattern))||(!password.match(pass_pattern))){

       // document.getElementById("msg0").innerHTML = "&#10006";
        document.getElementById("register-btn").disabled = true;
        //document.getElementById("msg0").style.color = "red";
    }
    else{
       // document.getElementById("msg0").innerHTML = "&#10003";
        document.getElementById("register-btn").disabled = false;
        //document.getElementById("msg0").style.color = "green";
    }
}