let utilizador = prompt("Nome do utilizador: ")
document.body.innerHTML += `<h2>Chamo-me ${utilizador}</h2>`
document.body.innerHTML += `<p>O ${utilizador} tem ${utilizador.length} letras</p>`

document.body.innerHTML += `<p>A segunda letra do meu nome é ${utilizador[0, 1]}</p>`

document.body.innerHTML += `<p>O indice da letra ${utilizador[0, 1]} do meu nome é ${utilizador.indexOf("u")}</p>`

document.body.innerHTML += `<p>O indice da letra ${utilizador[1, 2]} do meu nome é ${utilizador.indexOf("i")}</p>`

document.body.innerHTML += `<p>As ultimas 3 letras do meu nome são ${utilizador.slice(-3)}</p>`

document.body.innerHTML += `<p>As palavras do meu nome são ${utilizador.split(" ")}</p>`

document.body.innerHTML += `<p>O meu nome minusculas ${utilizador.toLowerCase()} e em maisculas ${utilizador.toUpperCase()}</p>`
