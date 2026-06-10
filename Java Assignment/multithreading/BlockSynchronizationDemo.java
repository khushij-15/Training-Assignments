/*
 * Concepts Covered:
 * 1. Block Synchronization
 */

class MessagePrinter {

    public void printMessage(String message) {

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
        // Synchronize only the block that accesses the shared resource
        synchronized (printer) {
            printer.printMessage(message);
        }
    }
}

public class BlockSynchronizationDemo {

    public static void main(String[] args) {

        MessagePrinter printer =
                new MessagePrinter();

        new MessageTask(printer,"Java");
        new MessageTask(printer,"Synchronization");
        new MessageTask(printer,"Demo");
    }
}

/**
 * Output: (varies due to thread scheduling, but messages will not interleave)
 * [Java][Synchronization][Demo]
 */