let button = document.querySelectorAll(".btn")

button.forEach(elem=>elem.addEventListener("click",()=>{
    button.forEach(giglo=> giglo.classList.remove("active"))

    elem.classList.add("active");
    document.querySelector("body").style.backgroundColor=elem.getAttribute("data-color");
}))