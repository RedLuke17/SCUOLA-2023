function invioDati(evento) {
    evento.preventDefault()
    let nome = document.querySelector("#nome").value
    let cognome = document.querySelector("#cognome").value
    let eta = document.querySelector("#eta").value
    let sesso = document.querySelector("#sesso").value
    utente = { nome, cognome, eta, sesso}
    utenti.push(utente)

    document.querySelector("#print").innerHTML = utente
    console.log(utenti)
}

let utenti = []

document.querySelector("#invia").addEventListener("click", invioDati)