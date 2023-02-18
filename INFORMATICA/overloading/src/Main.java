import java.util.Scanner;

class Persona {
    private String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Studente extends Persona {
    private String corsoDiStudi;

    public Studente(String nome, String corsoDiStudi) {
        super(nome);
        this.corsoDiStudi = corsoDiStudi;
    }

    public String getCorsoDiStudi() {
        return corsoDiStudi;
    }
}

class Main {
    public static void saluta(Persona persona) {
        System.out.println("Ciao " + persona.getNome());
    }

    public static void saluta(Studente studente) {
        System.out.println("Ciao " + studente.getNome() + ", studi " + studente.getCorsoDiStudi());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String studio;
        System.out.println("come ti chiami?");
        Persona persona = new Persona(nome = scanner.next());
        System.out.println("[studente]come ti chiami e che studio percorri?");
        Studente studente = new Studente(nome = scanner.next(), studio = scanner.next());

        saluta(persona);
        saluta(studente);
    }
}
