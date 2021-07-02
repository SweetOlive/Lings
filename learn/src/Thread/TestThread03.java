package Thread;

import java.util.concurrent.*;

//创建线程的方式3：实现callable接口
public class TestThread03 implements Callable<Boolean> {

    private String name;

    TestThread03(String name){
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("线程"+this.name+"执行成功，返回true！");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread03 thread01 = new TestThread03("01");
        TestThread03 thread02 = new TestThread03("02");
        TestThread03 thread03 = new TestThread03("03");

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = service.submit(thread01);
        Future<Boolean> r2 = service.submit(thread02);
        Future<Boolean> r3 = service.submit(thread03);

        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        service.shutdownNow();
    }
}
