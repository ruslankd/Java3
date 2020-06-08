package lesson4.ExecutorServiceTest.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Server serverInstance;
    private final Socket clientSocket;

    private BufferedReader inputStream;


    public ClientHandler(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.serverInstance = server;
    }

    public void run() {
        try {
            inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            readMessages();
        } catch (Exception e) {
                System.out.println("Connection has been failed");
        } finally {
                closeConnection();
        }
    }

    private void closeConnection() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessages() throws IOException {
        String message;

        do {
            message = inputStream.readLine();
            System.out.println("Client " + Thread.currentThread().getId() + ": " + message);
        } while (!message.equals("/end"));

        System.out.println("Client disconnected.");

    }
}
