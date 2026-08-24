const btnSair = document.getElementById("btnSair");


btnSair.addEventListener("click", function() {

    const confirmar = confirm(
        "Deseja realmente sair do Rental_Event?"
    );


    if (confirmar) {

        window.location.href = "../index.html";

    }

});
