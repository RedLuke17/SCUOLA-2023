import java.util.ArrayList;

class Persona {
    private String nome;
    private String cognome;

    public Persona(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
        System.out.println("Persona"+nome+cognome+"Creata con successo");
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getNome() {
        return this.nome;
    }

    public void visualizza(){
        System.out.println("Nome"+);
    }
}

class Dipendente extends Persona {
    String dataAssunzione;
    double stipendio;

    public double getStipendio() {
        return stipendio;
    }

    public String getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(String dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public Dipendente(String nome, String cognome, String dataAssunzione, Double stipendio) {
        super(nome, cognome);
        this.dataAssunzione=dataAssunzione;
        this.stipendio=stipendio;
    }

    @Override
    public void visualizza() {
        super.visualizza();
        System.out.println("Data di assunzione"+ dataAssunzione+"Stipendio: "+stipendio);
    }

    public boolean guadagnaDiPiu(Dipendente dipendente) {
        if(this.stipendio>dipendente.stipendio) {
            return true;
        }else{
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Dipendente dip1=new Dipendente("pippo","baudo","25 aprile",125.0);
        Dipendente dip2=new Dipendente("pippi","baudo","25 aprile",130.0);
        Dipendente dip3=new Dipendente("pippu","baudo","25 aprile",25.0);

        ArrayList<Dipendente> dipendenti = new ArrayList<>();


    }
}