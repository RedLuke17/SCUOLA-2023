let x = 600;

let y = 300;

let diametro = 50;

let raggio = diametro/2;

let i = diametro

let j = diametro


function setup() {

createCanvas(600, 300);
background(0, 210, 0);

}



function draw() {

frameRate(5)


if(i < (x / diametro) * diametro){
drawFlower(i, j, diametro, raggio)
  i += diametro * 2
}else{
i = diametro
  j += diametro * 2
}

if(j > (y / diametro) * diametro){
noLoop()
}

}



function drawFlower(x, y,diametro, raggio) {

strokeWeight(3);

fill(255, 140, 0);

circle(x - raggio, y - raggio, diametro);

circle(x + raggio, y + raggio, diametro);

circle(x - raggio, y + raggio, diametro);

circle(x + raggio, y - raggio, diametro);

fill(255, 0, 0);

circle(x, y, diametro);

}