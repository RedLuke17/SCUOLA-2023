package com.luca.inheritance2;

class Veicolo {
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

class Vettura extends Veicolo {
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

class Motociclo extends Veicolo {
    private int cilindrata;
    public Motociclo(String targa, String marca, String modello, boolean guasto, int cilindrata) {
        super(targa, marca, modello, guasto);
        this.cilindrata = cilindrata;
    }
}

public class Main {
    public static void main(String[] args) {
        Veicolo[] veicoli = new Veicolo[5];
        veicoli[0] = new Vettura("AB123CD", "Fiat", "Panda", false, "utilitaria");
        veicoli[1] = new Motociclo("EF456GH", "Honda", "CBR", false, 600);
        veicoli[2] = new Vettura("IJ789KL", "Ford", "Focus", true, "station wagon");
        veicoli[3] = new Motociclo("MN012OP", "Yamaha", "R1", true, 1000);
        veicoli[4] = new Vettura("QR345ST", "Toyota", "RAV4", false, "SUV");
        
        System.out.println("Lista delle targhe dei veicoli guasti:");
        for (int i = 0; i < veicoli.length; i++) {
            if (veicoli[i].isGuasto()) {
                System.out.println(veicoli[i].getTarga());
            }
        }
    }
}
