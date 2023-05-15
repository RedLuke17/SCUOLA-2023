let answersBox = document.querySelector(".answersBox")
let submit = document.querySelector("#submit")
let rightArrow = document.querySelector(".right-arrow")
let leftArrow = document.querySelector(".left-arrow")

let arrowCounter = 0
let gg = 0

let answers = [
    {
        domanda:"Il pianeta terra è un pianeta?", risposte:
        [
            {
                risposta:"credo di si", punteggio:10
            },
            {
                risposta:"ni", punteggio:-10
            },
            {
                risposta:"forse", punteggio:5
            },
        ]
    },
    {
        domanda:"Triggiano è un pianeta?", risposte:
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
        domanda:"Quanti pianeti esistono?", risposte:
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
    },
    {
        domanda:"Di che colore è marte???", risposte:
        [
            {
                risposta:"rossaceo", punteggio:10
            },
            {
                risposta:"nessuno", punteggio:-10
            },
            {
                risposta:"arancione", punteggio:5
            },
        ]
    }
]


randomValue()
for (let i = 0; i < answers.length; i++) {
    let answerDiv = document.createElement("form")
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
    gg++
    button.id = "answer-"+gg
    button.name = "answer-"+i
    button.value = answers[i].risposte[j].punteggio
    div.appendChild(button)

    let label = document.createElement("label")
    label.htmlFor = "answer-"+gg
    label.innerHTML = answers[i].risposte[j].risposta
    div.appendChild(label)
    }

}

submit.addEventListener("click", function(){
    let score = 0
    document.querySelector(".result").classList.remove("anim-typewriter")

    if(arrowCounter >= document.querySelector(".answersBox").children.length-1) {
        document.querySelectorAll("input[type=radio]").forEach(input => {
            if(input.checked) {
                score += parseInt(input.value)
            }
        })
        console.log(score)
        if(score < 0) {
            setTimeout(function(){ document.querySelector(".result").classList.add("anim-typewriter")
            document.querySelector(".result").innerHTML = "sei poco un giglo"},450)
        }
        if(score > 0 && score < 20) {
            setTimeout(function(){ document.querySelector(".result").classList.add("anim-typewriter")
            document.querySelector(".result").innerHTML = "sei mediamente un giglo"},450)
        }

        if(score > 20) {
            setTimeout(function(){ document.querySelector(".result").classList.add("anim-typewriter")
            document.querySelector(".result").innerHTML = "sei TROPPO un giglo"},450)
        }
    } else {
        submit.disabled = true
    }
    
})

rightArrow.addEventListener("click", function(){
    if(document.querySelector(".answersBox").children[arrowCounter] != undefined || arrowCounter < document.querySelector(".answersBox").children.length-1){
    document.querySelector(".answersBox").children[arrowCounter].style.display = "none"
    arrowCounter++
    submit.disabled = false

    answersBox.classList.add("slide-in-left")
    document.querySelector(".right-arrow").classList.add("flicker-in-1")
    setTimeout(function(){ answersBox.classList.remove("slide-in-left")
    document.querySelector(".right-arrow").classList.remove("flicker-in-1") },450)
    }
    if(arrowCounter == 1) {
        leftArrow.style.display = "block"
    }
    if(arrowCounter >= document.querySelector(".answersBox").children.length-1) {
        rightArrow.style.display = "none"
        submit.classList.add("vibrate-3")
    }
})

leftArrow.addEventListener("click", function(){
    answersBox.classList.add("slide-in-right")
    document.querySelector(".left-arrow").classList.add("flicker-in-1")
    setTimeout(function(){ answersBox.classList.remove("slide-in-right")
    document.querySelector(".left-arrow").classList.remove("flicker-in-1") },450)
    submit.classList.remove("vibrate-3")
    
    arrowCounter--
    if(document.querySelector(".answersBox").children[arrowCounter] != undefined || arrowCounter < document.querySelector(".answersBox").children.length){
    document.querySelector(".answersBox").children[arrowCounter].style.display = "block"
    }
    if(arrowCounter == 0) {
        leftArrow.style.display = "none"
    }
    if(arrowCounter < document.querySelector(".answersBox").children.length) {
        rightArrow.style.display = "block"
    }
})

function randomValue() {
    answers.sort(() => Math.random() -0.5)
    answers.forEach(e => e.risposte.sort(() => Math.random() -0.5))
}