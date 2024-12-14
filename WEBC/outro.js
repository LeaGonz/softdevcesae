const login = "xpto"
const password = "12345"
 
const sucess = login === "xpto" && password === "12345"
console.log(sucess)

// 0 - 9 MAU 10 - 14 Satisfatório > 15 Bom
const nota = 15
if(nota<10) console.log("MAU")
else if(nota<15) console.log("Satisfatório")
else console.log("Bom")
// operações ternárias
const val = 15
const ePar = val % 2 == 0 ? "Par" : "Impar"
console.log(ePar)