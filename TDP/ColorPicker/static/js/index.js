let button = document.querySelectorAll(".btn")
button.forEach(elem=>elem.addEventListener("click",()=>{
    document.querySelector("body").style.backgroundColor=elem.getAttribute("data-color")
}))