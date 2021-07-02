package leetcode;

public class leetcode_1115_Thread {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(1000);
        Thread foo = new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread bar = new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        foo.start();
        bar.start();
    }
}

class FooBar {
    private int n;

    private final Object ob = new Object();
    private volatile int state = 1;//循环等待条件。相当于竞争资源

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (ob){
                if (state != 1){
                    ob.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                state = 2;
                ob.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (ob){
                if (state != 2){
                    ob.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                state = 1;
                ob.notifyAll();
            }
        }
    }
}