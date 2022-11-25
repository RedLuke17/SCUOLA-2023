import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxClick = 0;
        int scelta = 0;
        Lampadina lampadina = new Lampadina(maxClick);

        System.out.println("quanti click massimi può subire la lampadina?");
        maxClick = scanner.nextInt();



        do {
            System.out.println("[1]per accendere/spegnere la lampadina inserisci\n[2]per verificare lo stato inserisci");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1 -> {
                    lampadina.click();
                }

                case 2 -> {
                    System.out.println(lampadina.stato());
                }
            }
        }while(scelta > 0);

    }
}

class Lampadina {

    int click = 0;
    int maxClick;
    int contClick = 0;

    public Lampadina(int maxClick) {
        this.maxClick = maxClick;
    }

    String stato() {
        if (contClick <= this.maxClick) {
            if (click == 1) {
                return "LA LAMPADINA è ACCESA\n";
            }else if (click == 0) {
                return "LA LAMPADINA è SPENTA\n";
            }
        }else {
            return "LA LAMPADINA è ROTTA\n";
        }
        return null;
    }

    void click() {
        if(click == 0) {
            click++;
        }else if(click == 1){
            click--;
        }
        contClick++;
    }
}