package com.luca.calcolatrice;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcolatriceModel {
    //mostra il contenuto dell'operazione
    private String displayContent = "";

    //conserva tutta loperazione
    private String content = "";

    //funzione che controlla che tipo di pulsante è stato cliccato
    public String button(String symbol) {
        //regex per i simboli
        String symbols = "[+\\-*/^√]";

        //compila la regex
        final Pattern pattern = Pattern.compile(symbols);

        final Matcher displayMatcher = pattern.matcher(displayContent);

        final Matcher symbolMatcher = pattern.matcher(symbol);

        //se è stato inserito qualcosa e se trova un simbolo allora mostrera soltanto il simbolo e togliera dal display la vecchia operazione
        if (displayContent.length() != 0 && symbolMatcher.find()) {
            displayContent = symbol;

            //memorizza l'intera operazione
            content += " " + symbol + " ";
        }

        if (symbol.equals(".")){
            //se trova la virgola inserita controllerà se ci sono dei numeri e aggiunge la virgola all'operazione e al display
            if (displayContent.matches("\\d")){
                content += symbol;
                displayContent += symbol;
            }
        }

        //controlla se ci sono dei numeri
        if (symbol.matches("\\d")) {

            //controlla se sta un operando e se c'è lo toglie
            if (displayMatcher.find()){
                displayContent = "";
            }
            content += symbol;
            displayContent += symbol;

        } else if (symbol.matches("^(CE|C)$")) {
            if (symbol.equals("CE")) {
                content = "";
                displayContent = "";
            } else {
                displayContent = displayContent.substring(0, displayContent.length() - 1);
                content = content.substring(0, content.length() - 1);
            }
        }



        if (symbol.equals("=")){
            //se trova l'uguale verificherà se la lunghezza dell'operazione è più lunga di almeno un operazione
            if (content.length() > 2) {
                //per calcolare l'operazione chiamerà la funzione per eseguire l'operazione e mostrerà sul display il totale
                content = String.valueOf(executeOperation());
                displayContent = content;
            }
        }

        //mostra sul display ogni pulsante cliccato
        return displayContent;
    }

    //funzione che esegue le operazioni
    private String executeOperation(){
        //prende ogni elemento dell'operazione separato da uno spazio vuoto e lo trasforma in un vettore che contiene tutti caratteri
        String[] tokens = content.split("\\s");

        //stack dei numeri
        Stack<Double> numeri = new Stack<>();

        //stack degli operandi
        Stack<Character> operatore = new Stack<>();

        for (String token : tokens) {

            //controlla se ci sono numeri con il punto
            if (token.matches("\\d+\\.?\\d*")) {
                numeri.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {

                //controlla se ci sono degli operandi presenti e controlla se sono operandi che hanno la precedenza
                while (!operatore.empty() && hasPrecedence(token.charAt(0), operatore.peek())) {
                    //quindi passa l'operazione e poi elimina i precedenti caratteri
                    numeri.push(applyOperation(numeri.pop(), numeri.pop(), operatore.pop()));
                }
                operatore.push(token.charAt(0));
            }
        }

        //controlla soltanto se c'è un operando e quindi esegue l'operazione
        while (!operatore.empty()) {
            numeri.push(applyOperation(numeri.pop(), numeri.pop(), operatore.pop()));
        }
        //quindi ritorna il risultato dell'operazione ed elimina l'elemento
        return String.valueOf(numeri.pop());
    }

    //funzione che controlla se ci sono degli operandi che hanno la precedenza
    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '^' || op1 == '√') && (op2 == '*' || op2 == '/')) {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    //funzione che controlla l'operando
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '√';
    }

    //funzione che applica l'operazione degli operandi, che con lo stack che inverte l'ordine degli elementi avremo A che è il secondo operatore e B come primo operatore
    private double applyOperation(double a, double b, char operatore) {
        switch (operatore) {
            case '+':
                return a + b;
            case '-':
                //lo stack inverte l'ordine degli elementi e per eseguire la sottrazione bisogna invertire la posizione dei numeri
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return b / a;
            case '√':
                return Math.pow(b, 1 / a);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operatore);
        }
    }
}