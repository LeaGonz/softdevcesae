// funções avançadas
 
function multiple() { // qd utilizamos a keyword function
    console.log(arguments[2])
}
 
const multipleV2 = (...args) => {
    for(val of args) {
        console.log(val)
    }
}
 
//multiple(1,2,3,4,5,6)
multipleV2(1,2,3,4,5,6)