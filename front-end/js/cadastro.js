const cadastroForm = document.getElementById("cadastroForm");

const mensagemErro = document.getElementById("mensagemErro");

const mensagemSucesso = document.getElementById("mensagemSucesso");


cadastroForm.addEventListener("submit", function(event) {

    event.preventDefault();


    const nome = document.getElementById("nome").value.trim();

    const cpf = document.getElementById("cpf").value.trim();

    const email = document.getElementById("email").value.trim();

    const telefone = document.getElementById("telefone").value.trim();

    const senha = document.getElementById("senha").value;

    const confirmarSenha =
        document.getElementById("confirmarSenha").value;


    mensagemErro.textContent = "";

    mensagemSucesso.textContent = "";


    if (senha !== confirmarSenha) {

        mensagemErro.textContent =
            "As senhas não são iguais.";

        return;
    }


    if (senha.length < 6) {

        mensagemErro.textContent =
            "A senha deve possuir pelo menos 6 caracteres.";

        return;
    }


    console.log("Nome:", nome);

    console.log("CPF:", cpf);

    console.log("E-mail:", email);

    console.log("Telefone:", telefone);

    console.log("Senha:", senha);


    mensagemSucesso.textContent =
        "Cadastro realizado com sucesso!";


    cadastroForm.reset();


    setTimeout(function() {

        window.location.href = "../index.html";

    }, 2000);

});