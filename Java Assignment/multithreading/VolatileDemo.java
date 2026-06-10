/*
 * Concepts Covered:
 * 1. volatile Keyword
 */

class TaskRunner implements Runnable {

    private volatile boolean running = true;

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " Started");

        while (running) {
            // keep running
        }

        System.out.println(Thread.currentThread().getName() + " Stopped");
    }

    public void stopTask() {
        running = false;
    }
}

public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {

        TaskRunner taskRunner = new TaskRunner();

        Thread workerThread = new Thread(taskRunner, "WorkerThread");

        workerThread.start();

        Thread.sleep(3000);

        System.out.println(Thread.currentThread().getName() + " Requesting to stop the task...");

        taskRunner.stopTask();
    }
}

/**
 * Output:
 * WorkerThread Started
 * main Requesting to stop the task...
 * WorkerThread Stopped
 */