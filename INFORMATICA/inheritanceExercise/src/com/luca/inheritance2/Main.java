package com.luca.inheritance2;
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
