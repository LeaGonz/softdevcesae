// objeto pessoa
const pessoa = {
    nome : "Maria",
    idade : 44,
    salario : 1234.56,
    morada : {
        localidade : "Ovar",
        cod_postal : "3880-123",
        porta : 2
    }
}
// console.log(pessoa.nome)
// console.log(pessoa.morada.porta)
 
const arrPessoas = []
arrPessoas.push(pessoa)
console.log(arrPessoas)
 
 
// for(let key in pessoa) {
//     console.log(`índice: ${key} Valor: ${pessoa[key]}`)
// }

const pessoas = [
    {nome: "Pedro", idade: 23},
    {nome: "Afonseca", idade: 41},
    {nome: "Ana", idade: 19}
]
// filter
// 1 - Todas as pessoas com idade inferior a 30 anos
const ageLess30 = pessoas.filter((person) => person.idade < 30)
//console.log(ageLess30)
// 2 - Todas as pessoas cujo nome tem menos que 4 carateres
const name4char = pessoas.filter((person) => person.nome.length < 4)
//console.log(name4char)
// 3 - Todas as pessoas cujo nome começa pela letra a
const nameStartA = pessoas.filter((person) => person.nome.toLowerCase().startsWith('a'))
console.log(nameStartA)

//.map aplica para todos os valores