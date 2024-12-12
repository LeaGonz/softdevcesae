let num1 = 0
let num2 = 0
let opera = ""
// let nome = prompt("Nome")

function nomes() {
    document.getElementById("nome").innerText = "test"
}

function adiciona(n) {
    if (num1 == 0) {
        num1 = n
        document.getElementById("v1").innerText = num1
    } else {
        num2 = n
        document.getElementById("v2").innerText = num2
    }
}

function operador(op) {
    opera = op
    document.getElementById("operadores").innerText = op
}

function calculo() {
    if (opera === "+") {
        resultado = num1 + num2
    } else if (opera === "-") {
        resultado = num1 - num2
    } else if (opera === "*") {
        resultado = num1 * num2
    } else if (opera === "/") {
        resultado = num1 / num2
    }

    document.getElementById("resultado").innerText = "RESULTADO " + resultado

    num1 = 0
    num2 = 0
    opera = ""
}