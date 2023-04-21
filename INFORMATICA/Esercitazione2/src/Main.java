import java.util.Scanner;

class Quesito {
    private String domanda;
    private String rispostaCorretta;
    private int punteggio;

    public Quesito(String domanda, String rispostaCorretta, int punteggio) {
        this.domanda = domanda;
        this.rispostaCorretta = rispostaCorretta;
        this.punteggio = punteggio;
    }

    public int ask() {
        System.out.println(domanda);
        Scanner scanner = new Scanner(System.in);
        String rispostaUtente = scanner.next();
        if (rispostaUtente.equals(rispostaCorretta)) {
            System.out.println("bravoooo");
            return punteggio;
        } else {
            return 0;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Quesito quesito = new Quesito("Che tipo di pasta inizia per B e finisce per A?", "barilla", 109);

        int punteggio = quesito.ask();

        System.out.println("complimenti hai guadagnato la bellezza di " + punteggio + " punti");
    }
}
