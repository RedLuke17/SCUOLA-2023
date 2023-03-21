import java.util.Arrays;
import java.util.Comparator;

class Persona {
    private String nome;
    private String cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public void visualizza() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}

class Dipendente extends Persona {
    private String dataAssunzione;
    private double stipendio;

    public Dipendente(String nome, String cognome, String dataAssunzione, double stipendio) {
        super(nome, cognome);
        this.dataAssunzione = dataAssunzione;
        this.stipendio = stipendio;
    }

    @Override
    public void visualizza() {
        super.visualizza();
        System.out.println("Data assunzione: " + dataAssunzione);
        System.out.println("Stipendio: " + stipendio);
    }

    public String getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(String dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public boolean guadagnaPiuDi(Dipendente altroDipendente) {
        return this.stipendio > altroDipendente.getStipendio();
    }
}

public class Main {
    public static void main(String[] args) {
        Dipendente[] dipendenti = new Dipendente[3];
        dipendenti[0] = new Dipendente("Mario", "Rossi", "01/01/2022", 2000);
        dipendenti[1] = new Dipendente("Luigi", "Verdi", "01/01/2022", 3000);
        dipendenti[2] = new Dipendente("Giovanni", "Bianchi", "01/01/2022", 2500);

        for (int i = 0; i < dipendenti.length; i++) {
            for (int j = i + 1; j < dipendenti.length; j++) {
                if (dipendenti[i].getStipendio() > dipendenti[j].getStipendio()) {
                    Dipendente temp = dipendenti[i];
                    dipendenti[i] = dipendenti[j];
                    dipendenti[j] = temp;
                }
            }
        }
        
        for (Dipendente dipendente : dipendenti) {
            dipendente.visualizza();
        }
    }
}