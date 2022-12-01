import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = null;
        Progetto progetto = new Progetto(nome);
        ArrayList<Integer> dipendenti = new ArrayList<>();
        Task task = new Task();
        int scelta;


        do {
            System.out.println("[1]dipendenti che partecipano al progetto\n" +
                    "[2]numero di milestone\n" +
                    "[3]numero di task per milestone\n" +
                    "[0]esci");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1 -> {
                    scelta = scanner.nextInt();
                    for (int i = 0; i < scelta ; i++ ) {
                        dipendenti.add(i);
                        System.out.println("dipendente "+dipendenti.get(i));
                    }
                }

                case 2 -> {
                    if( dipendenti.size() > 0 ) {
                        System.out.println("inserisci il numero di obbiettivi");
                        scelta = scanner.nextInt();
                        for (int i = 0 ; i < scelta ; i++ ) {
                            progetto.milestones.add(new Milestone());
                            System.out.println("Milestone: " + i);
                        }
                    }else {
                        System.out.println("inserisci prima un numero di dipendenti che aderiscono al progetto");
                    }
                }

                case 3 -> {
                    if( progetto.milestones.size() > 0 ) {
                        System.out.println("inserisci il numero del milestone");
                        scelta = scanner.nextInt();
                        if (scelta > progetto.milestones.size() - 1 ) {
                            System.out.println("non esiste la milestone");
                        } else {
                            System.out.println("inserisci il numero delle task");
                            int taskNumero = scanner.nextInt();
                            for (int i = 0; i < taskNumero; i++) {
                                progetto.milestones.get(scelta).tasks.add(new Task());
                            }

                            for (int i = 0; i < taskNumero; i++) {
                                System.out.println("Task: " + i);
                            }
                        }
                    } else {
                        System.out.println("inserisci prima dei milestone");
                    }
                }
            }
        } while (scelta > 0);
    }
}

class Progetto {
    String nome;

    public Progetto(String nome) {
        this.nome = nome;
    }

    float andamento;
    ArrayList<Milestone> milestones = new ArrayList<>();
}

class Milestone {
    ArrayList<Task> tasks = new ArrayList<>();
    float andamento = 0;
}

class Task {

    int stato;
}
