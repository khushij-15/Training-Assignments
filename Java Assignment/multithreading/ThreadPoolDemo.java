/*
 * Concepts Covered:
 * 1. Thread Pool
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NumberTask implements Runnable {

    private int taskNumber;

    public NumberTask(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " is executing Task " + taskNumber);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            executorService.submit( new NumberTask(i));
        }

        executorService.shutdown();
    }
}

/**
 * Output: (may vary due to thread scheduling)
 * pool-1-thread-2 is executing Task 2
 * pool-1-thread-3 is executing Task 3
 * pool-1-thread-1 is executing Task 1
 * pool-1-thread-1 is executing Task 4
 * pool-1-thread-3 is executing Task 5
 */