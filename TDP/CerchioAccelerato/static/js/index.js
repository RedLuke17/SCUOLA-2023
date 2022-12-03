let ax = 0.01;
let ay = 0.01;
let vy = 0;
let vx = 0;
let x = 0;
let y = 200;
let d=50
let r= d/2
let w=600
let h=400

function setup() {
    background("#ffffff");
    createCanvas(w, h);
}

function draw() {
    background(220);
    fill(255)
    circle(x, y, d)

    vx = vx+ax
    vy = vy+ay;

    y = y - vy
    x = x + vx

    if(y >= h +r){
        y = 0
    }

    if(y <= -r){
        y=h+r
    }

    if(x >= w + r){
        x=0
    }

    if(x <= -r){
        x=w+r
    }
}

let axInp = document.querySelector("[name=ax]");
axInp.addEventListener("input", function(e){
    ax = parseFloat(axInp.value);
    document.querySelector("#output").innerHTML = "X:"+ax;
})

let ayInp = document.querySelector("[name=ay]");
ayInp.addEventListener("input", function(e){
    ay = parseFloat(ayInp.value);
    document.querySelector("#output1").innerHTML = "Y:"+ay;
})

