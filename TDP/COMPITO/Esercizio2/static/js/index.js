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
    noStroke()

    if(random() < 0.5){
        fill("white")
        square(x,y,grandezza)
        fill("red")
        triangle(x+grandezza, y, x, y, x, y);
    }else{
        fill("black")
        square(x,y,grandezza)
        fill("red")
        triangle(x+grandezza, y, x, y, x, y);
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