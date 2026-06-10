/**
 * Concept covered:
 * 1. Thread safety by local variables
 * 2. Non Thread-safe Instance Variables
 */

class Counter {

    // shared instance variable 
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void demonstrateLocalVariable() {
        // local variable, thread-safe
        int localCounter = 0;
        for (int i = 1; i <= 5; i++) {
            localCounter++;
        }
        System.out.println(Thread.currentThread().getName()+ " Local Counter = "+ localCounter);
    }
}

class CounterClass implements Runnable {
    private Counter counter;

    public CounterClass(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
        counter.demonstrateLocalVariable();
    }
}

public class ThreadSafeDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterClass(counter), "Thread-1");
        Thread thread2 = new Thread(new CounterClass(counter), "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Count: " + counter.getCount());
    }
}

/**
 * Output: (varies due to thread scheduling)
 * Thread-1 Local Counter = 5
 * Thread-2 Local Counter = 5
 * Final Count: 145175
 */