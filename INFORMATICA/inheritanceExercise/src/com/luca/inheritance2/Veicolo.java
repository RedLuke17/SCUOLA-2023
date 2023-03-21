package com.luca.inheritance2;

public class Veicolo {
        private String targa;
        private String marca;
        private String modello;
        private boolean guasto;

        public Veicolo(String targa, String marca, String modello, boolean guasto) {
            this.targa = targa;
            this.marca = marca;
            this.modello = modello;
            this.guasto = guasto;
        }

        public String getTarga() {
            return targa;
        }

        public void setTarga(String targa) {
            this.targa = targa;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModello() {
            return modello;
        }

        public void setModello(String modello) {
            this.modello = modello;
        }

        public boolean isGuasto() {
            return guasto;
        }

        public void setGuasto(boolean guasto) {
            this.guasto = guasto;
        }
}
