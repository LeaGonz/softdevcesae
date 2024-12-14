/*const texto = "hola"
console.log(texto[0])
console.log(texto[texto.length - 1])
*/

/*
//       012345
let texto = "Vamos programar"
 
// índices 0 até N-1 (N n.º de elementos)
console.log(texto[0])
console.log(texto.charAt(texto.length - 1))
console.log(texto.indexOf('a'))

console.log(texto.slice(0,5))
console.log(texto.slice(0,5))
console.log(texto.slice(-3, -1))*/

/*
const texto = "O Ministério Público acusou oito arguidos, entre eles um funcionário da AT em funções na Direção de Finanças de Coimbra, de diversos crimes económicos, como corrupção, branqueamento e fraude fiscal."
palavras = texto.split(" ")
console.log(palavras)
console.log(palavras[1].toLowerCase())
console.log(palavras[2].toUpperCase())
 */

// Forma 1
let texto = "Eu gosto de JS";
console.log(transformarVogais(texto));

function transformarVogais(texto) {
    let resultado = "";
    for (let i = 0; i < texto.length; i++) {
        if (texto[i] === "a" || texto[i] === "e" || texto[i] === "i" || texto[i] === "o" || texto[i] === "u") {
            resultado += texto[i].toUpperCase();
        } else {
            resultado += texto[i];
        }
    }
    return resultado;
}

// Forma 2
const texto2 = "Eu gosto de JS"
const vowels = "aeiou"

console.log(transformsVowels(texto2))

function transformsVowels(texto2) {
    let resultado = ""
    for (let i = 0; i < texto2.length; i++) {
        if (vowels.includes(texto2[i])) {
            resultado += texto2[i].toUpperCase()
        } else {
            resultado += texto2[i]
        }
    }
    return resultado
}