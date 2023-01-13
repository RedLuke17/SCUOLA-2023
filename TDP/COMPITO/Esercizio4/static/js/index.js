let w = 500;
let h = 500;

let grandezza = 30;
let x = 0;
let y = 0;


function setup() {
    createCanvas(w, h);
    background(220,58,0)
}

function draw() {
    stroke("white")
    let x1 = random(-5,5)
    let y1 = random(-5,5)
    if(random() < 0.5){
        line(x + grandezza/2, y + grandezza, x1 + x + grandezza , y1 + grandezza + y)
    }else{
        line(x + grandezza, y + grandezza, x1 + x + grandezza/2, y1+ y + grandezza)
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