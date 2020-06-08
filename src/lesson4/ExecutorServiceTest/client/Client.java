package lesson4.ExecutorServiceTest.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final String serverHost;
    private final int serverPort;

    public Client(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String message;
        Socket socket = new Socket(serverHost, serverPort);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        do {
            System.out.print("Client: ");
            message = scanner.nextLine();
            out.println(message);
        } while (!message.equals("/end"));
    }
}
