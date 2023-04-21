
import java.util.ArrayList;
import java.util.List;

class Contatto {
    private String nome;
    private String cognome;
    private String telefono;

    public Contatto(String nome, String cognome, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Contatto{" +
                "nome=" + nome + " " +
                ", cognome=" + cognome + " " +
                ", telefono=" + telefono + " " +
                "}";
    }
}

class Rubrica {
    private List<Contatto> contatti;

    public Rubrica() {
        contatti = new ArrayList<>();
    }

    public void aggiungiContatto(String nome, String cognome, String telefono) {
        contatti.add(new Contatto(nome, cognome, telefono));
    }

    public void rimuoviContatto(String nome, String cognome) {
        contatti.removeIf(contatto -> contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome));
    }

    public String cerca(String nome, String cognome) {
        for (Contatto contatto : contatti) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                return contatto.getTelefono();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Contatto contatto : contatti) {
            sb.append(contatto.toString()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        System.out.println("contatti aggiunti");
        rubrica.aggiungiContatto("Luca", "Rossi", "1234567890");
        rubrica.aggiungiContatto("Gabriele", "Manciopez", "0987654321");
        System.out.println(rubrica);

        System.out.println("Numero di telefono di Luca");
        System.out.println(rubrica.cerca("Luca", "Rossi"));

        System.out.println("contatto Luca rimosso dalla rubrica");
        rubrica.rimuoviContatto("Luca", "Rossi");

        System.out.println("Rubrica:");
        System.out.println(rubrica);
    }
}