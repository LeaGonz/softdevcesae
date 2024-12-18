function altera(val, vec) {
    // val é passado por cópia e vec por referência
    val+=1
    vec[0] = "Alterou?????"
}
 
let x = 3
const arr2 = ["Texto", 12, 13.34, true, [1,2,3,4]]
altera(x, arr2)
console.log(x)
console.log(arr2)

let texto = "Eu sou um texto"
// texto = "dfgdfgfdrg" - nova atribuição
const textoArray = texto.split(" ")
textoArray[0] = "X"
texto = textoArray.join(" ")
console.log(textoArray)
console.log(texto)

const arr21 = ["Texto", 12, 13.34, true, [1,2,3,4]]
// no fim
arr2.push("elem")
// no início
arr2.unshift("first")
 
const deleted = delete arr2[2]
console.log(deleted)
 
console.log(arr2.length)
console.log(arr2)
 
const arr22 = ["Texto", 12, 13.34, true, [1,2,3,4]]
 
// slices
const slice = arr2.slice(0,-1)
 
console.log(arr2 instanceof Object)
 