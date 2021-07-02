package leetcode;

public class leetcode_1114_Thread {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread first = new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.println("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread second = new Thread(() -> {
            try {
                foo.second(() -> {
                    System.out.println("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread third = new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.println("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        third.start();
        first.start();
        second.start();


    }
}

class Foo {

    private final Object ob = new Object();
    private volatile int state = 1;//循环等待条件。相当于竞争资源
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (ob){
            while (state != 1) {
                ob.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            state = 2;
            ob.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (ob){
            while (state != 2) {
                ob.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            state = 3;
            ob.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (ob){
            while (state != 3) {
                ob.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            state = 1;
            ob.notifyAll();
        }
    }
}
