import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BankClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.print("Numero conto: ");
            String accountNumber = reader.readLine();
            System.out.print("Password: ");
            String password = reader.readLine();

            String authenticationResult = sendRequest(writer, serverReader, "LOGIN " + accountNumber + " " + password);
            if (authenticationResult.equals("OK")) {
                System.out.println("Accesso effettuato con successo.");

                while (true) {
                    System.out.println("Scegli un'operazione:");
                    System.out.println("1. Prelievo");
                    System.out.println("2. Versamento");
                    System.out.println("3. Visualizza lista movimenti");
                    System.out.println("4. Esci");

                    int choice = Integer.parseInt(reader.readLine());

                    switch (choice) {
                        case 1:
                            System.out.print("Importo del prelievo: ");
                            double withdrawAmount = Double.parseDouble(reader.readLine());
                            String withdrawResult = sendRequest(writer, serverReader, "WITHDRAW " + accountNumber + " " + withdrawAmount);
                            System.out.println(withdrawResult);
                            break;
                        case 2:
                            System.out.print("Importo del versamento: ");
                            double depositAmount = Double.parseDouble(reader.readLine());
                            String depositResult = sendRequest(writer, serverReader, "DEPOSIT " + accountNumber + " " + depositAmount);
                            System.out.println(depositResult);
                            break;
                        case 3:
                            String transactionHistory = sendRequest(writer, serverReader, "TRANSACTIONS " + accountNumber);
                            System.out.println(transactionHistory);
                            break;
                        case 4:
                            System.out.println("Chiusura del programma.");
                            return;
                        default:
                            System.out.println("Scelta non valida.");
                            break;
                    }
                }
            } else {
                System.out.println("Autenticazione fallita: " + authenticationResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sendRequest(PrintWriter writer, BufferedReader reader, String request) throws IOException {
        writer.println(request);
        return reader.readLine();
    }
}
