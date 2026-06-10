/**
 * Concept covered:
 * 1. Creating and starting threads using Runnable interface
 */

class NumberRunnable implements Runnable {
    private String name;

    NumberRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=1;i<5;i++){
            System.out.println(name + ":" + i);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class ThreadCreationByRunnable {

    public static void main(String[] args) {

        NumberRunnable numberRunnable =
                new NumberRunnable("Number-Thread");

        Thread thread = new Thread(numberRunnable);
        thread.start();

        for (int i = 1; i <= 9; i++) {

            System.out.println("Main Thread: " + i);

            try {
                Thread.sleep(250);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Output: (varies due to thread scheduling)
 * Main Thread: 1
 * Number-Thread:1
 * Main Thread: 2
 * Main Thread: 3
 * Main Thread: 4
 * Main Thread: 5
 * Main Thread: 6
 * Main Thread: 7
 * Main Thread: 8
 * Number-Thread:2
 * Main Thread: 9
 * Number-Thread:3
 * Number-Thread:4
 */