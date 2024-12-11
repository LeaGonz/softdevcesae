function generate10RandomNumbers(number) {
    for (let i = 0; i < number; i++) {
        console.log(Math.floor(Math.random() * 100) + 1)
    }
}

generate10RandomNumbers(5)