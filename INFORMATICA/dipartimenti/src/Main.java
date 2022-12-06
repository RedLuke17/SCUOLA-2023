import java.util.ArrayList;

public class Main {
}

class Persona{
    String nome;
    String cognome;
    int dataNascita;
    float stipendi;

    public Persona(String nome, String cognome, int dataNascita, float stipendi) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.stipendi = stipendi;
    }
}

class Dipartimento{
    ArrayList<Impiegato> impiegati = new ArrayList<>();
    String nome;
    String indirizzo;
    Direttore direttore;
}

class Impiegato extends Persona {
    ArrayList<Progetto> progetti = new ArrayList<>();

    public Impiegato(String nome, String cognome, int dataNascita, float stipendi) {
        super(nome, cognome, dataNascita, stipendi);
    }
}

class Direttore extends Persona {
    Dipartimento dipartimento;
    int anzianitaServizio;

    public Direttore(String nome, String cognome, int dataNascita, float stipendi) {
        super(nome, cognome, dataNascita, stipendi);
    }
}

class Progetto {
    String nome;
    float budget;
    int dataScadenza;

    public Progetto(String nome, float budget, int dataScadenza) {
        this.nome = nome;
        this.budget = budget;
        this.dataScadenza = dataScadenza;
    }

    ArrayList<Impiegato> impiegati = new ArrayList<>();
}