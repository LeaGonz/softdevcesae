let num = Number(prompt("Numero: "))
document.body.innerHTML += `<h1>Número inserido ${num}</h1>`
document.body.innerHTML += `<h2>Raiz quadrada: ${Math.sqrt(num)}</h2>`
document.body.innerHTML += `<h2>${num} é inteiro? ${Number.isInteger(num)}</h2>`
document.body.innerHTML += `<h2>${num} é NaN? ${isNaN(num)}</h2>`
document.body.innerHTML += `<h2>${num} arredonda para baixo ${Math.floor(num)}</h2>`
document.body.innerHTML += `<h2>${num} arredonda para cima ${Math.ceil(num)}</h2>`
document.body.innerHTML += `<h2>${num} com 2 decimais ${num.toFixed(2)}</h2>`
