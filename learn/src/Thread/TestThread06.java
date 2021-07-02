package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程池
public class TestThread06 {
    public static void main(String[] args) {

        //创建服务
        //newFixedThreadPool 参数为线程池的大小
        ExecutorService service = Executors.newFixedThreadPool(10);

        //执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //关闭连接
        service.shutdown();

    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
