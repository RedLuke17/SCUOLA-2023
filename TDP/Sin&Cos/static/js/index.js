let angle = 0;
let ampiezza = 100;
let frequenza = 1;
let fase = 0;

function setup() {
    createCanvas(innerWidth, 400);
    background(200);
    angleMode(DEGREES);
    line(0,200,innerWidth,200);
}

function draw() {
    strokeWeight(3);
    stroke(0,0,255);
    let y2 = frequenza * ampiezza * cos(frequenza * angle + fase);
    point(angle,y2+200);
    stroke(255,0,0);
    let y = ampiezza * sin(frequenza * angle + fase);
    point(angle,y+200);
    angle += 1;

    if(angle > innerWidth) {
        background(220);
        strokeWeight(1);
        line(0,200,innerWidth,200);
        angle = 0;
    }
}

let ampiezzaInp = document.querySelector("[name=ampiezza]");
ampiezzaInp.addEventListener("input", function(e){
    ampiezza = parseInt(ampiezzaInp.value);
    document.querySelector("#output").innerHTML = "AMPIEZZA:"+ampiezza;
})

let frequenzaInp = document.querySelector("[name=frequenza]");
frequenzaInp.addEventListener("input", function(e){
    frequenza = parseInt(frequenzaInp.value);
    document.querySelector("#output1").innerHTML = "FREQUENZA:"+frequenza;
})

let faseInp = document.querySelector("[name=fase]");
faseInp.addEventListener("input", function(e){
    fase = parseInt(faseInp.value);
    document.querySelector("#output2").innerHTML = "FASE:"+fase;
})