package com.luca.inheritance3;
import com.luca.inheritance2.Motociclo;
import com.luca.inheritance2.Veicolo;
import com.luca.inheritance2.Vettura;
public class Main {
    public static void main(String[] args) {
            Veicolo[] veicoli = new Veicolo[5];
            veicoli[0] = new Vettura("AB123CD", "Fiat", "Panda", false, "utilitaria");
            veicoli[1] = new Motociclo("EF456GH", "Honda", "CBR", false, 600);
            veicoli[2] = new Vettura("IJ789KL", "Ford", "Focus", true, "station wagon");
            veicoli[3] = new Motociclo("MN012OP", "Yamaha", "R1", true, 1000);
            veicoli[4] = new Vettura("QR345ST", "Toyota", "RAV4", false, "SUV");

            Officina officina = new Officina();

            System.out.println("Lista dei prezzi degli interventi:");
            for (int i = 0; i < veicoli.length; i++) {
                double prezzo =
                        officina.ripara(veicoli[i]);
                System.out.println("Il prezzo dell'intervento sulla " + veicoli[i].getClass().getSimpleName() + " " + veicoli[i].getMarca() + " " + veicoli[i].getModello() + " e': " + prezzo);
            }
    }
}
