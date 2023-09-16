document.querySelector(".formwrapper").addEventListener("submit", function(event) {
    event.preventDefault()
    let latitudine = document.querySelector("#lat").value;
    let longitudine = document.querySelector("#lng").value;

    console.log(latitudine + longitudine)

    let url;
})