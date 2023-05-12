let form = document.querySelector(".mainForm")
let div
let button
let label

for (let i = 0; i < 3; i++) {
    div = document.createElement("div")
    div.id = "question-"+i
    form.appendChild(div)

    button = document.createElement("input")
    button.type = "radio"
    button.id = "answer-1"
    button.value = random(-10, 10)
    button.name = "answer-1"
    div.appendChild(button)

    label = document.createElement("label")
    label.innerHTML = random(-10, 10)
    div.appendChild(label)
    
}


function random(min, max) {
    let numeriGenerati = [];
    let numeroCasuale = Math.floor(Math.random() * (max - min + 1)) + min;

    if (numeriGenerati.includes(numeroCasuale)) {
        return random(min, max);
    }

    numeriGenerati.push(numeroCasuale);

    if (numeroCasuale >= 0 && numeroCasuale <= 5) {
        return "Barilla, mi sembra un numero!";
    } else if (numeroCasuale < 0) {
        return "Sei minore di 0.";
    } else if (numeroCasuale > 5) {
        return "Sei maggiore di 5!!!";
    }

    return numeroCasuale;
}