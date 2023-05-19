const scroll = document.querySelector('.scrollMenu');

const servizi = scroll.querySelector('.servizi');

// Create a copy of the table and adds it to the scrollable element
const table2 = servizi.cloneNode(true)
scroll.appendChild(table2);

const options = {
    root: scroll,
    rootMargin: '0px',
    threshold: 0
}

const callback = (entries) => {
    if (!entries[0].isIntersecting) {
        // table1 is out of bounds, we can scroll back to it
        scroll.scrollLeft = 0;
    }
}

const observer = new IntersectionObserver(callback, options);
observer.observe(servizi);


let search = document.querySelector(".src")
let geo = document.querySelector(".geo")
let searchBar = document.querySelector("#searchBar")


search.addEventListener("click", function(e){
    search.classList.toggle("active")
   // geo.classList.toggle("active")
    searchBar.classList.toggle("active")
    searchBar.innerHTML= "Search..."

})


var elemento = document.querySelector('.animazione');
var animazioneAvviata = false;

window.addEventListener('scroll', function() {
    var posizioneElemento = elemento.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;

    if (posizioneElemento < posizioneSchermo && !animazioneAvviata) {
        animazioneAvviata = true;
        animaElemento();
    }
});

function animaElemento() {
    var altezzaElemento = elemento.offsetHeight;
    var posizioneElemento = elemento.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;
    var progresso = (posizioneSchermo - posizioneElemento) / (posizioneSchermo + altezzaElemento)+0.3;


    if (progresso >= 0 && progresso <= 1) {
        elemento.style.opacity = progresso;
        elemento.style.transform = 'translateX(' + (280 * (1 - progresso)) + 'px)';
    }

    if (progresso < 1) {
        requestAnimationFrame(animaElemento);
    } else {
        animazioneAvviata = false;
    }
}

window.addEventListener('load', function() {
    var posizioneElemento = elemento.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;

    if (posizioneElemento < posizioneSchermo) {
        animaElemento();
    }
});

var elemento1 = document.querySelector('.animazione1');
var animazioneAvviata1 = false;

window.addEventListener('scroll', function() {
    var posizioneElemento = elemento1.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;

    if (posizioneElemento < posizioneSchermo && !animazioneAvviata) {
        animazioneAvviata1 = true;
        animaElemento1();
    }
});

function animaElemento1() {
    var altezzaElemento = elemento1.offsetHeight;
    var posizioneElemento = elemento1.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;
    var progresso = (posizioneSchermo - posizioneElemento) / (posizioneSchermo + altezzaElemento)+0.5;


    if (progresso >= 0 && progresso <= 1) {
        elemento1.style.opacity = progresso;
        elemento1.style.transform = 'translateY(' + (350 * (1 - progresso)) + 'px)';
    }

    if (progresso < 1) {
        requestAnimationFrame(animaElemento);
    } else {
        animazioneAvviata1 = false;
    }
}

window.addEventListener('load', function() {
    var posizioneElemento = elemento1.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;

    if (posizioneElemento < posizioneSchermo) {
        animaElemento1();
    }
});


var elemento2 = document.querySelector('.animazione2');
var animazioneAvviata2 = false;

window.addEventListener('scroll', function() {
    var posizioneElemento = elemento2.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;

    if (posizioneElemento < posizioneSchermo && !animazioneAvviata) {
        animazioneAvviata2 = true;
        animaElemento2();
    }
});

function animaElemento2() {
    var altezzaElemento = elemento2.offsetHeight;
    var posizioneElemento = elemento2.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;
    var progresso = (posizioneSchermo - posizioneElemento) / (posizioneSchermo + altezzaElemento)+0.5;


    if (progresso >= 0 && progresso <= 1) {
        elemento2.style.opacity = progresso;
        elemento2.style.transform = 'translateY(' + (350 * (1 - progresso)) + 'px)';
    }

    if (progresso < 1) {
        requestAnimationFrame(animaElemento);
    } else {
        animazioneAvviata2 = false;
    }
}

window.addEventListener('load', function() {
    var posizioneElemento = elemento2.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;

    if (posizioneElemento < posizioneSchermo) {
        animaElemento2();
    }
});


var elemento3 = document.querySelector('.animazione3');
var animazioneAvviata3 = false;

window.addEventListener('scroll', function() {
    var posizioneElemento = elemento3.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;

    if (posizioneElemento < posizioneSchermo && !animazioneAvviata) {
        animazioneAvviata3 = true;
        animaElemento3();
    }
});

function animaElemento3() {
    var altezzaElemento = elemento3.offsetHeight;
    var posizioneElemento = elemento3.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;
    var progresso = (posizioneSchermo - posizioneElemento) / (posizioneSchermo + altezzaElemento)+0.5;


    if (progresso >= 0 && progresso <= 1) {
        elemento3.style.opacity = progresso;
        elemento3.style.transform = 'translateY(' + (350 * (1 - progresso)) + 'px)';
    }

    if (progresso < 1) {
        requestAnimationFrame(animaElemento);
    } else {
        animazioneAvviata3 = false;
    }
}

window.addEventListener('load', function() {
    var posizioneElemento = elemento3.getBoundingClientRect().top;
    var posizioneSchermo = window.innerHeight || document.documentElement.clientHeight;

    if (posizioneElemento < posizioneSchermo) {
        animaElemento3();
    }
});