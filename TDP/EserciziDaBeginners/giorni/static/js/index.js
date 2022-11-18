function giorni(){
    let month = document.querySelector("#month").value;
    let year = document.querySelector("#year").value;


    if(month > 0){
        document.querySelector("#print").innerHTML = (new Date(year,month,0).getDate())
    }else{
        document.querySelector("#print").innerHTML = "non hai inserito nessun valore"
    }
}