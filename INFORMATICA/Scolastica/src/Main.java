import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Classe classe = new Classe();
        String nome;
        String cognome;
        int eta;
        int scelta;

        do {
            System.out.println("[1]Anagrafica studente\n[2]Stampa classe\n[3]Ricerca per nome e cognome\n[0]EXIT");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci nome, cognome ed eta ");
                    nome = scanner.next();
                    cognome = scanner.next();
                    eta = scanner.nextInt();
                    classe.anagraficaStudente(nome, cognome, eta);
                    break;
                case 2:
                    classe.stampaClasse();
                    break;
                case 3:
                    System.out.println("Inserisci il nome e cognome dello studente");
                    nome = scanner.next();
                    cognome = scanner.next();
                    classe.ricerca(nome, cognome);
                    break;
            }
        } while (scelta != 0);
    }
}
