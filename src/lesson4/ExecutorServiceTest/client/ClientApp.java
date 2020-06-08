package lesson4.ExecutorServiceTest.client;

import java.io.IOException;

public class ClientApp {

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 8189);
        client.run();
    }
}
