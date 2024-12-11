const nome = "Luis"
const apelido = "Gonzalez"
const peso = 60
const altura = 1.70

const IMC = (peso / (altura ** 2)).toFixed(2)

console.log(`${nome} ${apelido} tem o IMC = ${IMC}`)