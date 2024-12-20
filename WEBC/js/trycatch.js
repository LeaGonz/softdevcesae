// tratamento de erros
 
const val = 3
try {
    console.log(val/0)
}
catch (error){
    console.log(error)
}
finally {
    console.log("Terminou")
}