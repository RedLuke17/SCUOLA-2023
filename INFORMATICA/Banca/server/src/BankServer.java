import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class BankServer {
    private static final int PORT = 8080;
    private static final String DATA_FILE = "..\\bankData.txt";
    private Map<String, Double> accountBalances;

    public BankServer() {
        accountBalances = new HashMap<>();
        loadAccountData();
    }

    public static void main(String[] args) {
        BankServer bankServer = new BankServer();
        bankServer.start();
    }

    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server avviato. In attesa di connessioni...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connessione accettata da: " + clientSocket.getInetAddress().getHostAddress());

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAccountData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String accountNumber = parts[0];
                double balance = Double.parseDouble(parts[1]);
                accountBalances.put(accountNumber, balance);
            }
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento dei dati del conto: " + e.getMessage());
        }
    }

    private void saveAccountData() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(DATA_FILE)))) {
            for (Map.Entry<String, Double> entry : accountBalances.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dei dati del conto: " + e.getMessage());
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String request;
                while ((request = reader.readLine()) != null) {
                    String response = processRequest(request);
                    writer.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processRequest(String request) {
            String[] parts = request.split(" ");
            String command = parts[0];

            switch (command) {
                case "LOGIN":
                    String accountNumber = parts[1];
                    String password = parts[2];
                    return authenticateUser(accountNumber, password);
                case "DEPOSIT":
                    accountNumber = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    return deposit(accountNumber, amount);
                case "WITHDRAW":
                    accountNumber = parts[1];
                    amount = Double.parseDouble(parts[2]);
                    return withdraw(accountNumber, amount);
                case "TRANSACTIONS":
                    accountNumber = parts[1];
                    return getTransactionHistory(accountNumber);
                default:
                    return "Comando non valido.";
            }
        }

        private String authenticateUser(String accountNumber, String password) {
            // Implementa qui la logica di autenticazione dell'utente
            // Puoi utilizzare una mappa separata per memorizzare gli account e le password

            // Esempio di implementazione:
            if ("123456".equals(password)) {
                return "OK";
            } else {
                return "Autenticazione fallita.";
            }
        }

        private String deposit(String accountNumber, double amount) {
            if (accountBalances.containsKey(accountNumber)) {
                double currentBalance = accountBalances.get(accountNumber);
                double newBalance = currentBalance + amount;
                accountBalances.put(accountNumber, newBalance);
                saveAccountData();
                return "Versamento effettuato. Nuovo saldo: " + newBalance;
            } else {
                return "Il conto specificato non esiste.";
            }
        }

        private String withdraw(String accountNumber, double amount) {
            if (accountBalances.containsKey(accountNumber)) {
                double currentBalance = accountBalances.get(accountNumber);
                if (currentBalance >= amount) {
                    double newBalance = currentBalance - amount;
                    accountBalances.put(accountNumber, newBalance);
                    saveAccountData();
                    return "Prelievo effettuato. Nuovo saldo: " + newBalance;
                } else {
                    return "Saldo insufficiente.";
                }
            } else {
                return "Il conto specificato non esiste.";
            }
        }

        private String getTransactionHistory(String accountNumber) {
            if (accountBalances.containsKey(accountNumber)) {
                // Implementa qui la logica per recuperare la lista dei movimenti del conto
                // Puoi utilizzare una mappa separata per memorizzare i movimenti per ciascun conto

                // Esempio di implementazione:
                StringBuilder sb = new StringBuilder();
                sb.append("Lista movimenti per il conto ").append(accountNumber).append(":");
                // Aggiungi i movimenti al StringBuilder
                return sb.toString();
            } else {
                return "Il conto specificato non esiste.";
            }
        }
    }
}
