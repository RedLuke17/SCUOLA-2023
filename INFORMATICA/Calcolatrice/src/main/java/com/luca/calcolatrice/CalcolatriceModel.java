package com.luca.calcolatrice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcolatriceModel {
    private String displayContent = "";
    private String content = "";

    public String button(String symbol) {
        String symbols = "[+\\-*/^√]";
        final Pattern pattern = Pattern.compile(symbols);
        final Matcher displayMatcher = pattern.matcher(displayContent);
        final Matcher symbolMatcher = pattern.matcher(symbol);


        if (displayContent.length() != 0 && symbolMatcher.find()) {
            displayContent = symbol;
            content += " " + symbol + " ";
        }


        if (symbol.equals(".")){
            if (displayContent.matches("\\d")){
                content += symbol;
                displayContent += symbol;
            }
        }

        if (symbol.matches("\\d")) {
            if (displayMatcher.find()){
                displayContent = "";
            }

            content += symbol;
            displayContent += symbol;
        }

        if (symbol.equals("=")){
            if (content.length() > 2) {
                content = String.valueOf(executeOperation());
                displayContent = content;
            }
        }

        return displayContent;
    }

    private double executeOperation(){
        return 10;
    }

    private double applyOperation(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return b / a;
            case '^':
                return Math.pow(b, a);
            case '√':
                return Math.pow(b, 1 / a);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}