const prompt = require('prompt-sync')();
let op = 1;

do {
    console.log("1- Ler valores")
    console.log("2- Ver valores")
    console.log("3- Média")
    console.log("4- Máximo")
    console.log("5- Mínimo")
    console.log("6- Sair")
    op = Number(prompt("Opção desejada: "));

    switch (op) {
        case 1:
            console.log("Clicou na opção 1")
            break;
        case 2:
            console.log("Clicou na opção 2")
            break;
        case 3:
            console.log("Clicou na opção 3")
            break;
        case 4:
            console.log("Clicou na opção 4")
            break;
        case 5:
            console.log("Clicou na opção 5")
            break;
        case 6:
            op = 0;
            break;
        default:
            console.log("Opção invalida");
    }
} while (op != 0);