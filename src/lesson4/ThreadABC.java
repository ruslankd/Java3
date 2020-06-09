package lesson4;

public class ThreadABC {

    private final Object mon = new Object();
    private volatile int currentIndex = 0;
    private final char [] charsABC = new char [] {'A', 'B', 'C'};

    public static void main(String[] args) {

        ThreadABC abc = new ThreadABC();

        Thread t1 = new Thread(() -> abc.printABC('A'));
        Thread t2 = new Thread(() -> abc.printABC('B'));
        Thread t3 = new Thread(() -> abc.printABC('C'));

        t1.start();
        t2.start();
        t3.start();
    }

    public void printABC(char c) {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (charsABC[currentIndex] != c) {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(charsABC[currentIndex]);
                currentIndex = (currentIndex + 1) % 3;
                mon.notifyAll();
            }
        }
    }


}
