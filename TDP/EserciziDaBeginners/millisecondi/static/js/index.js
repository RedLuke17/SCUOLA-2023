function millisecondiCalc(ore, minuti){
    let millisecondi = (ore * 60 * 60 * 1000) + (minuti * 60 * 1000)
    return "i millisecondi sono: "+millisecondi
}

let inputNum = document.querySelector("#mainForm")
inputNum.addEventListener("submit", function(e){
    e.preventDefault()
    let minuti = document.querySelector("#ore").value
    let ore = document.querySelector("#minuti").value
    document.querySelector("#output").innerHTML = millisecondiCalc(ore, minuti)
})