// Server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage, serverMessage;

            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);
                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                System.out.print("Enter response: ");
                serverMessage = stdIn.readLine();
                out.println(serverMessage);

                if (serverMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Server terminated connection.");
                    break;
                }
            }

            clientSocket.close();
            System.out.println("Server shutting down.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput, serverResponse;

            System.out.println("Connected to server. Type messages:");

            while (true) {
                System.out.print("You: ");
                userInput = stdIn.readLine();
                out.println(userInput);

                if (userInput.equalsIgnoreCase("bye")) {
                    System.out.println("Disconnected from server.");
                    break;
                }

                serverResponse = in.readLine();
                if (serverResponse == null || serverResponse.equalsIgnoreCase("bye")) {
                    System.out.println("Server disconnected.");
                    break;
                }

                System.out.println("Server: " + serverResponse);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
