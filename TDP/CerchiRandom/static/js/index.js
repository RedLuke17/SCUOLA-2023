let w = 800
let h = 800


function setup() {
createCanvas(w, h);
textSize(60);
textAlign(CENTER);
}

function draw() {
if(frameCount <= 1000)
{
    fill(0 , 0 ,0)
    let dimensione = 100
    square((w/2) - dimensione/2, (h/2) - dimensione/1.5, dimensione);
    fill(255, 255 ,255)
    text(frameCount,width / 2, height / 2);
    let x = random(800)
    let y = random(800)
    let diametro = random(30, 90)
    let r = random(0,255)
    let g = random(0,255)
    let b = random(0,255)
    noStroke();
    fill(r, g, b)
    circle(x, y , diametro)
}else
{
    frameCount = 0;
    background(220);
}
}