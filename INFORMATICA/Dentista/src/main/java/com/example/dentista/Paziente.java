package com.example.dentista;

public class Paziente {
    private String nome;
    private String cognome;
    private int eta;
    private String codiceFiscale;
    private String patologia;

    public Paziente(String nome, String cognome, int eta, String codiceFiscale, String patologia){
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.codiceFiscale = codiceFiscale;
        this.patologia = patologia;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + eta + " " + codiceFiscale + " " + patologia;
    }
}
