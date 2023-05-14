let categories = ["animal","career","celebrity","dev","explicit","fashion","food","history","money","movie","music","political","religion","science","sport","travel"]
let joke = document.querySelector(".joke")
let copyBox = document.querySelector(".copyBox")
let copyBTN = document.querySelector(".copyBTN")
let link = document.querySelector(".link")

for(let i = 0;i<categories.length;i++){
    let option = document.createElement("option")

    option.value= categories[i]
    option.innerHTML = categories[i].toUpperCase()
    document.querySelector("select[name=category]").appendChild(option)
}

document.querySelector("#mainForm").addEventListener("submit", function(e){
    e.preventDefault()
    let currentCategory = document.querySelector("select[name=category]").value
    console.log(`categoria -> ${currentCategory}`)

    let url = "https://api.chucknorris.io/jokes/random"

    if(currentCategory != ""){
        url += `?category=${currentCategory}`
        fetch(url).then(response => response.json())
        .then(data => { joke.innerHTML = `${data.value}`
        link.href = data.url})
    } else {
        fetch(url).then(response => response.json())
        .then(data => { joke.innerHTML = `${data.value}`
        link.href = data.url})
    }

    console.log(url)
})

copyBox.addEventListener("click", () => {
    navigator.clipboard.writeText(joke.innerText)
})

copyBTN.addEventListener("click", () => {
    copyBTN.innerHTML = "Battuta copiata"
    setTimeout(function(){ copyBTN.innerHTML = "copia" },1500)

})