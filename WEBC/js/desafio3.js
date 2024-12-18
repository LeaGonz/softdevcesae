const prompt = require('prompt-sync')();

const multiplos5 = gerarNums()
for (let n of multiplos5) {
    console.log(n)
}

function gerarNums() {
    const temp = []
    for (let i = 0; i < 5; i++) {
        num = Math.floor(Math.random() * 51)
        if (num % 5 === 0) {
            temp.push(num)
        } else {
            i--
        }
    }
    return temp
}

const valores30 = valoresValidos()
console.log(valores30)
function valoresValidos() {
    const temp = []
    while (temp.length < 5) {
        for (let i = 0; i < 5; i++) {
            let n = Number(prompt(`Insira o valor ${i + 1}: `))
            if (n > 0 && n < 31) {
                temp.push(n)
            } else {
                console.log("Valor invalido, insira novamente.")
                i--
            }
        }
    }
    return temp
}