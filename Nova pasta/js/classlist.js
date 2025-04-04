const allLi = document.querySelectorAll('li')
console.log(allLi)

const all = document.querySelector('ul')
console.log(all.children)

const changeHighlight = () => {
    allLi.forEach(element => {
        (element.classList.contains('highlight')) ? element.classList.remove('highlight') : element.classList.add('highlight')
    });
}
