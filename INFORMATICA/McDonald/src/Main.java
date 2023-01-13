import java.util.Scanner;

// Definizione della classe Panino
class Panino {
    String codice;
    String descrizione;
    int quantita;
    double prezzo;

    public Panino(String codice, String descrizione, int quantita, double prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }
}


public class Main {
    public static void main(String[] args) {
        // Precaricamento dei dati dei panini
        Panino[] panini = {
                new Panino("P1", "Big Mac", 5, 3.50),
                new Panino("P2", "McChicken", 7, 2.50),
                new Panino("P3", "Hamburger", 10, 1.50),
                new Panino("P4", "McNuggets", 20, 4.50),
                new Panino("P5", "Filet-O-Fish", 15, 3.00)
        };

        // Creazione di un oggetto Scanner per leggere gli input da tastiera
        Scanner sc = new Scanner(System.in);

        // Ciclo di esecuzione del programma
        while (true) {
            // Visualizzazione del menu
            System.out.println("Menu:");
            for (Panino panino : panini) {
                System.out.println(String.format("%s - %s - %.2f Euro - Disponibili: %d", panino.codice, panino.descrizione, panino.prezzo, panino.quantita));
            }

            // Acquisto dei panini
            while (true) {
                System.out.print("Inserisci il codice del panino da acquistare (o premi Enter per uscire): ");
                String codice = sc.nextLine();
                if (codice.equals("")) {
                    break;
                }
                System.out.print("Inserisci la quantità: ");
                int quantita = Integer.parseInt(sc.nextLine());
                for (Panino panino : panini) {
                    if (panino.codice.equals(codice) && panino.quantita >= quantita) {
                        panino.quantita -= quantita;
                        System.out.println(String.format("Hai acquistato %d %s per un totale di %.2f Euro", quantita, panino.descrizione, quantita * panino.prezzo));
                        break;
                    }
                }
            }

            // Visualizzazione dello scontrino
            double totale = 0;
            System.out.println("Scontrino:");
            for (Panino panino : panini) {
                if (panino.quantita < panino.quantita) {
                    System.out.println(String.format("%s - %d x %.2f Euro = %.2f Euro", panino.descrizione, panino.quantita, panino.prezzo, panino.quantita * panino.prezzo));
                    totale += panino.quantita * panino.prezzo;
                }
            }
            System.out.println(String.format("Totale: %.2f Euro", totale));
        }
    }
}
