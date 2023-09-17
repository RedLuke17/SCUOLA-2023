import './App.css';
import { useState } from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import * as L from "leaflet";
import 'leaflet/dist/leaflet.css';
import axios from 'axios';

const position = [41.9027835, 12.4963655];

function App() {
  const [markerPosition, setMarkerPosition] = useState(position);
  const [latInput, setLatInput] = useState('');
  const [lngInput, setLngInput] = useState('');
  const [maxTemperature, setMaxTemperature] = useState(null);
  const [minTemperature, setMinTemperature] = useState(null);

  const handleMapClick = (e) => {
    const { lat, lng } = e.latlng;
    setMarkerPosition([lat, lng]);
    setLatInput(lat);
    setLngInput(lng);
  };

  const handleLatInputChange = (e) => {
    setLatInput(e.target.value);
  };

  const handleLngInputChange = (e) => {
    setLngInput(e.target.value);
  };

  const handleUpdateMarkerPosition = () => {
    const lat = parseFloat(latInput);
    const lng = parseFloat(lngInput);
    if (!isNaN(lat) && !isNaN(lng)) {
      setMarkerPosition([lat, lng]);
      fetchTemperature(lat, lng);
    }
  };

  const handleResetInputs = () => {
    setLatInput('');
    setLngInput('');
    setMaxTemperature(null);
    setMinTemperature(null);
  };

  const markerIcon = L.icon({
    iconUrl: process.env.PUBLIC_URL + 'marker-icon-2x.png',
    iconSize: [40, 41],
    iconAnchor: [20, 41],
    popupAnchor: [1, -34],
  });

  const fetchTemperature = async (lat, lon) => {
    try {
      const response = await axios.get(
        `https://api.open-meteo.com/v1/forecast?latitude=${lat}&longitude=${lon}&daily=temperature_2m_max&timezone=Europe%2FRome`
      );

      const maxTemp = response.data.daily.temperature_2m_max[0].value;
      const minTemp = response.data.daily.temperature_2m_min[0].value;
      setMaxTemperature(maxTemp);
      setMinTemperature(minTemp);
    } catch (error) {
      console.error('Error fetching temperature:', error);
    }
  };


  return (
    <div className="App bg-[url('https://images.pexels.com/photos/209831/pexels-photo-209831.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1')] bg-no-repeat bg-cover">
      <header className="App-header">
        <div className='flex h-screen flex-col justify-center items-center'>
          <h1 className="text-white text-5xl font-bold">Previsioni del tempo</h1>
          <h2>giglo</h2>
          <MapContainer
            style={{ width: '50%', height: '40%' }}
            center={position}
            zoom={6}
            scrollWheelZoom={true}
            onClick={handleMapClick}
            >
              <TileLayer
                attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
              />
                {markerPosition && <Marker position={markerPosition} icon={markerIcon}>
              <Popup>
                <h1>Posizione del Marker</h1>
                <p>Latitudine: {markerPosition[0]}</p>
                <p>Longitudine: {markerPosition[1]}</p>
              </Popup>
            </Marker>}
          </MapContainer>

          <div className='mt-[50px]'>
            <input
              type="text"
              placeholder="Latitudine"
              value={latInput}
              onChange={handleLatInputChange}
              className="p-2 border border-gray-300 mr-2"
            />
            <input
              type="text"
              placeholder="Longitudine"
              value={lngInput}
              onChange={handleLngInputChange}
              className="p-2 border border-gray-300 mr-2"
            />
            <button className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline-blue active:bg-blue-800" onClick={handleUpdateMarkerPosition}>Submit</button>
            <button className="px-4 py-2 bg-gray-300 text-gray-800 rounded hover:bg-gray-400 focus:outline-none focus:shadow-outline-gray active:bg-gray-500" onClick={handleResetInputs}>Reset</button>
            
            <div className="mt-4">
              
                <p className="text-white">Temperatura massima: {maxTemperature}°C</p>
           
             
                {minTemperature !== null && (
              <p className="text-white">Temperatura minima: {minTemperature}°C</p>
            )}
            </div>
          </div>
        </div>
      </header>
    </div>
  );
}

export default App;
