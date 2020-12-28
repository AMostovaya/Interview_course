import java.util.concurrent.locks.ReentrantLock;

public class Counter extends Thread {

    private ReentrantLock reentrantLock = new ReentrantLock();
    private int count = 0;

    @Override
    public void run() {
        while (count != 20) {
            add();
        }
    }

    private void add() {
        reentrantLock.lock();
        try {
            count++;
            System.out.println(count);
        } finally {
            reentrantLock.unlock();
        }
    }


}
