package lesson4.ExecutorServiceTest.server;

public class ServerApp {

    private static final int PORT = 8189;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }
}