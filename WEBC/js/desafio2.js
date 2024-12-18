const prompt = require('prompt-sync')();
const notas = []
let n
do {
    // Menu
    console.log("1- Visualizar")
    console.log("2- Inserir")
    if (notas.length != 0) {
        console.log("3- Pesquisar")
        console.log("4- Remover")
        console.log("5- Estatísticas")
    }
    console.log("6- Sair")
    n = Number(prompt("Opção: "))
    switch (n) {
        case 1:
            mostrarValores(notas)
            break
        case 2:
            inserirValores(notas)
            break
        case 3:
            pesquisarValores(notas)
            break
        case 4:
            removerValores(notas)
            break
        case 5:
            estatisticasValores(notas)
            break
        case 6:
            console.log("A sair do programa...")
            break
        default:
            console.log("Opção invalida!\n")
    }
} while (n != 6)

function mostrarValores(vec) {
    if (vec.length != 0) console.log("Notas: " + vec + "\n")
    else console.log("Não há notas para mostrar\n")
}

function inserirValores(vec) {
    while (true) {
        let valor = Number(prompt("Insira a nota: "))
        if (!isNaN(valor)) {
            vec.push(valor)
            console.log(`Nota ${valor} inserida com sucesso!\n`)
            break
        } else {
            console.log("A nota deve ser númerica.")
        }
    }
}

function pesquisarValores(vec) {
    let valor = Number(prompt("Insira a nota a pesquisar: "))
    console.log(vec.includes(valor))
    console.log("\n")
}

function removerValores(vec) {
    while (true) {
        let valor = Number(prompt("Insira a nota a remover: "))
        if (!isNaN(valor)) {
            if (vec.includes(valor)) {
                const index = vec.indexOf(valor)
                vec.splice(index, 1)
                console.log(`Nota ${valor} removida com sucesso!\n`)
                break
            } else {
                console.log("Não existe essa nota\n")
            }
        } else {
            console.log("Debe inserir um número.\n")
        }
    }
}

function estatisticasValores(vec) {
    console.log("\nEstatísticas")
    console.log(`Max: ${Math.max(...vec)}`)
    console.log(`Min: ${Math.min(...vec)}`)
    // Media dos valores
    let soma = 0
    for (let i of vec) {
        soma += i
    }
    console.log(`Media: ${(soma / vec.length).toFixed(2)}\n`)
}