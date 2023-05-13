let form = document.querySelector(".mainForm")
let values = []
for (let i = 1; i <= 3; i++) {
    let div = document.createElement("div")
    div.id = "question-"+i
    form.appendChild(div)

    let button = document.createElement("input")
    button.type = "radio"
    button.id = "answer-1"
    button.name = "answer-1"
    button.value = randomValue(10,5,-10)
    div.appendChild(button)

    let label = document.createElement("label")
    label.innerHTML = randomText(values)
    div.appendChild(label)
}



function randomValue(min,med,max) {
    values = [min, med , max]

    return values.sort(() => Math.random() -0.5)
}

function randomText(values) {
    for (let i = 0; i < values.length; i++) {
        if (values[i] == 10) {
            return  "cruda"
        }
        if (values[i] == 5) {
            return "cotta"
        }
        if (values[i] == -10) {
            return "GIGLICAA"
        }
    }

}

console.log(randomValue(10, 5, -10))