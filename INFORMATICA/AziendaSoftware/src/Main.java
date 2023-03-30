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

    public Progetto(String nome, ArrayList<Dipendente> dipendenti) {
        this.nome = nome;
        this.dipendenti = dipendenti;
    }

    void infoProgetto(){
        percentuale();
        System.out.printf("\nInformazioni\nNome:%s\nPercentuale:%.2f\nDipendenti:%d\n",nome , percentuale, dipendenti.size());
        listaDipendenti();

        System.out.println("\nMilestone:");
        for (Milestone milestone : milestones) {
            milestone.completamento();
            System.out.printf("\nmilestone: %s - percentuale:%.2f - stato:%s\n", milestone.nome, milestone.percentuale, milestone.completata ? "completata" : "incompleta");
            for (Task task : milestone.tasks) {
                System.out.printf("Task: %s - Scadenza:%d - Assegnata al Dipendente:%s %s - criticità:%s - completata:%s\n", task.nome, task.scadenza, task.dipendente.nome, task.dipendente.cognome, task.critica ? "critica" : "non critica", task.completata ? "true": "false");
            }
        }
    }

    void listaDipendenti() {
        System.out.printf("\nNome\tCognome");
        for (Dipendente dipendente: dipendenti) {
            System.out.printf("\n%s\t%s", dipendente.nome, dipendente.cognome);
        }
    }

    void aggiungiMilestone(String nome) {
        milestones.add(new Milestone(nome));
    }

    public Milestone getMilestone() {
        System.out.println("Inserisci la milestone");
        for (int i = 0; i < milestones.size(); i++) {
            if (!milestones.get(i).completata) {
                System.out.printf("[%d]%s\n", i, milestones.get(i).nome);
            }
        }
        int selectedMilestone = Main.scanner.nextInt();
        return milestones.get(selectedMilestone);
    }

    float milestoneCompletate() {
        float milestoneCompletata = 0.0f;
        for (Milestone milestone: milestones) {
            milestone.percentuale();
            if (milestone.completata) {
                milestoneCompletata++;
            }
        }
        return milestoneCompletata;
    }

    void percentuale() {
        percentuale = (milestoneCompletate()/milestones.size()) * 100;
    }

    void completamento() {
        for (Milestone milestone : milestones) {
            for (Task task : milestone.tasks) {
                if (!task.completata) {
                    completata = false;
                    return;
                }
            }
        }
        completata = true;
    }

    void taskCritiche() {
        for (Milestone milestone : milestones) {
            for (Task task : milestone.tasks) {
                if (giorni > task.scadenza) {
                    task.critica = true;
                }
            }
        }
    }
}

class Milestone {
    String nome;
    float percentuale = 0;
    ArrayList<Task> tasks = new ArrayList<>();
    boolean completata = false;

    public Milestone(String nome) {
        this.nome = nome;
    }

    void aggiungiTask(String nome, Dipendente dipendente, int scadenza) {
        dipendente.occupazione = true;
        tasks.add(new Task(nome, dipendente, scadenza));
    }
    void percentuale() {
        percentuale = (taskCompletate()/tasks.size()) * 100;
    }

    float taskCompletate() {
        float taskCompletata = 0;
        for (Task task: tasks) {
            if (task.completata) {
                taskCompletata++;
            }
        }
        return taskCompletata;
    }

    void completamento() {
        int nonCompletate = 0;
        for (Task task : tasks) {
            if (!task.completata) {
                nonCompletate++;
            }
        }
        if (nonCompletate == 0) {
            completata = true;
        }
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

        progetto = new Progetto(nome, dipendenti);
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
                        System.out.println("Non esiste un progetto");
                        break;
                    }

                    int sceltaProgetto;
                    do {
                        System.out.printf("\n[0]esci\n[1]info\n[2]aggiungi dipendenti\n[3]Aggiungi milestone\n[4]Assegna task\n[5]completa task\n[6]giorno\n");
                        sceltaProgetto = scanner.nextInt();
                        switch (sceltaProgetto) {
                            case 1 -> {
                                azienda.progetto.taskCritiche();
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

                                    azienda.progetto.infoProgetto();
                                } while( sceltaDipendente != 0 );
                            }
                            case 3 -> {
                                System.out.println("Inserisci il nome del milestone");
                                String nomeMilestone = scanner.next();
                                azienda.progetto.aggiungiMilestone(nomeMilestone);
                            }
                            case 4 -> {
                                if (azienda.progetto.milestones.size() > 0) {
                                    Milestone milestone = azienda.progetto.getMilestone();

                                    System.out.println("Assegna una task a un dipendente");
                                    for (int i = 0; i < azienda.progetto.dipendenti.size(); i++) {
                                        if (!azienda.progetto.dipendenti.get(i).occupazione) {
                                            System.out.printf("\n[%d]%s %s\n", i+1, azienda.dipendenti.get(i).nome, azienda.dipendenti.get(i).cognome);
                                        }
                                    }
                                    int sceltaDipendente = scanner.nextInt();
                                    Dipendente dipendente = azienda.progetto.dipendenti.get(sceltaDipendente-1);

                                    System.out.println("Inserisci il nome della task");
                                    String nomeTask = scanner.next();

                                    System.out.println("Inserisci la scadenza della task");
                                    int scadenzaTask = scanner.nextInt();

                                    milestone.aggiungiTask(nomeTask, dipendente, scadenzaTask);
                                } else {
                                    System.out.println("Non esistono milestone");
                                }
                            }
                            case 5 -> {
                                if (azienda.progetto.milestones.size() > 0) {
                                    Milestone milestone = azienda.progetto.getMilestone();

                                    System.out.println("inserisci la task");
                                    for (int i = 0; i < milestone.tasks.size(); i++) {
                                        if (!milestone.tasks.get(i).completata) {
                                            System.out.printf("[%d]%s\n", i, milestone.tasks.get(i).nome);
                                        }
                                    }

                                    int sceltaTask = scanner.nextInt();

                                    Task task = milestone.tasks.get(sceltaTask);

                                    task.completata = true;
                                    task.dipendente.occupazione = false;
                                    azienda.progetto.completamento();
                                } else {
                                    System.out.println("Non esistono milestone");
                                }
                            }
                            case 6 -> {
                                azienda.progetto.giorni++;
                                System.out.println("e' il giorno " + azienda.progetto.giorni);
                                azienda.progetto.completamento();
                                azienda.progetto.taskCritiche();
                                System.out.println("task critiche");
                                for (Milestone milestone : azienda.progetto.milestones) {
                                    for (Task task : milestone.tasks) {
                                        if (task.critica) {
                                            System.out.println(task.nome + " in scadenza " + task.scadenza);
                                        }
                                    }
                                }
                            }
                        }
                    } while (sceltaProgetto != 0);
                }
            }

        } while(scelta != 0);

    }
}