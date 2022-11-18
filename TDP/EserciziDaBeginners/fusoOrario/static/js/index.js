function fusoOrarioCalc(ora,minuti){
let ny = ora
let ty = ora
let mc = ora
let minutiF = minuti

if( ny < 24 && ny > 0 ){
    ny = ny - 6 
    if( ny < 0 ){
        ny = 24 + ny
        console.log("a new york sono le ", ny)
    }
    else{
        console.log("a new york sono le ", ny)   
    }
}

if( ty < 24 && ty > 0 ){
    ty = ty + 7
    if( ty >= 24 ){
        ty = ty - 24
        console.log("a tokyo sono le ", ty)
    }
    else{
        console.log("a tokyo sono le ", ty)   
    }
}

if( mc < 24 && mc > 0 ){
    mc = mc + 1
    if( mc >= 24 ){
        mc = mc - 24
        return "a mosca sono le "+mc+":"+minutiF+" []a tokyo sono le "+ty+":"+minutiF+" []a new york sono le "+ny+":"+minutiF
    }
    else{
        return "a mosca sono le "+mc+":"+minutiF+" []a tokyo sono le "+ty+":"+minutiF+" []a new york sono le "+ny+":"+minutiF
    }
}
}


let inputNum = document.querySelector("#mainForm")
inputNum.addEventListener("submit" , function(e){
    e.preventDefault()
    let ore = document.querySelector("#ora").value;
    let minuti = document.querySelector("#minuti").value;
    document.querySelector("#print").innerHTML = fusoOrarioCalc(ore,minuti);
})