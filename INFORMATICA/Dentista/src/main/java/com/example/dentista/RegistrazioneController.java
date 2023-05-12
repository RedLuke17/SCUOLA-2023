package com.example.dentista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrazioneController {
    String DataListaPazienti = "ListaPazienti.txt";
    File file = new File(DataListaPazienti);
    public ArrayList<Paziente> pazienti;
    

    //registrazione
    @FXML
    private AnchorPane registrazione;

    public void inizializza(ArrayList<Paziente> pazienti) {
        this.pazienti = pazienti;
    }

    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField eta;
    @FXML
    private TextField codiceFiscale;
    @FXML
    private TextArea patologia;
    public void reset() {
        nome.setText("");
        cognome.setText("");
        eta.setText("");
        codiceFiscale.setText("");
        patologia.setText("");
    }

    public void esci() {
        Stage stage;
        stage = (Stage) registrazione.getScene().getWindow();
        stage.close();
    }
    // Python >> if sas is True or giglo is False:
    public void invia() {
        if (nome.getText().isEmpty() || cognome.getText().isEmpty() || eta.getText().isEmpty() || codiceFiscale.getText().isEmpty() || patologia.getText().isEmpty()) {

        } else {
            pazienti.add(new Paziente(nome.getText(), cognome.getText(), Integer.parseInt(eta.getText()), codiceFiscale.getText(), patologia.getText()));

            try {
                if (!file.exists()) {
                    file.createNewFile();
                }

                int i = 0;

                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] string = line.split("\s");
                    pazienti.set(i, new Paziente(string[0], string[1], Integer.parseInt(string[2]), string[3], string[4]));
                    i++;
                }
                scanner.close();

                FileWriter fileWriter = new FileWriter(DataListaPazienti);
                for (Paziente paziente : pazienti) {
                    fileWriter.write(paziente.toString() + "\n");
                }
                fileWriter.close();

            } catch (IOException e) {
                System.out.println("Errore con il file " + DataListaPazienti);
                e.printStackTrace();
            }

            nome.setText("");
            cognome.setText("");
            eta.setText("");
            codiceFiscale.setText("");
            patologia.setText("");
            Stage stage;
            stage = (Stage) registrazione.getScene().getWindow();
            stage.close();
        }
    }
}