let map = L.map('map').setView([41.1171, 16.8719], 6)

let marker

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; OpenStreetMap contributors'
}).addTo(map)

map.on("click", (e) => {
    let {lat, lng} = e.latlng

    selectedPoint(lat, lng)

    fetchWeather(lat, lng)
})

document.querySelector("#submitBtn").addEventListener("click", () => {
    let latitudine = document.querySelector("#latitudine").value
    let longitudine = document.querySelector("#longitudine").value
    fetchWeather(latitudine, longitudine)
    selectedPoint(latitudine,longitudine)
})

document.querySelector("#resetBtn").addEventListener("click", () => {
    document.querySelector("#latitudine").value= ""
    document.querySelector("#longitudine").value = ""

    if (marker) {
        map.removeLayer(marker)
    }
})

function fetchWeather(latitudine, longitudine) {
    let url = `https://api.open-meteo.com/v1/forecast?latitude=${latitudine}&longitude=${longitudine}&hourly=temperature_2m,apparent_temperature&daily=temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min`
    
    fetch(url)
        .then(response => response.json())
        .then(function (data) {
            if (data) {
                let maxTemp = data.temperature_2m_max
                let minTemp = data.temperature_2m_min
                marker.bindPopup(`Temperature massima: ${maxTemp}°C, Temperatura minima: ${minTemp}°C`).openPopup()
            }
        })
}

function selectedPoint(latitudine,longitudine) {
    map.setView([latitudine, longitudine], 6)

    if (marker) {
        map.removeLayer(marker)
    }

    marker = L.marker([latitudine, longitudine]).addTo(map)
}