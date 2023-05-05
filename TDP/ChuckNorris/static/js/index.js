let categories = ["animal","career","celebrity","dev","explicit","fashion","food","history","money","movie","music","political","religion","science","sport","travel"]
let joke = document.querySelector(".joke")
let copyBTN = document.querySelector(".copyBox")

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
        .then(data => { joke.innerHTML = `${data.value}`})
    }

    console.log(url)
})

copyBTN.addEventListener("click", () => {
    navigator.clipboard.writeText(joke.innerText)
})