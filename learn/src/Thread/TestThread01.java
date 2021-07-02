package Thread;

//线程的创建方式1：继承Thread方法，重写run()方法，调用start()方法开启线程
public class TestThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("=========我在看第"+i+"代码！！！==========");
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        //创建一个线程
        TestThread01 testThread01 = new TestThread01();
        //调用start()开启线程
        testThread01.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("你在看第"+i+"代码！！！");
        }
    }

}
