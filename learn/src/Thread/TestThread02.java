package Thread;

//创建线程方式2：实现Runnable接口，重写run()方法，执行线程需要丢入Runnable的实现类，调用start()方法
public class TestThread02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("=========我在看第"+i+"代码！！！==========");
        }
    }

    public static void main(String[] args) {
        TestThread02 testThread02 = new TestThread02();
        new Thread(testThread02).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("你在看第"+i+"代码！！！");
        }

    }
}
