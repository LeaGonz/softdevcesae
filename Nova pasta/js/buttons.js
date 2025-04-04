const div = document.getElementById('container')
console.log(div)

function createBtns() {
    for (let i = 1; i <= 100; i++) {
        const btn = document.createElement('button')
        btn.innerText = "Golpe " + i
        btn.style.margin = "5px"
        btn.style.color = "red"
        btn.style.backgroundColor = "black"
        btn.style.borderColor = "green"
        div.appendChild(btn)
    }
}

createBtns()