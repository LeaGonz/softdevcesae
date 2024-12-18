const prompt = require('prompt-sync')();
let validar = true
let n
const nums = []
do{
    // Pedimos valor
    n = Number(prompt("Digite un número: "))
    
    if(n != 0){
        // Adicionamos valor
        if(!isNaN(n)){
        nums.push(n)
        } else{
            console.log("Valor invalido")
            continue
        }
        // Máximo valor
        const max = Math.max(...nums)
        console.log(`Max: ${max}`)
        // Mínimo valor
        const min = Math.min(...nums)
        console.log(`Min: ${min}`)
        // Media dos valores
        let soma = 0
        for(let i of nums){ 
            soma += i
        }
        console.log(`Media: ${(soma/nums.length).toFixed(2)}`)
        // Mostramos listagem
        console.log(nums)
        // Números de valores
        console.log(`Total valores: ${nums.length}`)
    } else{
        console.log("Saindo do programa")
        break
    }
} while(validar)
