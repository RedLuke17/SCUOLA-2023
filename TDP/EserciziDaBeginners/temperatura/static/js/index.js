function temperaturaCalc(fahrenheit){
    let celsius = (fahrenheit - 32.0) * 5.0 / 9.0
    return "la temperatura in gradi centigradi è: " +celsius
}

let inputNum = document.querySelector("#mainForm")
inputNum.addEventListener("submit" , function(e){
    e.preventDefault()
    let fahrenheit = document.querySelector("#temp").value;
    document.querySelector("#print").innerHTML = temperaturaCalc(fahrenheit);
})