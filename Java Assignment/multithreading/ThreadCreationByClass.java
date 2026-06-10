/**
 * Concept covered:
 * 1. Creating a thread using Thread class
 */

class NumberThread extends Thread {
    NumberThread(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        for(int i=1;i<5;i++){
			System.out.println(this.getName()+ ":"+i);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
    }
}

public class ThreadCreationByClass {
    public static void main(String[] args) {
        NumberThread thread1 = new NumberThread("Thread-1");
        NumberThread thread2 = new NumberThread("Thread-2");
    }
}

/**
 * Output: (varies due to thread scheduling)
 * Thread-1:1
 * Thread-2:1
 * Thread-2:2
 * Thread-1:2
 * Thread-2:3
 * Thread-1:3
 * Thread-2:4
 * Thread-1:4
 */