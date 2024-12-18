const prompt = require('prompt-sync')();

const pessoa = {
    nome: "",
    idade: 0,
    localidade: ""
}

const pessoas = []

while (true) {
    let op = prompt("Deseja adicionar uma pessoa? S/N: ")
    if (op != "n" && op != "N") {
        pessoas.push(inserirPessoas())
        console.log(pessoas)
    } else{
        console.log("A sair do programa...")
        break
    }
}

function inserirPessoas() {
    let datos
    // creamos un nuevo objeto, asi no modificamos el existente
    const temp = {}
    for (let key in pessoa) {
        datos = prompt(`${key}: `)
        temp[key] = datos
    }
    return temp
}