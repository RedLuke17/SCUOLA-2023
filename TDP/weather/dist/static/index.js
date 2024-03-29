let canvas = document.querySelector("canvas")
let marker
let chart
let map

navigator.geolocation.getCurrentPosition(
    function (event) {
        createMap(event.coords.latitude, event.coords.longitude)
    },
    function (event) {
        createMap(41,16)
    }
)

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

function createMap (lat,lng) {
    map = L.map('map').setView([lat, lng], 6)

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; OpenStreetMap contributors'
    }).addTo(map)

    fetchWeather(lat, lng)

    marker = L.marker([lat, lng]).addTo(map)

    map.on("click", (e) => {
        let {lat, lng} = e.latlng

        selectedPoint(map, lat, lng)

        fetchWeather(lat, lng)
    })
}

function fetchWeather(latitudine, longitudine) {
    let url = `https://api.open-meteo.com/v1/forecast?latitude=${latitudine}&longitude=${longitudine}&hourly=temperature_2m,apparent_temperature&daily=temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min`
    
    fetch(url)
        .then((response) => response.json())
        .then(function (data) {
            if (data) {
                let maxTemp = data.daily.temperature_2m_max[0]
                let minTemp = data.daily.temperature_2m_min[0]
                
                let hourlyTemperatures = data.hourly.temperature_2m
                let hours = data.hourly.time.slice(0, 24)

                let config = {
                    type: 'line',
                    data: {
                        labels: hours,
                        datasets: [
                            {
                                label: 'Temperatura',
                                data: hourlyTemperatures,
                                fill: false,
                                borderColor: 'rgb(75, 192, 192)',
                                tension: 0.1,
                                yAxisID: 'y',
                            }
                        ]
                    },
                    options: {
                        scales: {
                            x: {
                                title: {
                                    display: true,
                                    text: 'Ore'
                                }
                            },
                            y: {
                                title: {
                                    display: true,
                                    text: 'Temperatura (°C)'
                                }
                            }
                        }
                    }
                }

                if (chart) {
                    chart.destroy()
                }
                chart = new Chart(canvas, config)

                marker.bindPopup(`Temperature massima: ${maxTemp}°C, Temperatura minima: ${minTemp}°C`).openPopup()
            }
        })
}

function selectedPoint(map, latitudine,longitudine) {
    map.setView([latitudine, longitudine], 6)

    if (marker) {
        map.removeLayer(marker)
    }

    marker = L.marker([latitudine, longitudine]).addTo(map)

    document.querySelector("#latitudine").value = latitudine
    document.querySelector("#longitudine").value = longitudine
}