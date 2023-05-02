package com.example.dentista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Vector;

public class HomeController {
    private Vector<Paziente> pazienti = new Vector<>();


    //dentista
    public void dentista() {
        pazienti.remove(0);
    }



    //registrazione
    @FXML
    private AnchorPane registrazione;

    public void inizializza(Vector<Paziente> pazienti) {
        this.pazienti = pazienti;
    }

    @FXML
    public void registrazione() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registrazione.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(), 590, 390));
        stage.setTitle("Registrazione");
        stage.setResizable(false);
        HomeController controller = loader.getController();
        controller.inizializza(pazienti);
        stage.show();
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

    public void invia() {
        if (nome.getText().isEmpty() || cognome.getText().isEmpty() || eta.getText().isEmpty() || codiceFiscale.getText().isEmpty() || patologia.getText().isEmpty()) {

        } else {
            pazienti.add(new Paziente(nome.getText(), cognome.getText(), Integer.parseInt(eta.getText()), codiceFiscale.getText(), patologia.getText()));
            nome.setText("");
            cognome.setText("");
            eta.setText("");
            codiceFiscale.setText("");
            patologia.setText("");
        }
    }





    //lista dei pazienti
    @FXML
    private ListView<String> listaPazienti;

    public void inizializzaLista(Vector<Paziente> pazienti){
        ObservableList<String> items = FXCollections.observableArrayList();
        for(Paziente paziente : pazienti){
            items.add(paziente.getCognome() + " " + paziente.getNome() + " " + paziente.getEta() + " " + paziente.getPatologia());
        }
        listaPazienti.setItems(items);
    }
    @FXML
    public void listaPazienti() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listaPazienti.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load(), 590, 390));
        stage.setTitle("Lista pazienti");
        stage.setResizable(false);
        HomeController controller = loader.getController();
        controller.inizializzaLista(pazienti);
        stage.show();
    }
}