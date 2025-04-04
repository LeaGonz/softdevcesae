const egg = document.querySelector('img')
console.log(egg.attributes)

let imgegg = 'https://devsprouthosting.com/images/egg.jpg'
let imgchi = 'https://devsprouthosting.com/images/chicken.jpg'

function changeImg(){
    egg.src = (egg.src === imgegg) ? imgchi : imgegg;
}

// Arrow function
// const changeImg = () => {
//     egg.src = (egg.src === imgegg) ? imgchi : imgegg;
// }
