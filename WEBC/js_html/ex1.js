const nome = document.getElementById("nome")
const registarBTN = document.getElementById("registarBTN")
const form = document.querySelector(".form")

function defineActions() {
    // // registrar
    // registarBTN.addEventListener("click", function(e){
    //     console.log(nome.value)
    // })

    form.addEventListener("submit", function (e) {
        e.preventDefault()
        if (nome.value === "") {
            alert("Campo vazio")
            return
        } else {
            alert("Nome: " + nome.value)
        }
    })
}

defineActions()