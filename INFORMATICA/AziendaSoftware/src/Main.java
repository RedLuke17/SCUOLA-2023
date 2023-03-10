import java.net.SocketOption;
import java.util.ArrayList;
import java.util.Scanner;

class Progetto {
    String nome;
    ArrayList<Dipendente> dipendenti = new ArrayList<>();
    float andamento;
    boolean completata;
    float percentuale;
    int giorni;
    ArrayList<Milestone> milestones = new ArrayList<>();

    public Progetto(String nome) {
        this.nome = nome;
    }

    public Progetto(ArrayList<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    void infoProgetto(){
        System.out.printf("\nInformazioni\nNome:%s\nPercentuale:%.2f\nDipendenti:%d\n",nome , percentuale, dipendenti.size());
        listaDipendenti();
    }

    void listaDipendenti() {
        System.out.printf("\nNome\tCognome");
        for (Dipendente dipendente: dipendenti) {
            System.out.printf("\n%s\t%s", dipendente.nome, dipendente.cognome);
        }
    }
}

class Milestone {
    String nome;
    ArrayList<Task> tasks = new ArrayList<>();
    float andamento = 0;
    boolean completata = false;

    public Milestone(String nome) {
        this.nome = nome;
    }
}

class Task {
    String nome;
    Dipendente dipendente;
    int scadenza;

    public Task(String nome, Dipendente dipendente, int scadenza) {
        this.nome = nome;
        this.dipendente = dipendente;
        this.scadenza = scadenza;
    }

    boolean completata = false;
    boolean critica = false;
}

class Dipendente {
    boolean occupazione;
    String nome;
    String cognome;

    public Dipendente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
}

class Azienda {
    Progetto progetto;
    ArrayList<Dipendente> dipendenti = new ArrayList<>();

    void aggiungiDipendente(String nome, String cognome) {
        dipendenti.add(new Dipendente(nome, cognome));
    }

    void aggiungiProgetto() {
        System.out.println("[0]esci\nInserisci il nome del progetto");
        String nome = Main.scanner.next();
        progetto = new Progetto(nome);
        System.out.println("Inserisci i dipendenti che lavoreranno a questo progetto");
        for (int i = 0 ; i < dipendenti.size() ; i++) {
            System.out.printf("\n[%d]%s %s\n", i+1, dipendenti.get(i).nome, dipendenti.get(i).cognome);
        }

        //arraylist di dipendenti temporanei
        ArrayList<Dipendente> dipendenti = new ArrayList<>();

        int scelta;
        do {
            scelta = Main.scanner.nextInt();
            if ( scelta != 0 ) {
                dipendenti.add(this.dipendenti.get(scelta-1));
            }
        } while( scelta != 0 );

        progetto = new Progetto(dipendenti);
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Azienda azienda = new Azienda();

        int scelta = 0;

        do {
            System.out.println("\n[1]aggiungi dipendente\n[2]aggiungi progetto\n[3]impostazioni progetto\n[0]esci");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> {
                    System.out.println("inserisci il nome e cognome del dipendente");
                    String nome = scanner.next();
                    String cognome = scanner.next();
                    azienda.aggiungiDipendente(nome,cognome);
                }

                case 2 -> {
                    if (azienda.progetto == null) {
                        azienda.aggiungiProgetto();
                        azienda.progetto.infoProgetto();
                    } else {
                        System.out.println("Esiste gia un progetto");
                    }
                }

                case 3 -> {
                    if (azienda.progetto == null) {
                        System.out.println("SOS");
                        break;
                    }

                    int sceltaProgetto;
                    do {
                        System.out.printf("\n[0]esci\n[1]info\n[2]aggiungi dipendenti\n[3]milestone\n[4]task\n[5]giorno\n[6]completa task\n");
                        sceltaProgetto = scanner.nextInt();
                        switch (sceltaProgetto) {
                            case 1 -> {
                                azienda.progetto.infoProgetto();
                            }
                            case 2 -> {
                                System.out.println("[0]esci\nInserisci i dipendenti che lavoreranno a questo progetto");
                                for (int i = 0 ; i < azienda.dipendenti.size() ; i++) {
                                    System.out.printf("\n[%d]%s %s\n", i+1, azienda.dipendenti.get(i).nome, azienda.dipendenti.get(i).cognome);
                                }
                                ArrayList<Dipendente> dipendenti = new ArrayList<>();
                                int sceltaDipendente;
                                do {
                                    sceltaDipendente = Main.scanner.nextInt();
                                    if ( sceltaDipendente != 0 ) {
                                        dipendenti.add(azienda.dipendenti.get(sceltaDipendente-1));
                                    }
                                    azienda.progetto = new Progetto(dipendenti);
                                    azienda.progetto.infoProgetto();
                                } while( sceltaDipendente != 0 );
                            }
                        }
                    } while (sceltaProgetto != 0);
                }
            }

        } while(scelta != 0);

    }
}