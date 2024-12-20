// assincronismo
 
function sendMessage(msg, time) {
    setTimeout(() => {
        console.log(msg)
    }, time)
}
 
sendMessage("Hello", 2000)
sendMessage("All Good?", 1500)
sendMessage("Byeeee", 800)
 
/*
Promise
    resolve (resposta) -> then / async  
    reject (erro) -> catch
*/