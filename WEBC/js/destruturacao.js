// destruturação
const arr = [1,2,3,4,5]
const [n1, n2, ...n3] = arr
console.log(n3)
 
const pessoa = {
    nome : 'Paula',
    idade : 23,
    morada: {
        rua : 'Rua qq coisa',
        localidade : 'Porto'
    }
}
 
const {nome, idade, morada: {localidade}} = pessoa
console.log(localidade)