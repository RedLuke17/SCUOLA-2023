import java.util.ArrayList;

public class Classe {
    private ArrayList<Studente> studenti;

    public Classe() {
        studenti = new ArrayList<>();
    }

    public void anagraficaStudente(String nome, String cognome, int eta) {
        studenti.add(new Studente(nome, cognome,eta));
        System.out.println("Anagrafica studente inserita con successo.");
    }

    public void stampaClasse() {
        if (studenti.isEmpty()) {
            System.out.println("Non ci sono studenti nella classe");
        } else {
            System.out.println("Lista degli studenti");
            for (Studente studente : studenti) {
                System.out.println(studente);
            }
        }
    }

    public void ricerca(String nome, String cognome) {
        for (Studente studente : studenti) {
            if (studente.nome().equalsIgnoreCase(nome) &&
                    studente.cognome().equalsIgnoreCase(cognome)) {
                System.out.println(studente + " Trovato");
            }else {
                System.out.println("Nessuno studente trovato con il nome e cognome inseriti");
            }
        }
    }
}