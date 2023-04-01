let w = 500;
let h = 500;

let grandezza = 20;
let x = 0;
let y = 0;


function setup() {
    createCanvas(w, h);
    background(220,58,0)
}

function draw() {
    stroke("white")

    if(random() < 0.5){
        line(x, y, x + grandezza, y + grandezza)
    }else{
        line(x, y + grandezza, x + grandezza, y)
    }

    x += grandezza

    if(x >= w){
        x = 0;
        y += grandezza;
    }
}

let grandezzaInp = document.querySelector("#grandezza");

    grandezzaInp.addEventListener("input", function(e){
    e.preventDefault()
    background(220,58,0)
    grandezza = parseInt(grandezzaInp.value);
    y=0
    x=0
})

function somma(array) {
    let risultato = 0;
    for (let i = 0; i < array.length; i++) {
        risultato += array[i];
    }
    return risultato;
}