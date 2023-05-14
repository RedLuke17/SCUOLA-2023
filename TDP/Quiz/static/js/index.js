let form = document.querySelector(".mainForm")
let container = document.querySelector(".container")
let values = []
let questions = []
let answers = ["la cozza come la preferisci?", "sei un giglo?"]
let i = -1



let domande = {
    questions
}

console.log(domande)

    for (let i = 0; i < 3; i++) {
        

        let div = document.createElement("div")
        div.id = "question-"+(i+1)
        form.appendChild(div)
    
        let button = document.createElement("input")
        button.type = "radio"
        button.id = "answer-1"
        button.name = "answer-1"
        if (i < 1){
            randomValue(10,5,-10)
        }
        button.value = values[i]
        div.appendChild(button)
    
        let label = document.createElement("label")
        randomQuestion(values)
        label.innerHTML = questions[i]
        div.appendChild(label)
    }






function randomValue(min,med,max) {
    values = [min, med , max]

    return values.sort(() => Math.random() -0.5)
}

function randomQuestion(values) {
    i++
    if (values[i] == 10) {
        questions[i] = "cruda"
        return randomQuestion(values)
    }
    if (values[i] == 5) {
        questions[i] = "cotta"
        return randomQuestion(values)
    }
    if (values[i] == -10) {
        questions[i] = "al ragù"
        return randomQuestion(values)
    }
}

console.log(i)

