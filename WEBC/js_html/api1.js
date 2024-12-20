const receita = document.getElementById("receita")
const receitaBTN = document.getElementById("receitaBTN")

receitaBTN.addEventListener("click", function (e) {
    mostrar()
})

function api() {
    //alert("hola")
    return fetch(`https://dummyjson.com/recipes/1`)
        .then(response => {
            if (response.ok) {
                return response.json()
            }
        })
//         .then(data => {
//             console.log(data)
//         //     receita.innerHTML = ""
//         //     receita.innerHTML += `
//         //     <div>
//         //         <p>Name: ${data.name}</p>
//         //         <p>Ingredients: ${data.ingredients}</p>
//         //         <p>Instructions: ${data.instructions}</p>
//         //         <p>cookTimeMinutes: ${data.cookTimeMinutes}</p>
//         //         <p>difficulty: ${data.difficulty}</p>
//         //         <p>cuisine: ${data.cuisine}</p>                               
//         //         <img src=${data.image} alt="">
//         //         </div>
//         // `;
// })
    .catch (error => console.error(error))
}

async function mostrar() {
    const data = await api()
    alert(data.name)
    receita.innerHTML = ""
            receita.innerHTML += `
            <div>
                <p>Name: ${data["name"]}</p>
                <p>Ingredients: ${data["ingredients"]}</p>
                <p>Instructions: ${data["instructions"]}</p>
                <p>cookTimeMinutes: ${data["cookTimeMinutes"]}</p>
                <p>difficulty: ${data["difficulty"]}</p>
                <p>cuisine: ${data["cuisine"]}</p>
                <img src=${data["image"]} alt="">
                </div>
        `;
}

//////////////////////////////////
const loadBTN = document.getElementById("loadBTN")
const recepyDIV = document.getElementById("recepyDIV")
 
const addReceipe = (data) => {
    // image (deverá ser apresentada a imagem)
    recepyDIV.innerHTML = `
        <h2>${data.name}</h2>
        <p><strong>Cuisine:</strong> ${data.cuisine}</p>
        <p><strong>Difficulty:</strong> ${data.difficulty}</p>
        <p><strong>Cook Time:</strong> ${data.cookTimeMinutes} minutos</p>
        <p>
            <strong>Ingredients:</strong>
            <ul>
                ${data.ingredients.map(ingredient => `<li>${ingredient}</li>`).join('')}
            </ul>
        </p>
        <p>
            <strong>Instructions:</strong>
            <ul>
                ${data.instructions.map(instruction => `<li>${instruction}</li>`).join('')}
            </ul>
        </p>
        <p><img src='${data.image}' alt='Image of ${data.name}'></p>
       
    `  
}
 
function defineActions() {
    loadBTN.addEventListener('click', function(e) {
        fetch('https://dummyjson.com/recipes/1')
            .then(res => res.json())
            .then(data => {
                addReceipe(data)
            })
            .catch(error => {
                console.log(`Erroe fetching API DATA: ${error}`)
            })
    })
}
 
defineActions()