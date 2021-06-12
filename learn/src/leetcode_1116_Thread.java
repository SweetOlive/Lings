public class leetcode_1116_Thread {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        Thread zero = new Thread(() -> {
            try {
                zeroEvenOdd.zero((new IntConsumer()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread even = new Thread(() -> {
            try {
                zeroEvenOdd.even((new IntConsumer()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread odd = new Thread(() -> {
            try {
                zeroEvenOdd.odd((new IntConsumer()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        even.start();
        zero.start();
        odd.start();
    }
}

class IntConsumer{
    public void accept(int x){
        System.out.print(x);
    }
}

class ZeroEvenOdd {
    private int n;

    private final Object ob = new Object();
    private volatile int state = 0;
    private volatile int j = 1;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (ob){
                if (state != 0){
                    ob.wait();
                }
                printNumber.accept(state);
                if (i % 2 == 0){
                    state = 2;
                }else{
                    state = 1;
                }
                ob.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            synchronized (ob){
                if (state != 2){
                    ob.wait();
                }
                printNumber.accept(i);
                state = 0;
                ob.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            synchronized (ob){
                if (state != 1){
                    ob.wait();
                }
                printNumber.accept(i);
                state = 0;
                ob.notifyAll();
            }
        }
    }
}
