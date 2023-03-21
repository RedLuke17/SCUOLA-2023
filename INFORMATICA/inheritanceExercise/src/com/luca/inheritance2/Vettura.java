package com.luca.inheritance2;

public class Vettura extends Veicolo {
        private String tipologia;
        public Vettura(String targa, String marca, String modello, boolean guasto, String tipologia) {
            super(targa, marca, modello, guasto);
            this.tipologia = tipologia;
        }

        public String getTipologia() {
            return tipologia;
        }

        public void setTipologia(String tipologia) {
            this.tipologia = tipologia;
        }
}
