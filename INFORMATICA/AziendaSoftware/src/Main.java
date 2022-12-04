import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = null;
        Progetto progetto = new Progetto(nome);
        Task task = new Task();
        int taskNumero, milestoneNumero, dipendenteNumero;
        int scelta;


        do {
            System.out.println("[1]dipendenti che partecipano al progetto\n" +
                    "[2]numero di milestone\n" +
                    "[3]numero di task per milestone\n" +
                    "[-1]esci");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1 -> {
                    scelta = scanner.nextInt();
                    for (int i = 0; i < scelta ; i++ ) {
                        progetto.dipendenti.add(new dipendente());
                        System.out.println("dipendente "+i);
                    }
                }

                case 2 -> {

                        System.out.println("inserisci il numero di obbiettivi");
                        scelta = scanner.nextInt();
                        for (int i = 0 ; i < scelta ; i++ ) {
                            progetto.milestones.add(new Milestone());
                            System.out.println("Milestone: " + i);
                        }

                        System.out.println("inserisci il numero del milestone");
                        milestoneNumero = scanner.nextInt();
                        System.out.println("inserisci il numero di partecipanti");
                        dipendenteNumero = scanner.nextInt();
                        for (int i = 0; i < dipendenteNumero; i++) {
                            progetto.milestones.get(milestoneNumero).dipendenti.add(i, new dipendente());
                        }


                        System.out.println("inserisci prima un numero di dipendenti che aderiscono al progetto");

                }

                case 3 -> {
                    if( progetto.milestones.size() > 0 ) {
                        System.out.println("inserisci il numero del milestone");
                        milestoneNumero = scanner.nextInt();
                        if (milestoneNumero > progetto.milestones.size() - 1 ) {
                            System.out.println("non esiste la milestone");
                        } else {
                            do {
                                System.out.println(
                                        "[1]inserisci il numero delle task\n" +
                                        "[2]assegna task a un dipendente\n" +
                                        "[0]esci"
                                );
                                scelta = scanner.nextInt();
                                switch (scelta) {
                                    case 1 -> {
                                        taskNumero = scanner.nextInt();
                                        for (int i = 0; i < taskNumero; i++) {
                                            progetto.milestones.get(milestoneNumero).tasks.add(new Task());
                                        }
                                        for (int i = 0; i < taskNumero; i++) {
                                            System.out.println("Task: " + i);
                                        }
                                    }

                                    case 2 -> {
                                        if ( progetto.milestones.get(milestoneNumero).tasks.size() > 0 ) {
                                            System.out.println("inserisci il dipendente interessato");
                                            dipendenteNumero = scanner.nextInt();
                                            if (progetto.dipendenti.size() > 0)   {
                                                progetto.dipendenti.get(dipendenteNumero);
                                            }
                                            System.out.println("inserisci la task da dargli");
                                            taskNumero = scanner.nextInt();
                                            progetto.milestones.get(milestoneNumero).dipendenti.get(dipendenteNumero).tasks.add(taskNumero, new Task());
                                        }
                                    }
                                }
                            }while (scelta > 0);
                        }
                    } else {
                        System.out.println("inserisci prima dei milestone");
                    }
                }
            }
        } while (scelta >= 0);
    }
}

class dipendente {
    ArrayList<Task> tasks = new ArrayList<>();
}

class Progetto {
    String nome;

    public Progetto(String nome) {
        this.nome = nome;
    }

    float andamento;
    ArrayList<dipendente> dipendenti = new ArrayList<>();
    ArrayList<Milestone> milestones = new ArrayList<>();
}

class Milestone {
    ArrayList<dipendente> dipendenti = new ArrayList<>();
    ArrayList<Task> tasks = new ArrayList<>();
    float andamento = 0;
}

class Task {
    int stato;
}
