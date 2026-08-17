// Procura o formulário pelo ID
const loginForm = document.getElementById("loginForm");

// Procura o elemento onde mostraremos mensagens de erro
const mensagemErro = document.getElementById("mensagemErro");


// Detecta quando o formulário for enviado
loginForm.addEventListener("submit", function(event) {

    // Impede que o navegador recarregue a página
    event.preventDefault();


    // Pega o valor digitado no campo de e-mail
    const email = document.getElementById("email").value;


    // Pega o valor digitado no campo de senha
    const senha = document.getElementById("senha").value;


    // Verifica se os campos estão preenchidos
    if (email === "" || senha === "") {

        mensagemErro.textContent = "Preencha todos os campos.";

        return;
    }


    // Apenas para TESTE.
    // Ainda não estamos usando o banco.
    if (email === "admin@email.com" && senha === "123456") {

        mensagemErro.textContent = "";

        alert("Login realizado com sucesso!");

        // Vai para a Home
        window.location.href = "pages/home.html";

    } else {

        mensagemErro.textContent =
            "E-mail ou senha incorretos.";

    }

});