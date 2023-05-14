package com.example.dentista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaGiornalieraController {
    String DataListaPazienti = "ListaPazienti.txt";
    File file = new File(DataListaPazienti);
    Paziente paziente;



    @FXML
    private ListView<String> listaGiornaliera;

    //lista dei pazienti
    @FXML
    public void inizializzaLista(){
        ObservableList<String> items = FXCollections.observableArrayList();
        /*for(Paziente paziente : pazienti){
           items.add(paziente.getCognome() + " " + paziente.getNome() + " " + paziente.getEta() + " " + paziente.getPatologia());
        }*/


        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                items.add(line);
            }
            scanner.close();
            listaGiornaliera.setItems(items);
        } catch (IOException e) {
            System.out.println("Errore con il file " + DataListaPazienti);
            e.printStackTrace();
        }
    }




    //dentista
    public void dentista() {
        ArrayList<Paziente> pazienti = new ArrayList<>();
        try {
            listaGiornaliera.getItems().remove(0);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] string = line.split("\s");
                pazienti.add(new Paziente(string[0], string[1], Integer.parseInt(string[2]), string[3], string[4]));
            }
            scanner.close();

            pazienti.remove(0);

            FileWriter fileWriter = new FileWriter(DataListaPazienti);
            for (Paziente paziente : pazienti) {
                fileWriter.write(paziente.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Errore con il file " + DataListaPazienti);
            e.printStackTrace();
        }




        /*try {



            FileWriter fileWriter = new FileWriter(DataListaPazienti, true);
            for (int i = 0; i < pazienti.size(); i++) {
                fileWriter.write(pazienti + "\n");
            }
            fileWriter.close();


        } catch (IOException e) {
            System.out.println("Errore con il file " + DataListaPazienti);
            e.printStackTrace();
        }*/
    }
}