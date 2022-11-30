import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> dipendenti = new ArrayList<>();
        ArrayList<Milestone> milestone = new ArrayList<>();
        int scelta, obbiettivi;


        do {
            System.out.println("[1]dipendenti che partecipano al progetto\n" +
                    "[2]numero di milestone\n" +
                    "[3]numero di task per milestone\n" +
                    "[0]esci");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1: {
                    scelta = scanner.nextInt();
                    for (int i = 0; i < scelta ; i++ ) {
                        dipendenti.add(i);
                        System.out.println("dipendente "+dipendenti.get(i));
                    }
                    break;
                }

                case 2: {
                    if( dipendenti.size() > 0 ) {
                        System.out.println("inserisci il numero di obbiettivi");
                        scelta = scanner.nextInt();
                        for (int i = 0 ; i < scelta ; i++ ) {
                            milestone.size() ;
                        }
                    }else {
                        System.out.println("inserisci prima un numero di dipendenti che aderiscono al progetto");
                    }
                    break;
                }

                case 3: {

                }
            }
        } while (scelta > 0);
    }
}

class Progetto {
    float andamento;
    Milestone milestone = new Milestone();

}

class Milestone {
    ArrayList<Task> tasks = new ArrayList<>();
    float andamento;
}

class Task {
    int stato;
}
