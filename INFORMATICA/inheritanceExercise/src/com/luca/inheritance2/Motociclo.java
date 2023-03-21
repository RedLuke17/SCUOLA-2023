package com.luca.inheritance2;

public class Motociclo extends Veicolo {
    private int cilindrata;
    public Motociclo(String targa, String marca, String modello, boolean guasto, int cilindrata) {
        super(targa, marca, modello, guasto);
        this.cilindrata = cilindrata;
    }
}
