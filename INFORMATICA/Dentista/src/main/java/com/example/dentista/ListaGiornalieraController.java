package com.example.dentista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ListaGiornalieraController {
    String DataListaPazienti = "ListaPazienti.txt";
    File file = new File(DataListaPazienti);
    ArrayList<Paziente> pazienti = new ArrayList<>();
    ObservableList<String> items = FXCollections.observableArrayList();

    int minimo = 0;

    List<Integer> giorni = new ArrayList<>();
    @FXML
    private Label giornoLista;
    @FXML
    private Button chiama;
    @FXML
    private ListView<String> listaGiornaliera;

    //lista dei pazienti
    @FXML
    public void inizializzaLista() {
        /*for(Paziente paziente : pazienti){
           items.add(paziente.getCognome() + " " + paziente.getNome() + " " + paziente.getEta() + " " + paziente.getPatologia());
        }*/

        lettura(file, pazienti, giornoLista, DataListaPazienti, items);

        for (int i = 0; i < giorni.size(); i++) {
            if (minimo == giorni.get(i)) {
                items.add(pazienti.get(i).toString() + ":GIORNO\n");
            }
        }
        listaGiornaliera.setItems(items);
        scrittura(pazienti);
    }


    //dentista
    public void dentista() {
        ArrayList<Paziente> pazienti = new ArrayList<>();
        lettura(file, pazienti, giornoLista, DataListaPazienti, items);

        try {
            if (pazienti.get(0).getDataRegistrazione() != giorni.get(minimo*2)) {
                chiama.setText("chiama");
                pazienti.remove(0);
                scrittura(pazienti);
                for (int i = 0; i < (minimo*2)-1; i++) {
                    if (minimo == giorni.get(i)) {
                        items.add(pazienti.get(i).toString() + ":GIORNO\n");
                        listaGiornaliera.getItems().remove(items.size()-1);
                    }
                }
                listaGiornaliera.setItems(items);
                listaGiornaliera.getItems().remove(0);
                giorni.get(0);
            }
        } catch (IndexOutOfBoundsException giglo) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Avanzamento Giorno");
            alert.setContentText("Avanza il giorno");
            alert.show();
            chiama.setText("avanza giorno");
            lettura(file, pazienti, giornoLista, DataListaPazienti, items);
            giorni.get(0);
            for (int i = 0; i < (minimo*2)-1; i++) {
                if (minimo == giorni.get(i)) {
                    items.add(pazienti.get(i).toString() + ":GIORNO\n");
                }
            }
            listaGiornaliera.setItems(items);
        }
    }


    public void lettura(File file, ArrayList<Paziente> pazienti, Label giornoLista, String DataListaPazienti, ObservableList<String> items) {
        giorni.clear();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] string = line.split(",");


                giorni.add(Integer.parseInt(string[5]));


                minimo = Collections.min(giorni);
                /*
                List<Integer> giorniCopy = new ArrayList<>(giorni);
                Collections.sort(giorniCopy);
                */


                pazienti.add(new Paziente(string[0], string[1], Integer.parseInt(string[2]), string[3], string[4], Integer.parseInt(string[5])));


                pazienti.sort(Comparator.comparingInt(Paziente::getDataRegistrazione));


                giornoLista.setText(Integer.toString(minimo));

            }
            scanner.close();
            Collections.sort(giorni);


        } catch (IOException e) {
            System.out.println("Errore con il file " + DataListaPazienti);
            e.printStackTrace();
        }
    }

    public void scrittura(ArrayList<Paziente> pazienti) {
        try {
            FileWriter fileWriter = new FileWriter(DataListaPazienti);
            for (Paziente paziente : pazienti) {
                fileWriter.write(paziente.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Errore con il file " + DataListaPazienti);
            e.printStackTrace();
        }
    }
}