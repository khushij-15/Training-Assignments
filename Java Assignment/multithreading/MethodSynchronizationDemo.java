/*
 * Concepts Covered:
 * 1. Method Synchronization
 */

class MessagePrinter {

    // Entire method is synchronized
    public synchronized void printMessage(String message) {

        System.out.print("[" + message);

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("]");
    }
}

class MessageTask implements Runnable {

    private Thread thread;
    private MessagePrinter printer;
    private String message;

    public MessageTask(MessagePrinter printer,String message) {

        this.printer = printer;
        this.message = message;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        printer.printMessage(message);
    }
}

public class MethodSynchronizationDemo {

    public static void main(String[] args) {

        MessagePrinter printer =new MessagePrinter();

        new MessageTask(printer,"Java");
        new MessageTask(printer,"Method");
        new MessageTask(printer,"Synchronization");
    }
}

/**
 * Output: (varies due to thread scheduling, but messages will not interleave)
 * [Java][Method][Synchronization]
 */