public class AsynchronousPrinter extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10_000);
                System.out.println("Асинхронный привет!");
                Thread.sleep(5000);
                System.out.println("Асинхронный пока!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
