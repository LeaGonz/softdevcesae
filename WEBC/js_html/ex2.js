// variaveis html
const nome = document.getElementById("nome")
const apelido = document.getElementById("apelido")
const peso = document.getElementById("peso")
const altura = document.getElementById("altura")
const registarBTN = document.getElementById("registarBTN")
const form = document.querySelector(".form")
const listaPessoas = document.getElementById("listaPessoas"); // Contenedor específico

// variaveis JS
const pessoas = []

function limpar() {
    nome.value = ""
    apelido.value = ""
    peso.value = ""
    altura.value = ""
}
function adicionar() {
    const temp = {
        nome: nome.value,
        apelido: apelido.value,
        peso: peso.value,
        altura: altura.value
    }
    pessoas.push(temp)
}
function mostrar() {
    listaPessoas.innerHTML = "";
    for (let i = 0; i < pessoas.length; i++) {
        listaPessoas.innerHTML += `
            <div>
                <p>PESSOAS---------------------------</p>
                <p>Nome: ${pessoas[i].nome}</p>
                <p>Apelido: ${pessoas[i].apelido}</p>
                <p>Peso: ${pessoas[i].peso}</p>
                <p>Altura: ${pessoas[i].altura}</p>
                <p><button type="button" id="removerBTN" data-index="${i}">Remover ${pessoas[i].nome}</button></p>
                </div>
        `;
    }
    const removerBTN = document.getElementById("removerBTN")
    removerBTN.forEach(btn => {
        btn.addEventListener("click", function (e) {
            const index = btn.getAttribute("data-index"); // Obtiene el índice de la persona a eliminar
            pessoas.splice(index, 1); // Elimina la persona del array
            mostrar(); // Vuelve a mostrar las personas actualizadas
        });
    });
}
function principal() {
    registarBTN.addEventListener("click", function (e) {
        e.preventDefault()
        adicionar()
        mostrar()
        limpar()
    })
}

principal()
