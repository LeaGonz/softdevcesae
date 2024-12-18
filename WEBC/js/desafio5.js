const prompt = require('prompt-sync')()
 
const pessoas = [
    {nome: "Pedro", idade: 23},
    {nome: "Afonseca", idade: 41},
    {nome: "Ana", idade: 19}
]
if(!("job" in pessoas[0])) pessoas[0].job = "Formador"
// Caso não exista a chave job na primeira pessoa defini-la com o valor de Formador
 
console.log(pessoas[0])