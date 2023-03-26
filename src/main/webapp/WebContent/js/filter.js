$(document).ready(function(){

    $("#show").click(function () {
            $(".card").show();

        }
    );

    $("#sashimi").click(function () {

            $(".card").hide();
            $(".card.sashimi").show();
        }
    );
    $("#nigiri").click(function () {
            $(".card").hide();
            $(".card.nigiri").show();
        }
    );
    $("#chirashi").click(function () {
            $(".card").hide();
            $(".card.chirashi").show();
        }
    );
    $("#maki").click(function () {
            $(".card").hide();
            $(".card.maki").show();
        }
    );
    $("#uramaki").click(function () {
            $(".card").hide();
            $(".card.uramaki").show();
        }
    );
    $("#gio").click(function () {
            $(".card").hide();
            $(".card.gio").show();
        }
    );
});