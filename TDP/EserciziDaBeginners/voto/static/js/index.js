function votoCalc(voto){
    if( voto < 6.0 ){
        return "insufficiente"
    }
    else if( voto <= 6.9 ){
        return "sufficiente"
    }
    else if( voto <= 7.9 ){
        return "il voto è discreto"
    }
    else{
        return "il voto è buono"
    }
}

let inputVoto = document.querySelector("#voto1")
inputVoto.addEventListener("submit" , function(e){
    e.preventDefault()
    let voti = document.querySelector("#voto").value;
    document.querySelector("#print").innerHTML = votoCalc(voti);
})