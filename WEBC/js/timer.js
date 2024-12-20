// timer
let count = 0
 
const timer = setInterval(() => {
    count++;
    console.log(count)
}, 1000)
 
setTimeout(() => {
    clearInterval(timer)
    console.log("Terminei!!!")
}, 6000)