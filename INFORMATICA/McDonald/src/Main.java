import java.util.ArrayList;
import java.util.Scanner;

class Panino {
    String codice;
    String descrizione;
    int quantita;
    float prezzo;

    public Panino(String codice, String descrizione, int quantita, float prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }
}


public class Main {
    public static void main(String[] args) {

        ArrayList<Panino> panini = new ArrayList<>();
        panini.add(new Panino("P1", "Big Mac", 5, 3.50f));
        panini.add(new Panino("P2", "McChicken", 7, 2.50f));
        panini.add(new Panino("P3", "Hamburger", 10, 1.50f));
        panini.add(new Panino("P4", "McNuggets", 20, 4.50f));
        panini.add(new Panino("P5", "Filet-O-Fish", 15, 3.00f));


        Scanner sc = new Scanner(System.in);

        int quantita = 0;
        float subTotale = 0f;
        float prezzo = 0f;
        float resto = 0f;

        // Ciclo di esecuzione del programma
        while (true) {
            // Visualizzazione del menu
            System.out.println("Menu:");
            for (Panino panino : panini) {
                System.out.printf("%s - %s - %.2f Euro - Disponibili: %d%n", panino.codice, panino.descrizione, panino.prezzo, panino.quantita);
                subTotale = 0;
            }

            // Acquisto dei panini
            while (true) {
                System.out.print("Inserisci il codice del panino da acquistare (premi 0 per pagare): ");
                String codice = sc.next();
                if (codice.equals("0")) {
                    if (subTotale != 0){
                        prezzo = sc.nextFloat();
                        while(prezzo < subTotale) {
                            System.out.println("non abbastanza soldi");
                            prezzo = sc.nextFloat();
                        }
                        resto = prezzo - subTotale;
                        System.out.println(String.format("il resto è %.2f",resto));
                        break;
                    } else {
                        System.out.println("non ce nessun ordine");
                    }
                }


                for (Panino panino : panini) {
                    if (panino.codice.equals(codice)) {
                        System.out.print("Inserisci la quantità: ");
                        quantita = sc.nextInt();
                        if(panino.quantita >= quantita){
                            panino.quantita -= quantita;
                            System.out.printf("Hai acquistato %d %s per un totale di %.2f Euro%n", quantita, panino.descrizione, quantita * panino.prezzo);
                            subTotale = subTotale + quantita * panino.prezzo;
                            System.out.println(String.format("il sub totale da pagare è di: %.2f", subTotale));
                            break;
                        }else {
                            System.out.println("le scorte sono esaurite");
                        }
                    }
                }
            }

            /*
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
            * */

            // Visualizzazione dello scontrino
            System.out.println("Scontrino:");
            System.out.printf("Totale conto %.2f Euro%nImporto pagato: %.2f Euro%nResto %.2f%n",subTotale,prezzo,resto);
            for (Panino panino : panini) {
                if (panino.quantita < panino.quantita) {
                    System.out.printf("%s - %d x %.2f Euro = %.2f Euro%n", panino.descrizione, panino.quantita, panino.prezzo, panino.quantita * panino.prezzo);
                }
            }
        }
    }
}
