const prompt = require('prompt-sync')()
//fetch
// Seleciona o endpoint https://dummyjson.com/docs/products limitado a 10 produtos

// const id = 24
// // HTTP GET a la url
// fetch(`https://dummyjson.com/products/${id}`)
//     // Metodo then, funcion response.json() convierte la respuesta en JSON
//     .then(response => {
//         if(response.ok) {
//             return response.json()
//         }
//     })
//     // data contiene el JSON, data.products contiene los productos
//     .then(data => console.log(data))
//     .catch(error => console.error(error))

// // Desafio API: Retornar todos os utilizadores que tenham um determinado nome (prompt). No máximo deverá retornar 5 utilizadores
// nome = prompt("Nome: ")
// fetch(`https://dummyjson.com/users/search?q=${nome}&limit=5`)
//     .then(response => {
//         if(response.ok) {
//             return response.json()
//         }
//     })
//     .then(data => console.log(data))
//     .catch(error => console.log(`Erro: ${error}`))

// Desafio API
const name = prompt('Qual o seu nome? ')
fetch(`https://dummyjson.com/users/search?q=${name}&limit=5`)
    .then(response => {
        if(response.ok) {
            return response.json()
        }
    })
    .then(data => console.log(data))