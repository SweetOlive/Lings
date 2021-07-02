package Thread;

import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
public class TestThreadLock {
    public static void main(String[] args) {
        TestLock lock = new TestLock();
        new Thread(lock).start();
        new Thread(lock).start();
        new Thread(lock).start();
    }

}

class TestLock implements Runnable{

    int tickNUms = 10;

    //定义锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if (tickNUms > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tickNUms--);
                }else break;
            }finally {
                //解锁
                lock.unlock();
            }
        }
    }
}
