package com.luca.inheritance3;

import com.luca.inheritance2.Motociclo;
import com.luca.inheritance2.Veicolo;
import com.luca.inheritance2.Vettura;

class Officina {
    public double ripara(Veicolo v) {
        double prezzo = 0;
        if (v.isGuasto()) {
            v.setGuasto(false);
            if (v instanceof Vettura) {
                prezzo = 100;
            } else if (v instanceof Motociclo) {
                prezzo = 50;
            }
        } else {
            prezzo = 10;
        }
        return prezzo;
    }
}