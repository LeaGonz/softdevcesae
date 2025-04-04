
// const fullNames = [
//     { first: 'Albus', last: 'Dumbledore' },
//     { first: 'Harry', last: 'Potter' },
//     { first: 'Hermione', last: 'Granger' },
//     { first: 'Ron', last: 'Weasley' },
//     { first: 'Rubeus', last: 'Hagrid' },
//     { first: 'Minerva', last: 'McGonagall' },
//     { first: 'Severus', last: 'Snape' }
// ];

// // const firstNames = fullNames.map(function (name){
// //     return name.first;
// // })

// const firstNames = fullNames.map(name=>name.first);
// console.log(firstNames);

// firstNames.forEach(function (n){
//     console.log(`Name: ${n}`);
// })


// let shoppingList = [];

// let nome = prompt("Qual é o seu nome: ");
// let apelido = prompt("Qual é o seu apelido: ");

// alert(`Bem-vindo ${nome} ${apelido}`);

// while (true) {
//     let item = prompt("Item para a lista de compras: ");
//     if (item.toLocaleLowerCase === "apagar") {
//         shoppingList.pop();
//     } else if (item.toLocaleLowerCase === "fim") {
//         break;
//     } else {
//         shoppingList.push(item);
//     }
// }


// var add = document.getElementById("itemAdd");
// var del = document.getElementById("itemDelete");
// var mostrar = document.getElementById("itemMostrar");
// let item;

// add.addEventListener("click", function () {
//     item = prompt("Item para a lista de compras: ");
//     shoppingList.push(item);
// })

// del.addEventListener("click", function () {
//     shoppingList.pop();
// })

// mostrar.addEventListener("click", function () {
//     console.log("*** Lista de compras ***");
//     for (let i = 0; i < shoppingList.length; i++) {
//         console.log(`${i + 1} - ${shoppingList[i]}`);
//     }
// })

// console.log("*** Lista de compras ***");
// for(let i = 0; i < shoppingList.length; i++){
//     console.log(`${i+1} - ${shoppingList[i]}`);
// }
// console.log(shoppingList);
