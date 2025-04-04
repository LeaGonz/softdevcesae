let myHistoryTag = document.getElementById("History");

// myHistoryTag.textContent = "Hello";
myHistoryTag.innerText = "Hello";

console.log(myHistoryTag);
console.log(myHistoryTag.textContent);

// Devolve uma collections de elementos
let myHistoryTagClass = document.getElementsByClassName("mw-headline");

console.log(myHistoryTagClass[0].textContent)

