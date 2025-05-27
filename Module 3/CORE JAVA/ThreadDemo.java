class MessageThread extends Thread {
    private String message;

    public MessageThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(message + " - " + (i + 1));
            try {
                Thread.sleep(500); // Pause for half a second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new MessageThread("Thread 1 running");
        Thread t2 = new MessageThread("Thread 2 running");

        t1.start();
        t2.start();
    }
}
