package com.luca.calcolatrice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class CalcolatriceController {

    private CalcolatriceModel calcolatriceModel;

    public void updateData(String content) {
        this.content.setText(content);
    }


    @FXML
    private Label content;

    @FXML
    private Button CE;

    @FXML
    private Button C;

    @FXML
    private Button radical;

    @FXML
    private Button power;
    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button division;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button multiplication;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button minus;

    @FXML
    private Button decimal;

    @FXML
    private Button zero;

    @FXML
    private Button equals;

    @FXML
    private Button plus;


    @FXML
    private void initialize() {
        ArrayList<Button> buttons = new ArrayList<>(){
            {
                add(CE);
                add(C);
                add(radical);
                add(power);
                add(division);
                add(multiplication);
                add(minus);
                add(plus);
                add(equals);
                add(decimal);
                add(zero);
                add(one);
                add(two);
                add(three);
                add(four);
                add(five);
                add(six);
                add(seven);
                add(eight);
                add(nine);
            }
        };

        calcolatriceModel = new CalcolatriceModel();


        for (Button button: buttons) {
            button.setOnAction(actionEvent -> {
                Button clickedButton = (Button) actionEvent.getSource();
                updateData(calcolatriceModel.button(clickedButton.getText()));
                System.out.println(clickedButton.getText());
            });
        }
    }
}