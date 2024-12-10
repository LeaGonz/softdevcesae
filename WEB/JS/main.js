let num1 = 0
let num2 = 0
let opera = ""

function adiciona(n) {
    if (num1 == 0) {
        num1 = n
    } else {
        num2 = n
    }
}

function operador(op) {
    opera = op
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