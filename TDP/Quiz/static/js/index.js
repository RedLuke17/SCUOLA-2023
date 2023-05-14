let answersBox = document.querySelector(".answersBox")
let submit = document.querySelector("#submit")
let rightArrow = document.querySelector(".right-arrow")
let leftArrow = document.querySelector(".left-arrow")

let barilla = 0

let answers = [
    {
        domanda:"giglo è un giglo?", risposte:
        [
            {
                risposta:"si", punteggio:10
            },
            {
                risposta:"no", punteggio:-10
            },
            {
                risposta:"forse", punteggio:5
            },
        ]
    },
    {
        domanda:"ti senti un giglo?", risposte:
        [
            {
                risposta:"che chiavica di domande", punteggio:5
            },
            {
                risposta:"ma sei un trimonio!", punteggio:-5
            },
            {
                risposta:"ovviamente sis", punteggio:10
            },
        ]
    },
    {
        domanda:"che colore preferisci?", risposte:
        [
            {
                risposta:"uno solo", punteggio:0
            },
            {
                risposta:"no", punteggio:5
            },
            {
                risposta:"forse", punteggio:10
            },
        ]
    }
]


/*for (let i = 0; i < 3; i++) {
    if (i < 1){
        randomValue()
    }
    
    if(i == 0) {
    let answerTitle = document.createElement("h1")
    answerTitle.innerHTML = answers[0].domanda
    answersBox.appendChild(answerTitle)
    }
    

    let div = document.createElement("div")
    div.id = "question-"+(i+1)
    answersBox.appendChild(div)

    let button = document.createElement("input")
    button.type = "radio"
    button.id = "answer-1"
    button.name = "answer-1"
    button.value = answers[0].risposte[i].punteggio
    div.appendChild(button)

    let label = document.createElement("label")
    
    label.innerHTML = answers[0].risposte[i].risposta
    div.appendChild(label)
}*/

randomValue()
for (let i = 0; i < answers.length; i++) {
    let answerDiv = document.createElement("div")
    answerDiv.setAttribute("class","answer answer-"+i)
    answersBox.appendChild(answerDiv)

    let answerTitle = document.createElement("h1")
    answerTitle.innerHTML = answers[i].domanda
    answerDiv.appendChild(answerTitle)
    
    for(let j = 0; j < answers[i].risposte.length; j++) {
    let div = document.createElement("div")
    div.className = "question-"+(j+1)
    answerDiv.appendChild(div)

    let button = document.createElement("input")
    button.type = "radio"
    button.className = "answer-"+i
    button.name = "answer-"+i
    button.value = answers[i].risposte[j].punteggio
    div.appendChild(button)

    let label = document.createElement("label")
    label.innerHTML = answers[i].risposte[j].risposta
    div.appendChild(label)
    }

}

submit.addEventListener("click", function(){
    let score = 0

    if(barilla >= document.querySelector(".answersBox").children.length-1) {
        document.querySelectorAll("input[type=radio]").forEach(input => {
            if(input.checked) {
                score += parseInt(input.value)
            }
        })
        console.log(score)
        if(score < 0) {
            document.querySelector(".result").innerHTML = "sei poco un giglo"
        }
    } else {
        submit.disabled = true
    }
    
})

rightArrow.addEventListener("click", function(){
    if(document.querySelector(".answersBox").children[barilla] != undefined || barilla < document.querySelector(".answersBox").children.length-1){
    document.querySelector(".answersBox").children[barilla].style.display = "none"
    barilla++
    submit.disabled = false
    }
    if(barilla == 1) {
        leftArrow.style.display = "block"
    }
    if(barilla >= document.querySelector(".answersBox").children.length-1) {
        rightArrow.style.display = "none"
    }
})

leftArrow.addEventListener("click", function(){
    barilla--
    if(document.querySelector(".answersBox").children[barilla] != undefined || barilla < document.querySelector(".answersBox").children.length){
    document.querySelector(".answersBox").children[barilla].style.display = "block"
    }
    if(barilla == 0) {
        leftArrow.style.display = "none"
    }
    if(barilla < document.querySelector(".answersBox").children.length) {
        rightArrow.style.display = "block"
    }
})

function randomValue() {
    answers.sort(() => Math.random() -0.5)
    answers.forEach(e => e.risposte.sort(() => Math.random() -0.5))
}